package com.firstproject.laboratorio.infrastructure.in;

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

import com.firstproject.laboratorio.application.BorrarLaboratorioUseCase;
import com.firstproject.laboratorio.application.GetAllLaboratoriosUseCase;
import com.firstproject.laboratorio.application.GetSpecifiedLaboratorioUseCase;
import com.firstproject.laboratorio.domain.entity.Laboratorio;

public class DeleteLaboratorioJPanel extends JPanel {
    private LaboratorioDropDown laboratorioDropDown;

    private GetSpecifiedLaboratorioUseCase getSpecifiedLaboratorioUseCase;
    private BorrarLaboratorioUseCase borrarLaboratorioUseCase;
    private GetAllLaboratoriosUseCase getAllLaboratoriosUseCase;

    private boolean initializer;
    private boolean isProcessing;

    public DeleteLaboratorioJPanel(GetSpecifiedLaboratorioUseCase getSpecifiedLaboratorioUseCase,
    BorrarLaboratorioUseCase borrarLaboratorioUseCase,
    GetAllLaboratoriosUseCase getAllLaboratoriosUseCase) {
        this.getSpecifiedLaboratorioUseCase = getSpecifiedLaboratorioUseCase;
        this.borrarLaboratorioUseCase = borrarLaboratorioUseCase;
        this.getAllLaboratoriosUseCase = getAllLaboratoriosUseCase;

        initializer = true;

        setLayout(new BorderLayout());
        setPreferredSize((new Dimension(500, 500)));

        initComponents();

        addComponentsToPanel();

        initializer = false;
    }

    private void initComponents() {
        laboratorioDropDown = new LaboratorioDropDown(seleccionarLaboratorio(), 
        buscarLaboratorio(), 
        getAllLaboratoriosUseCase);
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
        JLabel laboratorioLabel = new JLabel("laboratorio");
        createClienteFormulario.add(laboratorioLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        laboratorioDropDown.updateLaboratorio();
        createClienteFormulario.add(laboratorioDropDown, gbc);

        add(createClienteFormulario, BorderLayout.CENTER);
    }

    private ActionListener buscarLaboratorio() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bucle = true;
                int idLaboratorio = -1;
                do {
                    try {
                        String input = JOptionPane.showInputDialog(null, "ingrese la id del laboratorio", "buscar laboratorio", JOptionPane.PLAIN_MESSAGE);
                        if (input == null) {
                            return;
                        }
                        idLaboratorio = Integer.parseInt(input);
                        bucle = !bucle; 
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, "ingresa un numero entero", "error", JOptionPane.ERROR_MESSAGE);
                    }
                } while (bucle);
                Optional<Laboratorio> laboratorioOp = getSpecifiedLaboratorioUseCase.execute(idLaboratorio);
                if (!laboratorioOp.isPresent()) {
                    JOptionPane.showMessageDialog(null, "operacion cancelada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Laboratorio laboratorio = laboratorioOp.get();
                isProcessing = true;
                eliminarLaboratorio(laboratorio);
            }
        };
    }

    private ActionListener seleccionarLaboratorio() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!initializer && !isProcessing) {
                    Laboratorio laboratorio = laboratorioDropDown.getSelectedLaboratorio();
                    eliminarLaboratorio(laboratorio);
                }
            } 
        };
    }

    private void eliminarLaboratorio(Laboratorio laboratorio) {
        int continuar = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar este laboratorio?", "eliminar laboratorio", JOptionPane.YES_NO_OPTION);

        if (continuar == 0) {
            borrarLaboratorioUseCase.execute(laboratorio.getIdLaboratorio());
            JOptionPane.showMessageDialog(null, "eliminado correctamente", "eliminado", JOptionPane.INFORMATION_MESSAGE);
            laboratorioDropDown.updateLaboratorio();
            isProcessing = false;
        }
    }
}
