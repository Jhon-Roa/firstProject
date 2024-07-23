package com.firstproject.tipodocumento.infraestructure.in;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.firstproject.tipodocumento.application.GetAllTipoDocumentosUseCase;
import com.firstproject.tipodocumento.domain.entity.TipoDocumento;

public class TipoDocumentoDropDown extends JPanel {
    private JComboBox<TipoDocumento> tipoDocumentoComboBox;
    private GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase;

    public TipoDocumentoDropDown(GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase) {
        this.getAllTipoDocumentosUseCase = getAllTipoDocumentosUseCase;
        tipoDocumentoComboBox = new JComboBox<>();
        
        setLayout(new BorderLayout());
        add(tipoDocumentoComboBox, BorderLayout.CENTER);
        setEnabled(true);
    }

    public void UpdateTipoDocumento() {
        List<TipoDocumento> tipoDocumentos = getAllTipoDocumentosUseCase.execute();
        tipoDocumentoComboBox.removeAllItems();
        tipoDocumentos.forEach(tipoDocumento -> tipoDocumentoComboBox.addItem(tipoDocumento));
    }

    public TipoDocumento getSelectedTipoDocumento() {
        return (TipoDocumento) tipoDocumentoComboBox.getSelectedItem();
    }

    public void swicher(boolean swicher)  {
        tipoDocumentoComboBox.setEnabled(swicher);
    }
}
