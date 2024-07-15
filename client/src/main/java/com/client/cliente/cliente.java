package com.client.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="Cliente")
@Getter
@Setter
public class Cliente {

    @Id
    private int id;
    private String nome;
    private String nif;
    private String morada;
    private String telefone;
}
