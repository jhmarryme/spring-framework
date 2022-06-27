package com.example.controller;

import com.example.service.MyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

/**
 * test Controller
 * @author JiaHao Wang
 * @date 2022/4/20 下午1:06
 */
@Controller
public class MyController implements ApplicationContextAware, BeanNameAware {

	@Autowired
	private MyService myService;

	private ApplicationContext applicationContext;

	private String name;

	public void send(String s) {
		myService.sayHi(s);

		System.out.println("通过BeanNameAware获得 = " + name);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println("通过ApplicationContextAware获得" + beanDefinitionName);
		}
	}

	@Override
	public void setBeanName(String name) {
		this.name = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
