package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private ClienteService clienteService;
	private ModelMapper modelMapper;
	
	static final String MSG_CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado.";
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> listaClientes() {
		return clienteService.listaClientes();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente buscarClientePorId(@PathVariable("id") Long id) {
		return clienteService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_CLIENTE_NAO_ENCONTRADO));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void removerCliente(@PathVariable("id") Long id) {
		clienteService.buscarPorId(id).map(cliente -> {
			clienteService.removerPorId(cliente.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_CLIENTE_NAO_ENCONTRADO));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		clienteService.buscarPorId(id).map(clienteBase -> {
			modelMapper.map(cliente, clienteBase);
			clienteService.salvar(clienteBase);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_CLIENTE_NAO_ENCONTRADO));
	}
	
}
