package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * In this test, the full Spring application context is started but without the server
 * It runs faster than starting the whole application and with that, a smaller scope
 *
 * @link https://spring.io/guides/gs/testing-web/
 */
@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void shouldReturnFormPage_whenAcessingDeveloperRoute() throws Exception {
		final String developerRoute = "/developer";
		this.mockMvc.perform(get(developerRoute))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Form")));
	}
	
}