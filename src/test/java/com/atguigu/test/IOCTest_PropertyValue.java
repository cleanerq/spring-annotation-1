package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfLifeCycle;
import com.atguigu.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_PropertyValue {
    //创建ioc容器
    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01() {
        printBeans(applicationContext);
        System.out.println("=================");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String value = environment.getProperty("person.nickName");
        System.out.println(value);
        applicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
