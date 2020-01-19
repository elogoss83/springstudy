package com.example.demo.dao;

import java.util.ArrayList;

import com.example.demo.controller.User;

public class UserDao {

	ArrayList<User> users = new ArrayList<User>();

	public ArrayList<User> getUsers() {
		return this.users;
	}

	public int lastId() {
		if (users.size() < 1)
			return 0;
		else
			return users.get(users.size() - 1).getUserIdx();
	}

	public String addUser(String userId, String pass, String nick) {
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i).getUserId().equals(userId)) {
				return userId + "회원ID가 중복입니다.";
			}
		}
		User a = new User();

		a.setUserIdx(lastId() + 1);
		a.setUserId(userId);
		a.setPass(pass);
		a.setNick(nick);

		users.add(a);
		return userId + "님 회원가입을 축하합니다.";
		
	}

	public String delUser(String userId) {
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i).getUserId().equals(userId)) {
				this.users.remove(i);
				return userId + "회원이 삭제되었습니다.";
			}
		}
		return userId + "회원이 없습니다.";
	}

	public String upUser(String userId, String pass, String nick) {
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i).getUserId().equals(userId)) {
				users.get(i).setNick(nick);
				users.get(i).setPass(pass);
				return userId + "의 회원정보가 수정되었습니다.";
			}
		}
		return userId + "의 회원정보가 없습니다.";
	}

}
