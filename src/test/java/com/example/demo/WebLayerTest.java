package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.DeveloperController;
import com.example.demo.model.Developer;
import com.example.demo.service.DeveloperService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Web Layer Tests
 *
 * The @WebMvcTest annotation narrow the tests to only use the web layer
 * You need to use the @MockBean for the service layer or it fails
 */
@WebMvcTest(DeveloperController.class)
class WebLayerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * The annotation must be provided to create and inject a mock fort the Greeting Service
	 */
	@MockBean
	private DeveloperService service;
	
	@Test
	void shouldReturnFormPage_whenAcessingDeveloperRoute() throws Exception {
		final String developerRoute = "/developer";
		
		// if there is a service logic behind a request, here's where you mock it:
		Developer developer = new Developer();
		when(service.salvar(developer)).thenReturn(developer);
		
		this.mockMvc.perform(get(developerRoute))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Form")));
	}
}