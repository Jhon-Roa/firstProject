package com.firstproject.tipodocumento.application;

import java.util.List;

import com.firstproject.tipodocumento.domain.entity.TipoDocumento;
import com.firstproject.tipodocumento.domain.services.TipoDocumentoService;

public class GetAllTipoDocumentosUseCase {
    private TipoDocumentoService tipoDocumentoService;

    public GetAllTipoDocumentosUseCase(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    public List<TipoDocumento> execute() {
        return tipoDocumentoService.getAllTipoDocumentos();
    }
}
