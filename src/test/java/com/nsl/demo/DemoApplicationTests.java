package com.nsl.demo;

import com.nsl.demo.mapper.UserMapper;
import com.nsl.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void userInsert() {
		User user = new User();
		user.setUsername("nsl");
		user.setPassword(passwordEncoder.encode("111111"));

		int insert = userMapper.insert(user);
		System.out.println(insert);
	}

}
