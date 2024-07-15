package com.client.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.client.cliente.Cliente;
import com.client.service.ClienteServicos;


@RestController
@RequestMapping("/api")
public class ClientController {
    
    @Autowired
    private ClienteServicos clienteServicos;

    @PostMapping("/guardar")
    public Cliente guardar(@RequestBody Cliente cliente){
        return clienteServicos.GuardarCliente(cliente);
    }

    @DeleteMapping("/apagar")
    public void apagar(@RequestParam int id){
        clienteServicos.ApagarCliente(id);
    }

    @GetMapping("/listar")
    public List<Cliente> listar(){
        return clienteServicos.ListarClientes();
    }

    @GetMapping("/bynif")
    public Cliente Bynif(@RequestParam String nif) {
        return clienteServicos.ClienteporNif(nif);
    }

    @GetMapping("/listarbynome")
    public List<Cliente> listarBynome(@RequestParam String nome) {
        return clienteServicos.ClientePorNome(nome);
    }
    
    


    
    
}
