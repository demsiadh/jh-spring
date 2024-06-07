package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * <big>Bean容器</big>
 *
 * @author 13684
 * @data 2024/6/7 下午4:29
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;
}
