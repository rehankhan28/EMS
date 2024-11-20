package com.ems.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
//@Component
public class MyRunner implements CommandLineRunner {
@Autowired
JdbcTemplate jt;
	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String pwd=encoder.encode("durga@123");
		jt.update("insert into users values(?,?,?)","durga",pwd,1);
		String pwd1=encoder.encode("avinash@123");
		jt.update("insert into users values(?,?,?)","avinash",pwd1,1);
	}
}