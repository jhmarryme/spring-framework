package com.example.postprocessor;

import com.example.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author JiaHao Wang
 * @date 2022/6/20 上午10:27
 */
@Configuration
public class CustomizedBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
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
}
