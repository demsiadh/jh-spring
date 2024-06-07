package org.springframework.beans.factory.config;

/**
 * <big>单例注册表</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/7 下午4:53
 */
public interface SingletonBeanRegistry {
    // 获取单例对象
    Object getSingleton(String beanName);
}
