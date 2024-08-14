package com.firstproject.viaadministracion.application;

import com.firstproject.viaadministracion.domain.services.ViaAdministracionServices;

public class CrearViaAdministracionUseCase {
    private ViaAdministracionServices viaAdministracionServices;

    public CrearViaAdministracionUseCase(ViaAdministracionServices viaAdministracionServices) {
        this.viaAdministracionServices = viaAdministracionServices;
    }

    public void execute(String nombre) {
        viaAdministracionServices.crearviaAdministracion(nombre);
    }
}
