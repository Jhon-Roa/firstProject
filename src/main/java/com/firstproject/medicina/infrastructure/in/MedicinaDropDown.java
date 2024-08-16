package com.firstproject.medicina.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.firstproject.medicina.application.GetAllMedicinasUseCase;
import com.firstproject.medicina.domain.entity.Medicina;

public class MedicinaDropDown extends JPanel{
    private JButton buscarMedicina;
    private JComboBox<Medicina> medicinaCombobox;
    private GetAllMedicinasUseCase getAllMedicinasUseCase;

    public MedicinaDropDown(ActionListener actionListenerDropdown,
    ActionListener actionListenerButton,
    GetAllMedicinasUseCase getAllMedicinasUseCase) {
        this.getAllMedicinasUseCase = getAllMedicinasUseCase;

        buscarMedicina = new JButton("Buscar");
        buscarMedicina.addActionListener(actionListenerButton);

        medicinaCombobox = new JComboBox<>();
        medicinaCombobox.setSelectedItem("seleccionar");
        medicinaCombobox.addActionListener(actionListenerDropdown);

        setLayout(new BorderLayout());

        add(medicinaCombobox, BorderLayout.CENTER);
        add(buscarMedicina, BorderLayout.EAST);
    }

    public void updateMedicina() {
        List<Medicina> medicinas = getAllMedicinasUseCase.execute();
        medicinaCombobox.removeAllItems();
        medicinas.forEach(medicina -> {
            medicinaCombobox.addItem(medicina);
        });

        inHabilitarFuncion();
    }

    public Medicina getSelectedMedicina() {
        return (Medicina) medicinaCombobox.getSelectedItem();
    }

    public void swicher(boolean swicher) {
        medicinaCombobox.setEnabled(swicher);
        buscarMedicina.setEnabled(swicher);
    }

    public void setDefaultItem(Medicina medicina) {
        medicinaCombobox.addItem(medicina);
        medicinaCombobox.setSelectedItem(medicina);
    }

    public void inHabilitarFuncion() {
        if (medicinaCombobox.getItemCount() == 0) {
            medicinaCombobox.setEnabled(false);
            buscarMedicina.setEnabled(false);
        }

        revalidate();
        repaint();
    }
}
