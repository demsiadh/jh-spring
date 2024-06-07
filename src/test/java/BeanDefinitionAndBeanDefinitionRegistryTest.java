import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * <big>测试类</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/7 下午5:21
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {
    @Test
    public void testBeanDefinitionAndBeanDefinitionRegistry() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        Object bean = beanFactory.getBean("helloService");
        ((HelloService) bean).sayHello();
    }

    public static class HelloService{
        public void sayHello(){
            System.out.println("Hello World!");
        }
    }
}
