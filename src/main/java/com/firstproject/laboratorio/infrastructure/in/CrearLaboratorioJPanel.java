package com.firstproject.laboratorio.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.firstproject.barrio.application.CreateBarrioUseCase;
import com.firstproject.barrio.application.GetAllBarriosUseCase;
import com.firstproject.barrio.domain.entity.Barrio;
import com.firstproject.barrio.infrastructure.in.BarrioDropDown;
import com.firstproject.ciudad.application.GetAllCiudadesUseCase;
import com.firstproject.ciudad.domain.entity.Ciudad;
import com.firstproject.ciudad.infrastructure.in.CiudadDropDown;
import com.firstproject.laboratorio.application.CrearLaboratorioUseCase;
import com.firstproject.laboratorio.domain.entity.Laboratorio;
import com.firstproject.pais.application.GetAllPaisesUseCase;
import com.firstproject.pais.domain.entity.Pais;
import com.firstproject.pais.infrastructure.in.PaisDropDown;
import com.firstproject.region.application.GetAllRegionesUseCase;
import com.firstproject.region.domain.entity.Region;
import com.firstproject.region.infrastructure.in.RegionDropDown;

public class CrearLaboratorioJPanel extends JPanel {
    // clases de laboratorios
    private CrearLaboratorioUseCase crearLaboratorioUseCase;

    // clases de paises
    private GetAllPaisesUseCase getAllPaisesUseCase;
    private PaisDropDown paisDropDown;

    // clases de regiones
    private GetAllRegionesUseCase allRegionesUseCase;
    private RegionDropDown regionDropDown;

    // clases de ciudades
    private GetAllCiudadesUseCase getAllCiudadesUseCase;
    private CiudadDropDown ciudadDropDown;

    // clases de barrios
    private GetAllBarriosUseCase getAllBarriosUseCase;
    private CreateBarrioUseCase createBarrioUseCase;
    private BarrioDropDown barrioDropDown;

    // Componentes del formulario
    private JTextField nombrTextField;

    public CrearLaboratorioJPanel(CrearLaboratorioUseCase crearLaboratorioUseCase,
    GetAllPaisesUseCase getAllPaisesUseCase,
    GetAllRegionesUseCase getAllRegionesUseCase,
    GetAllCiudadesUseCase getAllCiudadesUseCase,
    GetAllBarriosUseCase getAllBarriosUseCase,
    CreateBarrioUseCase createBarrioUseCase) {
        this.crearLaboratorioUseCase = crearLaboratorioUseCase;
        this.getAllPaisesUseCase = getAllPaisesUseCase;
        this.allRegionesUseCase = getAllRegionesUseCase;
        this.getAllCiudadesUseCase = getAllCiudadesUseCase;
        this.getAllBarriosUseCase = getAllBarriosUseCase;
        this.createBarrioUseCase = createBarrioUseCase;

        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 500));

        // Initialize components
        initComponents();

        // Add components to the panel
        addComponentsToPanel();
    }

    private void initComponents() {
        paisDropDown = new PaisDropDown(habilitarRegion(), getAllPaisesUseCase);
        regionDropDown = new RegionDropDown(habilitarCiudad(), allRegionesUseCase);
        ciudadDropDown = new CiudadDropDown(habilitarBarrio(), getAllCiudadesUseCase);
        barrioDropDown = new BarrioDropDown(crearBarrio(), getAllBarriosUseCase);
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
        JLabel nombre = new JLabel("Nombre*:");
        createClienteFormulario.add(nombre, gbc);
        
        gbc.gridx = 1;
        nombrTextField = new JTextField(20);
        createClienteFormulario.add(nombrTextField, gbc);

        nombrTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (nombrTextField.getText().length() > 99) {
                    e.consume();
                }
            }
        });

        // País
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel paisLabel = new JLabel("País:");
        createClienteFormulario.add(paisLabel, gbc);
    
        gbc.gridx = 1;
        paisDropDown.updatePaises();
        createClienteFormulario.add(paisDropDown, gbc);
    
        // Región
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel regionLabel = new JLabel("Región:");
        createClienteFormulario.add(regionLabel, gbc);
    
        gbc.gridx = 1;
        createClienteFormulario.add(regionDropDown, gbc);
    
        // Ciudad
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel ciudadLabel = new JLabel("Ciudad:");
        createClienteFormulario.add(ciudadLabel, gbc);
    
        gbc.gridx = 1;
        createClienteFormulario.add(ciudadDropDown, gbc);
    
        // Barrio
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel barrioLabel = new JLabel("Barrio*:");
        createClienteFormulario.add(barrioLabel, gbc);
    
        gbc.gridx = 1;
        createClienteFormulario.add(barrioDropDown, gbc);

         // Crear un panel para el botón "Guardar Usuario"
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); // Espacio alrededor del botón
        JButton guardarUsuarioButton = new JButton("Guardar Laboratorio");
        buttonPanel.add(guardarUsuarioButton);
    
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
        guardarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarLaboratorio(); // Llama a la función para obtener y mostrar los datos
            }
        });
    }

    private void guardarLaboratorio() {
        String nombre = nombrTextField.getText();
        Barrio barrio = barrioDropDown.getSelecteBarrio();
        
        if (nombre.isEmpty() || barrio == null) {
            JOptionPane.showMessageDialog(null, "Estás ingresando valores nulos o vacíos en los campos marcados como obligatorios.", "Operación inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Laboratorio laboratorio = new Laboratorio(0, 
        nombre, 
        barrio.getIdBarrio());

        crearLaboratorioUseCase.execute(laboratorio);

        nombrTextField.setText("");

        JOptionPane.showMessageDialog(null, "guardado correctamente", "guardado", JOptionPane.INFORMATION_MESSAGE);
    }

    private ActionListener habilitarRegion() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (regionDropDown != null) {
                    Pais selectedPais = paisDropDown.getSelectedPais();
                    regionDropDown.updateRegions(selectedPais);
                    
                }
            }
        };
    }

    private ActionListener habilitarCiudad() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ciudadDropDown != null) {
                    Region selectedRegion = regionDropDown.getSelectedRegion();
                    ciudadDropDown.updateCiudades(selectedRegion);
                }
            }
        };
    }

    private ActionListener habilitarBarrio() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (barrioDropDown != null) {
                    Ciudad selectedCiudad = ciudadDropDown.getSelecteCiudad();
                    barrioDropDown.updateBarrios(selectedCiudad);
                }
            }
        };
    }

    private ActionListener crearBarrio() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el barrio", "Añadir barrio", JOptionPane.PLAIN_MESSAGE);
                if (nombre == null || nombre.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada", "Información", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                Ciudad ciudad = ciudadDropDown.getSelecteCiudad();
                createBarrioUseCase.execute(nombre, ciudad);
                barrioDropDown.updateBarrios(ciudad);
            }
        };
    }
}

