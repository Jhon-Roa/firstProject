package com.firstproject.cliente.infrastructure.in;

import java.awt.BorderLayout;
import java.util.List;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.firstproject.cliente.application.SeeAllClientesNoDtoUseCase;
import com.firstproject.cliente.domain.entity.Cliente;

public class ClienteDropDown extends JPanel {
    private JButton buscarCliente;
    private JComboBox<Cliente> clienteComboBox;
    private SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase;

    public ClienteDropDown(ActionListener actionListenerDropDown, 
    ActionListener actionListenerButton, 
    SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase) {
        this.seeAllClientesNoDtoUseCase = seeAllClientesNoDtoUseCase;

        buscarCliente = new JButton("Buscar");
        buscarCliente.addActionListener(actionListenerButton);

        clienteComboBox = new JComboBox<>();
        clienteComboBox.setSelectedItem("seleccionar");
        clienteComboBox.addActionListener(actionListenerDropDown);

        setLayout(new BorderLayout());

        add(clienteComboBox, BorderLayout.CENTER);
        add(buscarCliente, BorderLayout.EAST);
    }

    public void updatCliente() {
        List<Cliente> clientes = seeAllClientesNoDtoUseCase.execute();
        clienteComboBox.removeAllItems();
        clientes.forEach(cliente -> {
            clienteComboBox.addItem(cliente);
        });

        inHabilitarFuncion();
    }

    public Cliente getSelectedCliente() {
        return (Cliente) clienteComboBox.getSelectedItem();
    }

    private void inHabilitarFuncion() {
        if (clienteComboBox.getItemCount() == 0) {
            clienteComboBox.setEnabled(false);
            buscarCliente.setEnabled(false);

            revalidate();
            repaint();
        }
    }
}
