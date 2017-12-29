package com.ande.service;

import com.ande.model.User;
import com.ande.service.base.IBaseService;

public interface IUserService extends IBaseService<User>{
	public Integer insert(User user);
}
