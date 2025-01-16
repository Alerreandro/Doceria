package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido") // Define o nome da tabela no banco
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
    private int id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)// Relacionamento com Produto
    private List<Produto> produto = new ArrayList<>();

    private int quantidade;

    private int preco;

    @ManyToOne // Relacionamento com Cliente
    private Cliente cliente;

    @ManyToOne // Relacionamento com Endereco
    private Endereco endereco;

    @Enumerated(EnumType.STRING) // Mapeia o enum como String no banco
    private StatusPedido statusPedido;

    private boolean pago;

    private boolean opcaoDeEntrega;



    public Pedido() {}

    public Pedido(int id, ArrayList<Produto> produto, int quantidade, int preco, Cliente cliente, Endereco endereco,
                  StatusPedido statusPedido, boolean pago, boolean opcaoDeEntrega) {
        super();
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.cliente = cliente;
        this.endereco = endereco;
        this.statusPedido = statusPedido;
        this.pago = pago;
        this.opcaoDeEntrega = opcaoDeEntrega;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Produto> getProduto() {
		return (ArrayList<Produto>) produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getPreco() {
		return preco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public boolean isOpcaoDeEntrega() {
		return opcaoDeEntrega;
	}

	public void setOpcaoDeEntrega(boolean opcaoDeEntrega) {
		this.opcaoDeEntrega = opcaoDeEntrega;
	}

	
}
