package com.firstproject.farmaciamedicina.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.firstproject.farmacia.application.GetAllFarmaciasUseCase;
import com.firstproject.farmacia.application.GetSpecifiedFarmaciaUseCase;
import com.firstproject.farmacia.domain.entity.Farmacia;
import com.firstproject.farmacia.infrastructure.in.FarmaciaDropDown;
import com.firstproject.farmaciamedicina.application.DeleteMedicinaFromFarmaciaUseCase;
import com.firstproject.farmaciamedicina.domain.entity.FarmaciaMedicina;
import com.firstproject.medicina.application.GetAllMedicinasUseCase;
import com.firstproject.medicina.application.GetSpecifedMedicinaUseCase;
import com.firstproject.medicina.domain.entity.Medicina;
import com.firstproject.medicina.infrastructure.in.MedicinaDropDown;

public class DeleteFarmaciaMedicinaJPanel extends JPanel{
    //clases de farmacia medicina
    private DeleteMedicinaFromFarmaciaUseCase deleteMedicinaFromFarmaciaUseCase;

    //clases de farmacia
    private GetSpecifiedFarmaciaUseCase getSpecifiedFarmaciaUseCase;
    private GetAllFarmaciasUseCase getAllFarmaciasUseCase;
    private FarmaciaDropDown farmaciaDropDown;

    //clases de medicina
    private GetSpecifedMedicinaUseCase getSpecifedMedicinaUseCase;
    private GetAllMedicinasUseCase getAllMedicinasUseCase;
    private MedicinaDropDown medicinaDropDown;
    public DeleteFarmaciaMedicinaJPanel(DeleteMedicinaFromFarmaciaUseCase deleteMedicinaFromFarmaciaUseCase,
    GetSpecifiedFarmaciaUseCase getSpecifiedFarmaciaUseCase, GetAllFarmaciasUseCase getAllFarmaciasUseCase,
    GetSpecifedMedicinaUseCase getSpecifedMedicinaUseCase, GetAllMedicinasUseCase getAllMedicinasUseCase) {
        this.deleteMedicinaFromFarmaciaUseCase = deleteMedicinaFromFarmaciaUseCase;
        this.getSpecifiedFarmaciaUseCase = getSpecifiedFarmaciaUseCase;
        this.getAllFarmaciasUseCase = getAllFarmaciasUseCase;
        this.getSpecifedMedicinaUseCase = getSpecifedMedicinaUseCase;
        this.getAllMedicinasUseCase = getAllMedicinasUseCase;
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 500));

        // Initialize components
        initComponents();

        // Add components to the panel
        addComponentsToPanel();
    }

    private void addComponentsToPanel() {
        JPanel createClienteFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel farmaciaLabel = new JLabel("farmacia");
        createClienteFormulario.add(farmaciaLabel, gbc);

        gbc.gridx = 1;
        farmaciaDropDown.updateFarmacia();
        createClienteFormulario.add(farmaciaDropDown, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel medicinaLabel = new JLabel("medicina");
        createClienteFormulario.add(medicinaLabel, gbc);

        gbc.gridx = 1;
        medicinaDropDown.updateMedicina();
        createClienteFormulario.add(medicinaDropDown, gbc);

        //Guardar FarmaciaMedicina
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); // Espacio alrededor del botón
        JButton actualizarMedicinaButton = new JButton("Borrar farmaciaMedicina");
        buttonPanel.add(actualizarMedicinaButton);

        // Agregar el panel del botón al formulario
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.fill = GridBagConstraints.NONE; // No expandir
        gbc.anchor = GridBagConstraints.CENTER; // Centrar dentro de la celda
        gbc.weightx = 0.0; // No expandir horizontalmente
    
        createClienteFormulario.add(buttonPanel, gbc);
    
        add(createClienteFormulario, BorderLayout.CENTER);

        // Acción del botón "Guardar Usuario"
        actualizarMedicinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarFarmaciaMedicina(); // Llama a la función para obtener y mostrar los datos
            }
        });
    } 

    private void initComponents() {
        medicinaDropDown = new MedicinaDropDown(null, 
        buscarMedicina(), 
        getAllMedicinasUseCase);
        farmaciaDropDown = new FarmaciaDropDown(null, 
        buscarFarmacia(), 
        getAllFarmaciasUseCase);
    }

    private void borrarFarmaciaMedicina() {
        Farmacia farmacia = farmaciaDropDown.getSelectedFarmacia();
        Medicina medicina = medicinaDropDown.getSelectedMedicina();

        FarmaciaMedicina farmaciaMedicina = new FarmaciaMedicina(farmacia.getIdFarmacia(), 
        medicina.getIdMedicina(), 
        0);

        
        boolean borrado = deleteMedicinaFromFarmaciaUseCase.execute(farmaciaMedicina);
        
        if (borrado) {
            JOptionPane.showMessageDialog(null, "borrado correctamente", "borrado", JOptionPane.INFORMATION_MESSAGE);
        }
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
                Optional<Farmacia> farmaciaOp = getSpecifiedFarmaciaUseCase.execute(idFarmacia);
                if (!farmaciaOp.isPresent()) {
                    JOptionPane.showMessageDialog(null, "operacion cancelada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Farmacia farmacia = farmaciaOp.get();
                farmaciaDropDown.setDefaultItem(farmacia);;
            }
        };
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
                Optional<Medicina> medicinaOp = getSpecifedMedicinaUseCase.execute(idMedicina);
                if (!medicinaOp.isPresent()) {
                    JOptionPane.showMessageDialog(null, "operacion cancelada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Medicina medicina = medicinaOp.get();
                medicinaDropDown.setDefaultItem(medicina);
            }
            
        };
    }
}
