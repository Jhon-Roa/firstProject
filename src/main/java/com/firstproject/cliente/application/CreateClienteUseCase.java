package com.firstproject.cliente.application;

import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.cliente.domain.service.ClienteService;

public class CreateClienteUseCase {
    private final ClienteService clienteService;

    public CreateClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(Cliente cliente) {
        clienteService.crearCliente(cliente);
    }
}
