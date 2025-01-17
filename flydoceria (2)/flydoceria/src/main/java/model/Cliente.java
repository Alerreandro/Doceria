package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 60)
	private String nome;

	@NotNull
	@Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", message = "Formato de telefone inválido. Use (XX) XXXX-XXXX ou (XX) XXXXX-XXXX")
	private String contato;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

}
