package com.yueting.entity;

import io.swagger.annotations.ApiModelProperty;

public class User {

	@ApiModelProperty(value = "用户名")
	private String userName;
	
	@ApiModelProperty(value = "用户密码")
	private String password;
	
	@ApiModelProperty(value = "用户年龄")
	private Integer age;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", age=" + age + "]";
	}
	
	
}
