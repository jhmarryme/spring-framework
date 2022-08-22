package com.example.entrance.beandefinition;

import com.example.entity.abstractBeanDefinition.User;
import com.example.entity.abstractBeanDefinition.UserService;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 对AbstractBeanDefinition的几个实现类进行测试
 *
 * @author JiaHao Wang
 * @date 2022/4/22 下午4:23
 */
@ComponentScan("com.example")
@Configuration
public class AbstractBeanDefinitionEntrance {

	public static void main(String[] args) {
		// test1();
		// test1XmlConfig();
		// test2();
		test2XmlConfig();
		// test3();
		// test4();
	}

	/** 使用rootBeanDefinition.getPropertyValues().add 向业务类的属性赋值 */
	public static void test1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AbstractBeanDefinitionEntrance.class);

		// root bean
		RootBeanDefinition root = new RootBeanDefinition();
		root.setAbstract(true);
		root.setDescription("rootBeanDefinition");
		root.setBeanClass(UserService.class);
		root.getPropertyValues().add("name", "wwwjh");
		context.registerBeanDefinition("userRootBeanDefinition", root);

		// child bean 继承root bean
		ChildBeanDefinition child = new ChildBeanDefinition("userRootBeanDefinition");
		context.registerBeanDefinition("userChildBeanDefinition", child);

		context.refresh();

		// 获取 bean中的属性, print: wwwjh
		System.out.println(((UserService) context.getBean("userChildBeanDefinition")).getName());
	}

	/** 使用xml配置达到与test1相同的效果 */
	public static void test1XmlConfig() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config-test.xml");
		UserService userService = (UserService) context.getBean("user4");
		System.out.println(userService.getName());
	}

	/** 与test1类似, 但指定child的beanClass达到spring的继承 */
	public static void test2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AbstractBeanDefinitionEntrance.class);

		// root bean
		RootBeanDefinition root = new RootBeanDefinition();
		root.setAbstract(true);
		root.setDescription("root");
		root.setBeanClass(UserService.class);
		root.getPropertyValues().add("name", "wwwjh");
		context.registerBeanDefinition("userRootBeanDefinition", root);

		// child bean 继承root bean
		ChildBeanDefinition child = new ChildBeanDefinition("userRootBeanDefinition");
		child.setAbstract(false);
		child.setBeanClass(User.class);
		context.registerBeanDefinition("userChildBeanDefinition", child);

		context.refresh();

		// 获取 bean中的属性, print: wwwjh
		System.out.println(((User) context.getBean("userChildBeanDefinition")).getName());
	}

	/** 使用xml配置达到与test2相同的效果 */
	public static void test2XmlConfig() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config-test.xml");
		User user = (User) context.getBean("user5");
		System.out.println(user.getName());
	}

	/** 使用使用GenericBeanDefinition替换RootBeanDefinition和GenericBeanDefinition */
	public static void test3() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AbstractBeanDefinitionEntrance.class);

		GenericBeanDefinition root = new GenericBeanDefinition();
		root.setAbstract(true);
		root.setDescription("rootBeanDefinition");
		root.setBeanClass(UserService.class);
		root.getPropertyValues().add("name", "wwwjh");
		context.registerBeanDefinition("userRootBeanDefinition", root);

		// child bean 继承root bean
		GenericBeanDefinition child = new GenericBeanDefinition();
		child.setParentName("userRootBeanDefinition");
		context.registerBeanDefinition("userChildBeanDefinition", child);

		context.refresh();

		// 获取 bean中的属性, print: wwwjh
		System.out.println(((UserService) context.getBean("userChildBeanDefinition")).getName());
	}

	/** 使用RootBeanDefinition是不允许的 */
	public static void test4() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AbstractBeanDefinitionEntrance.class);

		RootBeanDefinition root = new RootBeanDefinition();
		root.setAbstract(true);
		root.setDescription("rootBeanDefinition");
		root.setBeanClass(UserService.class);
		root.getPropertyValues().add("name", "wwwjh");
		context.registerBeanDefinition("userRootBeanDefinition", root);

		// child bean 继承root bean
		RootBeanDefinition child = new RootBeanDefinition();
		child.setParentName("userRootBeanDefinition");
		context.registerBeanDefinition("userChildBeanDefinition", child);

		context.refresh();

		// 获取 bean中的属性, print: error
		System.out.println(((UserService) context.getBean("userChildBeanDefinition")).getName());
	}
}
