package com.example.fortest.referncecircle.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author JiaHao Wang
 * @date 8/1/22 4:42 PM
 */
@Component
public class ClassB {

	@Autowired
	private ClassA classA;

	public ClassA getClassA() {
		return classA;
	}

	public void setClassA(ClassA classA) {
		this.classA = classA;
	}
}
