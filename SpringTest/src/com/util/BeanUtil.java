package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class BeanUtil {
	private static ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
	// private static ApplicationContext app = new
	// FileSystemXmlApplicationContext("config/applicationContext2.xml");

	private BeanUtil() {

	}

	public static Object getBean(String beanName) {
		return app.getBean(beanName);
	}

	public static Object getBean(Class<?> clz) {
		return app.getBean(clz);
	}
}
