package com.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ClientsService {
    
    @Autowired
    private ClientsRepository clienteRepository;

    public Clients adicionarClient(Clients cliente) {
        return clientsRepository.save(cliente);
    }

    public void apagarClient(Long id) {
        clientsRepository.deleteById(id);
    }

    public List<Clients> listarClients() {
        return clientsRepository.findAll();
    }

    public Clients obterClientPorNif(String nif) {
        return clientsRepository.findByNif(nif);
    }

    public List<Clients> obterClientsPorNome(String nome) {
        return clientsRepository.findByNome(nome);
    }
}

