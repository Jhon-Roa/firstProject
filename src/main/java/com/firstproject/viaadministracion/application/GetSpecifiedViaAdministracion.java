package com.firstproject.viaadministracion.application;

import java.util.Optional;

import com.firstproject.viaadministracion.domain.entity.ViaAdministracion;
import com.firstproject.viaadministracion.domain.services.ViaAdministracionServices;

public class GetSpecifiedViaAdministracion {
    private ViaAdministracionServices viaAdministracionServices;

    public GetSpecifiedViaAdministracion(ViaAdministracionServices viaAdministracionServices) {
        this.viaAdministracionServices = viaAdministracionServices;
    }

    public Optional<ViaAdministracion>   execute (int idViaAdministracion) {
        return viaAdministracionServices.getEspecifiedViaAdministracion(idViaAdministracion);
    }
}
