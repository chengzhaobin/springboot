package com.ande;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import util.PageResult;

import com.ande.model.User;
import com.ande.service.IUserService;

@RestController
public class TestController {
	@Resource
	private IUserService userServiceImpl;
	@RequestMapping("/hello")
	public PageResult<User> ind(PageResult<User> page,User user){
		//PageHelper.startPage(1,2);
		//List<User> user=userServiceImpl.findUserInfo();
		userServiceImpl.queryByPage(page, user);
		return page;
	}
}

