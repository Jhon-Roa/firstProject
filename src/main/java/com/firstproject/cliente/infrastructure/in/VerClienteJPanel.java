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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.firstproject.cliente.application.FindClientByIdUseCase;
import com.firstproject.cliente.application.SeeAllClientesNoDtoUseCase;
import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.cliente.domain.entity.ClienteDto;

public class VerClienteJPanel extends JPanel {
    private ClienteDropDown clienteDropDown;
    private FindClientByIdUseCase findClientByIdUseCase;
    private SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase;

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane jScrollPane;
    private boolean initializer;

    public VerClienteJPanel(FindClientByIdUseCase findClientByIdUseCase,
            SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase) {
        this.findClientByIdUseCase = findClientByIdUseCase;
        this.seeAllClientesNoDtoUseCase = seeAllClientesNoDtoUseCase;

        initializer = true;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 300)); // Ajustar el alto preferido según sea necesario

        initComponents();
        addComponentsToPanel();

        initializer = false;
    }

    private void initComponents() {
        clienteDropDown = new ClienteDropDown(seleccionarCliente(), 
        buscarCliente(), 
        seeAllClientesNoDtoUseCase);
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
        JLabel clienteLabel = new JLabel("Cliente");
        createClienteFormulario.add(clienteLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        clienteDropDown.updatCliente();
        createClienteFormulario.add(clienteDropDown, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH; // Cambiado a BOTH para que se expanda vertical y horizontalmente
        String[] columnNames = {"ID", "Nombre", "Apellido", "Edad", "Fecha de Registro", "Barrio"};

        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Para que no ajuste automáticamente las columnas
        table.getColumnModel().getColumn(0).setPreferredWidth(81);
        table.getColumnModel().getColumn(1).setPreferredWidth(81);
        table.getColumnModel().getColumn(2).setPreferredWidth(81);
        table.getColumnModel().getColumn(3).setPreferredWidth(81);
        table.getColumnModel().getColumn(4).setPreferredWidth(81);
        table.getColumnModel().getColumn(5).setPreferredWidth(81);

        jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(470, 40)); 
        jScrollPane.setVisible(false); 
        createClienteFormulario.add(jScrollPane, gbc);

        add(createClienteFormulario, BorderLayout.CENTER);
    }

    private ActionListener buscarCliente() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idCliente = JOptionPane.showInputDialog(null, "Ingrese la ID del cliente", "Buscar Cliente",
                        JOptionPane.PLAIN_MESSAGE);
                if (idCliente != null && !idCliente.isEmpty()) {
                    Optional<ClienteDto> clienteOp = findClientByIdUseCase.execute(idCliente);
                    if (!clienteOp.isPresent()) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    ClienteDto cliente = clienteOp.get();
                    showClienteDto(cliente);
                }
            }
        };
    }

    private ActionListener seleccionarCliente() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!initializer) {
                    Cliente cliente = clienteDropDown.getSelectedCliente();
                    Optional<ClienteDto> clienteOp = findClientByIdUseCase.execute(cliente.getIdCliente());
                    if (!clienteOp.isPresent()) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    ClienteDto clienteDto = clienteOp.get();
                    showClienteDto(clienteDto);
                }
            }
        };
    }

    private void showClienteDto(ClienteDto cliente) {
        String nombre = String.format("%s, %s", cliente.getPrimerNombre(), cliente.getSegundoNombre());
        String apellido = cliente.getPrimerApellido() + " " + cliente.getSegundoApellido();
        Object[] rowData = {cliente.getIdCliente(), nombre, apellido, cliente.getEdad(), cliente.getFechaRegistro(),
                cliente.getBarrio()};
        model.addRow(rowData);


        jScrollPane.setVisible(true);

        revalidate(); 
        repaint();
    }
}
