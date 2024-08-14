package com.firstproject.viaadministracion.domain.services;

import java.util.List;

import com.firstproject.viaadministracion.domain.entity.ViaAdministracion;

public interface ViaAdministracionServices {
    List<ViaAdministracion> getAllViasAdministracion();
    void borrarViaAdministracion(ViaAdministracion viaAdministracion);
    ViaAdministracion getEspecifiedViaAdministracion(int idViaAdministracion);
    void crearviaAdministracion(String nombre);
}
