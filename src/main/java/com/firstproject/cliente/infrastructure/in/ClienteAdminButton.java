package com.firstproject.cliente.infrastructure.in;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ClienteAdminButton extends JPanel {
    private boolean menuExpanded = false;
    private JPanel optionsPanel;

    public ClienteAdminButton(ActionListener actionListenerCreate, 
    ActionListener actionListenerUpdate, 
    ActionListener actionListenerDelete, 
    ActionListener actionListenerFindCliente,
    ActionListener actionListenerSeeAllClientes) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(getWidth(), 200)); // Ajusta el tamaño del JPanel si es necesario

        // Botón para expandir/colapsar el menú
        JButton toggleMenuButton = new JButton("MenuCliente");
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

        // Panel para las opciones del menú
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        // Crear opciones de menú
        JButton crearCliente = designButton(new JButton("Crear cliente"));
        JButton actualizarCliente = designButton(new JButton("Actualizar cliente"));
        JButton eliminarCliente = designButton(new JButton("Eliminar cliente"));
        JButton verClientes = designButton(new JButton("ver clientes"));
        JButton buscarCliente = designButton(new JButton("buscar cliente"));

        optionsPanel.add(crearCliente);
        optionsPanel.add(actualizarCliente);
        optionsPanel.add(eliminarCliente);
        optionsPanel.add(verClientes);
        optionsPanel.add(buscarCliente);

        crearCliente.addActionListener(actionListenerCreate);
        actualizarCliente.addActionListener(actionListenerUpdate);
        eliminarCliente.addActionListener(actionListenerDelete);
        verClientes.addActionListener(actionListenerSeeAllClientes);
        buscarCliente.addActionListener(actionListenerFindCliente);

        optionsPanel.setVisible(menuExpanded); // Inicialmente oculto

        // Agregar componentes al panel de menú
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
