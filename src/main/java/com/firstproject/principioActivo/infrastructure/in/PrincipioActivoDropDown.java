package com.firstproject.principioActivo.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.firstproject.principioActivo.application.GetAllPrincipiosActivosUseCase;
import com.firstproject.principioActivo.domain.entity.PrincipioActivo;

public class PrincipioActivoDropDown extends JPanel {
    private JButton addPrincipioActivo;
    private JButton deletePrincipioActivo;
    private JComboBox<PrincipioActivo> principioActivoComboBox;
    private GetAllPrincipiosActivosUseCase getAllPrincipiosActivosUseCase;

    public PrincipioActivoDropDown(ActionListener actionListenerBorrar,
    ActionListener actionListenerCrear,
    GetAllPrincipiosActivosUseCase getAllPrincipiosActivosUseCase) {
        this.getAllPrincipiosActivosUseCase = getAllPrincipiosActivosUseCase;

        addPrincipioActivo = new JButton("+");
        addPrincipioActivo.addActionListener(actionListenerCrear);

        deletePrincipioActivo = new JButton("-");
        deletePrincipioActivo.addActionListener(actionListenerBorrar);

        principioActivoComboBox = new JComboBox<>();

        setLayout(new BorderLayout());

        add(principioActivoComboBox, BorderLayout.CENTER);
        add(deletePrincipioActivo, BorderLayout.WEST);
        add(addPrincipioActivo, BorderLayout.EAST);

        setEnabled(false);
    }

    public void updatePrincipioActivo() {
        List<PrincipioActivo> principiosActivos = getAllPrincipiosActivosUseCase.execute();
        
        principioActivoComboBox.removeAllItems();
        principiosActivos.forEach(principioActivo -> {
            principioActivoComboBox.addItem(principioActivo);
        });

        principioActivoComboBox.setEnabled(principioActivoComboBox.getItemCount() > 0);
        deletePrincipioActivo.setEnabled(principioActivoComboBox.getItemCount() > 0);
        principioActivoComboBox.revalidate();
        principioActivoComboBox.repaint();
    }

    public PrincipioActivo getSelectedPrincipioActivo() {
        return (PrincipioActivo) principioActivoComboBox.getSelectedItem();
    }

    public void swicher(boolean swicher) {
        principioActivoComboBox.setEnabled(swicher);
        addPrincipioActivo.setEnabled(swicher);
        deletePrincipioActivo.setEnabled(swicher);
    }

    public void setDefaultItem(PrincipioActivo principioActivo) {
        principioActivoComboBox.addItem(principioActivo);
        principioActivoComboBox.setSelectedItem(principioActivo);
    }
}
