package com.web.test;

import com.web.test.dao.UserDao;
import com.web.test.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {

	@Autowired
	UserDao userDao;

	@Test
	public void contextLoads() {
		List<User> users = userDao.selectAll();
		System.out.println(users);
	}

}
