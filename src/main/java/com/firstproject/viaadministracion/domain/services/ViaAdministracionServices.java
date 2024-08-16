package com.firstproject.viaadministracion.domain.services;

import java.util.List;
import java.util.Optional;

import com.firstproject.viaadministracion.domain.entity.ViaAdministracion;

public interface ViaAdministracionServices {
    List<ViaAdministracion> getAllViasAdministracion();
    void borrarViaAdministracion(ViaAdministracion viaAdministracion);
    Optional<ViaAdministracion> getEspecifiedViaAdministracion(int idViaAdministracion);
    void crearviaAdministracion(String nombre);
}
