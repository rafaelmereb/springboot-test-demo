package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		log.info("Salvando cliente...");
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listaClientes() {
		log.info("Listando clientes...");
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> buscarPorId(Long id) {
		log.info("Buscando cliente por id...");
		return clienteRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		log.info("Removendo cliente por id...");
		clienteRepository.deleteById(id);
	}
	
}
