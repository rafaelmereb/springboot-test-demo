package com.example.demo.service;

import com.example.demo.model.Developer;
import com.example.demo.repository.DeveloperRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class DeveloperService {
	
	private DeveloperRepository developerRepository;
	
	public Developer salvar(Developer developer) {
		log.info("Salvando developer...");
		return developerRepository.save(developer);
	}
	
	public List<Developer> listaDevelopers() {
		log.info("Listando developers...");
		return developerRepository.findAll();
	}
	
	public Optional<Developer> buscarPorId(Long id) {
		log.info("Buscando developer por id...");
		return developerRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		log.info("Removendo developer por id...");
		developerRepository.deleteById(id);
	}
	
}
