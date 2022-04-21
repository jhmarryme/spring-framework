package com.example.controller;

import com.example.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * test Controller
 * @author JiaHao Wang
 * @date 2022/4/20 下午1:06
 */
@Controller
public class MyController {

	@Autowired
	private MyService myService;

	public void send(String s) {
		myService.sayHi(s);
	}
}
