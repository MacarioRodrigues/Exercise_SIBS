package com.client.client.service;

import static java.lang.String.format;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void DeveAcionarExceptionPorNome(){
        when(repositorio.findAllPorNome(cliente.getNome())).thenThrow(new RuntimeException("Erro ao listar clientes pelo nome"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.PorNome(cliente.getNome());
        });

        assertThat(exception.getMessage(),is(format("Failed to find client by name:  %s",cliente.getNome())));
        assertThat(exception.getCause().getClass(),is(RuntimeException.class));
        assertThat(exception.getCause().getMessage(), is("Erro ao listar clientes pelo nome"));
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

    @Test
    void testPorNifAcionarException() {
        when(repositorio.findByNif(cliente.getNif())).thenThrow(new RuntimeException("Erro ao encontrar cliente por NIF"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.PorNif(cliente.getNif());
        });

        assertThat(exception.getMessage(), is(format("Failed to find client by NIF: %s",cliente.getNif())));
        assertThat(exception.getCause().getClass(), is(RuntimeException.class));
        assertThat(exception.getCause().getMessage(), is("Erro ao encontrar cliente por NIF"));
        verify(repositorio).findByNif(cliente.getNif());
        verifyNoMoreInteractions(repositorio);
    }

}
