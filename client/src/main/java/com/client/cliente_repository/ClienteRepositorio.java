package com.client.cliente_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.cliente.cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<cliente, Integer>{
    cliente ClientePorNif(String nif);
    List<cliente> ClientePorNome(String nome);
}
