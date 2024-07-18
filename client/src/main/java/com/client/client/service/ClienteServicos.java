package com.client.client.service;

import static java.lang.String.format;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.client.cliente.Cliente;
import com.client.client.cliente_repository.ClienteRepositorio;


@Service
public class ClienteServicos {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Cliente GuardarCliente(Cliente cliente) {
        try {
            return clienteRepositorio.save(cliente);
        } catch (Exception e) {
            throw new RuntimeException(format("Failed to save client", e));
        }
    }

    public void ApagarCliente(int id) {
        try {
            clienteRepositorio.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Failed to delete client with id", e));
        }
    }

    public List<Cliente> ListarClientes() {
        try {
            return clienteRepositorio.findAll();
        } catch (Exception e) {
            throw new RuntimeException(format("Failed to list clients", e));
        }
    }

    public Optional<Cliente> PorNif(String nif) {
        try {
            return clienteRepositorio.findByNif(nif);
        } catch (Exception e) {
            throw new RuntimeException(format("Failed to find client by NIF: %s", nif), e);
        }
    }

    public List<Cliente> PorNome(String nome) {
        try {
            return clienteRepositorio.findAllPorNome(nome);
        } catch (Exception e) {
            throw new RuntimeException(format("Failed to find client by name:  %s",nome),e);
        }
    }
}
