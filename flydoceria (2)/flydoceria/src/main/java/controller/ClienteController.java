package controller;

import jakarta.validation.Valid;
import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ClienteService;

import java.util.*;

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

/*  @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
            return clienteService.salvarCliente(clienteAtualizado);
    }
*/

}
