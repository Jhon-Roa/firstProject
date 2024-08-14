package com.firstproject.medicina.application;

import com.firstproject.medicina.domain.service.MedicinaService;

public class BorrarMedicinaUseCase {
    private MedicinaService medicinaService;

    public BorrarMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public void execute(int idMedicina) {
        medicinaService.borrarMedicina(idMedicina);
    }
}
