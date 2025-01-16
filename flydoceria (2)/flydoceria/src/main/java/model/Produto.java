package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    private int id;
    private String nome;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "pedido_id")  // Definindo a chave estrangeira para o relacionamento com Pedido
    private Pedido pedido;  // Referência de volta para a classe Pedido

    public Produto() {
    }

    public Produto(int id, String nome, Double preco, Pedido pedido) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.pedido = pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
