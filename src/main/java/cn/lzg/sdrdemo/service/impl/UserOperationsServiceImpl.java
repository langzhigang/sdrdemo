package cn.lzg.sdrdemo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import cn.lzg.sdrdemo.entity.User;
import cn.lzg.sdrdemo.service.UserOperationsService;

/**
 * @author Wolf.Lang
 *
 */
@Service
public class UserOperationsServiceImpl implements UserOperationsService {
	//这里别写泛型，因为StringRedisTemplate的源码是默 extends RedisTemplate<String, User> 你写泛型了就无法正确按照类型匹配了
	@Autowired
	private RedisTemplate stringRedisTemplate;	
	
	@Resource(name = "stringRedisTemplate")
	private ValueOperations<String, User> valueOps;

	@Override
	public void add(User user) {
		valueOps.set(user.getId(), user);
	}

	@Override
	public User getUser(String key) {
		 User user = valueOps.get(key);
		 return user;
	}

}