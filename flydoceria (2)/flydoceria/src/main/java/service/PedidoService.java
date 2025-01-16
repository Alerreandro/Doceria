package service;

import model.Pedido;
import repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido salvarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> buscarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPedidoPorId(int id) {
        return pedidoRepository.findById(id);
    }

    public void excluirPedido(int id) {
        pedidoRepository.deleteById(id);
    }
}
