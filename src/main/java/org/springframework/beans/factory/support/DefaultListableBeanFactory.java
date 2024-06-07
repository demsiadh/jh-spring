package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
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
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
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
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
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
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
