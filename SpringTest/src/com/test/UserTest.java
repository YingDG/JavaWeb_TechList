package com.test;

import org.junit.Test;

import com.dao.UserDao;
import com.service.UserService;
import com.util.BeanUtil;

public class UserTest {

	@Test
	public void test() {
		UserService us = (UserService) BeanUtil.getBean("userService");
		System.out.println(us.getUserInfo());
		UserDao ud = (UserDao) BeanUtil.getBean("userDao");
		System.out.println(ud.getUserId("1"));
	}

}
