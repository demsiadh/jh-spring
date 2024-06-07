package org.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * <big>Bean工厂</big>
 * <p>用来存储和获取bean的工厂</p>
 *
 * @author 13684
 * @data 2024/6/7 下午4:29
 */
public class BeanFactory {
    // key为bean的id，value为bean对象
    private Map<String, Object> beanMap = new HashMap<>();

    public void registerBean(String beanName, Object bean) {
        beanMap.put(beanName, bean);
    }

    public Object getBean(String beanName) {
        return beanMap.get(beanName);
    }
}
