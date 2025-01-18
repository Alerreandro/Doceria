package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	public Endereco() {
	}

}
