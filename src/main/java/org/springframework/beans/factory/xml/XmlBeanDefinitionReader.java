package org.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * <big>读取配置在xml文件中的Bean定义信息</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/17 下午1:55
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public static final String BEAN_ELEMENT = "bean";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String REF_ATTRIBUTE = "ref";

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }


    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        // 获取资源加载器
        ResourceLoader resourceLoader = getResourceLoader();
        // 获取资源
        Resource resource = resourceLoader.getResource(location);
        // 加载资源
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try (InputStream inputStream = resource.getInputStream()) {
            // 加载资源
            doLoadBeanDefinitions(inputStream);
        } catch (Exception e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    /**
     * 加载XML中的Bean定义信息
     * 注意：这里XML可以来自网络，文件，类路径下的资源
     * @param inputStream   输入流
     */
    protected void doLoadBeanDefinitions(InputStream inputStream){
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        // 遍历根节点下的所有子节点
        for (int i = 0; i < childNodes.getLength(); i++) {
            // 判断是否是元素节点
            if (childNodes.item(1) instanceof Element) {
                // 判断节点的标签名
                if (BEAN_ELEMENT.equals(childNodes.item(i).getNodeName())) {
                    Element bean = (Element) childNodes.item(i);
                    String id = bean.getAttribute(ID_ATTRIBUTE);
                    String name = bean.getAttribute(NAME_ATTRIBUTE);
                    String className = bean.getAttribute(CLASS_ATTRIBUTE);

                    // 通过反射获取类对象
                    Class<?> clazz = null;
                    try {
                        clazz = Class.forName(className);
                    } catch (ClassNotFoundException e) {
                        throw new BeansException("Class [" + className + "] for bean [" + className + "] not found");
                    }
                    // id配置优先于name配置
                    String beanName = StrUtil.isNotEmpty(id) ? id : name;
                    // 如果二者属性为空，则取类名首字母小写作为beanName
                    if (StrUtil.isEmpty(beanName)) {
                        beanName = StrUtil.lowerFirst(clazz.getSimpleName());
                    }

                    // 创建BeanDefinition
                    BeanDefinition beanDefinition = new BeanDefinition(clazz);
                    // 读取属性并填充
                    for (int i1 = 0; i1 < bean.getChildNodes().getLength(); i1++) {
                        // 保证元素格式正确
                        if (bean.getChildNodes().item(i1) instanceof Element) {
                            // 判断属性标签是否正确
                            if (PROPERTY_ELEMENT.equals(bean.getChildNodes().item(i1).getNodeName())) {
                                // 获取属性标签的name和value属性
                                Element property = (Element) bean.getChildNodes().item(i1);
                                String propertyName = property.getAttribute(NAME_ATTRIBUTE);
                                String propertyValue = property.getAttribute(VALUE_ATTRIBUTE);
                                String propertyRef = property.getAttribute(REF_ATTRIBUTE);

                                // 如果属性名字为空，则抛出异常
                                if (StrUtil.isEmpty(propertyName)) {
                                    throw new BeansException("The name of the property must not be null");
                                }

                                // value默认等于value值
                                Object value = propertyValue;
                                // 如果ref不为空，则把value替换为BeanReference
                                if (StrUtil.isNotEmpty(propertyRef)) {
                                    value = new BeanReference(propertyRef);
                                }
                                PropertyValue pV = new PropertyValue(propertyName, value);
                                // 添加属性到Bean的定义信息属性集合中
                                beanDefinition.getPropertyValues().addPropertyValue(pV);
                            }
                        }
                    }
                    // 判断是否重复，因为为单例Bean实现，所以要确保注册表中唯一
                    if (getRegistry().containsBeanDefinition(beanName)) {
                        throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
                    }
                    // 注册BeanDefinition
                    getRegistry().registerBeanDefinition(beanName, beanDefinition);
                }
            }
        }
    }
}
