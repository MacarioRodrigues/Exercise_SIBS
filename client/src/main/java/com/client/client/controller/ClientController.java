package com.client.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.client.client.cliente.Cliente;
import com.client.client.service.ClienteServicos;


@RestController
@RequestMapping("/api/client")
public class ClientController {
    
    @Autowired
    private ClienteServicos clienteServicos;

    @PostMapping("/guardar")
    public Cliente guardar(@RequestBody Cliente cliente){
        return clienteServicos.GuardarCliente(cliente);
    }

    @DeleteMapping("/apagar")
    public ResponseEntity<String> apagar(@RequestParam int id) {
        clienteServicos.ApagarCliente(id);
        return ResponseEntity.ok("Cliente deleted successfully");
    }

    @GetMapping("/listar")
    public List<Cliente> listar(){
        return clienteServicos.ListarClientes();
    }

}
