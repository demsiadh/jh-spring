package org.springframework.beans;

/**
 * <big>Bean的属性信息</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/13 下午5:09
 */
public class PropertyValue {
    private String name;
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
