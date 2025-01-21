package com.flydoceria.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDTO {

    @NotNull
    @Size(min = 2, max = 60, message = "O nome deve ter entre 2 e 60 caracteres.")
    private String nome;

    @NotNull
    @Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", message = "Formato de telefone inválido. Use (XX) XXXX-XXXX ou (XX) XXXXX-XXXX.")
    private String contato;

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    private String descricao;
}
