/**
 * @author chengzb
 *@date 2017年6月16日下午1:56:40
 * @Description: TODO
 */
package com.ande.dao;

import java.util.List;

import com.ande.dao.base.IBaseDao;
import com.ande.model.User;

public interface UserMapper extends IBaseDao<User>{
public List<User> findUserInfo();
public Integer insert(User user);
}
