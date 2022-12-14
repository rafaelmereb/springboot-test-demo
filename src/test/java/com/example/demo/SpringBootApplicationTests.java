package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.controller.DeveloperController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootApplicationTests {
	
	@Autowired
	private DeveloperController developerController;

	@Test
	void contextLoads() {
		assertThat(developerController).isNotNull();
	}

}
