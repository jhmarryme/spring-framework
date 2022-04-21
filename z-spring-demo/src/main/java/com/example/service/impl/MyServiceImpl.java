package com.example.service.impl;

import com.example.service.MyService;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
	@Override
	public void sayHi(String name) {
		System.out.println("你好: " + name);
	}
}