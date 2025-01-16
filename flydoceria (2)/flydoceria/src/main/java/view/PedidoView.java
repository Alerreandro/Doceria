package view;

import model.Pedido;


public class PedidoView {
    public void exibirDetalhesPedido(Pedido pedido) {
        System.out.println("Pedido Nº " + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        //System.out.println("Total: R$ " + String.format("%.2f", pedido.calcularTotal()));
    }
}


/*// View - PedidoView
class PedidoView {
    public void exibirDetalhesPedido(Pedido pedido) {
        System.out.println("Pedido Nº " + pedido.getNumeroPedido());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Itens do Pedido:");
        for (ItemPedido item : pedido.getItens()) {
            System.out.println(item);
        }
        System.out.println("Total: R$ " + String.format("%.2f", pedido.calcularTotal()));
    }
}*/