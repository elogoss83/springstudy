package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.UserDao;

@Controller
public class userController {

	UserDao dao = new UserDao();

	@RequestMapping("userList")
	@ResponseBody
	public ArrayList<User> userlist() {

		return dao.getUsers();
	}

	@RequestMapping("addUser")
	@ResponseBody
	public String add(String userId, String pass, String nick) {
		return dao.addUser(userId, pass, nick);
	}

	@RequestMapping("delUser")
	@ResponseBody
	public String del(String userId) {
		return dao.delUser(userId);
	}

	@RequestMapping("upUser")
	@ResponseBody
	public String up(String userId, String pass, String nick) {
		return dao.upUser(userId, pass, nick);
	}

}
