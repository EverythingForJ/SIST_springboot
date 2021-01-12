package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.vo.UserVO;

@Service("userService")
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public void insertUser(UserVO userVo) {
		String passwd = userVo.getPasswd();
		userVo.setPasswd(this.bcryptPasswordEncoder.encode(passwd));
		this.userDao.insert(userVo);
	}
	
	public UserVO getUserByID(String userid) {
		return this.userDao.select(userid);
	}
}
