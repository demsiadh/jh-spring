package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * <big>读取Bean定义信息即BeanDefinition接口</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/17 下午1:45
 */
public interface BeanDefinitionReader {
    // 获取注册表（因为需要把Bean注册到注册表中）
    BeanDefinitionRegistry getRegistry();
    // 获取资源加载器
    ResourceLoader getResourceLoader();
    // 从资源加载器中加载BeanDefinition
    void loadBeanDefinitions(String location) throws BeansException;
    void loadBeanDefinitions(String[] locations) throws BeansException;
    void loadBeanDefinitions(Resource resource) throws BeansException;
}
