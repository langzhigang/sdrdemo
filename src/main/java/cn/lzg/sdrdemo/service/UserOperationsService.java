package cn.lzg.sdrdemo.service;

import cn.lzg.sdrdemo.entity.User;

/**
 * @author Wolf.Lang
 *
 */
public interface UserOperationsService {
	void add(User user);

	User getUser(String key);

}
