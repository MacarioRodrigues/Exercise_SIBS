package com.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.cliente.Cliente;
import com.client.cliente_repository.ClienteRepositorio;

@Service
public class ClienteServicos {

        @Autowired
        private ClienteRepositorio clienteRepositorio;

        public Cliente GuardarCliente(Cliente cliente){
            return clienteRepositorio.save(cliente);
        }

        public void ApagarCliente(int id){
            clienteRepositorio.deleteById(id);
        }

        public List<Cliente> ListarClientes(){
            return clienteRepositorio.findAll();
        }

        public Cliente ClienteporNif(String nif){
            if (nif.isEmpty()){
                throw new RuntimeException("Cliente não encontrado");
            }else{
                return clienteRepositorio.ClientePorNif(nif);
            }
        }
        
        public List<Cliente> ClientePorNome(String nome){
            return clienteRepositorio.ClientePorNome(nome);
        }
}
