package com.flydoceria.service;

import java.util.List;
import java.util.Optional;

import com.flydoceria.DTO.ClienteDTO;
import com.flydoceria.mapper.ClienteMapper;
import com.flydoceria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Cliente;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para buscar um cliente por nome
    public Optional<Cliente> buscarClientePorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    // Método para listar todos os clientes
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    // Método para salvar um cliente
    public Cliente salvarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.toEntity(clienteDTO);
        return clienteRepository.save(cliente);
    }

    /*
    // Método para atualizar um cliente
    public Cliente atualizarCliente(Integer id, ClienteDTO clienteDTO) {
        // Verifica se o cliente existe
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();

            // Atualiza os dados do cliente com as informações do DTO
            cliente.setNome(clienteDTO.getNome());
            cliente.setContato(clienteDTO.getContato());
            // Atualize outros campos, se necessário

            // Salva o cliente atualizado
            return clienteRepository.save(cliente);
        }

        // Se o cliente não for encontrado, lança uma exceção ou retorna null
        throw new RuntimeException("Cliente não encontrado");
    }

    // Método para deletar um cliente
    public void deletarCliente(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }
    */
}
