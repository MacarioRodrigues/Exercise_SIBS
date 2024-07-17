package com.client.client.controller;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente) {
        Cliente savedCliente = clienteServicos.GuardarCliente(cliente);
        return ResponseEntity.ok(savedCliente);
    }

    @DeleteMapping("/apagar")
    public ResponseEntity<String> apagar(@RequestParam int id) {
        clienteServicos.ApagarCliente(id);
        return ResponseEntity.ok("Cliente deleted successfully");
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = clienteServicos.ListarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/por-nif")
    public ResponseEntity<Cliente> porNif(@RequestParam String nif) {
        Optional<Cliente> cliente = clienteServicos.PorNif(nif);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Cliente>> porNome(@RequestParam String nome) {
        List<Cliente> clientes = clienteServicos.PorNome(nome);
        return ResponseEntity.ok(clientes);
    }
}
