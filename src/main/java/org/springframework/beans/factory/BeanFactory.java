package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * <big>Bean工厂</big>
 *
 * @author 13684
 * @data 2024/6/7 下午4:29
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    /**
     * 根据名称和类型查找bean
     *
     * @param name bean名称
     * @param requiredType Bean类型
     * @param <T> Bean类型泛型
     * @return Bean实例
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
