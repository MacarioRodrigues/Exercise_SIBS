package com.client.client.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.client.client.cliente.Cliente;
import com.client.client.cliente_repository.ClienteRepositorio;

@ExtendWith(MockitoExtension.class)
public class ClientServicosTests {
    
    @InjectMocks
    ClienteServicos service;

    @Mock
    ClienteRepositorio repositorio;

    Cliente cliente;

    @BeforeEach
    public void setup(){
        cliente = new Cliente(5, "Barfg", "24643231", "Rua kdsaf", "94836612");

    }

    @Test
    void PorNomeComSucesso(){
        when(repositorio.findAllPorNome(cliente.getNome())).thenReturn(Collections.singletonList(cliente));

        List<Cliente> clientes = service.PorNome(cliente.getNome());

        assertEquals(Collections.singletonList(cliente), clientes);
        verify(repositorio).findAllPorNome(cliente.getNome());
        verifyNoMoreInteractions(repositorio);
    }

    @Test
    void testGuardarCliente() {
        when(repositorio.save(cliente)).thenReturn(cliente);

        Cliente savedCliente = service.GuardarCliente(cliente);

        assertEquals(cliente, savedCliente);
        verify(repositorio).save(cliente);
        verifyNoMoreInteractions(repositorio);
    }

    @Test
    void testApagarCliente() {
        int id = cliente.getId();

        service.ApagarCliente(id);

        verify(repositorio).deleteById(id);
        verifyNoMoreInteractions(repositorio);
    }

    @Test
    void testListarClientes() {
        when(repositorio.findAll()).thenReturn(Collections.singletonList(cliente));

        List<Cliente> clientes = service.ListarClientes();

        assertEquals(Collections.singletonList(cliente), clientes);
        verify(repositorio).findAll();
        verifyNoMoreInteractions(repositorio);
    }

    @Test
    void testPorNifComSucesso() {
        when(repositorio.findByNif(cliente.getNif())).thenReturn(Optional.of(cliente));

        Optional<Cliente> foundCliente = service.PorNif(cliente.getNif());

        assertEquals(Optional.of(cliente), foundCliente);
        verify(repositorio).findByNif(cliente.getNif());
        verifyNoMoreInteractions(repositorio);
    }

}
