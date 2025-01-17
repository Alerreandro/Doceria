package controller;

import jakarta.validation.Valid;
import model.Pedido;
import org.springframework.web.bind.annotation.*;
import service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.*;

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
