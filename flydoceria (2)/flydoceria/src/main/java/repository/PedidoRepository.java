package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Pedido;
import model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByClienteNome(String nome);

    List<Pedido> findByStatusPedido(StatusPedido statusPedido);

    List<Pedido> findByDataPedidoBetween(LocalDate dataPedido, LocalDate dataEntrega);
}


/*package repository;

import jdk.jshell.Snippet;
import model.Pedido;
import model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByClienteNome(String nome);

    List<Pedido> findByStatusPedido(StatusPedido statusPedido);

    List<Pedido> findByPedidoBetween(LocalDate dataPedido, LocalDate dataEntrega);

}
*/