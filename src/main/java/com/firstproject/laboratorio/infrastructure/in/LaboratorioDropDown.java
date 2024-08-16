package com.firstproject.laboratorio.infrastructure.in;

import java.awt.BorderLayout;
import java.util.List;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.firstproject.laboratorio.application.GetAllLaboratoriosUseCase;
import com.firstproject.laboratorio.domain.entity.Laboratorio;

public class LaboratorioDropDown extends JPanel {
    private JButton buscarLaboratorio;
    private JComboBox<Laboratorio> laboratorioComboBox;
    private GetAllLaboratoriosUseCase getAllLaboratoriosUseCase;

    public LaboratorioDropDown(ActionListener actionListenerDropDown,
    ActionListener actionListenerButton,
    GetAllLaboratoriosUseCase getAllLaboratoriosUseCase) {
        this.getAllLaboratoriosUseCase = getAllLaboratoriosUseCase;

        buscarLaboratorio = new JButton("Buscar");
        buscarLaboratorio.addActionListener(actionListenerButton);

        laboratorioComboBox = new JComboBox<>();
        laboratorioComboBox.setSelectedItem("seleccionar");
        laboratorioComboBox.addActionListener(actionListenerDropDown);

        setLayout(new BorderLayout());

        add(laboratorioComboBox, BorderLayout.CENTER);
        add(buscarLaboratorio, BorderLayout.EAST);
    }

    public void updateLaboratorio() {
        List<Laboratorio> laboratorios = getAllLaboratoriosUseCase.execute();
        laboratorioComboBox.removeAllItems();
        laboratorios.forEach(laboratorio -> {
            laboratorioComboBox.addItem(laboratorio);
        });

        inHabilitarFuncion();
    }

    public Laboratorio getSelectedLaboratorio() {
        return (Laboratorio) laboratorioComboBox.getSelectedItem();
    }

    public void swicher(boolean swicher) {
        laboratorioComboBox.setEnabled(swicher);
        buscarLaboratorio.setEnabled(swicher);
    }

    public void setDefaultItem(Laboratorio laboratorio) {
        laboratorioComboBox.addItem(laboratorio);
        laboratorioComboBox.setSelectedItem(laboratorio);
    }

    public void inHabilitarFuncion() {
        if (laboratorioComboBox.getItemCount() == 0) {
            laboratorioComboBox.setEnabled(false);
            buscarLaboratorio.setEnabled(false);

            revalidate();
            repaint();
        }
    }
}
