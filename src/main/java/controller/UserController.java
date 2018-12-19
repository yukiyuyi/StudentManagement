package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.User;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/{path}")
	public String jump(@PathVariable("path")String path) {
		return "user/" + path;
	}
//	@RequestMapping("/add")
//	public String add(User user) {
//		if(userService.addUser(user)>0) {
//			return "main";
//		}
//		return "error";
//	}
	@RequestMapping("/login")
	public String login(User user) {
		if(userService.isExistsUser(user)) {
			return "main";
		}
		return "error";
	}
	@RequestMapping("/add")
	public String add(String username,String password,
									String passwordAgain) {
		if(!userService.isExistsUsername(username)) {
			if(password!=null && passwordAgain!=null && !"".equals(password) 
					&& password.equals(passwordAgain)) {
				if(userService.addUser(new User(username,password))>0) {
					return "user/loginForm";
				}
			}
		}
		return "error";
	}
}
