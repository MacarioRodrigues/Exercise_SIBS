package com.client.client.cliente_repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.client.client.cliente.Cliente;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
    
    @Query("SELECT c FROM Cliente c WHERE c.nif = :nif")
    Optional<Cliente> findByNif(@Param("nif") String nif);

    @Query("SELECT c FROM Cliente c WHERE c.nome = :nome")
    List<Cliente> findAllPorNome(@Param("nome")String nome);
}
