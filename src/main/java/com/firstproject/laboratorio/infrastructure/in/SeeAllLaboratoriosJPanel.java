package com.firstproject.laboratorio.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.firstproject.laboratorio.application.GetAllLaboratorioDtosUseCase;
import com.firstproject.laboratorio.domain.entity.LaboratorioDto;

public class SeeAllLaboratoriosJPanel extends JPanel {
    private GetAllLaboratorioDtosUseCase getAllLaboratorioDtosUseCase;

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane jScrollPane;

    public SeeAllLaboratoriosJPanel(GetAllLaboratorioDtosUseCase getAllLaboratorioDtosUseCase) {
        this.getAllLaboratorioDtosUseCase = getAllLaboratorioDtosUseCase;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 500));

        addComponentsToPanel();
    }

    private void addComponentsToPanel() {
        JPanel createPanelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx= 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        String[] columnNames = {"idLaboratorio", "nombre", "Barrio"};

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
        createPanelFormulario.add(jScrollPane, gbc);

        showAllLaboratoriosDto();

        add(createPanelFormulario, BorderLayout.CENTER);
    }

    private void showAllLaboratoriosDto() {
        List<LaboratorioDto> laboratorios = getAllLaboratorioDtosUseCase.execute();
        laboratorios.forEach(laboratorio -> {
            Object[] rowData = {laboratorio.getIdLaboratorio(), laboratorio.getNombre(), laboratorio.getNombreBarrio()};
            model.addRow(rowData);
        });

        revalidate();
    }
}
