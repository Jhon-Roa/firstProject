package com.firstproject.region.application;

import java.util.List;

import com.firstproject.region.domain.entity.Region;
import com.firstproject.region.domain.service.RegionServices;

public class GetAllRegionesUseCase {
    private RegionServices regionServices;

    public GetAllRegionesUseCase(RegionServices regionServices) {
        this.regionServices = regionServices;
    }

    public List<Region> execute() {
        return regionServices.getAllRegiones();
    }
}
