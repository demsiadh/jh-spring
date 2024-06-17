package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * <big>默认的ListBean工厂</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/7 下午5:14
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 根据bean名称获取BeanDefinition。
     * 此方法用于从bean定义映射中检索特定名称的bean定义。如果找不到对应的bean定义，
     * 则抛出BeansException异常，表明没有定义名为beanName的bean。
     *
     * @param beanName 需要获取bean定义的bean的名称。
     * @return 对应于beanName的BeanDefinition对象。
     * @throws BeansException 如果没有找到名为beanName的bean定义。
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        // 从bean定义映射中获取名为beanName的bean定义。
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        // 检查bean定义是否为空，如果为空则抛出异常。
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        // 返回找到的bean定义。
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }


    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        // 构建一个结果集
        Map<String, T> beans = new HashMap<>();
        // 遍历当前所有的Bean注册表
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            // 获取bean的类
            Class<?> beanClass = beanDefinition.getBeanClass();
            // 判断是否是BeanClass是否为type类型或者为其子类
            if (type.isAssignableFrom(beanClass)) {
                // 获取Bean
                T bean = (T) getBean(beanName);
                // 添加到结果集中
                beans.put(beanName, bean);
            }
        });
        return beans;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        int size = beanDefinitionMap.size();
        return beanDefinitionMap.keySet().toArray(new String[size]);
    }
}
