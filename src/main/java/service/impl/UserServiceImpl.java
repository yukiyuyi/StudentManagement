package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.User;
import mapper.UserMapper;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public boolean isExistsUser(User user) {
		return userMapper.isExistUser(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public boolean isExistsUsername(String username) {
		return userMapper.isExistsUserByUname(username);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int addUser(User user) {
		return userMapper.addUser(user);
	}
	
}
