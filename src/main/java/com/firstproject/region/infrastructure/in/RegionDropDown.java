package com.firstproject.region.infrastructure.in;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;
import com.firstproject.region.domain.entity.Region;
import com.firstproject.region.application.GetAllRegionesUseCase;
import com.firstproject.pais.domain.entity.Pais;

public class RegionDropDown extends JPanel {
    private JComboBox<Region> regionComboBox;
    private GetAllRegionesUseCase getAllRegionesUseCase;

    public RegionDropDown(ActionListener actionListener, GetAllRegionesUseCase getAllRegionesUseCase) {
        this.getAllRegionesUseCase = getAllRegionesUseCase;
        regionComboBox = new JComboBox<>();
        regionComboBox.addActionListener(actionListener);
        
        setLayout(new BorderLayout()); 
        add(regionComboBox, BorderLayout.CENTER); 
        setEnabled(false);
    }

    public void updateRegions(Pais selectedPais) {
        List<Region> regiones = getAllRegionesUseCase.execute();
        regionComboBox.removeAllItems();
        regiones.forEach(region -> {
            if (region.getIdPais() == selectedPais.getIdPais()) {
                regionComboBox.addItem(region);
            }
        });
        setEnabled(true);
    }

    public Region getSelectedRegion() {
        return (Region) regionComboBox.getSelectedItem();
    }

    public void swicher(boolean swicher) {
        regionComboBox.setEnabled(swicher);
    }

    public void setDefaultItem(Region region) {
        regionComboBox.addItem(region);
        regionComboBox.setSelectedItem(region);
    }
}