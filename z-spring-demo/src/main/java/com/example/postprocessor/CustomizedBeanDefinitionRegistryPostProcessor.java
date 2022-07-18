package com.example.postprocessor;

import com.example.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 *
 * @author JiaHao Wang
 * @date 2022/6/20 上午10:27
 */
@Component
public class CustomizedBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		Class<?> clazz = User.class;
		GenericBeanDefinition genericBeanDefinition =
				(GenericBeanDefinition) BeanDefinitionBuilder.genericBeanDefinition(clazz).getRawBeanDefinition();
		registry.registerBeanDefinition("user-customBeanDefinitionRegistryPostProcessor", genericBeanDefinition);

	}

	@Override
	public int getOrder() {
		return -1;
	}
}
