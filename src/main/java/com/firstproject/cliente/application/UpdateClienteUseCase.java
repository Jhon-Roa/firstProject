package com.firstproject.cliente.application;

import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.cliente.domain.service.ClienteService;

public class UpdateClienteUseCase {
    private final ClienteService clienteService;

    public UpdateClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(Cliente cliente) {
        clienteService.updateCliente(cliente);
    }
}
