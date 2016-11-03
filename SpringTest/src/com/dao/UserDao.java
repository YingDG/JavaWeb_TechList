package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class UserDao {
	private Logger logger = Logger.getLogger(UserDao.class);
	@Resource(name = "myDataSource")
	// private DriverManagerDataSource ds;
	private ComboPooledDataSource ds;
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public String getUserId(String uid) {
		String id = null;
		try {
			// con = SpringJdbcConfig.getConnection();
			con = ds.getConnection();
			ps = con.prepareStatement("select * from user where id = ?");
			ps.setString(1, uid);
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getString(1);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			logger.info(UserDao.class, e);
		}
		return id;
	}

	@PreDestroy
	public void close() throws SQLException {
		System.out.println("destory");
		rs.close();
		ps.close();
		con.close();
		// ds.close();
	}
}
