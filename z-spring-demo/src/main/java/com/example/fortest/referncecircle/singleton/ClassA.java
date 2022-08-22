package com.example.fortest.referncecircle.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author JiaHao Wang
 * @date 8/1/22 4:42 PM
 */
@Component
public class ClassA {

	@Autowired
	private ClassB classB;

	public ClassB getClassB() {
		return classB;
	}

	public void setClassB(ClassB classB) {
		this.classB = classB;
	}
}
