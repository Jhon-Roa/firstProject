package com.firstproject.farmacia.domain.service;

import java.util.List;
import java.util.Optional;

import com.firstproject.farmacia.domain.entity.Farmacia;
import com.firstproject.farmacia.domain.entity.FarmaciaDto;

public interface FarmaciaService {
    List<FarmaciaDto> getAllFarmaciasDto();
    List<Farmacia> getAllFarmacias();
    Optional<Farmacia> getEspecifiedFarmacia(int idFarmacia);
    Optional<FarmaciaDto> findFarmacia(int idFarmacia);
    void crearFarmacia(Farmacia farmacia);
    void deleteFarmacia(int idFarmacia);
    void updateFarmacia(Farmacia farmacia);
}
