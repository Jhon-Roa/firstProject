package com.firstproject.farmaciamedicina.infrastructure.in;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FarmaciaMedicinaAdminButton extends JPanel {
    private boolean menuExpanded = false;
    private JPanel optionsPanel;

    public FarmaciaMedicinaAdminButton(ActionListener actionListenerCreate,
    ActionListener actionListenerDelete,
    ActionListener actionListenerList) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(getWidth(), 200));

        JButton toggleMenuButton = new JButton("MenuFarmaciaMedicina");
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

        JButton crearFarmaciaMedicina = designButton(new JButton("Crear farmaciaMedicina"));
        JButton borrarFarmaciaMedicina = designButton(new JButton("borrar farmaciaMedicina"));
        JButton listarFarmaciaMedicina = designButton(new JButton("ListarMedicinasFarmacia"));

        optionsPanel.add(crearFarmaciaMedicina);
        optionsPanel.add(borrarFarmaciaMedicina);
        optionsPanel.add(listarFarmaciaMedicina);

        crearFarmaciaMedicina.addActionListener(actionListenerCreate);
        borrarFarmaciaMedicina.addActionListener(actionListenerDelete);
        listarFarmaciaMedicina.addActionListener(actionListenerList);
        
        optionsPanel.setVisible(true);

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
