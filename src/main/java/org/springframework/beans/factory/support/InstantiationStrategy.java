package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * <big>Bean的实例化策略接口</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/7 下午5:45
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
