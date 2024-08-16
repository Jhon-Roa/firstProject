package com.firstproject.farmaciamedicina.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.firstproject.farmacia.application.FindFarmaciaUseCase;
import com.firstproject.farmacia.application.GetAllFarmaciasUseCase;
import com.firstproject.farmacia.domain.entity.Farmacia;
import com.firstproject.farmacia.domain.entity.FarmaciaDto;
import com.firstproject.farmacia.infrastructure.in.FarmaciaDropDown;
import com.firstproject.farmaciamedicina.application.GetAllMedicinasFromFarmaciaUseCase;
import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicinaDto;

public class ListMedicamentosFromFarmaciaJPanel extends JPanel {
    private FarmaciaDropDown farmaciaDropDown;
    private GetAllMedicinasFromFarmaciaUseCase getAllMedicinasFromFarmaciaUseCase;
    private GetAllFarmaciasUseCase getAllFarmaciasUseCase;
    private FindFarmaciaUseCase findFarmaciaUseCase;

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane jScrollPane;

    private boolean initializer;
    private boolean isProcessing;
    public ListMedicamentosFromFarmaciaJPanel(GetAllMedicinasFromFarmaciaUseCase getAllMedicinasFromFarmaciaUseCase,
            GetAllFarmaciasUseCase getAllFarmaciasUseCase, FindFarmaciaUseCase findFarmaciaUseCase) {
        this.getAllMedicinasFromFarmaciaUseCase = getAllMedicinasFromFarmaciaUseCase;
        this.getAllFarmaciasUseCase = getAllFarmaciasUseCase;
        this.findFarmaciaUseCase = findFarmaciaUseCase;

        initializer = true;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 400)); // Ajustar el alto preferido según sea necesario

        initComponents();
        addComponentsToPanel();

        initializer = false;
        isProcessing = false;
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
        String[] columnNames = {"farmacia", "medicina", "precio"};

        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(0).setPreferredWidth(81);
        table.getColumnModel().getColumn(1).setPreferredWidth(81);
        table.getColumnModel().getColumn(2).setPreferredWidth(81);

        jScrollPane = new JScrollPane(table);

        jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(500, 400 )); 
        createClienteFormulario.add(jScrollPane, gbc);

        add(createClienteFormulario, BorderLayout.CENTER);
    }

    private void initComponents() {
        farmaciaDropDown = new FarmaciaDropDown(seleccionarFarmacia(), 
        buscarFarmacia(), 
        getAllFarmaciasUseCase);
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
                showMedicinasFarmacia(farmacia);
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
                    showMedicinasFarmacia(farmaciaDto);
                }
            }
        };
    }

    private void showMedicinasFarmacia(FarmaciaDto farmaciaDto) {
        List<FarmaciaMedicinaDto> farmaciasMedicinas = getAllMedicinasFromFarmaciaUseCase.execute(farmaciaDto.getIdFarmacia());
        farmaciasMedicinas.forEach(farmaciaMedicina -> {
            Object[] rowData = {farmaciaMedicina.getFarmacia(), farmaciaMedicina.getMedicina(), farmaciaMedicina.getPrecio()};
            model.addRow(rowData);
        });
    }
}

