package com.example.todo_api.bean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    public void getAllBeanTest() {

        for (String name: context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        // context 안에 myBean이 들어있는지 검증
        Assertions.assertThat(context.getBeanDefinitionNames()).contains("myBean");
    }

    @Test
    public void getOneBeanTest() {
        MyBean myBean1 = context.getBean(MyBean.class);
        MyBean myBean2 = context.getBean(MyBean.class);

        System.out.println(myBean1);
        System.out.println(myBean2);

        Assertions.assertThat(myBean1).isSameAs(myBean2);
    }

    @Test
    public void dependencyInjection() {
        MyBean myBean = context.getBean(MyBean.class);
        MySubBean mySubBean = context.getBean(MySubBean.class);

        System.out.println(myBean.getMySubBean());
        System.out.println(mySubBean);

        Assertions.assertThat(myBean.getMySubBean()).isSameAs(mySubBean);

    }
}
