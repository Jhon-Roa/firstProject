package com.firstproject.console;

import com.firstproject.barrio.application.CreateBarrioUseCase;
import com.firstproject.barrio.application.GetAllBarriosUseCase;
import com.firstproject.barrio.application.GetSpecifiedBarrioUseCase;
import com.firstproject.barrio.domain.service.BarrioService;
import com.firstproject.barrio.infrastructure.out.BarrioRepository;
import com.firstproject.ciudad.application.GetAllCiudadesUseCase;
import com.firstproject.ciudad.application.GetSpecifiedCiudadUseCase;
import com.firstproject.ciudad.domain.services.CiudadServices;
import com.firstproject.ciudad.infrastructure.out.CiudadRepository;
import com.firstproject.cliente.application.CreateClienteUseCase;
import com.firstproject.cliente.application.DeleteClienteUseCase;
import com.firstproject.cliente.application.FindClientByIdUseCase;
import com.firstproject.cliente.application.FindClienteByIdNoDtoUseCase;
import com.firstproject.cliente.application.SeeAllClientesNoDtoUseCase;
import com.firstproject.cliente.application.SeeAllClientsUseCase;
import com.firstproject.cliente.application.UpdateClienteUseCase;
import com.firstproject.cliente.domain.service.ClienteService;
import com.firstproject.cliente.infrastructure.out.ClienteRepository;
import com.firstproject.farmacia.application.CrearFarmaciaUseCase;
import com.firstproject.farmacia.application.DeleteFarmaciaUseCase;
import com.firstproject.farmacia.application.FindFarmaciaUseCase;
import com.firstproject.farmacia.application.GetAllFarmaciasDtoUseCase;
import com.firstproject.farmacia.application.GetAllFarmaciasUseCase;
import com.firstproject.farmacia.application.GetSpecifiedFarmaciaUseCase;
import com.firstproject.farmacia.application.UpdateFarmaciaUseCase;
import com.firstproject.farmacia.domain.service.FarmaciaService;
import com.firstproject.farmacia.infrastructure.out.FarmaciaRepository;
import com.firstproject.farmaciamedicina.application.CreateFarmaciaMedicinaUseCase;
import com.firstproject.farmaciamedicina.application.DeleteMedicinaFromFarmaciaUseCase;
import com.firstproject.farmaciamedicina.application.GetAllMedicinasFromFarmaciaUseCase;
import com.firstproject.farmaciamedicina.domain.service.FarmaciaMedicinaService;
import com.firstproject.farmaciamedicina.infrastructure.out.FarmaciaMedicinaRepository;
import com.firstproject.laboratorio.application.BorrarLaboratorioUseCase;
import com.firstproject.laboratorio.application.CrearLaboratorioUseCase;
import com.firstproject.laboratorio.application.GetAllLaboratorioDtosUseCase;
import com.firstproject.laboratorio.application.GetAllLaboratoriosUseCase;
import com.firstproject.laboratorio.application.GetSpecifiedLaboratorioUseCase;
import com.firstproject.laboratorio.domain.service.LaboratorioService;
import com.firstproject.laboratorio.infrastructure.out.LaboratorioRepository;
import com.firstproject.medicina.application.BorrarMedicinaUseCase;
import com.firstproject.medicina.application.CreateMedicinaUseCase;
import com.firstproject.medicina.application.FindMedicinaUseCase;
import com.firstproject.medicina.application.GetAllMedicinasDtoUseCase;
import com.firstproject.medicina.application.GetAllMedicinasUseCase;
import com.firstproject.medicina.application.GetSpecifedMedicinaUseCase;
import com.firstproject.medicina.application.UpdateMedicinaUseCase;
import com.firstproject.medicina.domain.service.MedicinaService;
import com.firstproject.medicina.infrastructure.out.MedicinaRepository;
import com.firstproject.pais.application.GetAllPaisesUseCase;
import com.firstproject.pais.domain.service.PaisServices;
import com.firstproject.pais.infrastructure.out.PaisRepository;
import com.firstproject.principioActivo.application.BorrarPrincipioActivoUseCase;
import com.firstproject.principioActivo.application.CrearPrincipioActivoUseCase;
import com.firstproject.principioActivo.application.GetAllPrincipiosActivosUseCase;
import com.firstproject.principioActivo.application.GetEspecifiedPrincipioActivo;
import com.firstproject.principioActivo.domain.service.PrincipioActivoService;
import com.firstproject.principioActivo.infrastructure.out.PrincipioActivoRepository;
import com.firstproject.region.application.GetAllRegionesUseCase;
import com.firstproject.region.application.GetSpecifiedPaisUseCase;
import com.firstproject.region.application.GetSpecifiedRegionUseCase;
import com.firstproject.region.domain.service.RegionServices;
import com.firstproject.region.infrastructure.out.RegionRepository;
import com.firstproject.tipodocumento.application.GetAllTipoDocumentosUseCase;
import com.firstproject.tipodocumento.domain.services.TipoDocumentoService;
import com.firstproject.tipodocumento.infraestructure.out.TipoDocumentoRepository;
import com.firstproject.ui.MainFrame;
import com.firstproject.unidadmedida.application.BorrarUnidadMedidaUseCase;
import com.firstproject.unidadmedida.application.CrearUnidadMedidaUseCase;
import com.firstproject.unidadmedida.application.GetAllUnidadesMedidaUseCase;
import com.firstproject.unidadmedida.application.GetEspecifiedUnidadMedidaUseCase;
import com.firstproject.unidadmedida.domain.service.UnidadMedidaService;
import com.firstproject.unidadmedida.infrastructure.out.UnidadMedidaRepository;
import com.firstproject.viaadministracion.application.BorrarViaAdministracionUseCase;
import com.firstproject.viaadministracion.application.CrearViaAdministracionUseCase;
import com.firstproject.viaadministracion.application.GetAllViasAdministracionUseCase;
import com.firstproject.viaadministracion.application.GetSpecifiedViaAdministracion;
import com.firstproject.viaadministracion.domain.services.ViaAdministracionServices;
import com.firstproject.viaadministracion.infrastructure.out.ViaAdministracionRepository;

public class Initializer {
    private GetSpecifiedPaisUseCase getSpecifiedPaisUseCase;
    private PaisServices paisServices;
    private GetAllPaisesUseCase getAllPaisesUseCase;

    private GetSpecifiedRegionUseCase getSpecifiedRegionUseCase;
    private RegionServices regionServices;
    private GetAllRegionesUseCase getAllRegionesUseCase;

    private GetSpecifiedCiudadUseCase getSpecifiedCiudadUseCase;
    private CiudadServices ciudadServices;
    private GetAllCiudadesUseCase getAllCiudadesUseCase;

    private GetSpecifiedBarrioUseCase getSpecifiedBarrioUseCase;
    private BarrioService barrioService;
    private GetAllBarriosUseCase getAllBarriosUseCase;
    private CreateBarrioUseCase createBarrioUseCase;

    private TipoDocumentoService tipoDocumentoService;
    private GetAllTipoDocumentosUseCase getAllTipoDocumentosUseCase;

    private ClienteService clienteService;
    private CreateClienteUseCase createClienteUseCase;
    private DeleteClienteUseCase deleteClienteUseCase;
    private FindClientByIdUseCase findClientByIdUseCase;
    private FindClienteByIdNoDtoUseCase findClienteByIdNoDtoUseCase;
    private SeeAllClientsUseCase seeAllClientsUseCase;
    private SeeAllClientesNoDtoUseCase seeAllClientesNoDtoUseCase;
    private UpdateClienteUseCase updatePersonUseCase;

    private LaboratorioService laboratorioService;
    private BorrarLaboratorioUseCase borrarLaboratorioUseCase;
    private CrearLaboratorioUseCase crearLaboratorioUseCase;
    private GetAllLaboratorioDtosUseCase getAllLaboratorioDtosUseCase;
    private GetAllLaboratoriosUseCase getAllLaboratoriosUseCase;
    private GetSpecifiedLaboratorioUseCase getSpecifiedLaboratorioUseCase;
    
    private FarmaciaService farmaciaService;
    private CrearFarmaciaUseCase crearFarmaciaUseCase;
    private DeleteFarmaciaUseCase deleteFarmaciaUseCase;
    private FindFarmaciaUseCase findFarmaciaUseCase;
    private GetAllFarmaciasDtoUseCase getAllFarmaciasDtoUseCase;
    private GetAllFarmaciasUseCase getAllFarmaciasUseCase;
    private GetSpecifiedFarmaciaUseCase getSpecifiedFarmaciaUseCase;
    private UpdateFarmaciaUseCase updateFarmaciaUseCase;

    private PrincipioActivoService principioActivoService;
    private BorrarPrincipioActivoUseCase borrarPrincipioActivoUseCase;
    private CrearPrincipioActivoUseCase crearPrincipioActivoUseCase;
    private GetAllPrincipiosActivosUseCase getAllPrincipiosActivosUseCase;
    private GetEspecifiedPrincipioActivo getEspecifiedPrincipioActivo;

    private ViaAdministracionServices administracionServices;
    private BorrarViaAdministracionUseCase borrarViaAdministracionUseCase;
    private CrearViaAdministracionUseCase crearViaAdministracionUseCase;
    private GetAllViasAdministracionUseCase getAllViasAdministracionUseCase;
    private GetSpecifiedViaAdministracion getSpecifiedViaAdministracion;

    private UnidadMedidaService unidadMedidaService;
    private BorrarUnidadMedidaUseCase borrarUnidadMedidaUseCase;
    private CrearUnidadMedidaUseCase crearUnidadMedidaUseCase;
    private GetAllUnidadesMedidaUseCase getAllUnidadesMedidaUseCase;
    private GetEspecifiedUnidadMedidaUseCase getEspecifiedUnidadMedidaUseCase;

    private MedicinaService medicinaService;
    private BorrarMedicinaUseCase borrarMedicinaUseCase;
    private CreateMedicinaUseCase createMedicinaUseCase;
    private FindMedicinaUseCase findMedicinaUseCase;
    private GetAllMedicinasDtoUseCase getAllMedicinasDtoUseCase;
    private GetAllMedicinasUseCase getAllMedicinasUseCase;
    private GetSpecifedMedicinaUseCase getSpecifedMedicinaUseCase;
    private UpdateMedicinaUseCase updateMedicinaUseCase;

    private FarmaciaMedicinaService farmaciaMedicinaService;
    private CreateFarmaciaMedicinaUseCase createFarmaciaMedicinaUseCase;
    private DeleteMedicinaFromFarmaciaUseCase deleteMedicinaFromFarmaciaUseCase;
    private GetAllMedicinasFromFarmaciaUseCase getAllMedicinasFromFarmaciaUseCase;

    public Initializer() {
        // inicializamos los repositorios

        paisServices = new PaisRepository();
        getSpecifiedPaisUseCase = new GetSpecifiedPaisUseCase(paisServices);
        getAllPaisesUseCase = new GetAllPaisesUseCase(paisServices);
        
        regionServices = new RegionRepository();
        getSpecifiedRegionUseCase = new GetSpecifiedRegionUseCase(regionServices);
        getAllRegionesUseCase = new GetAllRegionesUseCase(regionServices);

        ciudadServices = new CiudadRepository();
        getSpecifiedCiudadUseCase = new GetSpecifiedCiudadUseCase(ciudadServices);
        getAllCiudadesUseCase = new GetAllCiudadesUseCase(ciudadServices);

        barrioService = new BarrioRepository();
        getSpecifiedBarrioUseCase = new GetSpecifiedBarrioUseCase(barrioService);
        getAllBarriosUseCase = new GetAllBarriosUseCase(barrioService);
        createBarrioUseCase = new CreateBarrioUseCase(barrioService);

        tipoDocumentoService = new TipoDocumentoRepository();
        getAllTipoDocumentosUseCase = new GetAllTipoDocumentosUseCase(tipoDocumentoService);

        clienteService = new ClienteRepository();
        createClienteUseCase = new CreateClienteUseCase(clienteService);
        deleteClienteUseCase = new DeleteClienteUseCase(clienteService);
        findClientByIdUseCase = new FindClientByIdUseCase(clienteService);
        findClienteByIdNoDtoUseCase = new FindClienteByIdNoDtoUseCase(clienteService);
        seeAllClientsUseCase = new SeeAllClientsUseCase(clienteService);
        seeAllClientesNoDtoUseCase = new SeeAllClientesNoDtoUseCase(clienteService);
        updatePersonUseCase = new UpdateClienteUseCase(clienteService);

        laboratorioService = new LaboratorioRepository();
        borrarLaboratorioUseCase = new BorrarLaboratorioUseCase(laboratorioService);
        crearLaboratorioUseCase = new CrearLaboratorioUseCase(laboratorioService);
        getAllLaboratorioDtosUseCase = new GetAllLaboratorioDtosUseCase(laboratorioService);
        getAllLaboratoriosUseCase = new GetAllLaboratoriosUseCase(laboratorioService);
        getSpecifiedLaboratorioUseCase = new GetSpecifiedLaboratorioUseCase(laboratorioService);

        farmaciaService = new FarmaciaRepository();
        crearFarmaciaUseCase = new CrearFarmaciaUseCase(farmaciaService);
        deleteFarmaciaUseCase = new DeleteFarmaciaUseCase(farmaciaService);
        findFarmaciaUseCase = new FindFarmaciaUseCase(farmaciaService);
        getAllFarmaciasDtoUseCase = new GetAllFarmaciasDtoUseCase(farmaciaService);
        getAllFarmaciasUseCase = new GetAllFarmaciasUseCase(farmaciaService);
        getSpecifiedFarmaciaUseCase = new GetSpecifiedFarmaciaUseCase(farmaciaService);
        updateFarmaciaUseCase = new UpdateFarmaciaUseCase(farmaciaService);
                
        principioActivoService = new PrincipioActivoRepository();
        borrarPrincipioActivoUseCase = new BorrarPrincipioActivoUseCase(principioActivoService);
        crearPrincipioActivoUseCase = new CrearPrincipioActivoUseCase(principioActivoService);
        getAllPrincipiosActivosUseCase = new GetAllPrincipiosActivosUseCase(principioActivoService);
        getEspecifiedPrincipioActivo = new GetEspecifiedPrincipioActivo(principioActivoService);

        administracionServices = new ViaAdministracionRepository();
        borrarViaAdministracionUseCase = new BorrarViaAdministracionUseCase(administracionServices);
        crearViaAdministracionUseCase = new CrearViaAdministracionUseCase(administracionServices);
        getAllViasAdministracionUseCase = new GetAllViasAdministracionUseCase(administracionServices);
        getSpecifiedViaAdministracion = new GetSpecifiedViaAdministracion(administracionServices);

        unidadMedidaService = new UnidadMedidaRepository();
        borrarUnidadMedidaUseCase = new BorrarUnidadMedidaUseCase(unidadMedidaService);
        crearUnidadMedidaUseCase = new CrearUnidadMedidaUseCase(unidadMedidaService);
        getAllUnidadesMedidaUseCase = new GetAllUnidadesMedidaUseCase(unidadMedidaService);
        getEspecifiedUnidadMedidaUseCase = new GetEspecifiedUnidadMedidaUseCase(unidadMedidaService);

        medicinaService = new MedicinaRepository();
        borrarMedicinaUseCase = new BorrarMedicinaUseCase(medicinaService);
        createMedicinaUseCase = new CreateMedicinaUseCase(medicinaService);
        findMedicinaUseCase = new FindMedicinaUseCase(medicinaService);
        getAllMedicinasDtoUseCase = new GetAllMedicinasDtoUseCase(medicinaService);
        getAllMedicinasUseCase = new GetAllMedicinasUseCase(medicinaService);
        getSpecifedMedicinaUseCase = new GetSpecifedMedicinaUseCase(medicinaService);
        updateMedicinaUseCase = new UpdateMedicinaUseCase(medicinaService);

        farmaciaMedicinaService = new FarmaciaMedicinaRepository();
        createFarmaciaMedicinaUseCase = new CreateFarmaciaMedicinaUseCase(farmaciaMedicinaService);
        deleteMedicinaFromFarmaciaUseCase = new DeleteMedicinaFromFarmaciaUseCase(farmaciaMedicinaService);
        getAllMedicinasFromFarmaciaUseCase = new GetAllMedicinasFromFarmaciaUseCase(farmaciaMedicinaService);

        //llamamos mainFrame (UI principal)
        MainFrame mainFrame = new MainFrame(seeAllClientsUseCase,
        findClientByIdUseCase,
        deleteClienteUseCase, 
        seeAllClientesNoDtoUseCase, 
        updatePersonUseCase, 
        findClienteByIdNoDtoUseCase, 
        createClienteUseCase, 
        getSpecifiedPaisUseCase, 
        getAllPaisesUseCase, 
        getSpecifiedRegionUseCase, 
        getAllRegionesUseCase, 
        getSpecifiedCiudadUseCase, 
        getAllCiudadesUseCase, 
        getSpecifiedBarrioUseCase, 
        getAllBarriosUseCase,
        createBarrioUseCase, 
        getAllTipoDocumentosUseCase, 
        borrarLaboratorioUseCase, 
        crearLaboratorioUseCase, 
        getAllLaboratorioDtosUseCase, 
        getAllLaboratoriosUseCase, 
        getSpecifiedLaboratorioUseCase, 
        crearFarmaciaUseCase, 
        deleteFarmaciaUseCase, 
        findFarmaciaUseCase, 
        getAllFarmaciasDtoUseCase, 
        getAllFarmaciasUseCase, 
        getSpecifiedFarmaciaUseCase, 
        updateFarmaciaUseCase, 
        borrarPrincipioActivoUseCase, 
        crearPrincipioActivoUseCase, 
        getAllPrincipiosActivosUseCase, 
        getEspecifiedPrincipioActivo, 
        borrarViaAdministracionUseCase, 
        crearViaAdministracionUseCase, 
        getAllViasAdministracionUseCase, 
        getSpecifiedViaAdministracion, 
        borrarUnidadMedidaUseCase, 
        crearUnidadMedidaUseCase, 
        getAllUnidadesMedidaUseCase, 
        getEspecifiedUnidadMedidaUseCase, 
        borrarMedicinaUseCase, 
        createMedicinaUseCase, 
        findMedicinaUseCase, 
        getAllMedicinasDtoUseCase, 
        getAllMedicinasUseCase, 
        getSpecifedMedicinaUseCase, 
        updateMedicinaUseCase, 
        createFarmaciaMedicinaUseCase, 
        deleteMedicinaFromFarmaciaUseCase, 
        getAllMedicinasFromFarmaciaUseCase);
        
        mainFrame.setVisible(true);
    }
}
