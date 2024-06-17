package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * <big></big>
 * <p></p>
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
