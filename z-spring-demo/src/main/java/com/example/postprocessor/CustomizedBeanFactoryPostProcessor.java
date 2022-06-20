package com.example.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author JiaHao Wang
 * @date 2022/6/20 上午11:14
 */
@Configuration
public class CustomizedBeanFactoryPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + "调用了postProcessBeforeInitialization方法");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + "调用了postProcessAfterInitialization方法");
		return bean;
	}
}
