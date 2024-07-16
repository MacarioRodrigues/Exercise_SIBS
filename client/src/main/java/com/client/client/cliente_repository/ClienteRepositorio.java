package com.client.client.cliente_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.client.cliente.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
}
