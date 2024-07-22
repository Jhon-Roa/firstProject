package com.firstproject.cliente.application;

import java.util.Optional;

import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.cliente.domain.service.ClienteService;

public class FindClienteByIdNoDtoUseCase {
    private final ClienteService clienteService;

    public FindClienteByIdNoDtoUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Optional<Cliente> execute(String idCliente) {
        return clienteService.findClienteByIdNoDto(idCliente);
    }
}
