package com.yueting.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/hello")
@EnableSwagger2
public class HelloController {

	@RequestMapping("/index")
	public String hello(@RequestParam(name = "name", required = false, defaultValue="test") String name) {
		
		return String.format("Hello, %s!", name);
	}
	
}
