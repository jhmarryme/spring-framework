package com.example.entrance;

import com.example.aspect.introduction.LittleUniverse;
import com.example.controller.MyController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiaHao Wang
 * @date 8/2/22 3:54 PM
 */
@ComponentScan("com.example")
@Configuration
public class ComprehensiveEntrance {

	public static void main(String[] args) {
		// test1_referenceCircle();
		test2_introductionAdvice();
	}

	public static void test1_referenceCircle() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComprehensiveEntrance.class);
		// prototype 类型的bean需要显示调用spring才会才会创建
		// Company company = (Company) applicationContext.getBean("company");
	}

	public static void test2_introductionAdvice() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComprehensiveEntrance.class);
		MyController myController = (MyController) applicationContext.getBean("myController");
		myController.send("hello");
		((LittleUniverse) myController).burningup();
	}
}
