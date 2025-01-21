package com.flydoceria.mapper;

import com.flydoceria.DTO.ClienteDTO;
import model.Cliente;

public class ClienteMapper {

    // Método para converter ClienteDTO para Cliente (Entidade)
    public static Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setContato(clienteDTO.getContato());
        cliente.setDescricao(clienteDTO.getDescricao());
        return cliente;
    }

    // Método para converter Cliente (Entidade) para ClienteDTO
    public static ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setContato(cliente.getContato());
        clienteDTO.setDescricao(cliente.getDescricao());
        return clienteDTO;
    }
    
}
