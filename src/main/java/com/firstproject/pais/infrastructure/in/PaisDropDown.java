package com.firstproject.pais.infrastructure.in;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;

import com.firstproject.pais.application.GetAllPaisesUseCase;
import com.firstproject.pais.domain.entity.Pais;

public class PaisDropDown extends JPanel {
    private JComboBox<Pais> paisComboBox;
    private GetAllPaisesUseCase getAllPaisesUseCase;

    public PaisDropDown(ActionListener actionListener, GetAllPaisesUseCase getAllPaisesUseCase) {
        this.getAllPaisesUseCase = getAllPaisesUseCase;
        paisComboBox = new JComboBox<>();
        paisComboBox.addActionListener(actionListener);
        
        setLayout(new BorderLayout()); 
        add(paisComboBox, BorderLayout.CENTER); 
        setEnabled(true);
    }

    public void updatePaises() {
        List<Pais> paises = getAllPaisesUseCase.execute();
        paisComboBox.removeAllItems();
        paises.forEach(pais -> paisComboBox.addItem(pais));
        setEnabled(!paises.isEmpty());
    }

    public Pais getSelectedPais() {
        return (Pais) paisComboBox.getSelectedItem();
    }

    public void reset() {
        paisComboBox.removeAllItems();
        setEnabled(false);
    }
}