package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * <big>BeanDefinition注册表接口</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/7 下午4:54
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注入BeanDefinition
     * @param beanName Bean id
     * @param beanDefinition BeanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 获取注册表中的BeanDefinition
     * @param beanName Bean id
     * @return BeanDefinition
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断注册表中是否存在当前Bean
     * @param beanName Bean id
     * @return  是否存在
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
