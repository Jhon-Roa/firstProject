package com.firstproject.cliente.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.firstproject.cliente.application.DeleteClienteUseCase;
import com.firstproject.cliente.application.FindClienteByIdNoDtoUseCase;
import com.firstproject.cliente.application.SeeAllClientesNoDtoUseCase;
import com.firstproject.cliente.domain.entity.Cliente;

public class DeleteClienteJPanel extends JPanel{
    private ClienteDropDown clienteDropDown;

    private FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase;
    private DeleteClienteUseCase deleteClienteUseCase;
    private SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase;

    private boolean initializer;

    public DeleteClienteJPanel(FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase,
    DeleteClienteUseCase deleteClienteUseCase,
    SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase) {
        this.findClienteByIdNoDtoUseCase = findClienteByIdNoDtoUseCase;
        this.deleteClienteUseCase = deleteClienteUseCase;
        this.seeAllClientesNoDtoUseCase = seeAllClientesNoDtoUseCase;

        initializer = true;

        setLayout(new BorderLayout());
        setPreferredSize((new Dimension(500, 500)));

        initComponents();

        addComponentsToPanel();

        initializer = false;
    }

    private void initComponents() {
        clienteDropDown = new ClienteDropDown(seleccionarCliente(), buscarCliente(),seeAllClientesNoDtoUseCase);
    }

    private void addComponentsToPanel() {
        JPanel createClienteFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel clienteLabel = new JLabel("cliente");
        createClienteFormulario.add(clienteLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        clienteDropDown.updatCliente();
        createClienteFormulario.add(clienteDropDown, gbc);

        add(createClienteFormulario, BorderLayout.CENTER);
    }

    private ActionListener buscarCliente() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idCliente = JOptionPane.showInputDialog(null, "ingrese la id del cliente", "buscar cliente", JOptionPane.PLAIN_MESSAGE);
                Optional<Cliente> clienteOp = findClienteByIdNoDtoUseCase.execute(idCliente);
                if(!clienteOp.isPresent()) {
                    JOptionPane.showMessageDialog(null, "operacion cancelada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Cliente cliente = clienteOp.get();
                eliminarCliente(cliente);
            }
        };
    }
    
    private ActionListener seleccionarCliente() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(! initializer) {
                    Cliente cliente = clienteDropDown.getSelectedCliente();
                    eliminarCliente(cliente);
                }
            }
        };
    }

    private void eliminarCliente(Cliente cliente) {
        int continuar = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar este cliente?", "eliminar cliente", JOptionPane.YES_NO_OPTION);

        if (continuar == 0) {
            deleteClienteUseCase.execute(cliente.getIdCliente());
            JOptionPane.showMessageDialog(null, "eliminado correctamente", "eliminado", JOptionPane.INFORMATION_MESSAGE);
            clienteDropDown.updatCliente();
        }
    }
}   

