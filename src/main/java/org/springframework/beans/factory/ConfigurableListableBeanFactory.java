package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * <big>配置Bean工厂接口</big>
 * <p>继承了列表Bean工厂接口</p>
 *
 * @author 13684
 * @data 2024/6/17 下午3:08
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory{
    /**
     * 获取BeanDefinition
     * @param beanName Bean名称
     * @return BeanDefinition
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有单例Bean
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;
}
