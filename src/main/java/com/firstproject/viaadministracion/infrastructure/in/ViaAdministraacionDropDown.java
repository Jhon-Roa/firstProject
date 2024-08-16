package com.firstproject.viaadministracion.infrastructure.in;

import java.awt.BorderLayout;
import java.util.List;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.firstproject.viaadministracion.application.GetAllViasAdministracionUseCase;
import com.firstproject.viaadministracion.domain.entity.ViaAdministracion;

public class ViaAdministraacionDropDown extends JPanel{
    private JButton addViaadministracion;
    private JButton deleteViaAadministracion;
    private JComboBox<ViaAdministracion> viaAdministracionComboBoX;
    private GetAllViasAdministracionUseCase getAllViasAdministracionUseCase;

    public ViaAdministraacionDropDown(ActionListener actionListenerBorrar,
    ActionListener actionListenerCrear,
    GetAllViasAdministracionUseCase getAllViasAdministracionUseCase) {
        this.getAllViasAdministracionUseCase = getAllViasAdministracionUseCase;

        addViaadministracion = new JButton("+");
        addViaadministracion.addActionListener(actionListenerCrear);

        deleteViaAadministracion = new JButton("-");
        deleteViaAadministracion.addActionListener(actionListenerBorrar);

        viaAdministracionComboBoX = new JComboBox<>();

        setLayout(new BorderLayout());

        add(viaAdministracionComboBoX, BorderLayout.CENTER);
        add(addViaadministracion, BorderLayout.EAST);
        add(deleteViaAadministracion, BorderLayout.WEST);

        setEnabled(false);
    }

    public void updateViaAdministracion() {
        List<ViaAdministracion> viasAdministracion = getAllViasAdministracionUseCase.execute();
        
        viaAdministracionComboBoX.removeAllItems();
        viasAdministracion.forEach(viaAdministracion -> {
            viaAdministracionComboBoX.addItem(viaAdministracion);
        });

        viaAdministracionComboBoX.setEnabled(viaAdministracionComboBoX.getItemCount() > 0);
        deleteViaAadministracion.setEnabled(viaAdministracionComboBoX.getItemCount() > 0);
        viaAdministracionComboBoX.revalidate();
        viaAdministracionComboBoX.repaint();
    }

    public ViaAdministracion getSelectedViaAdministracion() {
        return (ViaAdministracion) viaAdministracionComboBoX.getSelectedItem();
    }

    public void swicher(boolean swicher) {
        viaAdministracionComboBoX.setEnabled(swicher);
        addViaadministracion.setEnabled(swicher);
        deleteViaAadministracion.setEnabled(swicher);
    }

    public void setDefaultItem(ViaAdministracion viaAdministracion) {
        viaAdministracionComboBoX.addItem(viaAdministracion);
        viaAdministracionComboBoX.setSelectedItem(viaAdministracion);
    }
}
