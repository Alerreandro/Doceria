package com.flydoceria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flydoceria.service.ClienteService;

import jakarta.validation.Valid;
import model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteService.listarTodosClientes();
	}

	@GetMapping("/{id}")
	public Optional<Cliente> buscarCliente(@PathVariable Integer id) {
		return clienteService.buscarClientePorId(id);
	}

	@PostMapping
	public Cliente criarCliente(@RequestBody @Valid Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}

	/*
	 * @PutMapping("/{id}") public Cliente atualizarCliente(@PathVariable Integer
	 * id, @RequestBody Cliente cliente) { return
	 * clienteService.salvarCliente(clienteAtualizado); }
	 */

}
