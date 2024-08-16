package com.firstproject.laboratorio.infrastructure.in;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaboratorioAdminButton extends JPanel {
    private boolean menuExpanded = false;
    private JPanel optionsPanel;

    public LaboratorioAdminButton(ActionListener actionListenerCreate,
    ActionListener actionListenerDelete,
    ActionListener actionListenerGetAll) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(getWidth(), 200));

        JButton toggleMenuButton = new JButton("MenuLaboratorio");
        toggleMenuButton.setFont(new Font("Arial", Font.BOLD, 16));
        toggleMenuButton.setForeground(Color.WHITE);
        toggleMenuButton.setBackground(Color.BLACK);
        toggleMenuButton.setOpaque(true);
        toggleMenuButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50)); // Ancho máximo y altura fija

        toggleMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleMenu();
            }
        });

        optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        JButton crearLaboratorio = designButton(new JButton("Crear Laboratorio"));
        JButton borrarLaboratorio = designButton(new JButton("Borrar Laboratorio"));
        JButton verLaboratorios = designButton(new JButton("Ver laboratorios"));

        optionsPanel.add(crearLaboratorio);
        optionsPanel.add(borrarLaboratorio);
        optionsPanel.add(verLaboratorios);

        crearLaboratorio.addActionListener(actionListenerCreate);
        borrarLaboratorio.addActionListener(actionListenerDelete);
        verLaboratorios.addActionListener(actionListenerGetAll);

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
