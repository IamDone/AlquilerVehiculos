package persistencia;

import java.util.List;

import persistencia.dto.CategoriaDTO;
import persistencia.dto.ClienteDTO;
import persistencia.dto.ReservaDTO;
import persistencia.dto.SucursalDTO;
import excepciones.DAOExcepcion;

public class DAL {
	private static DAL dal;
    // Declaración de los DAO

    CategoriaDAOImp categoriaDAO;
    ClienteDAOImp clienteDAO;
    SucursalDAOImp sucursalDAO;
    ReservaDAOImp reservaDAO;
    
    // constructor privado
    private DAL() throws DAOExcepcion {
    	categoriaDAO = new CategoriaDAOImp();
    	sucursalDAO = new SucursalDAOImp();
    	reservaDAO = new ReservaDAOImp();
    	clienteDAO = new ClienteDAOImp();
    }
    
    
    // Patrón Singleton
    public static DAL dameDAL() throws DAOExcepcion {
    	if (dal == null)
    		dal = new DAL();
    	return dal;
    }

    public List<CategoriaDTO> obtenerCategorias(){
    	try{
    		return categoriaDAO.obtenerCategorias();
    	}catch(DAOExcepcion e){
    		return null;
    	}
   }
    public List<ClienteDTO> obtenerClientes(){
    	try{
    		return clienteDAO.obtenerClientes();
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    public List<SucursalDTO> obtenerSucursales(){
    	try{
    		return sucursalDAO.obtenerSucursales();
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    public void crearReserva(ReservaDTO reserva){
    	try{
        		reservaDAO.crearReserva(reserva);
        	}catch(DAOExcepcion e){
        		
        	}
    		
    	}
    public ReservaDTO buscarReserva(int reserva){
    	try{
        		return reservaDAO.buscarReserva(reserva);
        	}catch(DAOExcepcion e){
        		return null;
        	}
    		
    	}
    public List<ReservaDTO> obtenerReservas(){
    	try{
    		return reservaDAO.obtenerReservas();
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    public List<ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal){
    	try{
    		return reservaDAO.obtenerReservasPorSucursalOrigen(idSucursal);
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    public void crearCliente(ClienteDTO cliente){
    	try{
    		clienteDAO.crearCliente(cliente);
    	}catch(DAOExcepcion e){
    		
    	}
		
	}
}
