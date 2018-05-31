package com.yueting.api.rest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yueting.entity.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ApiOperation(value = "test")
	public String hello(User user) {
		System.out.println("User:"+user);
		System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		return String.format("Hello, %s!", user.toString());
	}
	
	@RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
	@ApiOperation(value = "根据用户ID查询用户信息")
	public User getUser(@ApiParam(value="用户ID") @PathVariable Integer id) {
		System.out.println(id);
		User user = new User();
		user.setAge(12);
		user.setPassword("");
		user.setUserName("SkyOne");
		
		return user;
	}
	
	/**
	 *  @RequestBody User user 前端post的user json 是json对象而不是json字符串，不然报415错误。 swagger 的文档自动生成的测试方法会报错。
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ApiOperation(value = "更新用户信息")
	public User update(@ApiParam(value="用户") @RequestBody User user) {
		
		return user;
	}
	
}
