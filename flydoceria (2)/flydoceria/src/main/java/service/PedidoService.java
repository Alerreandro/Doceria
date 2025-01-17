package service;

import model.Pedido;
import repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPedidoPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    public Pedido salvarPedido(Pedido pedido) {
        pedido.calcularValorTotal();
        return pedidoRepository.save(pedido);
    }

    public void excluirPedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
