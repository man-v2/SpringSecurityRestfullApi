package com.yueting.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
//	@Test
	public void testHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello/index?name=skyone")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value("Hello, skyone!".length()));
	}
	
//	@Test
	public void testHello2() throws Exception {
		// MockMvcRequestBuilders 添加到content assist 中，即可采用间歇模式
		mockMvc.perform(get("/hello/index").param("name", "test")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testUser() throws Exception {
		mockMvc.perform(get("/user/test").param("userName", "test")
				.param("password", "test")
				.param("age", "22")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
}
