package com.example.demo.controller;

import com.example.demo.model.Developer;
import com.example.demo.service.DeveloperService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@Controller
@Slf4j
@RequestMapping("/developer")
public class DeveloperController {
	
	private DeveloperService developerService;
	
	@GetMapping
	public String index() {
		return "index.html";
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String salvar(Developer developer) {
		log.info(developer.toString());
		developerService.salvar(developer);
		return index();
	}
	
}
