package com.client.cliente_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.cliente.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
    Cliente ClientePorNif(String nif);
    List<Cliente> ClientePorNome(String nome);
}
