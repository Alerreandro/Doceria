package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @NotNull
    @Size(min = 2, max = 60)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public @NotNull @Size(min = 2, max = 60) Double getQuantidade() {
        return null;
    }
}