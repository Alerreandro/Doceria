package com.flydoceria.controller;

import java.util.List;
import java.util.Optional;

import com.flydoceria.DTO.ClienteDTO;
import com.flydoceria.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flydoceria.service.ClienteService;

import jakarta.validation.Valid;
import model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/buscar/{nome}")
	public ResponseEntity<Cliente> buscarClientePorNome(@PathVariable String nome) {
		Optional<Cliente> cliente = clienteService.buscarClientePorNome(nome);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> listarClientes() {
		return clienteService.listarTodosClientes();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ClienteDTO> criarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
		Cliente cliente = clienteService.salvarCliente(clienteDTO);
		ClienteDTO clienteDTOCriado = ClienteMapper.toDTO(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTOCriado);
	}
}
