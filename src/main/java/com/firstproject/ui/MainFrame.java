package com.firstproject.ui;

import javax.swing.*;

import com.firstproject.barrio.application.CreateBarrioUseCase;
import com.firstproject.barrio.application.GetAllBarriosUseCase;
import com.firstproject.ciudad.application.GetAllCiudadesUseCase;
import com.firstproject.cliente.application.CreateClienteUseCase;
import com.firstproject.cliente.application.FindClientByIdUseCase;
import com.firstproject.cliente.application.FindClienteByIdNoDtoUseCase;
import com.firstproject.cliente.application.SeeAllClientesNoDtoUseCase;
import com.firstproject.cliente.application.UpdateClienteUseCase;
import com.firstproject.cliente.infrastructure.in.ClienteAdminButton;
import com.firstproject.cliente.infrastructure.in.CrearClienteJPanel;
import com.firstproject.cliente.infrastructure.in.UpdateClienteJpanel;
import com.firstproject.pais.application.GetAllPaisesUseCase;
import com.firstproject.region.application.GetAllRegionesUseCase;
import com.firstproject.tipodocumento.application.GetAllTipoDocumentosUseCase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel contentPanel;
    private SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase;
    private UpdateClienteUseCase updateClienteUseCase;
    private FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase;
    private CreateClienteUseCase createClienteUseCase;
    private GetAllPaisesUseCase getAllPaisesUseCase;
    private GetAllRegionesUseCase getAllRegionesUseCase;
    private GetAllCiudadesUseCase getAllCiudadesUseCase;
    private GetAllBarriosUseCase getAllBarriosUseCase;
    private CreateBarrioUseCase createBarrioUseCase;
    private GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase;

    public MainFrame(SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase,
    UpdateClienteUseCase updateClienteUseCase,
    FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase,
    CreateClienteUseCase createClienteUseCase,
    GetAllPaisesUseCase getAllPaisesUseCase,
    GetAllRegionesUseCase getAllRegionesUseCase,
    GetAllCiudadesUseCase getAllCiudadesUseCase,
    GetAllBarriosUseCase getAllBarriosUseCase,
    CreateBarrioUseCase createBarrioUseCase,
    GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase) {
        this.seeAllClientesNoDtoUseCase = seeAllClientesNoDtoUseCase;
        this.updateClienteUseCase = updateClienteUseCase;
        this.findClienteByIdNoDtoUseCase = findClienteByIdNoDtoUseCase;
        this.createClienteUseCase = createClienteUseCase;
        this.getAllPaisesUseCase = getAllPaisesUseCase;
        this.getAllRegionesUseCase = getAllRegionesUseCase;
        this.getAllCiudadesUseCase = getAllCiudadesUseCase;
        this.getAllBarriosUseCase = getAllBarriosUseCase;
        this.createBarrioUseCase = createBarrioUseCase;
        this.getAllTipoDocumentosUseCase = getAllTipoDocumentosUseCase;

        createMainFrame();
    }

    private void createMainFrame() {
        setTitle("Farmacia");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(new ClienteAdminButton(mostrarFormCreateUser(),
        mostrarFormUpdateUser())); //clienteAdminButton: tiene todos los ActionListener

        JScrollPane scrollPane = new JScrollPane(leftPanel);
        scrollPane.setPreferredSize(new Dimension(200, getHeight()));

        contentPanel = new JPanel();
        contentPanel.add(new JLabel("APLICACION FARMACIA"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, contentPanel);
        splitPane.setDividerLocation(200);
        splitPane.setEnabled(false);

        add(splitPane, BorderLayout.CENTER);
    }

    private ActionListener mostrarFormCreateUser() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearClienteJPanel crearClienteJPanel = new CrearClienteJPanel(createClienteUseCase,
                getAllPaisesUseCase,
                getAllRegionesUseCase,
                getAllCiudadesUseCase,
                getAllBarriosUseCase,
                createBarrioUseCase,
                getAllTipoDocumentosUseCase);

                updateContent(crearClienteJPanel);
            }
        };
    }

    private ActionListener mostrarFormUpdateUser() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateClienteJpanel updateClienteJpanel = new UpdateClienteJpanel(findClienteByIdNoDtoUseCase, 
                seeAllClientesNoDtoUseCase, 
                updateClienteUseCase, 
                getAllPaisesUseCase, 
                getAllRegionesUseCase, 
                getAllCiudadesUseCase, 
                getAllBarriosUseCase, 
                createBarrioUseCase, 
                getAllTipoDocumentosUseCase);

                updateContent(updateClienteJpanel);
            }
            
        };
    }

    public void updateContent(JPanel newContent) {
        contentPanel.removeAll();
        contentPanel.add(newContent, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
