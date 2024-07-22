package com.firstproject.cliente.application;

import java.util.List;

import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.cliente.domain.service.ClienteService;

public class SeeAllClientesNoDtoUseCase {
    private final ClienteService clienteService;

    public SeeAllClientesNoDtoUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<Cliente> execute() {
        return clienteService.SeeAllClientsNoDto();
    }
}
