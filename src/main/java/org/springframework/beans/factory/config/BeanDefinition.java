package org.springframework.beans.factory.config;

import org.springframework.beans.PropertyValues;

import java.util.Optional;

/**
 * <big>Bean的定义信息</big>
 * <p>BeanDefinition实例保存bean的信息，包括class类型、方法构造参数、是否为单例等，此处简化只包含class类型</p>
 *
 * @author 13684
 * @data 2024/6/7 下午4:51
 */
public class BeanDefinition {
    private Class<?> beanClass;
    private PropertyValues propertyValues;
    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, null);
    }
    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = Optional.ofNullable(propertyValues).orElse(new PropertyValues());
    }
    public Class<?> getBeanClass() {
        return beanClass;
    }
    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
