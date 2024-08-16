package com.firstproject.medicina.infrastructure.in;

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

import com.firstproject.medicina.application.BorrarMedicinaUseCase;
import com.firstproject.medicina.application.GetAllMedicinasUseCase;
import com.firstproject.medicina.application.GetSpecifedMedicinaUseCase;
import com.firstproject.medicina.domain.entity.Medicina;

public class DeleteMedicinaJPanel extends JPanel{
    private MedicinaDropDown medicinaDropDown;

    private GetSpecifedMedicinaUseCase getSpecifedMedicinaUseCase;
    private BorrarMedicinaUseCase borrarMedicinaUseCase;
    private GetAllMedicinasUseCase getAllMedicinasUseCase;

    private boolean initializer;
    private boolean isProcessing;

    public DeleteMedicinaJPanel(GetSpecifedMedicinaUseCase getSpecifedMedicinaUseCase,
    BorrarMedicinaUseCase borrarMedicinaUseCase, 
    GetAllMedicinasUseCase getAllMedicinasUseCase) {
        this.getSpecifedMedicinaUseCase = getSpecifedMedicinaUseCase;
        this.borrarMedicinaUseCase = borrarMedicinaUseCase;
        this.getAllMedicinasUseCase = getAllMedicinasUseCase;

        initializer = true;

        setLayout(new BorderLayout());
        setPreferredSize((new Dimension(500, 500)));

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
                        JOptionPane.showMessageDialog(null, "ingresa un numero entero", "error", ERROR);
                    }
                } while (bucle);
                Optional<Medicina> medicinaOp = getSpecifedMedicinaUseCase.execute(idMedicina);
                if (!medicinaOp.isPresent()) {
                    JOptionPane.showMessageDialog(null, "operacion cancelada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Medicina medicina = medicinaOp.get();
                isProcessing = true;
                eliminarMedicina(medicina);
            }
            
        };
    }

    private ActionListener seleccionarMedicina() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!initializer && !isProcessing) {
                    Medicina medicina = medicinaDropDown.getSelectedMedicina();
                    eliminarMedicina(medicina);
                    
                }
            }
        };
    }

    private void eliminarMedicina(Medicina medicina) {
        int continuar = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar este cliente?", "eliminar cliente", JOptionPane.YES_NO_OPTION);

        if (continuar == 0) {
            borrarMedicinaUseCase.execute(medicina.getIdMedicina());
            JOptionPane.showMessageDialog(null, "eliminado correctamente", "eliminado", JOptionPane.INFORMATION_MESSAGE);
            medicinaDropDown.updateMedicina();
            isProcessing = false;
        }
    } 
}
