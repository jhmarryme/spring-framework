package com.example.entrance;

import com.example.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author JiaHao Wang
 * @date 2022/6/20 上午10:37
 */
@ComponentScan("com.example")
@Configuration
public class PostProcessorEntrance {

	public static void main(String[] args) {
		test1_BeanDefinitionRegistryPostProcessor();
	}

	public static void test1_BeanDefinitionRegistryPostProcessor() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(PostProcessorEntrance.class);
		User user = (User) context.getBean("user-customBeanDefinitionRegistryPostProcessor");
		System.out.println("在CustomizedBeanDefinitionRegistryPostProcessor中创建的对象:" + user);
	}
}
