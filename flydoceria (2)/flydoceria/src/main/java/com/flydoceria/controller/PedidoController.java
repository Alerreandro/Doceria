package com.flydoceria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flydoceria.service.PedidoService;

import jakarta.validation.Valid;
import model.Pedido;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarTodosPedidos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarPedido(@PathVariable Integer id) {
        return pedidoService.buscarPedidoPorId(id);
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody @Valid Pedido pedido) {
        return pedidoService.salvarPedido(pedido);
    }

    //criar requisito de atualizar pedido

    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable Integer id) {
        pedidoService.excluirPedido(id);
    }
}
