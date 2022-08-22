package com.example.fortest.referncecircle.protorype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author JiaHao Wang
 * @date 8/2/22 3:45 PM
 */
@Component
@Scope(value = "prototype")
public class Company {

	private Staff staff;

	@Autowired
	public Company(Staff staff) {
		this.staff = staff;
	}
}
