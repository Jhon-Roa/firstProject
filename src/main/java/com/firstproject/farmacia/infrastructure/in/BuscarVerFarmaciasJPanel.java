package com.firstproject.farmacia.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

import com.firstproject.farmacia.application.FindFarmaciaUseCase;
import com.firstproject.farmacia.application.GetAllFarmaciasDtoUseCase;
import com.firstproject.farmacia.application.GetAllFarmaciasUseCase;
import com.firstproject.farmacia.domain.entity.Farmacia;
import com.firstproject.farmacia.domain.entity.FarmaciaDto;

public class BuscarVerFarmaciasJPanel extends JPanel {
    private FarmaciaDropDown farmaciaDropDown;
    private FindFarmaciaUseCase findFarmaciaUseCase;
    private GetAllFarmaciasUseCase getAllFarmaciasUseCase;
    private GetAllFarmaciasDtoUseCase getAllFarmaciasDtoUseCase;

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane jScrollPane;

    private boolean initializer;
    private boolean isProcessing;

    public BuscarVerFarmaciasJPanel(FindFarmaciaUseCase findFarmaciaUseCase,
    GetAllFarmaciasUseCase getAllFarmaciasUseCase,
    GetAllFarmaciasDtoUseCase getAllFarmaciasDtoUseCase) {
        this.findFarmaciaUseCase = findFarmaciaUseCase;
        this.getAllFarmaciasUseCase = getAllFarmaciasUseCase;
        this.getAllFarmaciasDtoUseCase = getAllFarmaciasDtoUseCase;

        initializer = true;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 400)); // Ajustar el alto preferido según sea necesario

        initComponents();
        addComponentsToPanel();

        initializer = false;
        isProcessing = false;
    }

    private void initComponents() {
        farmaciaDropDown = new FarmaciaDropDown(seleccionarFarmacia(), 
        buscarFarmacia(), 
        getAllFarmaciasUseCase);
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
        JLabel farmaciaLabel = new JLabel("Farmacia");
        createClienteFormulario.add(farmaciaLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        farmaciaDropDown.updateFarmacia();
        createClienteFormulario.add(farmaciaDropDown, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        String[] columnNames = {"id", "nombre", "direccion", "barrio", "logo"};

        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setRowHeight(100);
        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);

        table.getColumnModel().getColumn(4).setCellRenderer(new ImageCellRenderer(100, 100)); // Establecer el renderizador de imágenes

        jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(500, 300)); 
        createClienteFormulario.add(jScrollPane, gbc);

        showAllFarmaciasDto();

        add(createClienteFormulario, BorderLayout.CENTER);
    }

    private ActionListener buscarFarmacia() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bucle = true;
                int idFarmacia = -1;
                do {
                    try {
                        String input = JOptionPane.showInputDialog(null, "ingrese la id de la farmacia", "buscar farmacia", JOptionPane.PLAIN_MESSAGE);   
                        if (input == null) {
                            return;
                        }
                        idFarmacia = Integer.parseInt(input);
                        bucle = !bucle; 
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, "ingresa un numero entero", "error", JOptionPane.ERROR_MESSAGE);
                    }
                } while (bucle);
                Optional<FarmaciaDto> farmaciaOp = findFarmaciaUseCase.execute(idFarmacia);
                if (!farmaciaOp.isPresent()) {
                    JOptionPane.showMessageDialog(null, "operacion cancelada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                FarmaciaDto farmacia = farmaciaOp.get();
                isProcessing = true;
                showFarmacia(farmacia);
            }
        };
    }

    private ActionListener seleccionarFarmacia() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!initializer && !isProcessing) {
                    Farmacia farmacia = farmaciaDropDown.getSelectedFarmacia();
                    Optional<FarmaciaDto> farmaciaOp = findFarmaciaUseCase.execute(farmacia.getIdFarmacia());
                    FarmaciaDto farmaciaDto = farmaciaOp.get();
                    showFarmacia(farmaciaDto);
                }
            }
        };
    }

    private void showFarmacia(FarmaciaDto farmacia) {
        model.setRowCount(0);
        ImageIcon logoIcon = (farmacia.getLogoFarmacia() != null) ? new ImageIcon(farmacia.getLogoFarmacia()) : (ImageIcon) UIManager.getIcon("OptionPane.warningIcon"); 
        Object[] rowData = {farmacia.getIdFarmacia(), farmacia.getNombre(), farmacia.getDireccion(), farmacia.getBarrio(), logoIcon};
        model.addRow(rowData);
        isProcessing = false;
    }

    private void showAllFarmaciasDto() {
        List<FarmaciaDto> farmacias = getAllFarmaciasDtoUseCase.execute();
        farmacias.forEach(farmacia -> {
            // Convertir el logo a ImageIcon
            ImageIcon logoIcon = (farmacia.getLogoFarmacia() != null) ? new ImageIcon(farmacia.getLogoFarmacia()) : (ImageIcon) UIManager.getIcon("OptionPane.warningIcon"); 
            Object[] rowData = {farmacia.getIdFarmacia(), farmacia.getNombre(), farmacia.getDireccion(), farmacia.getBarrio(), logoIcon};
            model.addRow(rowData);
        });
    }
}

