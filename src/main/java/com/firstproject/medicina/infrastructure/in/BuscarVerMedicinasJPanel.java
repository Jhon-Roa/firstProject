package com.firstproject.medicina.infrastructure.in;

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

import com.firstproject.medicina.application.FindMedicinaUseCase;
import com.firstproject.medicina.application.GetAllMedicinasDtoUseCase;
import com.firstproject.medicina.application.GetAllMedicinasUseCase;
import com.firstproject.medicina.domain.entity.Medicina;
import com.firstproject.medicina.domain.entity.MedicinaDto;

public class BuscarVerMedicinasJPanel extends JPanel{
    private MedicinaDropDown medicinaDropDown;
    private FindMedicinaUseCase findMedicinaUseCase;
    private GetAllMedicinasDtoUseCase getAllMedicinasDtoUseCase;
    private GetAllMedicinasUseCase getAllMedicinasUseCase;

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane jScrollPane;
    private boolean initializer;
    private boolean isProcessing;

    public BuscarVerMedicinasJPanel(FindMedicinaUseCase findMedicinaUseCase,
    GetAllMedicinasDtoUseCase getAllMedicinasDtoUseCase, 
    GetAllMedicinasUseCase getAllMedicinasUseCase) {
        this.findMedicinaUseCase = findMedicinaUseCase;
        this.getAllMedicinasDtoUseCase = getAllMedicinasDtoUseCase;
        this.getAllMedicinasUseCase = getAllMedicinasUseCase;

        initializer = true;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 400)); // Ajustar el alto preferido según sea necesario

        initComponents();
        addComponentsToPanel();

        initializer = false;
        isProcessing = false;
    }

    private void initComponents() {
        medicinaDropDown = new MedicinaDropDown(seleccionarMedicina(), 
        buscarMedicina(), 
        getAllMedicinasUseCase);
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
        JLabel medicinaLabel = new JLabel("medicina");
        createClienteFormulario.add(medicinaLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        medicinaDropDown.updateMedicina();
        createClienteFormulario.add(medicinaDropDown, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        String[] columnNames = {"nombre", "viaAdministracion", "principioActivo", "unidadMedida", "laboratorio"};

        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);

        jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(500, 300)); 
        createClienteFormulario.add(jScrollPane, gbc);

        showAllFarmaciasDto();

        add(createClienteFormulario, BorderLayout.CENTER);
    }
    
    private ActionListener buscarMedicina() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bucle = true;
                int idMedicina = -1;
                do {
                    try {
                        String input = JOptionPane.showInputDialog(null, "ingrese la id de la medicina", "buscar medicina", JOptionPane.PLAIN_MESSAGE);   
                        if (input == null) {
                            return;
                        }
                        idMedicina = Integer.parseInt(input);
                        bucle = !bucle; 
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, "ingresa un numero entero", "error", JOptionPane.ERROR_MESSAGE);
                    }
                } while (bucle);
                Optional<MedicinaDto> medicinaOp = findMedicinaUseCase.execute(idMedicina);
                if (!medicinaOp.isPresent()) {
                    JOptionPane.showMessageDialog(null, "operacion cancelada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                MedicinaDto medicina = medicinaOp.get();
                isProcessing= true;
                showMedicina(medicina);
            }
            
        };
    }

    private ActionListener seleccionarMedicina() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!initializer && !isProcessing) {
                    Medicina medicina = medicinaDropDown.getSelectedMedicina();
                    MedicinaDto medicinaDto = (findMedicinaUseCase).execute(medicina.getIdMedicina()).get();
                    showMedicina(medicinaDto);
                }
            }
        };
    }

    private void showMedicina(MedicinaDto medicinaDto) {
        model.setRowCount(0);
        Object[] rowData = {medicinaDto.getNombre(), medicinaDto.getViaAdministracion(), medicinaDto.getPrincipioActivo(), medicinaDto.getUnidadMedida(), medicinaDto.getLaboratorio()};
        model.addRow(rowData);
        isProcessing = false;
    }

    private void showAllFarmaciasDto() {
        List<MedicinaDto> medicinas = getAllMedicinasDtoUseCase.execute();
        medicinas.forEach(medicinaDto -> {
            Object[] rowData = {medicinaDto.getNombre(), medicinaDto.getViaAdministracion(), medicinaDto.getPrincipioActivo(), medicinaDto.getUnidadMedida(), medicinaDto.getLaboratorio()};
            model.addRow(rowData);
        });
    }
}


