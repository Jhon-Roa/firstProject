package com.firstproject.cliente.application;

import com.firstproject.cliente.domain.service.ClienteService;

public class DeleteClienteUseCase {
    private final ClienteService clienteService;

    public DeleteClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(String idCliente) {
        clienteService.deleteCliente(idCliente);
    }
}
