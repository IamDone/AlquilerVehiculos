package Negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.DAL;
import persistencia.dto.CategoriaDTO;
import persistencia.dto.ClienteDTO;
import persistencia.dto.ReservaDTO;
import persistencia.dto.SucursalDTO;

public class AlquilerVehiculos{
	
	private HashMap<String, Cliente> listaCliente = new HashMap<String, Cliente>();
	private HashMap<Integer, Sucursal> listaSucursal = new HashMap<Integer, Sucursal>();
	private HashMap<Integer, Reserva> listaReserva = new HashMap<Integer, Reserva>();
	private HashMap<String, Categoria> listaCategoria = new HashMap<String, Categoria>();
	
	private DAL dal;
	
	public AlquilerVehiculos() throws DAOExcepcion{
		this.dal = DAL.dameDAL();
		cargaSistema();
	}
	private static AlquilerVehiculos instancia= null;
	public static AlquilerVehiculos newInstancia() throws DAOExcepcion{
		
		if(instancia == null) instancia = new AlquilerVehiculos();
		return instancia;
	}
	
	
	 
	public HashMap<String, Cliente> getListaCliente() {
		return listaCliente;
	}



	public void setListaCliente(HashMap<String, Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}



	public HashMap<Integer, Sucursal> getListaSucursal() {
		return listaSucursal;
	}



	public void setListaSucursal(HashMap<Integer, Sucursal> listaSucursal) {
		this.listaSucursal = listaSucursal;
	}



	public HashMap<Integer, Reserva> getListaReserva() {
		return listaReserva;
	}



	public void setListaReserva(HashMap<Integer, Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}



	public HashMap<String, Categoria> getListaCategoria() {
		return listaCategoria;
	}



	public void setListaCategoria(HashMap<String, Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public int crearReserva(LocalDateTime fechaRecogida, LocalDateTime fechaDevolucion,
							 int idR, int idD,String dniCliente, String idCat, int modalidadAlquiler){
		int i;
		do{
		i = (int) (Math.random()*10000);
		}while(listaReserva.containsKey(i));
		
		Reserva r = new Reserva(i, fechaRecogida, fechaDevolucion, modalidadAlquiler,dniCliente, listaCategoria.get(idCat),listaSucursal.get(idR),listaSucursal.get(idD));
		 crearReserva(r);
		 return i;
	}
	private void crearReserva(Reserva r){
		listaReserva.put(r.getIdentificador(),r);
		listaSucursal.get(r.getLugarD().getId()).getListaRecogida().put(r.getIdentificador(), r);
		listaSucursal.get(r.getLugarR().getId()).getListaDevolucion().put(r.getIdentificador(), r);
		listaCliente.get(r.getDniCliente()).getListaReserva().put(r.getIdentificador() ,r);
		dal.crearReserva(new ReservaDTO(r.getIdentificador()
				,r.getFechaRecogida()
				,r.getFechaDevolucion()
				,r.getModalidadAlquiler()
				,r.getDniCliente()
				,r.getCategoriaAsociada().getNombre()
				,r.getLugarD().getId()
				,r.getLugarR().getId()));
	}
	
	public int encontrarS(String nom){
		for(Sucursal su:listaSucursal.values()){
			if(su.getDireccion().equals(nom)){
				return su.getId();
			}
		}
		return -1;
	}
	
	public void crearCliente(String id, String nombreyApellidos, String direccion, String poblacion,String codPostal, LocalDateTime fechaCarnetConducir, 
							String digitosTC, int mesTC, int añoTC, int cvcTC, String tipoTC){
		Cliente cl = new Cliente(id,nombreyApellidos, direccion, poblacion, codPostal, fechaCarnetConducir, digitosTC, mesTC, añoTC, cvcTC, tipoTC);
		crearCliente(cl);
	}
	public void crearCliente(Cliente cl){
		listaCliente.put(cl.getIdentificador(),cl);
		dal.crearCliente(new ClienteDTO(cl.getIdentificador()
									   ,cl.getNombreyApellidos()
									   ,cl.getDireccion()
									   ,cl.getPoblacion()
									   ,cl.getCodPostal()
									   ,cl.getFechaCarnetConducir()
									   ,cl.getDigitosTC()
									   ,cl.getMesTC()
									   ,cl.getAñoTC()
									   ,cl.getCvcTC()
									   ,cl.getTipoTC()));
		
	}
	public ArrayList<Reserva> listarReservaSucursal(int id){
		ArrayList<Reserva> r1 = new ArrayList<Reserva>(listaSucursal.get(id).getListaDevolucion().values());
		r1.addAll(listaSucursal.get(id).getListaRecogida().values());
		return r1;
	}
	private void añadirCategoria(Categoria cat1){
		//Categoria cat1 = new Categoria(nombre, precioModIlimitado, precioModKms,precioKmModKms, precioSeguroTRiesgo,precioSeguroTerceros);
		listaCategoria.put(cat1.getNombre(),cat1);
		
	}
	private Categoria buscarCategoria(String nombre){
		return listaCategoria.get(nombre);
	}
	private void añadirCliente(Cliente cli1){
		listaCliente.put(cli1.getIdentificador(),cli1);
	}
	
	private void añadirSucursal(Sucursal su){
		listaSucursal.put(su.getId(),su);
	}
	private void añadirReserva(Reserva re){
		listaReserva.put(re.getIdentificador(),re);
	}
	
	/*****************************/
	/***** CARGA DEL SISTEMA******/
	/*****************************/
	private void cargaSistema(){	
	cargaCategorias();
	cargaSucursales();
	cargaClientes();
	cargaReservas();
	}
	
	private void cargaCategorias(){
		List<CategoriaDTO> listacatDTO = dal.obtenerCategorias();
		//crear y añadir todas las categorias a la coleccion
		for (CategoriaDTO catDTO : listacatDTO) {
			añadirCategoria(new Categoria(catDTO.getNombre(),
			catDTO.getPrecioModIlimitada(), catDTO.getPrecioModKms(),
			catDTO.getPrecioKMModKms(), catDTO.getPrecioSeguroTRiesgo(),
			catDTO.getPrecioSeguroTerceros()));
			 }
		// Actualizar los enlaces que representan la relación “superior”
		for (CategoriaDTO catDTO : listacatDTO)
		if (catDTO.getNombreCategoriaSuperior() != null)
			buscarCategoria(catDTO.getNombre()).setSuperior(buscarCategoria(catDTO.getNombreCategoriaSuperior()));
	}

	private void cargaSucursales(){
		List<SucursalDTO> listasuDTO = dal.obtenerSucursales();
		for (SucursalDTO suDTO : listasuDTO) {
			añadirSucursal(new Sucursal(
					suDTO.getId(),
					suDTO.getDirección()
					));
			 }
	}
	private void cargaReservas(){
		List<ReservaDTO> listareDTO = dal.obtenerReservas();
		for(ReservaDTO reDTO : listareDTO){
			añadirReserva(new Reserva(reDTO.getId()
					,reDTO.getFechaRecogida()
					,reDTO.getFechaDevolucion()
					,reDTO.getModalidadAlquiler()
					,reDTO.getDniCliente()
					,listaCategoria.get(reDTO.getNombreCategoria())
					,listaSucursal.get(reDTO.getIdSucursalRecogida())
					,listaSucursal.get(reDTO.getIdSucursalDevolucion())));
		}
	}
	
	private void cargaClientes(){
	List<ClienteDTO> listaclDTO = dal.obtenerClientes();
	for (ClienteDTO clDTO : listaclDTO) {
		añadirCliente(new Cliente(
				clDTO.getDni(),
				clDTO.getNombreyApellidos(),
				clDTO.getDireccion(),
				clDTO.getPoblacion(),
				clDTO.getCodPostal(),
				clDTO.getFechaCanetConducir(),
				clDTO.getDigitosTC(),
				clDTO.getMesTC(),
				clDTO.getAñoTC(),
				clDTO.getCvcTC(),
				clDTO.getTipoTC()));
		 }
}
	public List<ReservaDTO> getReservasPorSucursal(int i){
		List<ReservaDTO> listaDTO = dal.obtenerReservasPorSucursalOrigen(i);
		return listaDTO;	 
	}
}
