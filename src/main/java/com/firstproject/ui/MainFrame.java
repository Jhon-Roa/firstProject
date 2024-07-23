package com.firstproject.ui;

import javax.swing.*;

import com.firstproject.barrio.application.CreateBarrioUseCase;
import com.firstproject.barrio.application.GetAllBarriosUseCase;
import com.firstproject.barrio.application.GetSpecifiedBarrioUseCase;
import com.firstproject.ciudad.application.GetAllCiudadesUseCase;
import com.firstproject.ciudad.application.GetSpecifiedCiudadUseCase;
import com.firstproject.cliente.application.CreateClienteUseCase;
import com.firstproject.cliente.application.DeleteClienteUseCase;
import com.firstproject.cliente.application.FindClientByIdUseCase;
import com.firstproject.cliente.application.FindClienteByIdNoDtoUseCase;
import com.firstproject.cliente.application.SeeAllClientesNoDtoUseCase;
import com.firstproject.cliente.application.UpdateClienteUseCase;
import com.firstproject.cliente.infrastructure.in.DeleteClienteJPanel;
import com.firstproject.cliente.infrastructure.in.ClienteAdminButton;
import com.firstproject.cliente.infrastructure.in.CrearClienteJPanel;
import com.firstproject.cliente.infrastructure.in.UpdateClienteJpanel;
import com.firstproject.cliente.infrastructure.in.VerClienteJPanel;
import com.firstproject.pais.application.GetAllPaisesUseCase;
import com.firstproject.region.application.GetAllRegionesUseCase;
import com.firstproject.region.application.GetSpecifiedPaisUseCase;
import com.firstproject.region.application.GetSpecifiedRegionUseCase;
import com.firstproject.tipodocumento.application.GetAllTipoDocumentosUseCase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    // clases de clientes
    private FindClientByIdUseCase findClientByIdUseCase;
    private DeleteClienteUseCase deleteClienteUseCase;
    private SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase;
    private UpdateClienteUseCase updateClienteUseCase;
    private FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase;
    private CreateClienteUseCase createClienteUseCase;

    // clases de paises
    private GetSpecifiedPaisUseCase getSpecifiedPaisUseCase;
    private GetAllPaisesUseCase getAllPaisesUseCase;

    // clases de regiones
    private GetSpecifiedRegionUseCase getSpecifiedRegionUseCase;
    private GetAllRegionesUseCase getAllRegionesUseCase;

    // clases de ciudades
    private GetSpecifiedCiudadUseCase getSpecifiedCiudadUseCase;
    private GetAllCiudadesUseCase getAllCiudadesUseCase;

    // clases de barrios
    private GetSpecifiedBarrioUseCase getSpecifiedBarrioUseCase;
    private GetAllBarriosUseCase getAllBarriosUseCase;

    // clases de tipodocumentos
    private CreateBarrioUseCase createBarrioUseCase;
    private GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase;
    
    // panel de contenido
    private JPanel contentPanel;
    
    public MainFrame(FindClientByIdUseCase findClientByIdUseCase,
    DeleteClienteUseCase deleteClienteUseCase,
    SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase,
    UpdateClienteUseCase updateClienteUseCase,
    FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase,
    CreateClienteUseCase createClienteUseCase,
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

        this.findClientByIdUseCase = findClientByIdUseCase;
        this.deleteClienteUseCase = deleteClienteUseCase;
        this.seeAllClientesNoDtoUseCase = seeAllClientesNoDtoUseCase;
        this.updateClienteUseCase = updateClienteUseCase;
        this.findClienteByIdNoDtoUseCase = findClienteByIdNoDtoUseCase;
        this.createClienteUseCase = createClienteUseCase;
        this.getSpecifiedPaisUseCase = getSpecifiedPaisUseCase;
        this.getAllPaisesUseCase = getAllPaisesUseCase;
        this.getSpecifiedRegionUseCase = getSpecifiedRegionUseCase;
        this.getAllRegionesUseCase = getAllRegionesUseCase;
        this.getSpecifiedCiudadUseCase = getSpecifiedCiudadUseCase;
        this.getAllCiudadesUseCase = getAllCiudadesUseCase;
        this.getSpecifiedBarrioUseCase = getSpecifiedBarrioUseCase;
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

        // añadido de los botones (dropdown)
        leftPanel.add(new ClienteAdminButton(mostrarFormCreateUser(),
        mostrarFormUpdateUser(),
        deleteCliente(),
        findCliente()));

        JScrollPane scrollPane = new JScrollPane(leftPanel);
        scrollPane.setPreferredSize(new Dimension(200, getHeight()));

        contentPanel = new JPanel();
        contentPanel.add(new JLabel("APLICACION FARMACIA"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, contentPanel);
        splitPane.setDividerLocation(200);
        splitPane.setEnabled(false);

        add(splitPane, BorderLayout.CENTER);
    }

    // conexion de los event listener de cliente 

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
                getSpecifiedPaisUseCase, 
                getAllPaisesUseCase, 
                getSpecifiedRegionUseCase, 
                getAllRegionesUseCase, 
                getSpecifiedCiudadUseCase, 
                getAllCiudadesUseCase, 
                getSpecifiedBarrioUseCase, 
                getAllBarriosUseCase, 
                createBarrioUseCase, 
                getAllTipoDocumentosUseCase);

                updateContent(updateClienteJpanel);
            }
            
        };
    }

    private ActionListener deleteCliente() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteClienteJPanel clientDelete = new DeleteClienteJPanel(findClienteByIdNoDtoUseCase, 
                deleteClienteUseCase, 
                seeAllClientesNoDtoUseCase); 
                
                updateContent(clientDelete);
            }    
        };
    }

    private ActionListener findCliente() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerClienteJPanel clientSearch = new VerClienteJPanel(findClientByIdUseCase, 
                seeAllClientesNoDtoUseCase);

                updateContent(clientSearch);
            }
            
        };
    }

    // actualizacion de el panel derecho

    public void updateContent(JPanel newContent) {
        contentPanel.removeAll();
        contentPanel.add(newContent, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
