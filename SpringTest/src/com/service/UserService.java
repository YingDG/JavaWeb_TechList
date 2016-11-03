package com.service;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bean.User;

@Service
public class UserService {
	@Resource
	private User u;

	public String getUserInfo() {
		u.setId(1);
		u.setUsername("user");
		u.setBirthday(new Date());
		return u.toString();
	}

	@PostConstruct
	public void info() {
		System.out.println("getUser");
	}
}
