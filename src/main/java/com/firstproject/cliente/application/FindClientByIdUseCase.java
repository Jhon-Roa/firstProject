package com.firstproject.cliente.application;

import java.util.Optional;

import com.firstproject.cliente.domain.entity.ClienteDto;
import com.firstproject.cliente.domain.service.ClienteService;

public class FindClientByIdUseCase {
    private final ClienteService clienteService;

    public FindClientByIdUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Optional<ClienteDto> execute(String idCliente) {
        return clienteService.findClienteById(idCliente);
    }
}
