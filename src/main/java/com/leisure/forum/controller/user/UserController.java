package com.leisure.forum.controller.user;

import com.leisure.forum.entity.Menu;
import com.leisure.forum.entity.User;
import com.leisure.forum.exception.HttpException;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.servie.user.UserService;
import com.leisure.forum.util.EmptyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean addUser(@RequestParam("user") User user) throws ServiceException {
		return userService.add(user);
	}

	@RequestMapping(value = "/menus", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Menu> queryMenus(@RequestParam(value = "userName") String userName)
			throws ServiceException, HttpException {
		if (EmptyUtil.isEmpty(userName)) {
			throw new HttpException("参数错误");
		}
		return userService.queryMenusByUserName(userName);
	}

}
