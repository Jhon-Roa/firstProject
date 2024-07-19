package com.firstproject.cliente.application;

import java.util.List;

import com.firstproject.cliente.domain.entity.ClienteDto;
import com.firstproject.cliente.domain.service.ClienteService;

public class SeeAllClientsUseCase {
    private final ClienteService clienteService;

    public SeeAllClientsUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<ClienteDto> execute() {
        return clienteService.SeeAllClients();
    }
}
