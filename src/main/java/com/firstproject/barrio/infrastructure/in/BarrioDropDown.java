package com.firstproject.barrio.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.firstproject.barrio.application.GetAllBarriosUseCase;
import com.firstproject.barrio.domain.entity.Barrio;
import com.firstproject.ciudad.domain.entity.Ciudad;

public class BarrioDropDown extends JPanel {
    private JButton addBarrio;
    private JComboBox<Barrio> barrioComboBox;
    private GetAllBarriosUseCase getAllBarriosUseCase;

    public BarrioDropDown(ActionListener actionListenerButton, GetAllBarriosUseCase getAllBarriosUseCase) {
        this.getAllBarriosUseCase = getAllBarriosUseCase;

        addBarrio = new JButton("+");
        addBarrio.addActionListener(actionListenerButton);

        barrioComboBox= new JComboBox<>();

        setLayout(new BorderLayout());

        add(barrioComboBox, BorderLayout.CENTER);
        add(addBarrio, BorderLayout.EAST);

        setEnabled(false);
    }

    public void unhabilitarBarrios() {
        
    }

    public void updateBarrios(Ciudad selectedCiudad) {
        if (selectedCiudad == null) {
            System.out.println("cargando barrios...");
            barrioComboBox.removeAllItems();
            setEnabled(false);
            return;
        } 

        List<Barrio> barrios = getAllBarriosUseCase.execute();
        barrioComboBox.removeAllItems();
        barrios.forEach(barrio -> {
            if (barrio.getIdCiudad() == selectedCiudad.getIdCiudad()) {
                barrioComboBox.addItem(barrio);
            }
        });

        barrioComboBox.setEnabled(barrioComboBox.getItemCount() > 0);
        barrioComboBox.revalidate();
        barrioComboBox.repaint();
    }

    public Barrio getSelecteBarrio() {
        return (Barrio) barrioComboBox.getSelectedItem();
    }

    public void reset() {
        barrioComboBox.removeAllItems();
        setEnabled(false);
    }
}
