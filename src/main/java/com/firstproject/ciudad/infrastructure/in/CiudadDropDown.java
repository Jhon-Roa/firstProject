package com.firstproject.ciudad.infrastructure.in;

import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.firstproject.ciudad.application.GetAllCiudadesUseCase;
import com.firstproject.ciudad.domain.entity.Ciudad;
import com.firstproject.region.domain.entity.Region;

public class CiudadDropDown extends JPanel {
    private JComboBox<Ciudad> ciudadComboBox;
    private GetAllCiudadesUseCase getAllCiudadesUseCase;

    public CiudadDropDown(ActionListener actionListener, GetAllCiudadesUseCase getAllCiudadesUseCase) {
        this.getAllCiudadesUseCase = getAllCiudadesUseCase;
        ciudadComboBox= new JComboBox<>();
        ciudadComboBox.addActionListener(actionListener);
        setLayout(new BorderLayout()); 
        add(ciudadComboBox, BorderLayout.CENTER); 
        setEnabled(false);
    }

    public void updateCiudades(Region selectedRegion) {
        if (selectedRegion == null) {
            // Maneja el caso donde selectedRegion es null
            System.out.println("cargando ciudades ...");
            ciudadComboBox.removeAllItems();
            setEnabled(false); // O simplemente no hacer nada
            return;
        }
        
        List<Ciudad> ciudades = getAllCiudadesUseCase.execute();
        ciudadComboBox.removeAllItems();
        
        ciudades.forEach(ciudad -> {
            if (ciudad.getIdRegion() == selectedRegion.getIdRegion()) {
                ciudadComboBox.addItem(ciudad);
            }
        });
        
        setEnabled(true);
    }

    public Ciudad getSelecteCiudad() {
        return (Ciudad) ciudadComboBox.getSelectedItem();
    }

    public void reset() {
        ciudadComboBox.removeAllItems();
        setEnabled(false);
    }
}
