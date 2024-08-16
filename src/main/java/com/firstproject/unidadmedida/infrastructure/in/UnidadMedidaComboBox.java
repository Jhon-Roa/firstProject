package com.firstproject.unidadmedida.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.firstproject.unidadmedida.application.GetAllUnidadesMedidaUseCase;
import com.firstproject.unidadmedida.domain.entity.UnidadMedida;

public class UnidadMedidaComboBox extends JPanel {
    private JButton addUnidadMedida;
    private JButton deleteUnidadMedida;
    private JComboBox<UnidadMedida> unidadMedidaComboBox;
    private GetAllUnidadesMedidaUseCase getAllUnidadesMedidaUseCase;

    public UnidadMedidaComboBox(ActionListener actionListenerBorrar,
    ActionListener actionListenerCrear,
    GetAllUnidadesMedidaUseCase getAllUnidadesMedidaUseCase) {
        this.getAllUnidadesMedidaUseCase = getAllUnidadesMedidaUseCase;

        addUnidadMedida = new JButton("+");
        addUnidadMedida.addActionListener(actionListenerCrear);

        deleteUnidadMedida = new JButton("-");
        deleteUnidadMedida.addActionListener(actionListenerBorrar);

        unidadMedidaComboBox = new JComboBox<>();

        setLayout(new BorderLayout());

        add(unidadMedidaComboBox, BorderLayout.CENTER);
        add(addUnidadMedida, BorderLayout.EAST);
        add(deleteUnidadMedida, BorderLayout.WEST);

        setEnabled(false);
    }

    public void updateUnidadMedida() {
        List<UnidadMedida> unidadesMedida = getAllUnidadesMedidaUseCase.execute();
        unidadMedidaComboBox.removeAllItems();
        unidadesMedida.forEach(unidadMedida -> {
            unidadMedidaComboBox.addItem(unidadMedida);
        });

        unidadMedidaComboBox.setEnabled(unidadMedidaComboBox.getItemCount() > 0);
        deleteUnidadMedida.setEnabled(unidadMedidaComboBox.getItemCount() > 0);
        unidadMedidaComboBox.revalidate();
        unidadMedidaComboBox.repaint();
    }

    public UnidadMedida getSelectedUnidadMedida() {
        return (UnidadMedida) unidadMedidaComboBox.getSelectedItem();
    }

    public void swicher(boolean swicher) {
        unidadMedidaComboBox.setEnabled(swicher);
        addUnidadMedida.setEnabled(swicher);
        deleteUnidadMedida.setEnabled(swicher);
    }

    public void setDefaultItem(UnidadMedida unidadMedida) {
        unidadMedidaComboBox.addItem(unidadMedida);
        unidadMedidaComboBox.setSelectedItem(unidadMedida);
    }
}
