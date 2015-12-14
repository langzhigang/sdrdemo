package cn.lzg.sdrdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lzg.sdrdemo.entity.User;
import cn.lzg.sdrdemo.service.impl.UserOperationsServiceImpl;

/**
 * @author Wolf.Lang
 *
 */
@Controller
@RequestMapping(value = "/redis")
public class UserController {
	@Autowired
	private UserOperationsServiceImpl userOperationsService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(
			@RequestParam(value = "Id", required = true) String Id,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "password", required = true) String password) {
		User user = new User(Id, name, password);
		userOperationsService.add(user);
		return "/WEB-INF/jsp/AddUserSuccess.jsp";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser() {
		return "/WEB-INF/jsp/AddUser.jsp";
	}

	@RequestMapping(value = "/queryUser")
	public String queryUser() {
		return "/WEB-INF/jsp/getUser.jsp";
	}

	@RequestMapping(value = "/getUser")
	public String getUser(
			@RequestParam(value = "key", required = true) String key,
			Model model) {
		User user = userOperationsService.getUser(key);
		model.addAttribute("userId", user.getId());
		model.addAttribute("username", user.getName());
		model.addAttribute("userpassword", user.getPassword());

		return "/WEB-INF/jsp/showUser.jsp";
	}
}
