package com.example;

import com.example.controller.MyController;
import com.example.entity.User;
import com.example.entity.factory.UserFactoryBean;
import com.example.service.MyService;
import org.springframework.beans.factory.support.GenericBeanDefinition;
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

	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		test4();
	}
	/** 通过XML配置文件获取IoC容器 */
	public static void test1() {
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
	public static void test2() {
		// 创建容器实例, 告诉其解析Entrance这个配置类
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
		// 打印所有的beanName
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
		// 获取bean
		MyService myService = (MyService) applicationContext.getBean("myServiceImpl");
		// 正常调用
		myService.sayHi("test2");

		MyController myController = (MyController) applicationContext.getBean("myController");
		myController.send("来自MyController的问候");

		System.out.println(applicationContext.getBeanDefinition("myController").getSource());
		System.out.println(Arrays.toString(applicationContext.getBeanDefinition("myController").attributeNames()));
	}

	/** 创建bean的几种方式 */
	public static void test3() {
		System.out.println("hello world");
		String xmlPath = "//home/jhmarryme/develop/code/spring-framework/z-spring-demo/src/main/resources/spring" +
				"-config-test.xml";
		// Spring容器为我们创建并装配好配置文件中指定的所有Bean
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);

		User user1a = (User) applicationContext.getBean("user1");
		User user1b = (User) applicationContext.getBean("user1");
		System.out.println("无参构造函数创建的对象:"+user1a);
		System.out.println("无参构造函数创建的对象:"+user1b);

		User user2a = (User) applicationContext.getBean("user2");
		User user2b = (User) applicationContext.getBean("user2");
		System.out.println("静态工厂创建的对象:"+user2a);
		System.out.println("静态工厂创建的对象:"+user2b);

		User user3a = (User) applicationContext.getBean("user3");
		User user3b = (User) applicationContext.getBean("user3");
		System.out.println("实例工厂创建的对象:"+user3a);
		System.out.println("实例工厂创建的对象:"+user3b);

		// 默认会调用userFactoryBean的getBean方法
		User user4a = (User) applicationContext.getBean("userFactoryBean");
		User user4b = (User) applicationContext.getBean("userFactoryBean");
		// 如果要获取userFactoryBean本身, 需要在前面加上&, 具体定义在BeanFactory.FACTORY_BEAN_PREFIX
		UserFactoryBean userfactoryBean = (UserFactoryBean) applicationContext.getBean("&userFactoryBean");
		System.out.println("UserFactoryBean创建的对象:"+user4a);
		System.out.println("UserFactoryBean创建的对象:"+user4b);
		System.out.println("UserFactoryBean:"+userfactoryBean);
	}

	/**
	 * 自定义BeanDefinition并查看其属性值
	 */
	public static void test4() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Entrance.class);
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName("com.example.controller.MyController");
		// 设置属性值
		beanDefinition.setAttribute("customAttribute", "customValue");
		// 将beanDefinition注册到spring容器中
		context.registerBeanDefinition("customBeanDefinition", beanDefinition);
		// 加载或者刷新当前的配置信息
		context.refresh();
		// 拿到属性信息
		String[] attributeNames = context.getBeanDefinition("customBeanDefinition").attributeNames();
		Arrays.stream(attributeNames).forEach(System.out::println);
	}
}