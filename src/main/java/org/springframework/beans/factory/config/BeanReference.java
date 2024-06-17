package org.springframework.beans.factory.config;

/**
 * <big>Bean引用</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/13 下午8:16
 */
public class BeanReference {
    // Bean的名称
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
