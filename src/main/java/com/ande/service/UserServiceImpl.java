package com.ande.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ande.dao.UserMapper;
import com.ande.dao.base.IBaseDao;
import com.ande.model.User;
import com.ande.service.base.impl.BaseServiceImpl;
@Service
public class UserServiceImpl extends BaseServiceImpl<User>implements IUserService{
@Resource
private UserMapper userMapper;
	@Override
	@Transactional
	public Integer insert(User user) {
		Integer i=userMapper.insert(user);
		System.out.println(i);
		return 1;
	}
	@Override
	protected IBaseDao<User> getMapper() {
		return userMapper;
	}

}
