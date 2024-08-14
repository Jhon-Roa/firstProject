package com.firstproject.viaadministracion.application;

import com.firstproject.viaadministracion.domain.entity.ViaAdministracion;
import com.firstproject.viaadministracion.domain.services.ViaAdministracionServices;

public class BorrarViaAdministracionUseCase {
    ViaAdministracionServices viaAdministracionServices;

    public BorrarViaAdministracionUseCase(ViaAdministracionServices viaAdministracionServices) {
        this.viaAdministracionServices = viaAdministracionServices;
    }

    public void execute(ViaAdministracion viaAdministracion) {
        viaAdministracionServices.borrarViaAdministracion(viaAdministracion);
    }
}
