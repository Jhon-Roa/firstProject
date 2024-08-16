package com.firstproject.medicina.infrastructure.in;

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

import com.firstproject.laboratorio.application.GetAllLaboratoriosUseCase;
import com.firstproject.laboratorio.application.GetSpecifiedLaboratorioUseCase;
import com.firstproject.laboratorio.domain.entity.Laboratorio;
import com.firstproject.laboratorio.infrastructure.in.LaboratorioDropDown;
import com.firstproject.medicina.application.CreateMedicinaUseCase;
import com.firstproject.medicina.domain.entity.Medicina;
import com.firstproject.principioActivo.application.BorrarPrincipioActivoUseCase;
import com.firstproject.principioActivo.application.CrearPrincipioActivoUseCase;
import com.firstproject.principioActivo.application.GetAllPrincipiosActivosUseCase;
import com.firstproject.principioActivo.application.GetEspecifiedPrincipioActivo;
import com.firstproject.principioActivo.domain.entity.PrincipioActivo;
import com.firstproject.principioActivo.infrastructure.in.PrincipioActivoDropDown;
import com.firstproject.unidadmedida.application.BorrarUnidadMedidaUseCase;
import com.firstproject.unidadmedida.application.CrearUnidadMedidaUseCase;
import com.firstproject.unidadmedida.application.GetAllUnidadesMedidaUseCase;
import com.firstproject.unidadmedida.application.GetEspecifiedUnidadMedidaUseCase;
import com.firstproject.unidadmedida.domain.entity.UnidadMedida;
import com.firstproject.unidadmedida.infrastructure.in.UnidadMedidaComboBox;
import com.firstproject.viaadministracion.application.BorrarViaAdministracionUseCase;
import com.firstproject.viaadministracion.application.CrearViaAdministracionUseCase;
import com.firstproject.viaadministracion.application.GetAllViasAdministracionUseCase;
import com.firstproject.viaadministracion.application.GetSpecifiedViaAdministracion;
import com.firstproject.viaadministracion.domain.entity.ViaAdministracion;
import com.firstproject.viaadministracion.infrastructure.in.ViaAdministraacionDropDown;

public class CrearMedicinaJPanel extends JPanel {
    //clases de medicina
    private CreateMedicinaUseCase createMedicinaUseCase;

    //clases de viaAdministracion
    private GetAllViasAdministracionUseCase getAllViasAdministracionUseCase;
    private ViaAdministraacionDropDown viaAdministraacionDropDown;
    private BorrarViaAdministracionUseCase borrarViaAdministracionUseCase;
    private CrearViaAdministracionUseCase crearViaAdministracionUseCase;

    //Clases de PrincipioActivo
    private GetAllPrincipiosActivosUseCase getAllPrincipiosActivosUseCase;
    private PrincipioActivoDropDown principioActivoDropDown;
    private BorrarPrincipioActivoUseCase borrarPrincipioActivoUseCase;
    private CrearPrincipioActivoUseCase crearPrincipioActivoUseCase;

    //Clases de UnidadMedida
    private GetAllUnidadesMedidaUseCase getAllUnidadesMedidaUseCase;
    private UnidadMedidaComboBox unidadMedidaComboBox;
    private BorrarUnidadMedidaUseCase borrarUnidadMedidaUseCase;
    private CrearUnidadMedidaUseCase crearUnidadMedidaUseCase;

    //CLases de laboratorio
    private GetAllLaboratoriosUseCase getAllLaboratoriosUseCase;
    private LaboratorioDropDown laboratorioDropDown;
    private GetSpecifiedLaboratorioUseCase getSpecifiedLaboratorioUseCase;

    //Componentes formulario
    private JTextField actaField;
    private JTextField nombreField;
    private JTextField registroSaludField;
    private JTextField descripcionField;

    

    public CrearMedicinaJPanel(CreateMedicinaUseCase createMedicinaUseCase,
    GetAllViasAdministracionUseCase getAllViasAdministracionUseCase,
    BorrarViaAdministracionUseCase borrarViaAdministracionUseCase,
    CrearViaAdministracionUseCase crearViaAdministracionUseCase,
    GetSpecifiedViaAdministracion getSpecifiedViaAdministracion,
    GetAllPrincipiosActivosUseCase getAllPrincipiosActivosUseCase,
    BorrarPrincipioActivoUseCase borrarPrincipioActivoUseCase,
    CrearPrincipioActivoUseCase crearPrincipioActivoUseCase,
    GetEspecifiedPrincipioActivo getEspecifiedPrincipioActivo,
    GetAllUnidadesMedidaUseCase getAllUnidadesMedidaUseCase,
    BorrarUnidadMedidaUseCase borrarUnidadMedidaUseCase, CrearUnidadMedidaUseCase crearUnidadMedidaUseCase,
    GetEspecifiedUnidadMedidaUseCase getEspecifiedUnidadMedidaUseCase,
    GetAllLaboratoriosUseCase getAllLaboratoriosUseCase,
    GetSpecifiedLaboratorioUseCase getSpecifiedLaboratorioUseCase) {
        this.createMedicinaUseCase = createMedicinaUseCase;
        this.getAllViasAdministracionUseCase = getAllViasAdministracionUseCase;
        this.borrarViaAdministracionUseCase = borrarViaAdministracionUseCase;
        this.crearViaAdministracionUseCase = crearViaAdministracionUseCase;
        this.getAllPrincipiosActivosUseCase = getAllPrincipiosActivosUseCase;
        this.borrarPrincipioActivoUseCase = borrarPrincipioActivoUseCase;
        this.crearPrincipioActivoUseCase = crearPrincipioActivoUseCase;
        this.getAllUnidadesMedidaUseCase = getAllUnidadesMedidaUseCase;
        this.borrarUnidadMedidaUseCase = borrarUnidadMedidaUseCase;
        this.crearUnidadMedidaUseCase = crearUnidadMedidaUseCase;
        this.getAllLaboratoriosUseCase = getAllLaboratoriosUseCase;
        this.getSpecifiedLaboratorioUseCase = getSpecifiedLaboratorioUseCase;
    
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 500));

        // Initialize components
        initComponents();

        // Add components to the panel
        addComponentsToPanel();
    }

    private void initComponents() {
        viaAdministraacionDropDown = new ViaAdministraacionDropDown(borrarViaAdministracion(),
        crearViaAdministracion(), 
        getAllViasAdministracionUseCase);
        principioActivoDropDown = new PrincipioActivoDropDown(borrarPrincipioActivo(), 
        crearPrincipioActivo(), 
        getAllPrincipiosActivosUseCase);
        unidadMedidaComboBox = new UnidadMedidaComboBox(borrarUnidadMedida(),
        crearUnidadMedida(), 
        getAllUnidadesMedidaUseCase);
        laboratorioDropDown = new LaboratorioDropDown(null, 
        seleccionarLaboratorioBuscado(), 
        getAllLaboratoriosUseCase);
    }

    private void addComponentsToPanel() {
        JPanel createMedicinaFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // Acta
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel acta = new JLabel("Acta*:");
        createMedicinaFormulario.add(acta, gbc);
        
        gbc.gridx = 1;
        actaField = new JTextField(20);
        createMedicinaFormulario.add(actaField, gbc);

        actaField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (actaField.getText().length() == 10) {
                    e.consume();
                }
            }
        });

        // Nombre
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel nombre = new JLabel("Nombre*:");
        createMedicinaFormulario.add(nombre, gbc);
        
        gbc.gridx = 1;
        nombreField = new JTextField(20);
        createMedicinaFormulario.add(nombreField, gbc);

        nombreField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (nombreField.getText().length() == 100) {
                    e.consume();
                }
            }
        });

        // Registro Salud
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel registroSalud = new JLabel("RegistroSalud*:");
        createMedicinaFormulario.add(registroSalud, gbc);
        
        gbc.gridx = 1;
        registroSaludField = new JTextField(20);
        createMedicinaFormulario.add(registroSaludField, gbc);

        registroSaludField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (registroSaludField.getText().length() == 50) {
                    e.consume();
                }
            }
        });

        // Descripcion
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel descripcion = new JLabel("Descripcion*:");
        createMedicinaFormulario.add(descripcion, gbc);
        
        gbc.gridx = 1;
        descripcionField = new JTextField(20);
        createMedicinaFormulario.add(descripcionField, gbc);

        descripcionField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (descripcionField.getText().length() == 255) {
                    e.consume();
                }
            }
        });

        // viaAdministracion
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel viaAdminLabel = new JLabel("Via Administracion:");
        createMedicinaFormulario.add(viaAdminLabel, gbc);

        gbc.gridx = 1;
        viaAdministraacionDropDown.updateViaAdministracion();
        createMedicinaFormulario.add(viaAdministraacionDropDown, gbc);

        // PrincipioActivo
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel principioActivoLabel = new JLabel("Principio activo:");
        createMedicinaFormulario.add(principioActivoLabel, gbc);

        gbc.gridx = 1;
        principioActivoDropDown.updatePrincipioActivo();
        createMedicinaFormulario.add(principioActivoDropDown, gbc);

        // UnidadMedida
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel unidadMedidaLabel = new JLabel("Unidad Medida:");
        createMedicinaFormulario.add(unidadMedidaLabel, gbc);

        gbc.gridx = 1;
        unidadMedidaComboBox.updateUnidadMedida();
        createMedicinaFormulario.add(unidadMedidaComboBox, gbc);

        // Laboratorio
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel laboratorioLabel = new JLabel("Laboratorio:");
        createMedicinaFormulario.add(laboratorioLabel, gbc);

        gbc.gridx = 1;
        laboratorioDropDown.updateLaboratorio();
        createMedicinaFormulario.add(laboratorioDropDown, gbc);

        //Guardar Medicina
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); // Espacio alrededor del botón
        JButton guardarUsuarioButton = new JButton("Guardar Medicina");
        buttonPanel.add(guardarUsuarioButton);
    
        // Agregar el panel del botón al formulario
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.fill = GridBagConstraints.NONE; // No expandir
        gbc.anchor = GridBagConstraints.CENTER; // Centrar dentro de la celda
        gbc.weightx = 0.0; // No expandir horizontalmente
    
        createMedicinaFormulario.add(buttonPanel, gbc);
    
        add(createMedicinaFormulario, BorderLayout.CENTER);

        // Acción del botón "Guardar Usuario"
        guardarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarMedicina(); // Llama a la función para obtener y mostrar los datos
            }
        });
    }

    private void guardarMedicina() {
        String acta = actaField.getText();
        String nombre = nombreField.getText();
        String registroSalud = registroSaludField.getText();
        String descripcion = descripcionField.getText();
        PrincipioActivo principioActivo = principioActivoDropDown.getSelectedPrincipioActivo();
        ViaAdministracion viaAdministracion = viaAdministraacionDropDown.getSelectedViaAdministracion();
        UnidadMedida unidadMedida = unidadMedidaComboBox.getSelectedUnidadMedida();
        Laboratorio laboratorio = laboratorioDropDown.getSelectedLaboratorio();

        if (acta.isEmpty() || nombre.isEmpty() || registroSalud.isEmpty() || 
        principioActivo == null || viaAdministracion == null || unidadMedida == null || laboratorio == null) {
            JOptionPane.showMessageDialog(null, "Estás ingresando valores nulos o vacíos en los campos marcados como obligatorios.", "Operación inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Medicina medicina = new Medicina(0, 
        acta, 
        nombre, 
        registroSalud, 
        descripcion, 
        viaAdministracion.getIdViaAdministracion(), 
        principioActivo.getIdPrincipioActivo(), 
        unidadMedida.getIdUnidadMedida(), 
        laboratorio.getIdLaboratorio());

        createMedicinaUseCase.execute(medicina);
        
        actaField.setText("");
        nombreField.setText("");
        registroSaludField.setText("");
        descripcionField.setText("");

        JOptionPane.showMessageDialog(null, "guardado correctamente", "guardado", JOptionPane.INFORMATION_MESSAGE);
    }

    private ActionListener borrarViaAdministracion() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViaAdministracion viaAdministracion = viaAdministraacionDropDown.getSelectedViaAdministracion();
                borrarViaAdministracionUseCase.execute(viaAdministracion);
                viaAdministraacionDropDown.updateViaAdministracion();
            }
        };
    }

    private ActionListener crearViaAdministracion() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = "";
                do {
                    nombre = JOptionPane.showInputDialog(null, "ingrese el nombre de la via administracio", "añadir via administracion", JOptionPane.PLAIN_MESSAGE);
                    if (nombre == null) {
                        return;
                    }
                } while (nombre.length() > 60 || nombre.length() < 1);
                crearViaAdministracionUseCase.execute(nombre);
                viaAdministraacionDropDown.updateViaAdministracion();
            }
        };
    }

    private ActionListener borrarPrincipioActivo() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrincipioActivo principioActivo = principioActivoDropDown.getSelectedPrincipioActivo();
                borrarPrincipioActivoUseCase.execute(principioActivo);
                principioActivoDropDown.updatePrincipioActivo();
            }
        };
    }

    private ActionListener crearPrincipioActivo() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = "";
                do {
                    nombre = JOptionPane.showInputDialog(null, "ingrese el nombre del pricipio activo", "añadir principio activo", JOptionPane.PLAIN_MESSAGE);
                    if (nombre == null) {
                        return;
                    }
                } while (nombre.length() > 60 || nombre.length() < 1);
                crearPrincipioActivoUseCase.execute(nombre);
                principioActivoDropDown.updatePrincipioActivo();
            }
        };
    }

    private ActionListener borrarUnidadMedida() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnidadMedida unidadMedida = unidadMedidaComboBox.getSelectedUnidadMedida();
                borrarUnidadMedidaUseCase.execute(unidadMedida);
                unidadMedidaComboBox.updateUnidadMedida();
            }
            
        };
    }

    private ActionListener crearUnidadMedida() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = "";
                do {
                    nombre = JOptionPane.showInputDialog(null, "ingrese el nombre de la unidad de medida", "añadir unidad de medida", JOptionPane.PLAIN_MESSAGE);
                    if (nombre == null) {
                        return;
                    }
                } while (nombre.length() > 60 || nombre.length() < 1);
                crearUnidadMedidaUseCase.execute(nombre);
                unidadMedidaComboBox.updateUnidadMedida();
            }
        };
    }

    private ActionListener seleccionarLaboratorioBuscado() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bucle = true;
                int idLaboratorio = -1;
                do {
                    try {
                        idLaboratorio = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la id del laboratorio", "buscar laboratorio", JOptionPane.PLAIN_MESSAGE));   
                        bucle = !bucle; 
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, "ingresa un numero entero", "error", ERROR);
                    }
                } while (bucle);
                Optional<Laboratorio> laboratorioOp = getSpecifiedLaboratorioUseCase.execute(idLaboratorio);
                if (!laboratorioOp.isPresent()) {
                    JOptionPane.showMessageDialog(null, "operacion cancelada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Laboratorio laboratorio = laboratorioOp.get();
                laboratorioDropDown.setDefaultItem(laboratorio);
            }
            
        };
    }
     
}
