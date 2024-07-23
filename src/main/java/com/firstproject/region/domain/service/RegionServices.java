package com.firstproject.region.domain.service;

import java.util.List;

import com.firstproject.ciudad.domain.entity.Ciudad;
import com.firstproject.region.domain.entity.Region;

public interface RegionServices {
    List<Region> getAllRegiones();
    Region getSpecifiedRegion(int idRegion);
}
