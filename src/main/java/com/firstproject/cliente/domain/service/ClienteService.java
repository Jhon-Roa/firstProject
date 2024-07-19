package com.firstproject.cliente.domain.service;

import java.util.List;
import java.util.Optional;

import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.cliente.domain.entity.ClienteDto;

public interface ClienteService {
    void crearCliente(Cliente cliente);
    void updateCliente(Cliente cliente, String idCliente);
    void deleteCliente(String idCliente);
    Optional<ClienteDto> findClienteById(String idCliente);
    List<Cliente> SeeAllClients();
}
