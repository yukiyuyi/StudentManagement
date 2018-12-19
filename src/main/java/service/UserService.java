package service;

import org.springframework.stereotype.Service;

import domain.User;

@Service
public interface UserService {
	boolean isExistsUser(User user);
	boolean isExistsUsername(String username);
	int addUser(User user);
}
