package com.client.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.client.cliente.Cliente;
import com.client.client.cliente_repository.ClienteRepositorio;

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

}
