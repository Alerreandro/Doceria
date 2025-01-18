package model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@ManyToOne
	private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<Produto> produtos;

	private int quantidade;

	@Embedded
    private Endereco endereco;

	private Boolean statusPagamento;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    private boolean opcaoDeEntrega;
	private Double valorTotal;
	private LocalDate dataPedido;
	private LocalDate dataEntrega;

	public void calcularValorTotal() {
		this.valorTotal = produtos.stream()
				.mapToDouble(produto -> produto.getPreco() * produto.getQuantidade())
				.sum();
	}
}
