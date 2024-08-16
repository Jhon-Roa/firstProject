package com.firstproject.farmacia.infrastructure.in;

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
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.firstproject.barrio.application.CreateBarrioUseCase;
import com.firstproject.barrio.application.GetAllBarriosUseCase;
import com.firstproject.barrio.application.GetSpecifiedBarrioUseCase;
import com.firstproject.barrio.domain.entity.Barrio;
import com.firstproject.barrio.infrastructure.in.BarrioDropDown;
import com.firstproject.ciudad.application.GetAllCiudadesUseCase;
import com.firstproject.ciudad.application.GetSpecifiedCiudadUseCase;
import com.firstproject.ciudad.domain.entity.Ciudad;
import com.firstproject.ciudad.infrastructure.in.CiudadDropDown;
import com.firstproject.farmacia.application.GetAllFarmaciasUseCase;
import com.firstproject.farmacia.application.GetSpecifiedFarmaciaUseCase;
import com.firstproject.farmacia.application.UpdateFarmaciaUseCase;
import com.firstproject.farmacia.domain.entity.Farmacia;
import com.firstproject.pais.application.GetAllPaisesUseCase;
import com.firstproject.pais.domain.entity.Pais;
import com.firstproject.pais.infrastructure.in.PaisDropDown;
import com.firstproject.region.application.GetAllRegionesUseCase;
import com.firstproject.region.application.GetSpecifiedPaisUseCase;
import com.firstproject.region.application.GetSpecifiedRegionUseCase;
import com.firstproject.region.domain.entity.Region;
import com.firstproject.region.infrastructure.in.RegionDropDown;

public class UpdateFarmaciaJPanel extends JPanel{
    // clases de farmacias
    private GetSpecifiedFarmaciaUseCase getSpecifiedFarmaciaUseCase;
    private GetAllFarmaciasUseCase getAllFarmaciasUseCase;
    private UpdateFarmaciaUseCase updateFarmaciaUseCase;
    private FarmaciaDropDown farmaciaDropDown;

    // clases de paises
    private GetAllPaisesUseCase getAllPaisesUseCase;
    private PaisDropDown paisDropDown;
    private GetSpecifiedPaisUseCase getSpecifiedPaisUseCase;

    // clases de regiones
    private GetAllRegionesUseCase allRegionesUseCase;
    private RegionDropDown regionDropDown;
    private GetSpecifiedRegionUseCase getSpecifiedRegionUseCase;

    // clases de ciudades
    private GetAllCiudadesUseCase getAllCiudadesUseCase;
    private CiudadDropDown ciudadDropDown;
    private GetSpecifiedCiudadUseCase getSpecifiedCiudadUseCase;

    // clases de barrios
    private GetAllBarriosUseCase getAllBarriosUseCase;
    private CreateBarrioUseCase createBarrioUseCase;
    private BarrioDropDown barrioDropDown;
    private GetSpecifiedBarrioUseCase getSpecifiedBarrioUseCase;

    // Componentes del formulario
    //Componentes de el formulario
    private JTextField nombreField;
    private JTextField direccionField;
    private JButton seleccionarLogoButton;
    private JButton actualizarFarmaciaButton;


    //Variables "globales"
    private byte[] logo;

    private boolean initializer;
    private boolean isProcessing;
    private int idFarmaciaToUpdate;

    public UpdateFarmaciaJPanel(GetSpecifiedFarmaciaUseCase getSpecifiedFarmaciaUseCase,
    GetAllFarmaciasUseCase getAllFarmaciasUseCase, 
    UpdateFarmaciaUseCase updateFarmaciaUseCase,
    GetAllPaisesUseCase getAllPaisesUseCase, 
    GetSpecifiedPaisUseCase getSpecifiedPaisUseCase,
    GetAllRegionesUseCase allRegionesUseCase, 
    GetSpecifiedRegionUseCase getSpecifiedRegionUseCase,
    GetAllCiudadesUseCase getAllCiudadesUseCase, 
    GetSpecifiedCiudadUseCase getSpecifiedCiudadUseCase,
    GetAllBarriosUseCase getAllBarriosUseCase, 
    CreateBarrioUseCase createBarrioUseCase,
    GetSpecifiedBarrioUseCase getSpecifiedBarrioUseCase) {
        this.getSpecifiedFarmaciaUseCase = getSpecifiedFarmaciaUseCase;
        this.getAllFarmaciasUseCase = getAllFarmaciasUseCase;
        this.updateFarmaciaUseCase = updateFarmaciaUseCase;
        this.getAllPaisesUseCase = getAllPaisesUseCase;
        this.getSpecifiedPaisUseCase = getSpecifiedPaisUseCase;
        this.allRegionesUseCase = allRegionesUseCase;
        this.getSpecifiedRegionUseCase = getSpecifiedRegionUseCase;
        this.getAllCiudadesUseCase = getAllCiudadesUseCase;
        this.getSpecifiedCiudadUseCase = getSpecifiedCiudadUseCase;
        this.getAllBarriosUseCase = getAllBarriosUseCase;
        this.createBarrioUseCase = createBarrioUseCase;
        this.getSpecifiedBarrioUseCase = getSpecifiedBarrioUseCase;

        initializer = true;

        setLayout(new BorderLayout());
        setPreferredSize((new Dimension(600, 500)));

        initComponents();

        addComponentsToPanel();

        initializer = false;
        isProcessing = false;
    }

    private void initComponents() {
        farmaciaDropDown = new FarmaciaDropDown(seleccionarFarmacia(), 
        buscarFarmacia(), 
        getAllFarmaciasUseCase);
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
        JLabel farmaciaLabel = new JLabel("farmacia");
        createClienteFormulario.add(farmaciaLabel, gbc);

        gbc.gridx = 1;
        farmaciaDropDown.updateFarmacia();
        createClienteFormulario.add(farmaciaDropDown, gbc);

        //nombre
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel nombre = new JLabel("Nombre*:");
        createClienteFormulario.add(nombre, gbc);
        
        gbc.gridx = 1;
        nombreField = new JTextField(20);
        nombreField.setEnabled(false);
        createClienteFormulario.add(nombreField, gbc);

        nombreField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (nombreField.getText().length() > 100) {
                    e.consume();
                }
            }
        });

        // Direccion
        row ++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel direccion = new JLabel("direccion*:");
        createClienteFormulario.add(direccion, gbc);

        gbc.gridx =1;
        direccionField = new JTextField(20);
        direccionField.setEnabled(false);
        createClienteFormulario.add(direccionField, gbc);

        direccionField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (nombreField.getText().length() > 100) {
                    e.consume();
                }
            }
        });

        // logo
        row ++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel logoLabel = new JLabel("Logo:");
        createClienteFormulario.add(logoLabel, gbc);

        gbc.gridx = 1;
        seleccionarLogoButton = new JButton("Seleccionar Logo");
        seleccionarLogoButton.setEnabled(false);
        createClienteFormulario.add(seleccionarLogoButton, gbc);

        seleccionarLogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "png"));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedImage image = ImageIO.read(selectedFile);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        String formatName = selectedFile.getName().substring(selectedFile.getName().lastIndexOf(".") + 1);
                        ImageIO.write(image, formatName, baos);
                        logo = baos.toByteArray();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
        paisDropDown.swicher(false);
        createClienteFormulario.add(paisDropDown, gbc);
    
        // Región
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel regionLabel = new JLabel("Región:");
        createClienteFormulario.add(regionLabel, gbc);
    
        gbc.gridx = 1;
        regionDropDown.swicher(false);
        createClienteFormulario.add(regionDropDown, gbc);
    
        // Ciudad
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel ciudadLabel = new JLabel("Ciudad:");
        createClienteFormulario.add(ciudadLabel, gbc);
    
        gbc.gridx = 1;
        ciudadDropDown.swicher(false);
        createClienteFormulario.add(ciudadDropDown, gbc);
    
        // Barrio
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel barrioLabel = new JLabel("Barrio*:");
        createClienteFormulario.add(barrioLabel, gbc);
    
        gbc.gridx = 1;
        barrioDropDown.swicher(false);
        createClienteFormulario.add(barrioDropDown, gbc);

        //Guardar farmacia
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); // Espacio alrededor del botón
        actualizarFarmaciaButton = new JButton("Actualizar farmacia");
        buttonPanel.add(actualizarFarmaciaButton);
    
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
        actualizarFarmaciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFarmacia(); // Llama a la función para obtener y mostrar los datos
            }
        });
    }

    private void updateFarmacia() {
        String nombre = nombreField.getText();
        String direccion = direccionField.getText();
        Barrio barrio = barrioDropDown.getSelecteBarrio();


        if (nombre.isEmpty() || direccion.isEmpty() || barrio == null) {
            JOptionPane.showMessageDialog(null, "Estás ingresando valores nulos o vacíos en los campos marcados como obligatorios.", "Operación inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Farmacia farmacia = new Farmacia(idFarmaciaToUpdate, 
        nombre, 
        barrio.getIdBarrio(), 
        direccion, 
        logo);

        updateFarmaciaUseCase.execute(farmacia);

        JOptionPane.showMessageDialog(null, "actualizado correctamente", "actualizado", JOptionPane.INFORMATION_MESSAGE);
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
                habilitarFormulario(farmacia);
            }
        };
    }

    private ActionListener seleccionarFarmacia() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!initializer && !isProcessing) {
                    Farmacia farmacia = farmaciaDropDown.getSelectedFarmacia();
                    habilitarFormulario(farmacia);
                }
            }
        };
    }

    private void habilitarFormulario(Farmacia farmacia) {
        idFarmaciaToUpdate = farmacia.getIdFarmacia();

        nombreField.setEnabled(true);
        nombreField.setText(farmacia.getNombre());

        direccionField.setEnabled(true);
        direccionField.setText(farmacia.getDireccion());

        seleccionarLogoButton.setEnabled(true);

        actualizarFarmaciaButton.setEnabled(true);
        logo = farmacia.getLogoFarmacia();

        Barrio barrio = getSpecifiedBarrioUseCase.execute(farmacia.getIdBarrio());
        Ciudad ciudad = getSpecifiedCiudadUseCase.execute(barrio.getIdCiudad());
        Region region = getSpecifiedRegionUseCase.execute(ciudad.getIdRegion());
        Pais pais = getSpecifiedPaisUseCase.execute(region.getIdPais());

        paisDropDown.swicher(true);
        regionDropDown.swicher(true);
        ciudadDropDown.swicher(true);
        barrioDropDown.swicher(true);

        paisDropDown.setDefaultItem(pais);
        regionDropDown.setDefaultItem(region);
        ciudadDropDown.setDefaultItem(ciudad);
        barrioDropDown.setDefaultItem(barrio);

        isProcessing = false;
        revalidate();
        repaint();
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
