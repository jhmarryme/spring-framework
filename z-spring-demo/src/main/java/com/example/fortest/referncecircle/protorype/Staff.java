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
public class Staff {

	private Company company;

	@Autowired
	public Staff(Company company) {
		this.company = company;
	}
}
