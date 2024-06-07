package org.springframework.beans.factory.support;

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
}
