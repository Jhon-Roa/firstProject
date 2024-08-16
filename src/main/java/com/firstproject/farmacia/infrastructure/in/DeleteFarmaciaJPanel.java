package com.firstproject.farmacia.infrastructure.in;

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

import com.firstproject.farmacia.application.DeleteFarmaciaUseCase;
import com.firstproject.farmacia.application.GetAllFarmaciasUseCase;
import com.firstproject.farmacia.application.GetSpecifiedFarmaciaUseCase;
import com.firstproject.farmacia.domain.entity.Farmacia;

public class DeleteFarmaciaJPanel extends JPanel {
    private FarmaciaDropDown farmaciaDropDown;

    private GetSpecifiedFarmaciaUseCase getSpecifiedFarmaciaUseCase;
    private DeleteFarmaciaUseCase deleteFarmaciaUseCase;
    private GetAllFarmaciasUseCase getAllFarmaciasUseCase;

    private boolean initializer;
    private boolean isProcessing;

    public DeleteFarmaciaJPanel(GetSpecifiedFarmaciaUseCase getSpecifiedFarmaciaUseCase,
            DeleteFarmaciaUseCase deleteFarmaciaUseCase, 
            GetAllFarmaciasUseCase getAllFarmaciasUseCase) {
        this.getSpecifiedFarmaciaUseCase = getSpecifiedFarmaciaUseCase;
        this.deleteFarmaciaUseCase = deleteFarmaciaUseCase;
        this.getAllFarmaciasUseCase = getAllFarmaciasUseCase;
    
        initializer = true;

        setLayout(new BorderLayout());
        setPreferredSize((new Dimension(500, 500)));

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
        JLabel farmaciaLabel = new JLabel("farmacia");
        createClienteFormulario.add(farmaciaLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        farmaciaDropDown.updateFarmacia();
        createClienteFormulario.add(farmaciaDropDown, gbc);

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
                Optional<Farmacia> farmaciaOp = getSpecifiedFarmaciaUseCase.execute(idFarmacia);
                if (!farmaciaOp.isPresent()) {
                    JOptionPane.showMessageDialog(null, "operacion cancelada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Farmacia farmacia = farmaciaOp.get();
                isProcessing = true;
                eliminarFarmacia(farmacia);
            }
        };
    }

    private ActionListener seleccionarFarmacia() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!initializer && !isProcessing) {
                    Farmacia farmacia = farmaciaDropDown.getSelectedFarmacia();
                    eliminarFarmacia(farmacia);
                }
            }
        };
    }

    private void eliminarFarmacia(Farmacia farmacia) {
        int continuar = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar este cliente?", "eliminar cliente", JOptionPane.YES_NO_OPTION);

        if (continuar == 0) {
            deleteFarmaciaUseCase.execute(farmacia.getIdFarmacia());
            JOptionPane.showMessageDialog(null, "eliminado correctamente", "eliminado", JOptionPane.INFORMATION_MESSAGE);
            farmaciaDropDown.updateFarmacia();
            isProcessing = false;
        }
    } 
}
