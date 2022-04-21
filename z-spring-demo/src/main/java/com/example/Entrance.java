package com.example;

import com.example.controller.MyController;
import com.example.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

/**
 *
 * @author Jiahao Wang
 * @date 2022/4/20 下午1:04
 */
@ComponentScan("com.example")
@Configuration
public class Entrance {
	/** 通过XML配置文件获取IoC容器 */
	public static void main1(String[] args) {
		System.out.println("hello world");
		String xmlPath = "//home/jhmarryme/develop/code/spring-framework/z-spring-demo/src/main/resources/spring" +
				"-config-test.xml";
		// Spring容器为我们创建并装配好配置文件中指定的所有Bean
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
		// 获取Bean
		MyService myService = (MyService) applicationContext.getBean("myService");
		// 正常调用
		myService.sayHi("test");
	}

	/** 使用注解的方式获取容器 */
	public static void main(String[] args) {
		// 创建容器实例, 告诉其解析Entrance这个配置类
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
		// 打印所有的beanName
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
		// 获取bean
		MyService myService = (MyService) applicationContext.getBean("myServiceImpl");
		// 正常调用
		myService.sayHi("test2");

		MyController myController = (MyController) applicationContext.getBean("myController");
		myController.send("来自MyController的问候");
	}
}