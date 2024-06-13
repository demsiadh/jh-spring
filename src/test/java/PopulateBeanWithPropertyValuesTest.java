import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * <big>测试填充Bean属性是否成功</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/13 下午5:29
 */
public class PopulateBeanWithPropertyValuesTest {
    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        PropertyValues propertyValues2 = new PropertyValues();
        propertyValues2.addPropertyValue(new PropertyValue("brand", "宝马"));
        propertyValues2.addPropertyValue(new PropertyValue("maxSpeed", 300));
        BeanDefinition beanDefinition2 = new BeanDefinition(Car.class, propertyValues2);
        beanFactory.registerBeanDefinition("car", beanDefinition2);

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "小明"));
        propertyValues.addPropertyValue(new PropertyValue("age", 18));
        propertyValues.addPropertyValue(new PropertyValue("car", new BeanReference("car")));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);



        beanFactory.registerBeanDefinition("person", beanDefinition);
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);

    }

    private static class Person{
        private String name;
        private int age;
        private Car car;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", car=" + car +
                    '}';
        }
    }


    private static class Car{
        private String brand;
        private String color;
        private int maxSpeed;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getMaxSpeed() {
            return maxSpeed;
        }

        public void setMaxSpeed(int maxSpeed) {
        }
    }
}
