package com.firstproject.region.application;

import com.firstproject.region.domain.entity.Region;
import com.firstproject.region.domain.service.RegionServices;

public class GetSpecifiedRegionUseCase {
    private RegionServices regionService;

    public GetSpecifiedRegionUseCase(RegionServices regionService) {
        this.regionService = regionService;
    }

    public Region execute(int idRegion) {
        return regionService.getSpecifiedRegion(idRegion);
    }
}
