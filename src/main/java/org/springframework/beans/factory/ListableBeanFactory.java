package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

import java.util.Map;

/**
 * <big></big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/17 下午3:05
 */
public interface ListableBeanFactory extends BeanFactory{
    /**
     * 根据类型获取同类型的所有Bean
     * @param type 类型
     * @return Map<String, T>
     * @param <T> 类型泛型
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回定义的所有bean的名称
     *
     * @return  结果数组
     */
    String[] getBeanDefinitionNames();
}
