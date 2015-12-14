package cn.lzg.sdrdemo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class JedisTransaction {
	@Autowired
	private RedisTemplate stringRedisTemplate;	
	
	@Resource(name = "stringRedisTemplate")
	private ValueOperations<String, String> valueOps;
	
	//这个是官网写法
	public void testTransaction(){
		List<Object> txResults = (List<Object>) stringRedisTemplate.execute(new SessionCallback<List<Object>>() {
			  public List<Object> execute(RedisOperations operations) throws DataAccessException {
			    operations.multi();
			    operations.opsForSet().add("key", "value1");
			    // This will contain the results of all ops in the transaction
			    return operations.exec();
			  }
			});
			System.out.println("Number of items added to set: " + txResults.get(0));
			
		//直接使用会有问题，因为RedisTemplate每次拿到的都是新的连接	
//		stringRedisTemplate.multi();
//		stringRedisTemplate.exec();
	}
}
