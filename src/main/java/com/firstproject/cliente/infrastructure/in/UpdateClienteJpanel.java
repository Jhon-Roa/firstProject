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
import java.sql.Date;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.firstproject.barrio.application.CreateBarrioUseCase;
import com.firstproject.barrio.application.GetAllBarriosUseCase;
import com.firstproject.barrio.application.GetSpecifiedBarrioUseCase;
import com.firstproject.barrio.domain.entity.Barrio;
import com.firstproject.barrio.infrastructure.in.BarrioDropDown;
import com.firstproject.ciudad.application.GetAllCiudadesUseCase;
import com.firstproject.ciudad.application.GetSpecifiedCiudadUseCase;
import com.firstproject.ciudad.domain.entity.Ciudad;
import com.firstproject.ciudad.infrastructure.in.CiudadDropDown;
import com.firstproject.cliente.application.FindClienteByIdNoDtoUseCase;
import com.firstproject.cliente.application.SeeAllClientesNoDtoUseCase;
import com.firstproject.cliente.application.UpdateClienteUseCase;
import com.firstproject.cliente.domain.entity.Cliente;
import com.firstproject.pais.application.GetAllPaisesUseCase;
import com.firstproject.pais.domain.entity.Pais;
import com.firstproject.pais.infrastructure.in.PaisDropDown;
import com.firstproject.region.application.GetAllRegionesUseCase;
import com.firstproject.region.application.GetSpecifiedPaisUseCase;
import com.firstproject.region.application.GetSpecifiedRegionUseCase;
import com.firstproject.region.domain.entity.Region;
import com.firstproject.region.infrastructure.in.RegionDropDown;
import com.firstproject.tipodocumento.application.GetAllTipoDocumentosUseCase;
import com.firstproject.tipodocumento.domain.entity.TipoDocumento;
import com.firstproject.tipodocumento.infraestructure.in.TipoDocumentoDropDown;
import com.toedter.calendar.JDateChooser;

public class UpdateClienteJpanel extends JPanel {
    private FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase;
    private SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase;
    private UpdateClienteUseCase updateClienteUseCase;
    private ClienteDropDown clienteDropDown;
    private GetSpecifiedPaisUseCase getSpecifiedPaisUseCase;
    private GetAllPaisesUseCase getAllPaisesUseCase;
    private PaisDropDown paisDropDown;
    private GetSpecifiedRegionUseCase getSpecifiedRegionUseCase;
    private GetAllRegionesUseCase allRegionesUseCase;
    private RegionDropDown regionDropDown;
    private GetSpecifiedCiudadUseCase getSpecifiedCiudadUseCase;
    private GetAllCiudadesUseCase getAllCiudadesUseCase;
    private CiudadDropDown ciudadDropDown;
    private GetSpecifiedBarrioUseCase getSpecifiedBarrioUseCase;
    private GetAllBarriosUseCase getAllBarriosUseCase;
    private CreateBarrioUseCase createBarrioUseCase;
    private BarrioDropDown barrioDropDown;
    private GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase;
    private TipoDocumentoDropDown tipoDocumentoDropDown;

    private JTextField primerNombreField;
    private JTextField segundoNombreField;
    private JTextField primerApellidoField;
    private JTextField segundoApellidoField;
    private JDateChooser fechaNacimientoChooser;

    private boolean isInitializing;


    public UpdateClienteJpanel(FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase,
    SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase,
    UpdateClienteUseCase updateClienteUseCase, 
    GetSpecifiedPaisUseCase getSpecifiedPaisUseCase,
    GetAllPaisesUseCase getAllPaisesUseCase,
    GetSpecifiedRegionUseCase getSpecifiedRegionUseCase,
    GetAllRegionesUseCase getAllRegionesUseCase,
    GetSpecifiedCiudadUseCase getSpecifiedCiudadUseCase,
    GetAllCiudadesUseCase getAllCiudadesUseCase,
    GetSpecifiedBarrioUseCase getSpecifiedBarrioUseCase,
    GetAllBarriosUseCase getAllBarriosUseCase,
    CreateBarrioUseCase createBarrioUseCase,
    GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase) {
        this.findClienteByIdNoDtoUseCase = findClienteByIdNoDtoUseCase;
        this.seeAllClientesNoDtoUseCase = seeAllClientesNoDtoUseCase;
        this.updateClienteUseCase = updateClienteUseCase;
        this.getSpecifiedPaisUseCase = getSpecifiedPaisUseCase;
        this.getAllPaisesUseCase = getAllPaisesUseCase;
        this.getSpecifiedRegionUseCase = getSpecifiedRegionUseCase;
        this.allRegionesUseCase = getAllRegionesUseCase;
        this.getSpecifiedCiudadUseCase = getSpecifiedCiudadUseCase;
        this.getAllCiudadesUseCase = getAllCiudadesUseCase;
        this.getSpecifiedBarrioUseCase = getSpecifiedBarrioUseCase;
        this.getAllBarriosUseCase = getAllBarriosUseCase;
        this.createBarrioUseCase = createBarrioUseCase;
        this.getAllTipoDocumentosUseCase = getAllTipoDocumentosUseCase;

        isInitializing = true;

        setLayout(new BorderLayout());
        setPreferredSize((new Dimension(600, 500)));

        initComponents();

        addComponentsToPanel();

        isInitializing = false;
    }

    private void initComponents() {
        clienteDropDown= new ClienteDropDown(seleccionarCliente(), buscarCliente(), seeAllClientesNoDtoUseCase);
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

        // Primer Nombre
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel primerNombreLabel = new JLabel("Primer Nombre*:");
        createClienteFormulario.add(primerNombreLabel, gbc);
    
        gbc.gridx = 1;
        primerNombreField = new JTextField(20);
        primerNombreField.setEnabled(false);
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
        segundoNombreField.setEnabled(false);
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
        primerApellidoField.setEnabled(false);
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
        segundoApellidoField.setEnabled(false);
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
        fechaNacimientoChooser.setEnabled(false);
        createClienteFormulario.add(fechaNacimientoChooser, gbc);
    
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

        // tipo documento
        row++;
        gbc.gridx= 0;
        gbc.gridy = row;
        JLabel tipoDocumentoLabel = new JLabel("Tipo de documento*");
        createClienteFormulario.add(tipoDocumentoLabel, gbc);

        gbc.gridx = 1;
        tipoDocumentoDropDown.UpdateTipoDocumento();
        tipoDocumentoDropDown.swicher(false);
        createClienteFormulario.add(tipoDocumentoDropDown, gbc);
    
        // Crear un panel para el botón "Actualizar"
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); // Espacio alrededor del botón
        JButton actualizarUsuarioButton = new JButton("Actualizar");
        buttonPanel.add(actualizarUsuarioButton);
    
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

        // Acción del botón "Actualizar"
        actualizarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarUsuario(); // Llama a la función para obtener y mostrar los datos
            }
        }); 
    }

    private void actualizarUsuario() {
        Cliente clienteToEdit = clienteDropDown.getSelectedCliente();
        String primerNombre = primerNombreField.getText();
        String segundoNombre = segundoNombreField.getText();
        String primerApellido = primerApellidoField.getText();
        String segundoApellido = segundoApellidoField.getText();
        java.util.Date fechaNacimientoNoParse = fechaNacimientoChooser.getDate();
        Date fechaNacimiento = new Date(fechaNacimientoNoParse.getTime());
        Barrio barrio = barrioDropDown.getSelecteBarrio();
        TipoDocumento tipoDocumento = tipoDocumentoDropDown.getSelectedTipoDocumento();

        if (primerNombre.isEmpty() || primerApellido.isEmpty() || fechaNacimiento == null || barrio == null || tipoDocumento == null) {
            JOptionPane.showMessageDialog(null, "Estás ingresando valores nulos o vacíos en los campos marcados como obligatorios.", "Operación inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Cliente cliente = new Cliente(primerNombre, 
        segundoNombre, 
        primerApellido, 
        segundoApellido, 
        fechaNacimiento, 
        clienteToEdit.getIdCliente(), 
        barrio.getIdBarrio(), 
        tipoDocumento.getidTipoDocumento());

        updateClienteUseCase.execute(cliente);

        JOptionPane.showMessageDialog(null, "actualizado correctamente", "actualizado", JOptionPane.INFORMATION_MESSAGE);
    }

    private ActionListener buscarCliente() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idCliente = JOptionPane.showInputDialog(null, "ingrese la id del cliente", "buscar cliente", JOptionPane.PLAIN_MESSAGE);
                Optional<Cliente> clienteOp = findClienteByIdNoDtoUseCase.execute(idCliente);
                if(!clienteOp.isPresent()) {
                    JOptionPane.showMessageDialog(null, "operacion cancelada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Cliente cliente = clienteOp.get();
                habilitarFormulario(cliente);
            }
        };
    }

    private ActionListener seleccionarCliente() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isInitializing) {
                    Cliente cliente = clienteDropDown.getSelectedCliente();
                    habilitarFormulario(cliente);
                }
            }
        };
    }

    private void habilitarFormulario(Cliente cliente) {
        primerNombreField.setEnabled(true);
        primerNombreField.setText(cliente.getPrimerNombre());

        segundoNombreField.setEnabled(true);
        segundoNombreField.setText(cliente.getSegundoNombre());

        primerApellidoField.setEnabled(true);
        primerApellidoField.setText(cliente.getPrimerApellido());

        segundoApellidoField.setEnabled(true);
        segundoApellidoField.setText(cliente.getSegundoApellido());

        fechaNacimientoChooser.setEnabled(true);
        fechaNacimientoChooser.setDate(new java.util.Date(cliente.getFechaNacimiento().getTime()));

        Barrio barrio = getSpecifiedBarrioUseCase.execute(cliente.getIdBarrio());
        Ciudad ciudad = getSpecifiedCiudadUseCase.execute(barrio.getIdCiudad());
        Region region = getSpecifiedRegionUseCase.execute(ciudad.getIdRegion());
        Pais pais = getSpecifiedPaisUseCase.execute(region.getIdPais());

        paisDropDown.swicher(true);
        regionDropDown.swicher(true);
        ciudadDropDown.swicher(true);
        barrioDropDown.swicher(true);
        tipoDocumentoDropDown.swicher(true);

        paisDropDown.setDefaultItem(pais);
        regionDropDown.setDefaultItem(region);
        ciudadDropDown.setDefaultItem(ciudad);
        barrioDropDown.setDefaultItem(barrio);

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


