package org.springframework.beans.factory.config;

/**
 * <big>一个Bean对另一个Bean得引用</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/13 下午8:16
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
