package com.firstproject.cliente.domain.service;

import java.util.List;
import java.util.Optional;

import com.firstproject.cliente.domain.entity.Cliente;

public interface ClienteService {
    void crearCliente(Cliente cliente);
    void updateCliente(Cliente cliente);
    Cliente deleteCliente(String idCliente);
    Optional<Cliente> findClienteById(String idCliente);
    List<Cliente> SeeAllClients();
}
