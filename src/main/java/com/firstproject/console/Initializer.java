package com.firstproject.console;

import com.firstproject.barrio.application.CreateBarrioUseCase;
import com.firstproject.barrio.application.GetAllBarriosUseCase;
import com.firstproject.barrio.domain.service.BarrioService;
import com.firstproject.barrio.infrastructure.out.BarrioRepository;
import com.firstproject.ciudad.application.GetAllCiudadesUseCase;
import com.firstproject.ciudad.domain.services.CiudadServices;
import com.firstproject.ciudad.infrastructure.out.CiudadRepository;
import com.firstproject.cliente.application.CreateClienteUseCase;
import com.firstproject.cliente.application.DeleteClienteUseCase;
import com.firstproject.cliente.application.FindClientByIdUseCase;
import com.firstproject.cliente.application.SeeAllClientsUseCase;
import com.firstproject.cliente.application.UpdatePersonUseCase;
import com.firstproject.cliente.domain.service.ClienteService;
import com.firstproject.cliente.infrastructure.out.ClienteRepository;
import com.firstproject.pais.application.GetAllPaisesUseCase;
import com.firstproject.pais.domain.service.PaisServices;
import com.firstproject.pais.infrastructure.out.PaisRepository;
import com.firstproject.region.application.GetAllRegionesUseCase;
import com.firstproject.region.domain.service.RegionServices;
import com.firstproject.region.infrastructure.out.RegionRepository;
import com.firstproject.tipodocumento.application.GetAllTipoDocumentosUseCase;
import com.firstproject.tipodocumento.domain.entity.TipoDocumento;
import com.firstproject.tipodocumento.domain.services.TipoDocumentoService;
import com.firstproject.tipodocumento.infraestructure.out.TipoDocumentoRepository;
import com.firstproject.ui.MainFrame;

public class Initializer {
    private PaisServices paisServices;
    private GetAllPaisesUseCase getAllPaisesUseCase;

    private RegionServices regionServices;
    private GetAllRegionesUseCase getAllRegionesUseCase;

    private CiudadServices ciudadServices;
    private GetAllCiudadesUseCase getAllCiudadesUseCase;

    private BarrioService barrioService;
    private GetAllBarriosUseCase getAllBarriosUseCase;
    private CreateBarrioUseCase createBarrioUseCase;

    private TipoDocumentoService tipoDocumentoService;
    private GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase;

    private ClienteService clienteService;
    private CreateClienteUseCase createClienteUseCase;
    private DeleteClienteUseCase deleteClienteUseCase;
    private FindClientByIdUseCase findClientByIdUseCase;
    private SeeAllClientsUseCase seeAllClientsUseCase;
    private UpdatePersonUseCase updatePersonUseCase;
    
    public Initializer() {
        // inicializamos los repositorios

        paisServices = new PaisRepository();
        getAllPaisesUseCase = new GetAllPaisesUseCase(paisServices);
        
        regionServices = new RegionRepository();
        getAllRegionesUseCase = new GetAllRegionesUseCase(regionServices);

        ciudadServices = new CiudadRepository();
        getAllCiudadesUseCase = new GetAllCiudadesUseCase(ciudadServices);

        barrioService = new BarrioRepository();
        getAllBarriosUseCase = new GetAllBarriosUseCase(barrioService);
        createBarrioUseCase = new CreateBarrioUseCase(barrioService);

        tipoDocumentoService = new TipoDocumentoRepository();
        getAllTipoDocumentosUseCase = new GetAllTipoDocumentosUseCase(tipoDocumentoService);

        clienteService = new ClienteRepository();
        createClienteUseCase = new CreateClienteUseCase(clienteService);
        deleteClienteUseCase = new DeleteClienteUseCase(clienteService);
        findClientByIdUseCase = new FindClientByIdUseCase(clienteService);
        seeAllClientsUseCase = new SeeAllClientsUseCase(clienteService);
        updatePersonUseCase = new UpdatePersonUseCase(clienteService);

        //llamamos mainFrame (UI principal)
        MainFrame mainFrame = new MainFrame(createClienteUseCase, 
        getAllPaisesUseCase, 
        getAllRegionesUseCase, 
        getAllCiudadesUseCase, 
        getAllBarriosUseCase, 
        createBarrioUseCase,
        getAllTipoDocumentosUseCase);
        
        mainFrame.setVisible(true);
    }
}
