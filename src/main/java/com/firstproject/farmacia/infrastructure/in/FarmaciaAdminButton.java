package com.firstproject.farmacia.infrastructure.in;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FarmaciaAdminButton extends JPanel {
    private boolean menuExpanded = false;
    private JPanel optionsPanel;

    public FarmaciaAdminButton (ActionListener actionListenerCreate,
    ActionListener actionListenerDelete,
    ActionListener actionListenerUpdate,
    ActionListener actionListenerShowAll) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(getWidth(), 200));

        JButton toggleMenuButton = new JButton("MenuFarmacia");
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

        JButton crearFarmacia = designButton(new JButton("Crear farmacia"));
        JButton updateFarmacia = designButton(new JButton("Actualizar farmacia"));
        JButton borrarFarmacia = designButton(new JButton("Borrar farmacia"));
        JButton verFarmacias = designButton(new JButton("Ver o buscar"));

        optionsPanel.add(crearFarmacia);
        optionsPanel.add(updateFarmacia);
        optionsPanel.add(borrarFarmacia);
        optionsPanel.add(verFarmacias);

        crearFarmacia.addActionListener(actionListenerCreate);
        updateFarmacia.addActionListener(actionListenerUpdate);
        borrarFarmacia.addActionListener(actionListenerDelete);
        verFarmacias.addActionListener(actionListenerShowAll);

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
