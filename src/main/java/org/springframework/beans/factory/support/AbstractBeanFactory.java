package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * <big>实现BeanFactory接口的抽象类</big>
 * <p>继承了默认的单例注册表</p>
 *
 * @author 13684
 * @data 2024/6/7 下午5:02
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    /**
     * 根据bean名称获取bean实例。
     * 首先尝试从单例缓存中获取已实例化的bean，如果存在则直接返回。
     * 如果缓存中不存在，则通过bean定义来创建新的bean实例。
     * 此方法扩展了基类的getSingleton方法，提供了处理bean定义和创建新bean实例的能力。
     *
     * @param beanName 需要获取的bean的名称。
     * @return 相应bean的实例。
     * @throws BeansException 如果在获取或创建bean过程中发生了异常。
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        // 尝试从单例缓存中获取bean实例
        Object bean = super.getSingleton(beanName);
        if (bean != null) {
            // 如果缓存中存在，则直接返回bean实例
            return bean;
        }
        // 如果缓存中不存在，则从bean定义注册表中获取bean的定义
        BeanDefinition beanDefinition = this.getBeanDefinition(beanName);
        // 根据bean定义创建新的bean实例
        return createBean(beanName, beanDefinition);
    }


    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
