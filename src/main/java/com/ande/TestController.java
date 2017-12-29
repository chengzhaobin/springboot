package com.ande;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rr")
public class TestController {
	@Resource
	private Test a;
	@RequestMapping("/hello")
	public String ind(){
		a.test();
		return "hello word";
	}
}

