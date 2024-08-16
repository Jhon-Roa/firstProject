package com.firstproject.medicina.infrastructure.in;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MedicinaAadminButton extends JPanel {
    private boolean menuExpanded = false;
    private JPanel optionsPanel;

    public MedicinaAadminButton(ActionListener actionListenerCreate,
    ActionListener actionListenerDelete,
    ActionListener actionListenerUpdate,
    ActionListener actionListenerShowAll) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(getWidth(), 200));

        JButton toggleMenuButton = new JButton("MenuMedicina");
        toggleMenuButton.setFont(new Font("Arial", Font.BOLD, 16));
        toggleMenuButton.setForeground(Color.WHITE);
        toggleMenuButton.setBackground(Color.BLACK);
        toggleMenuButton.setOpaque(true);
        toggleMenuButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        toggleMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleMenu();
            }
        });

        optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        JButton crearMedicina = designButton(new JButton("Crear Medicina"));
        JButton updateMedicina = designButton(new JButton("Actualizar Medicina"));
        JButton borrarMedicina = designButton(new JButton("Borrar Medicina"));
        JButton verMedicinas = designButton(new JButton("Ver o buscar"));

        optionsPanel.add(crearMedicina);
        optionsPanel.add(updateMedicina);
        optionsPanel.add(borrarMedicina);
        optionsPanel.add(verMedicinas);

        crearMedicina.addActionListener(actionListenerCreate);
        updateMedicina.addActionListener(actionListenerUpdate);
        borrarMedicina.addActionListener(actionListenerDelete);
        verMedicinas.addActionListener(actionListenerShowAll);

        optionsPanel.setVisible(menuExpanded);

        add(toggleMenuButton);
        add(optionsPanel);
    }

    private void toggleMenu() {
        menuExpanded = !menuExpanded;
        optionsPanel.setVisible(menuExpanded);
        revalidate();
        repaint();
    }

    private JButton designButton(JButton newButton) {
        newButton.setFont(new Font("Arial", Font.BOLD, 16));
        newButton.setForeground(Color.WHITE);
        newButton.setBackground(Color.DARK_GRAY);
        newButton.setOpaque(true);
        newButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Ancho máximo y altura fija
        return newButton;
    }
}
