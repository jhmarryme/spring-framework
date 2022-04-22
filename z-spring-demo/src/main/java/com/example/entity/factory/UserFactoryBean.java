package com.example.entity.factory;

import com.example.entity.User;
import org.springframework.beans.factory.FactoryBean;

/**
 *
 * @author JiaHao Wang
 * @date 2022/4/21 下午4:31
 */
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
