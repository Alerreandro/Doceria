package model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

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

	@ManyToOne
	@JoinColumn(name = "endereco_id")
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
