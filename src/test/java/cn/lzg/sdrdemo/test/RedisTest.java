package cn.lzg.sdrdemo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.lzg.sdrdemo.entity.User;
import cn.lzg.sdrdemo.service.UserOperationsService;
import cn.lzg.sdrdemo.service.impl.JedisApiTest;
import cn.lzg.sdrdemo.service.impl.JedisTransaction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-context.xml",
		"classpath:config/redis-context.xml" })
public class RedisTest {

	@Autowired
	private UserOperationsService userops;

	@Autowired
	private JedisApiTest jedisApiTest;
	
	@Autowired
	private JedisTransaction jedisTransaction;
	
	@Test
	public void test1() {
		User user = new User("1", "lzg", "admin");
		userops.add(user);
		User user1 = userops.getUser(user.getId());
		System.out.println(user1);
	}
	
	@Test
	public void testListOps(){
		jedisApiTest.testListOps();
	}
	
	@Test
	public void testSetOps(){
		jedisApiTest.testSetOps();
	}
	
	@Test
	public void testZSetOps(){
		jedisApiTest.testZSetOps();
	}
	
	@Test
	public void testHashOps(){
		jedisApiTest.testHashOps();
	}
	
	@Test
	public void testValueOps(){
		jedisApiTest.testValueOps();
	}
	
	@Test
	public void testTransaction(){
		jedisTransaction.testTransaction();
	}
}