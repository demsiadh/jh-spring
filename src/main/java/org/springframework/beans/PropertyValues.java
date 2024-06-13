package org.springframework.beans;

import java.util.LinkedList;
import java.util.List;

/**
 * <big>存储Bean的属性集合</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/13 下午5:13
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new LinkedList<>();
    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据属性名称得到属性对象
     * @param propertyName  属性名称
     * @return 属性对象
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}
