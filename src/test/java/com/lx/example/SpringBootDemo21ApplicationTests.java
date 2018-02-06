package com.lx.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lx.example.component.LxJmsComponent;
import com.lx.example.controller.IndexController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo21ApplicationTests {

	private MockMvc mvc;
	
	@Autowired
	private LxJmsComponent lxJmsComponent;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		RequestBuilder request = get("/index");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("hello world"));
		
		request = get("/index/get").param("name", "无境");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"无境\",\"title\":\"hello world\"}"));
	}

	@Test
	public void send() {
		lxJmsComponent.send("hello world");
	}
}
