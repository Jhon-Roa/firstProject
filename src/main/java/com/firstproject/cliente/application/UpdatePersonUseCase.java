package com.firstproject.cliente.application;

import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.cliente.domain.service.ClienteService;

public class UpdatePersonUseCase {
    private final ClienteService clienteService;

    public UpdatePersonUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(Cliente cliente, String idCliente) {
        clienteService.updateCliente(cliente, idCliente);
    }
}
