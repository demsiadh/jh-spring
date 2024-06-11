package org.springframework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * <big>使用CGLIB动态生成Bean</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/7 下午5:49
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    /**
     * 根据给定的bean名称和bean定义，实例化一个动态代理对象。
     * 此方法通过CGLIB生成一个指定类的子类实例，用于动态增强目标类的功能。
     *
     * @param beanDefinition 目标bean的定义，包含了类信息和初始化参数等。
     * @return 返回一个动态生成的代理对象，该对象实现了目标类的所有方法。
     * @throws BeansException 如果实例化过程中出现异常，则抛出此异常。
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        // 使用CGLIB创建一个增强器实例，用于生成目标类的子类。
        Enhancer enhancer = new Enhancer();
        // 设置增强器的父类为bean定义中的类。
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        // 设置回调函数，以便在调用方法时执行自定义逻辑。
        // 这里使用MethodInterceptor实现，确保所有方法调用都会通过invokeSuper在父类（即目标类）中执行。
        enhancer.setCallback((MethodInterceptor) (obj, method, argsTemp, proxy) -> proxy.invokeSuper(obj,argsTemp));
        // 创建并返回增强后的子类实例，即动态代理对象。
        return enhancer.create();
    }

}
