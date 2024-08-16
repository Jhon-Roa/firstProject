package com.firstproject.farmacia.infrastructure.in;

import java.util.List;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.firstproject.farmacia.application.GetAllFarmaciasUseCase;
import com.firstproject.farmacia.domain.entity.Farmacia;

public class FarmaciaDropDown extends JPanel {
    private JButton buscarFarmacia;
    private JComboBox<Farmacia> farmaciaComboBox;
    private GetAllFarmaciasUseCase getAllFarmaciasUseCase;

    public FarmaciaDropDown(ActionListener actionListenerDropDown, 
    ActionListener actionListenerButton, 
    GetAllFarmaciasUseCase getAllFarmaciasUseCase) {
        this.getAllFarmaciasUseCase = getAllFarmaciasUseCase;

        buscarFarmacia = new JButton("Buscar");
        buscarFarmacia.addActionListener(actionListenerButton);

        farmaciaComboBox = new JComboBox<>();
        farmaciaComboBox.setSelectedItem("seleccionar");
        farmaciaComboBox.addActionListener(actionListenerDropDown);

        setLayout(new BorderLayout());

        add(farmaciaComboBox, BorderLayout.CENTER);
        add(buscarFarmacia, BorderLayout.EAST);
    }

    public void updateFarmacia() {
        List<Farmacia> farmacias = getAllFarmaciasUseCase.execute();
        farmaciaComboBox.removeAllItems();
        farmacias.forEach(farmacia -> {
            farmaciaComboBox.addItem(farmacia);
        });

        inHabilitarFuncion();
    }

    public Farmacia getSelectedFarmacia() {
        return (Farmacia) farmaciaComboBox.getSelectedItem();
    }

    public void swicher(boolean swicher) {
        farmaciaComboBox.setEnabled(false);
        buscarFarmacia.setEnabled(false);
    }

    public void setDefaultItem(Farmacia farmacia) {
        farmaciaComboBox.addItem(farmacia);
        farmaciaComboBox.setSelectedItem(farmacia);
    }

    private void inHabilitarFuncion() {
        if (farmaciaComboBox.getItemCount() == 0) {
            farmaciaComboBox.setEnabled(false);
            buscarFarmacia.setEnabled(false);

            revalidate();
            repaint();
        }
    }
}
