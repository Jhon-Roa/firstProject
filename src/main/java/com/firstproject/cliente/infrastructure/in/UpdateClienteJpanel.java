package com.firstproject.cliente.infrastructure.in;

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
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.firstproject.barrio.application.CreateBarrioUseCase;
import com.firstproject.barrio.application.GetAllBarriosUseCase;
import com.firstproject.barrio.infrastructure.in.BarrioDropDown;
import com.firstproject.ciudad.application.GetAllCiudadesUseCase;
import com.firstproject.ciudad.domain.entity.Ciudad;
import com.firstproject.ciudad.infrastructure.in.CiudadDropDown;
import com.firstproject.cliente.application.CreateClienteUseCase;
import com.firstproject.cliente.application.FindClienteByIdNoDtoUseCase;
import com.firstproject.cliente.application.SeeAllClientesNoDtoUseCase;
import com.firstproject.cliente.application.UpdateClienteUseCase;
import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.pais.application.GetAllPaisesUseCase;
import com.firstproject.pais.domain.entity.Pais;
import com.firstproject.pais.infrastructure.in.PaisDropDown;
import com.firstproject.region.application.GetAllRegionesUseCase;
import com.firstproject.region.domain.entity.Region;
import com.firstproject.region.infrastructure.in.RegionDropDown;
import com.firstproject.tipodocumento.application.GetAllTipoDocumentosUseCase;
import com.firstproject.tipodocumento.infraestructure.in.TipoDocumentoDropDown;
import com.toedter.calendar.JDateChooser;

public class UpdateClienteJpanel extends JPanel {
    private FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase;
    private SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase;
    private UpdateClienteUseCase updateClienteUseCase;
    private ClienteDropDown clienteDropDown;
    private GetAllPaisesUseCase getAllPaisesUseCase;
    private PaisDropDown paisDropDown;
    private GetAllRegionesUseCase allRegionesUseCase;
    private RegionDropDown regionDropDown;
    private GetAllCiudadesUseCase getAllCiudadesUseCase;
    private CiudadDropDown ciudadDropDown;
    private GetAllBarriosUseCase getAllBarriosUseCase;
    private CreateBarrioUseCase createBarrioUseCase;
    private BarrioDropDown barrioDropDown;
    private GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase;
    private TipoDocumentoDropDown tipoDocumentoDropDown;

    private JTextField documentoField;
    private JTextField primerNombreField;
    private JTextField segundoNombreField;
    private JTextField primerApellidoField;
    private JTextField segundoApellidoField;
    private JDateChooser fechaNacimientoChooser;


    public UpdateClienteJpanel(FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase,
    SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase,
    UpdateClienteUseCase updateClienteUseCase, 
    GetAllPaisesUseCase getAllPaisesUseCase,
    GetAllRegionesUseCase getAllRegionesUseCase,
    GetAllCiudadesUseCase getAllCiudadesUseCase,
    GetAllBarriosUseCase getAllBarriosUseCase,
    CreateBarrioUseCase createBarrioUseCase,
    GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase) {
        this.findClienteByIdNoDtoUseCase = findClienteByIdNoDtoUseCase;
        this.seeAllClientesNoDtoUseCase = seeAllClientesNoDtoUseCase;
        this.updateClienteUseCase = updateClienteUseCase;
        this.getAllPaisesUseCase = getAllPaisesUseCase;
        this.allRegionesUseCase = getAllRegionesUseCase;
        this.getAllCiudadesUseCase = getAllCiudadesUseCase;
        this.getAllBarriosUseCase = getAllBarriosUseCase;
        this.createBarrioUseCase = createBarrioUseCase;
        this.getAllTipoDocumentosUseCase = getAllTipoDocumentosUseCase;

        setLayout(new BorderLayout());
        setPreferredSize((new Dimension(600, 500)));

        initComponents();

        addComponentsToPanel();
    }

    private void initComponents() {
        clienteDropDown= new ClienteDropDown(buscarCliente(), seeAllClientesNoDtoUseCase);
        paisDropDown = new PaisDropDown(habilitarRegion(), getAllPaisesUseCase);
        regionDropDown = new RegionDropDown(habilitarCiudad(), allRegionesUseCase);
        ciudadDropDown = new CiudadDropDown(habilitarBarrio(), getAllCiudadesUseCase);
        barrioDropDown = new BarrioDropDown(crearBarrio(), getAllBarriosUseCase);
        tipoDocumentoDropDown = new TipoDocumentoDropDown(getAllTipoDocumentosUseCase);
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
        JLabel clienteLabel = new JLabel("cliente");
        createClienteFormulario.add(clienteLabel, gbc);

        gbc.gridx = 1;
        clienteDropDown.updatCliente();
        createClienteFormulario.add(clienteDropDown, gbc);


        // Documento
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel documentoLabel = new JLabel("Documento*:");
        createClienteFormulario.add(documentoLabel, gbc);
        
        gbc.gridx = 1;
        documentoField = new JTextField(20);
        createClienteFormulario.add(documentoField, gbc);

        documentoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (documentoField.getText().length() > 30) {
                    e.consume();
                }
            }
        });

        // Primer Nombre
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel primerNombreLabel = new JLabel("Primer Nombre*:");
        createClienteFormulario.add(primerNombreLabel, gbc);
    
        gbc.gridx = 1;
        primerNombreField = new JTextField(20);
        createClienteFormulario.add(primerNombreField, gbc);
    
        primerNombreField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (primerNombreField.getText().length() > 20) {
                    e.consume();
                }
            }
        });

        // Segundo Nombre
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel segundoNombreLabel = new JLabel("Segundo Nombre:");
        createClienteFormulario.add(segundoNombreLabel, gbc);
    
        gbc.gridx = 1;
        segundoNombreField = new JTextField(20);
        createClienteFormulario.add(segundoNombreField, gbc);

        segundoNombreField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (segundoNombreField.getText().length() > 20) {
                    e.consume();
                }
            }
        });
    
        // Primer Apellido
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel primerApellidoLabel = new JLabel("Primer Apellido*:");
        createClienteFormulario.add(primerApellidoLabel, gbc);
    
        gbc.gridx = 1;
        primerApellidoField = new JTextField(20);
        createClienteFormulario.add(primerApellidoField, gbc);
        
        primerApellidoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (primerApellidoField.getText().length() > 20) {
                    e.consume();
                }
            }
        });

        // Segundo Apellido
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel segundoApellidoLabel = new JLabel("Segundo Apellido:");
        createClienteFormulario.add(segundoApellidoLabel, gbc);
    
        gbc.gridx = 1;
        segundoApellidoField = new JTextField(20);
        createClienteFormulario.add(segundoApellidoField, gbc);
    
        segundoApellidoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (segundoApellidoField.getText().length() > 20) {
                    e.consume();
                }
            }
        });

        // Fecha de Nacimiento
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel fechaNacimientoLabel = new JLabel("Fecha de Nacimiento*:");
        createClienteFormulario.add(fechaNacimientoLabel, gbc);
    
        gbc.gridx = 1;
        fechaNacimientoChooser = new JDateChooser();
        fechaNacimientoChooser.setPreferredSize(new Dimension(200, 25));
        createClienteFormulario.add(fechaNacimientoChooser, gbc);
    
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

        // tipo documento
        row++;
        gbc.gridx= 0;
        gbc.gridy = row;
        JLabel tipoDocumentoLabel = new JLabel("Tipo de documento*");
        createClienteFormulario.add(tipoDocumentoLabel, gbc);

        gbc.gridx = 1;
        tipoDocumentoDropDown.UpdateTipoDocumento();
        createClienteFormulario.add(tipoDocumentoDropDown, gbc);
    
        // Crear un panel para el botón "Guardar Usuario"
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); // Espacio alrededor del botón
        JButton guardarUsuarioButton = new JButton("Guardar Usuario");
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
        /* guardarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarUsuario(); // Llama a la función para obtener y mostrar los datos
            }
        }); */
    }

    private void inhabilitarFormulario() {
        documentoField.setEnabled(false);
        primerNombreField.setEnabled(false);
        segundoNombreField.setEnabled(false);
        primerApellidoField.setEnabled(false);
        segundoApellidoField.setEnabled(false);
        fechaNacimientoChooser.setEnabled(false);

        revalidate();
        repaint();
    }



    private ActionListener buscarCliente() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idCliente = JOptionPane.showInputDialog(null, "ingrese la id del cliente", "buscar cliente", JOptionPane.PLAIN_MESSAGE);
                Optional<Cliente> cliente = findClienteByIdNoDtoUseCase.execute(idCliente);

                if(!cliente.isPresent()) {
                    JOptionPane.showMessageDialog(null, "el id no existe", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        };
    }

        private ActionListener habilitarRegion() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (regionDropDown != null) {
                    regionDropDown.reset();
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
                    ciudadDropDown.reset();
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
                    barrioDropDown.reset();
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
                barrioDropDown.reset();
                barrioDropDown.updateBarrios(ciudad);
            }
        };
    }
}


