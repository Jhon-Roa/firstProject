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
import com.firstproject.medicina.application.GetAllMedicinasUseCase;
import com.firstproject.medicina.application.GetSpecifedMedicinaUseCase;
import com.firstproject.medicina.application.UpdateMedicinaUseCase;
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

public class UpdateMedicinaJPanel extends JPanel {
    //Clases de medicina 
    private GetSpecifedMedicinaUseCase getSpecifedMedicinaUseCase;
    private GetAllMedicinasUseCase getAllMedicinasUseCase;
    private UpdateMedicinaUseCase updateMedicinaUseCase;
    private MedicinaDropDown medicinaDropDown;

     //clases de viaAdministracion
    private GetAllViasAdministracionUseCase getAllViasAdministracionUseCase;
    private ViaAdministraacionDropDown viaAdministraacionDropDown;
    private BorrarViaAdministracionUseCase borrarViaAdministracionUseCase;
    private CrearViaAdministracionUseCase crearViaAdministracionUseCase;
    private GetSpecifiedViaAdministracion getSpecifiedViaAdministracion;

    //Clases de PrincipioActivo
    private GetAllPrincipiosActivosUseCase getAllPrincipiosActivosUseCase;
    private PrincipioActivoDropDown principioActivoDropDown;
    private BorrarPrincipioActivoUseCase borrarPrincipioActivoUseCase;
    private CrearPrincipioActivoUseCase crearPrincipioActivoUseCase;
    private GetEspecifiedPrincipioActivo getEspecifiedPrincipioActivo;

    //Clases de UnidadMedida
    private GetAllUnidadesMedidaUseCase getAllUnidadesMedidaUseCase;
    private UnidadMedidaComboBox unidadMedidaComboBox;
    private BorrarUnidadMedidaUseCase borrarUnidadMedidaUseCase;
    private CrearUnidadMedidaUseCase crearUnidadMedidaUseCase;
    private GetEspecifiedUnidadMedidaUseCase getEspecifiedUnidadMedidaUseCase;

    //CLases de laboratorio
    private GetAllLaboratoriosUseCase getAllLaboratoriosUseCase;
    private LaboratorioDropDown laboratorioDropDown;
    private GetSpecifiedLaboratorioUseCase getSpecifiedLaboratorioUseCase;

    //Componentes formulario
    private JTextField actaField;
    private JTextField nombreField;
    private JTextField registroSaludField;
    private JTextField descripcionField;

    private boolean initializer;
    private boolean isProcessing;
    private int idMedicinaToUpdate;

    public UpdateMedicinaJPanel(GetSpecifedMedicinaUseCase getSpecifedMedicinaUseCase,
            GetAllMedicinasUseCase getAllMedicinasUseCase, UpdateMedicinaUseCase updateMedicinaUseCase,
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
        this.getSpecifedMedicinaUseCase = getSpecifedMedicinaUseCase;
        this.getAllMedicinasUseCase = getAllMedicinasUseCase;
        this.updateMedicinaUseCase = updateMedicinaUseCase;
        this.getAllViasAdministracionUseCase = getAllViasAdministracionUseCase;
        this.borrarViaAdministracionUseCase = borrarViaAdministracionUseCase;
        this.crearViaAdministracionUseCase = crearViaAdministracionUseCase;
        this.getSpecifiedViaAdministracion = getSpecifiedViaAdministracion;
        this.getAllPrincipiosActivosUseCase = getAllPrincipiosActivosUseCase;
        this.borrarPrincipioActivoUseCase = borrarPrincipioActivoUseCase;
        this.crearPrincipioActivoUseCase = crearPrincipioActivoUseCase;
        this.getEspecifiedPrincipioActivo = getEspecifiedPrincipioActivo;
        this.getAllUnidadesMedidaUseCase = getAllUnidadesMedidaUseCase;
        this.borrarUnidadMedidaUseCase = borrarUnidadMedidaUseCase;
        this.crearUnidadMedidaUseCase = crearUnidadMedidaUseCase;
        this.getEspecifiedUnidadMedidaUseCase = getEspecifiedUnidadMedidaUseCase;
        this.getAllLaboratoriosUseCase = getAllLaboratoriosUseCase;
        this.getSpecifiedLaboratorioUseCase = getSpecifiedLaboratorioUseCase;

        initializer = true;

        setLayout(new BorderLayout());
        setPreferredSize((new Dimension(600, 500)));

        initComponents();

        addComponentsToPanel();

        initializer = false;
        isProcessing = false;
    }

    private void initComponents() {
        medicinaDropDown = new MedicinaDropDown(seleccionarMedicina(), 
        buscarMedicina(), 
        getAllMedicinasUseCase);
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

        // MedicinaDropDown
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel medicinaLabel = new JLabel("medicina");
        createMedicinaFormulario.add(medicinaLabel, gbc);

        gbc.gridx = 1;
        medicinaDropDown.updateMedicina();
        createMedicinaFormulario.add(medicinaDropDown, gbc);

        // Acta
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel acta = new JLabel("Acta*:");
        createMedicinaFormulario.add(acta, gbc);
        
        gbc.gridx = 1;
        actaField = new JTextField(20);
        actaField.setEnabled(false);
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
        nombreField.setEnabled(false);
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
        registroSaludField.setEnabled(false);
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
        descripcionField.setEnabled(false);
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
        viaAdministraacionDropDown.swicher(false);
        createMedicinaFormulario.add(viaAdministraacionDropDown, gbc);

        // PrincipioActivo
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel principioActivoLabel = new JLabel("Principio activo:");
        createMedicinaFormulario.add(principioActivoLabel, gbc);

        gbc.gridx = 1;
        principioActivoDropDown.updatePrincipioActivo();
        principioActivoDropDown.swicher(false);
        createMedicinaFormulario.add(principioActivoDropDown, gbc);

        // UnidadMedida
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel unidadMedidaLabel = new JLabel("Unidad Medida:");
        createMedicinaFormulario.add(unidadMedidaLabel, gbc);

        gbc.gridx = 1;
        unidadMedidaComboBox.updateUnidadMedida();
        unidadMedidaComboBox.swicher(false);
        createMedicinaFormulario.add(unidadMedidaComboBox, gbc);

        // Laboratorio
        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel laboratorioLabel = new JLabel("Laboratorio:");
        createMedicinaFormulario.add(laboratorioLabel, gbc);

        gbc.gridx = 1;
        laboratorioDropDown.updateLaboratorio();
        laboratorioDropDown.swicher(false);
        createMedicinaFormulario.add(laboratorioDropDown, gbc);

        //Actualizar Medicina
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); // Espacio alrededor del botón
        JButton actualizarMedicinaButton = new JButton("Actualizar Medicina");
        buttonPanel.add(actualizarMedicinaButton);
    
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
        actualizarMedicinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarMedicina(); // Llama a la función para obtener y mostrar los datos
            }
        });
    }

    private void actualizarMedicina() {
        String acta = actaField.getText();
        String nombre = nombreField.getText();
        String registroSalud = registroSaludField.getText();
        String descripcion = descripcionField.getText();
        ViaAdministracion viaAdministracion = viaAdministraacionDropDown.getSelectedViaAdministracion();
        PrincipioActivo principioActivo = principioActivoDropDown.getSelectedPrincipioActivo();
        UnidadMedida unidadMedida = unidadMedidaComboBox.getSelectedUnidadMedida();
        Laboratorio laboratorio = laboratorioDropDown.getSelectedLaboratorio();

        if (acta.isEmpty() || nombre.isEmpty() || registroSalud.isEmpty() || 
        principioActivo == null || viaAdministracion == null || unidadMedida == null || laboratorio == null) {
            JOptionPane.showMessageDialog(null, "Estás ingresando valores nulos o vacíos en los campos marcados como obligatorios.", "Operación inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Medicina medicina = new Medicina(idMedicinaToUpdate, 
        acta, 
        nombre, 
        registroSalud, 
        descripcion, 
        viaAdministracion.getIdViaAdministracion(), 
        principioActivo.getIdPrincipioActivo(), 
        unidadMedida.getIdUnidadMedida(), 
        laboratorio.getIdLaboratorio());

        updateMedicinaUseCase.execute(medicina);
        
        actaField.setText("");
        nombreField.setText("");
        registroSaludField.setText("");
        descripcionField.setText("");

        JOptionPane.showMessageDialog(null, "actualizado correctamente", "actualizado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void habilitarFormulario(Medicina medicina) {
        idMedicinaToUpdate = medicina.getIdMedicina();

        actaField.setEnabled(true);
        actaField.setText(medicina.getActa());
        
        nombreField.setEnabled(true);
        nombreField.setText(medicina.getNombre());
        
        registroSaludField.setEnabled(true);
        registroSaludField.setText(medicina.getRegistroSalud());

        descripcionField.setEnabled(true);
        descripcionField.setText(medicina.getDescripcion());
        
        ViaAdministracion viaAdministracion = (getSpecifiedViaAdministracion.execute(medicina.getIdViaAdministracion())).get();
        PrincipioActivo principioActivo = (getEspecifiedPrincipioActivo.execute(medicina.getIdPrincipioActivo())).get();
        UnidadMedida unidadMedida = (getEspecifiedUnidadMedidaUseCase.execute(medicina.getIdUnidadMedida())).get();
        Laboratorio laboratorio = (getSpecifiedLaboratorioUseCase.execute(medicina.getIdLaboratorio())).get();
        
        viaAdministraacionDropDown.swicher(true);
        principioActivoDropDown.swicher(true);
        unidadMedidaComboBox.swicher(true);
        laboratorioDropDown.swicher(true);

        viaAdministraacionDropDown.setDefaultItem(viaAdministracion);
        principioActivoDropDown.setDefaultItem(principioActivo);
        unidadMedidaComboBox.setDefaultItem(unidadMedida);
        laboratorioDropDown.setDefaultItem(laboratorio);
        
        isProcessing = false;
        revalidate();
        repaint();
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
                isProcessing = true;
                habilitarFormulario(medicina);
            }
            
        };
    }

    private ActionListener seleccionarMedicina() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!initializer && !isProcessing) {
                    Medicina medicina = medicinaDropDown.getSelectedMedicina();
                    habilitarFormulario(medicina);
                }
            }
        };
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
