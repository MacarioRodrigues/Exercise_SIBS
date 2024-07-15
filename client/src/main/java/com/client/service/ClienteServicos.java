package com.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.cliente.cliente;
import com.client.cliente_repository.ClienteRepositorio;

@Service
public class ClienteServicos {

        @Autowired
        private ClienteRepositorio clienteRepositorio;

        public cliente GuardarCliente(cliente cliente){
            return clienteRepositorio.save(cliente);
        }

        public void ApagarCliente(int id){
            clienteRepositorio.deleteById(id);
        }

        public List<cliente> ListarClientes(){
            return clienteRepositorio.findAll();
        }

        public cliente ClienteporNif(String nif){
            return clienteRepositorio.ClientePorNif(nif);
        }
        
        public List<cliente> ClientePorNome(String nome){
            return clienteRepositorio.ClientePorNome(nome);
        }
}
