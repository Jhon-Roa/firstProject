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
import com.firstproject.cliente.application.SeeAllClientsUseCase;
import com.firstproject.cliente.application.UpdateClienteUseCase;
import com.firstproject.cliente.infrastructure.in.DeleteClienteJPanel;
import com.firstproject.cliente.infrastructure.in.SeeAllClientesJPanel;
import com.firstproject.cliente.infrastructure.in.ClienteAdminButton;
import com.firstproject.cliente.infrastructure.in.CrearClienteJPanel;
import com.firstproject.cliente.infrastructure.in.UpdateClienteJpanel;
import com.firstproject.cliente.infrastructure.in.VerClienteJPanel;
import com.firstproject.farmacia.application.CrearFarmaciaUseCase;
import com.firstproject.farmacia.application.DeleteFarmaciaUseCase;
import com.firstproject.farmacia.application.FindFarmaciaUseCase;
import com.firstproject.farmacia.application.GetAllFarmaciasDtoUseCase;
import com.firstproject.farmacia.application.GetAllFarmaciasUseCase;
import com.firstproject.farmacia.application.GetSpecifiedFarmaciaUseCase;
import com.firstproject.farmacia.application.UpdateFarmaciaUseCase;
import com.firstproject.farmacia.infrastructure.in.BuscarVerFarmaciasJPanel;
import com.firstproject.farmacia.infrastructure.in.CrearFarmaciaJPanel;
import com.firstproject.farmacia.infrastructure.in.DeleteFarmaciaJPanel;
import com.firstproject.farmacia.infrastructure.in.FarmaciaAdminButton;
import com.firstproject.farmacia.infrastructure.in.UpdateFarmaciaJPanel;
import com.firstproject.farmaciamedicina.application.CreateFarmaciaMedicinaUseCase;
import com.firstproject.farmaciamedicina.application.DeleteMedicinaFromFarmaciaUseCase;
import com.firstproject.farmaciamedicina.application.GetAllMedicinasFromFarmaciaUseCase;
import com.firstproject.farmaciamedicina.infrastructure.in.CrearFarmaciaMedicinaJPanel;
import com.firstproject.farmaciamedicina.infrastructure.in.DeleteFarmaciaMedicinaJPanel;
import com.firstproject.farmaciamedicina.infrastructure.in.FarmaciaMedicinaAdminButton;
import com.firstproject.farmaciamedicina.infrastructure.in.ListMedicamentosFromFarmaciaJPanel;
import com.firstproject.laboratorio.application.BorrarLaboratorioUseCase;
import com.firstproject.laboratorio.application.CrearLaboratorioUseCase;
import com.firstproject.laboratorio.application.GetAllLaboratorioDtosUseCase;
import com.firstproject.laboratorio.application.GetAllLaboratoriosUseCase;
import com.firstproject.laboratorio.application.GetSpecifiedLaboratorioUseCase;
import com.firstproject.laboratorio.infrastructure.in.CrearLaboratorioJPanel;
import com.firstproject.laboratorio.infrastructure.in.DeleteLaboratorioJPanel;
import com.firstproject.laboratorio.infrastructure.in.LaboratorioAdminButton;
import com.firstproject.laboratorio.infrastructure.in.SeeAllLaboratoriosJPanel;
import com.firstproject.medicina.application.BorrarMedicinaUseCase;
import com.firstproject.medicina.application.CreateMedicinaUseCase;
import com.firstproject.medicina.application.FindMedicinaUseCase;
import com.firstproject.medicina.application.GetAllMedicinasDtoUseCase;
import com.firstproject.medicina.application.GetAllMedicinasUseCase;
import com.firstproject.medicina.application.GetSpecifedMedicinaUseCase;
import com.firstproject.medicina.application.UpdateMedicinaUseCase;
import com.firstproject.medicina.infrastructure.in.BuscarVerMedicinasJPanel;
import com.firstproject.medicina.infrastructure.in.CrearMedicinaJPanel;
import com.firstproject.medicina.infrastructure.in.DeleteMedicinaJPanel;
import com.firstproject.medicina.infrastructure.in.MedicinaAadminButton;
import com.firstproject.medicina.infrastructure.in.UpdateMedicinaJPanel;
import com.firstproject.pais.application.GetAllPaisesUseCase;
import com.firstproject.principioActivo.application.BorrarPrincipioActivoUseCase;
import com.firstproject.principioActivo.application.CrearPrincipioActivoUseCase;
import com.firstproject.principioActivo.application.GetAllPrincipiosActivosUseCase;
import com.firstproject.principioActivo.application.GetEspecifiedPrincipioActivo;
import com.firstproject.region.application.GetAllRegionesUseCase;
import com.firstproject.region.application.GetSpecifiedPaisUseCase;
import com.firstproject.region.application.GetSpecifiedRegionUseCase;
import com.firstproject.tipodocumento.application.GetAllTipoDocumentosUseCase;
import com.firstproject.unidadmedida.application.BorrarUnidadMedidaUseCase;
import com.firstproject.unidadmedida.application.CrearUnidadMedidaUseCase;
import com.firstproject.unidadmedida.application.GetAllUnidadesMedidaUseCase;
import com.firstproject.unidadmedida.application.GetEspecifiedUnidadMedidaUseCase;
import com.firstproject.viaadministracion.application.BorrarViaAdministracionUseCase;
import com.firstproject.viaadministracion.application.CrearViaAdministracionUseCase;
import com.firstproject.viaadministracion.application.GetAllViasAdministracionUseCase;
import com.firstproject.viaadministracion.application.GetSpecifiedViaAdministracion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    // clases de clientes
    private SeeAllClientsUseCase seeAllClientsUseCase;
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
    
    // clases de laboratorios
    private BorrarLaboratorioUseCase borrarLaboratorioUseCase;
    private CrearLaboratorioUseCase crearLaboratorioUseCase;
    private GetAllLaboratorioDtosUseCase getAllLaboratorioDtosUseCase;
    private GetAllLaboratoriosUseCase getAllLaboratoriosUseCase;
    private GetSpecifiedLaboratorioUseCase getSpecifiedLaboratorioUseCase;

    // clases de farmacia
    private CrearFarmaciaUseCase crearFarmaciaUseCase;
    private DeleteFarmaciaUseCase deleteFarmaciaUseCase;
    private FindFarmaciaUseCase findFarmaciaUseCase;
    private GetAllFarmaciasDtoUseCase getAllFarmaciasDtoUseCase;
    private GetAllFarmaciasUseCase getAllFarmaciasUseCase;
    private GetSpecifiedFarmaciaUseCase getSpecifiedFarmaciaUseCase;
    private UpdateFarmaciaUseCase updateFarmaciaUseCase;

    // clases de principio activo
    private BorrarPrincipioActivoUseCase borrarPrincipioActivoUseCase;
    private CrearPrincipioActivoUseCase crearPrincipioActivoUseCase;
    private GetAllPrincipiosActivosUseCase getAllPrincipiosActivosUseCase;
    private GetEspecifiedPrincipioActivo getEspecifiedPrincipioActivo;

    // clases de via de administracion
    private BorrarViaAdministracionUseCase borrarViaAdministracionUseCase;
    private CrearViaAdministracionUseCase crearViaAdministracionUseCase;
    private GetAllViasAdministracionUseCase getAllViasAdministracionUseCase;
    private GetSpecifiedViaAdministracion getSpecifiedViaAdministracion;
    
    //clases de unidad medida
    private BorrarUnidadMedidaUseCase borrarUnidadMedidaUseCase;
    private CrearUnidadMedidaUseCase crearUnidadMedidaUseCase;
    private GetAllUnidadesMedidaUseCase getAllUnidadesMedidaUseCase;
    private GetEspecifiedUnidadMedidaUseCase getEspecifiedUnidadMedidaUseCase;

    // clases de medicina
    private BorrarMedicinaUseCase borrarMedicinaUseCase;
    private CreateMedicinaUseCase createMedicinaUseCase;
    private FindMedicinaUseCase findMedicinaUseCase;
    private GetAllMedicinasDtoUseCase getAllMedicinasDtoUseCase;
    private GetAllMedicinasUseCase getAllMedicinasUseCase;
    private GetSpecifedMedicinaUseCase getSpecifedMedicinaUseCase;
    private UpdateMedicinaUseCase updateMedicinaUseCase;

    // clases de FarmaciaMedicina
    private CreateFarmaciaMedicinaUseCase createFarmaciaMedicinaUseCase;
    private DeleteMedicinaFromFarmaciaUseCase deleteMedicinaFromFarmaciaUseCase;
    private GetAllMedicinasFromFarmaciaUseCase getAllMedicinasFromFarmaciaUseCase;
    
    // panel de contenido
    private JPanel contentPanel;

    public MainFrame(SeeAllClientsUseCase seeAllClientsUseCase, FindClientByIdUseCase findClientByIdUseCase,
            DeleteClienteUseCase deleteClienteUseCase, SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase,
            UpdateClienteUseCase updateClienteUseCase, FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase,
            CreateClienteUseCase createClienteUseCase, GetSpecifiedPaisUseCase getSpecifiedPaisUseCase,
            GetAllPaisesUseCase getAllPaisesUseCase, GetSpecifiedRegionUseCase getSpecifiedRegionUseCase,
            GetAllRegionesUseCase getAllRegionesUseCase, GetSpecifiedCiudadUseCase getSpecifiedCiudadUseCase,
            GetAllCiudadesUseCase getAllCiudadesUseCase, GetSpecifiedBarrioUseCase getSpecifiedBarrioUseCase,
            GetAllBarriosUseCase getAllBarriosUseCase, CreateBarrioUseCase createBarrioUseCase,
            GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase, BorrarLaboratorioUseCase borrarLaboratorioUseCase,
            CrearLaboratorioUseCase crearLaboratorioUseCase, GetAllLaboratorioDtosUseCase getAllLaboratorioDtosUseCase,
            GetAllLaboratoriosUseCase getAllLaboratoriosUseCase,
            GetSpecifiedLaboratorioUseCase getSpecifiedLaboratorioUseCase, CrearFarmaciaUseCase crearFarmaciaUseCase,
            DeleteFarmaciaUseCase deleteFarmaciaUseCase, FindFarmaciaUseCase findFarmaciaUseCase,
            GetAllFarmaciasDtoUseCase getAllFarmaciasDtoUseCase, GetAllFarmaciasUseCase getAllFarmaciasUseCase,
            GetSpecifiedFarmaciaUseCase getSpecifiedFarmaciaUseCase, UpdateFarmaciaUseCase updateFarmaciaUseCase,
            BorrarPrincipioActivoUseCase borrarPrincipioActivoUseCase,
            CrearPrincipioActivoUseCase crearPrincipioActivoUseCase,
            GetAllPrincipiosActivosUseCase getAllPrincipiosActivosUseCase,
            GetEspecifiedPrincipioActivo getEspecifiedPrincipioActivo,
            BorrarViaAdministracionUseCase borrarViaAdministracionUseCase,
            CrearViaAdministracionUseCase crearViaAdministracionUseCase,
            GetAllViasAdministracionUseCase getAllViasAdministracionUseCase,
            GetSpecifiedViaAdministracion getSpecifiedViaAdministracion,
            BorrarUnidadMedidaUseCase borrarUnidadMedidaUseCase, CrearUnidadMedidaUseCase crearUnidadMedidaUseCase,
            GetAllUnidadesMedidaUseCase getAllUnidadesMedidaUseCase,
            GetEspecifiedUnidadMedidaUseCase getEspecifiedUnidadMedidaUseCase,
            BorrarMedicinaUseCase borrarMedicinaUseCase, CreateMedicinaUseCase createMedicinaUseCase,
            FindMedicinaUseCase findMedicinaUseCase, GetAllMedicinasDtoUseCase getAllMedicinasDtoUseCase,
            GetAllMedicinasUseCase getAllMedicinasUseCase, GetSpecifedMedicinaUseCase getSpecifedMedicinaUseCase,
            UpdateMedicinaUseCase updateMedicinaUseCase, CreateFarmaciaMedicinaUseCase createFarmaciaMedicinaUseCase,
            DeleteMedicinaFromFarmaciaUseCase deleteMedicinaFromFarmaciaUseCase,
            GetAllMedicinasFromFarmaciaUseCase getAllMedicinasFromFarmaciaUseCase) {
        this.seeAllClientsUseCase = seeAllClientsUseCase;
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
        this.borrarLaboratorioUseCase = borrarLaboratorioUseCase;
        this.crearLaboratorioUseCase = crearLaboratorioUseCase;
        this.getAllLaboratorioDtosUseCase = getAllLaboratorioDtosUseCase;
        this.getAllLaboratoriosUseCase = getAllLaboratoriosUseCase;
        this.getSpecifiedLaboratorioUseCase = getSpecifiedLaboratorioUseCase;
        this.crearFarmaciaUseCase = crearFarmaciaUseCase;
        this.deleteFarmaciaUseCase = deleteFarmaciaUseCase;
        this.findFarmaciaUseCase = findFarmaciaUseCase;
        this.getAllFarmaciasDtoUseCase = getAllFarmaciasDtoUseCase;
        this.getAllFarmaciasUseCase = getAllFarmaciasUseCase;
        this.getSpecifiedFarmaciaUseCase = getSpecifiedFarmaciaUseCase;
        this.updateFarmaciaUseCase = updateFarmaciaUseCase;
        this.borrarPrincipioActivoUseCase = borrarPrincipioActivoUseCase;
        this.crearPrincipioActivoUseCase = crearPrincipioActivoUseCase;
        this.getAllPrincipiosActivosUseCase = getAllPrincipiosActivosUseCase;
        this.getEspecifiedPrincipioActivo = getEspecifiedPrincipioActivo;
        this.borrarViaAdministracionUseCase = borrarViaAdministracionUseCase;
        this.crearViaAdministracionUseCase = crearViaAdministracionUseCase;
        this.getAllViasAdministracionUseCase = getAllViasAdministracionUseCase;
        this.getSpecifiedViaAdministracion = getSpecifiedViaAdministracion;
        this.borrarUnidadMedidaUseCase = borrarUnidadMedidaUseCase;
        this.crearUnidadMedidaUseCase = crearUnidadMedidaUseCase;
        this.getAllUnidadesMedidaUseCase = getAllUnidadesMedidaUseCase;
        this.getEspecifiedUnidadMedidaUseCase = getEspecifiedUnidadMedidaUseCase;
        this.borrarMedicinaUseCase = borrarMedicinaUseCase;
        this.createMedicinaUseCase = createMedicinaUseCase;
        this.findMedicinaUseCase = findMedicinaUseCase;
        this.getAllMedicinasDtoUseCase = getAllMedicinasDtoUseCase;
        this.getAllMedicinasUseCase = getAllMedicinasUseCase;
        this.getSpecifedMedicinaUseCase = getSpecifedMedicinaUseCase;
        this.updateMedicinaUseCase = updateMedicinaUseCase;
        this.createFarmaciaMedicinaUseCase = createFarmaciaMedicinaUseCase;
        this.deleteMedicinaFromFarmaciaUseCase = deleteMedicinaFromFarmaciaUseCase;
        this.getAllMedicinasFromFarmaciaUseCase = getAllMedicinasFromFarmaciaUseCase;

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
        findCliente(),
        seeAllClients()
        ));

        leftPanel.add(new LaboratorioAdminButton(mostrarFormCreateLaboratorio(), 
        mostrarFormDeleteLAboratorio(),
        mostrarAllLaboratorio()));

        leftPanel.add(new FarmaciaAdminButton(mostrarFormCreateFarmacia(),
        mostrarFormDeleteFarmacia(), 
        mostrarFormUpdateFarmacia(),
        mostrarFormShowAllFarmacia()));

        leftPanel.add(new MedicinaAadminButton(createFormMedicina(), 
        deleteFormMedicina(), 
        updateFormMedicina(), 
        showAllFormMedicina()));

        leftPanel.add(new FarmaciaMedicinaAdminButton(createFormFarmaciaMedicina(), 
        deleteFormFarmaciaMedicina(), 
        listMedicinasFromFarmacia()));

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

    private ActionListener seeAllClients() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeeAllClientesJPanel seeAllClientesJPanel = new SeeAllClientesJPanel(seeAllClientsUseCase);

                updateContent(seeAllClientesJPanel);
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

    // Conexion de los event listener de laboratorio

    private ActionListener mostrarFormCreateLaboratorio() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearLaboratorioJPanel crearLaboratorioJPanel = new CrearLaboratorioJPanel(crearLaboratorioUseCase, 
                getAllPaisesUseCase, 
                getAllRegionesUseCase, 
                getAllCiudadesUseCase, 
                getAllBarriosUseCase, 
                createBarrioUseCase);

                updateContent(crearLaboratorioJPanel);
            }
        };
    }

    private ActionListener mostrarFormDeleteLAboratorio() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteLaboratorioJPanel deleteLaboratorioJPanel = new DeleteLaboratorioJPanel(getSpecifiedLaboratorioUseCase, 
                borrarLaboratorioUseCase, 
                getAllLaboratoriosUseCase);
                
                updateContent(deleteLaboratorioJPanel);
            }
        };
    }
    
    private ActionListener mostrarAllLaboratorio() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeeAllLaboratoriosJPanel seeAllLaboratoriosJPanel = new SeeAllLaboratoriosJPanel(getAllLaboratorioDtosUseCase);

                updateContent(seeAllLaboratoriosJPanel);
            }
        };
    }

    //Conexion de los event listeners de farmacia
    private ActionListener mostrarFormCreateFarmacia() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearFarmaciaJPanel crearFarmaciaJPanel = new CrearFarmaciaJPanel(crearFarmaciaUseCase, 
                getAllPaisesUseCase, 
                getAllRegionesUseCase, 
                getAllCiudadesUseCase, 
                getAllBarriosUseCase, 
                createBarrioUseCase);

                updateContent(crearFarmaciaJPanel);
            }
        };
    }

    private ActionListener mostrarFormDeleteFarmacia() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteFarmaciaJPanel deleteFarmaciaJPanel = new DeleteFarmaciaJPanel(getSpecifiedFarmaciaUseCase, 
                deleteFarmaciaUseCase, 
                getAllFarmaciasUseCase);

                updateContent(deleteFarmaciaJPanel);
            }
        };
    }

    private ActionListener mostrarFormUpdateFarmacia() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateFarmaciaJPanel updateFarmaciaJPanel = new UpdateFarmaciaJPanel(getSpecifiedFarmaciaUseCase, 
                getAllFarmaciasUseCase, 
                updateFarmaciaUseCase, 
                getAllPaisesUseCase, 
                getSpecifiedPaisUseCase, 
                getAllRegionesUseCase, 
                getSpecifiedRegionUseCase, 
                getAllCiudadesUseCase, 
                getSpecifiedCiudadUseCase, 
                getAllBarriosUseCase, 
                createBarrioUseCase, 
                getSpecifiedBarrioUseCase);

                updateContent(updateFarmaciaJPanel);
            }
        };
    }

    private ActionListener mostrarFormShowAllFarmacia() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarVerFarmaciasJPanel buscarVerFarmaciasJPanel =  new BuscarVerFarmaciasJPanel(findFarmaciaUseCase, 
                getAllFarmaciasUseCase, 
                getAllFarmaciasDtoUseCase);

                updateContent(buscarVerFarmaciasJPanel);
            }
        };
    }

    // Conexion de los event listeners de medicina
    private ActionListener createFormMedicina() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearMedicinaJPanel crearMedicinaJPanel = new CrearMedicinaJPanel(createMedicinaUseCase, 
                getAllViasAdministracionUseCase, 
                borrarViaAdministracionUseCase, 
                crearViaAdministracionUseCase, 
                getSpecifiedViaAdministracion, 
                getAllPrincipiosActivosUseCase, 
                borrarPrincipioActivoUseCase, 
                crearPrincipioActivoUseCase, 
                getEspecifiedPrincipioActivo, 
                getAllUnidadesMedidaUseCase, 
                borrarUnidadMedidaUseCase, 
                crearUnidadMedidaUseCase, 
                getEspecifiedUnidadMedidaUseCase,
                getAllLaboratoriosUseCase, 
                getSpecifiedLaboratorioUseCase);

                updateContent(crearMedicinaJPanel);
            }
        };
    }

    private ActionListener deleteFormMedicina() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteMedicinaJPanel deleteMedicinaJPanel = new DeleteMedicinaJPanel(getSpecifedMedicinaUseCase, 
                borrarMedicinaUseCase, 
                getAllMedicinasUseCase);

                updateContent(deleteMedicinaJPanel);
            }
        };
    }

    private ActionListener updateFormMedicina() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateMedicinaJPanel updateMedicinaJPanel = new UpdateMedicinaJPanel(getSpecifedMedicinaUseCase, 
                getAllMedicinasUseCase, 
                updateMedicinaUseCase,
                getAllViasAdministracionUseCase, 
                borrarViaAdministracionUseCase, 
                crearViaAdministracionUseCase, 
                getSpecifiedViaAdministracion, 
                getAllPrincipiosActivosUseCase, 
                borrarPrincipioActivoUseCase, 
                crearPrincipioActivoUseCase, 
                getEspecifiedPrincipioActivo, 
                getAllUnidadesMedidaUseCase, 
                borrarUnidadMedidaUseCase, 
                crearUnidadMedidaUseCase, 
                getEspecifiedUnidadMedidaUseCase, 
                getAllLaboratoriosUseCase, 
                getSpecifiedLaboratorioUseCase);

                updateContent(updateMedicinaJPanel);
            }
        };
    }    

    private ActionListener showAllFormMedicina() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarVerMedicinasJPanel buscarVerMedicinasJPanel = new BuscarVerMedicinasJPanel(findMedicinaUseCase, 
                getAllMedicinasDtoUseCase, 
                getAllMedicinasUseCase);

                updateContent(buscarVerMedicinasJPanel);
            }
        };
    }    

    // Conexion de los event listener de farmacia medicina
    private ActionListener createFormFarmaciaMedicina() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearFarmaciaMedicinaJPanel crearFarmaciaMedicinaJPanel = new CrearFarmaciaMedicinaJPanel(createFarmaciaMedicinaUseCase, 
                getSpecifiedFarmaciaUseCase, 
                getAllFarmaciasUseCase, 
                getSpecifedMedicinaUseCase, 
                getAllMedicinasUseCase);

                updateContent(crearFarmaciaMedicinaJPanel);
            }
        };
    }    

    private ActionListener deleteFormFarmaciaMedicina() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteFarmaciaMedicinaJPanel deleteFarmaciaMedicinaJPanel = new DeleteFarmaciaMedicinaJPanel(deleteMedicinaFromFarmaciaUseCase, 
                getSpecifiedFarmaciaUseCase, 
                getAllFarmaciasUseCase, 
                getSpecifedMedicinaUseCase, 
                getAllMedicinasUseCase);

                updateContent(deleteFarmaciaMedicinaJPanel);
            }
        };
    }
    
    private ActionListener listMedicinasFromFarmacia() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListMedicamentosFromFarmaciaJPanel listMedicamentosFromFarmaciaJPanel = new ListMedicamentosFromFarmaciaJPanel(getAllMedicinasFromFarmaciaUseCase, 
                getAllFarmaciasUseCase, 
                findFarmaciaUseCase);

                updateContent(listMedicamentosFromFarmaciaJPanel);
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
