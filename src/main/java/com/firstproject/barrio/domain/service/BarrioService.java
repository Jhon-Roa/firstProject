package com.firstproject.barrio.domain.service;

import java.util.List;

import com.firstproject.barrio.domain.entity.Barrio;
import com.firstproject.ciudad.domain.entity.Ciudad;

public interface BarrioService {
    void createBarrio(String barrio, Ciudad selectedCiudad);
    List<Barrio> getAllBarrios();
}
