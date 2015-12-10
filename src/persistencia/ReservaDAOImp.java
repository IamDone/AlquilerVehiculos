package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Util.DateUtil;
import persistencia.dto.ReservaDTO;
import excepciones.DAOExcepcion;

public class ReservaDAOImp implements IReservaDAO{

	protected ConnectionManager connManager;
	
	public ReservaDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
	
	public List<ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA  where  SUCURSALRECOGIDA = "+idSucursal);						
			connManager.close();
	  	  
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
				
			try{				
				while (rs.next()){

					ReservaDTO reDTO = new ReservaDTO(
							rs.getInt("ID"),
							LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),
											 rs.getTime("FECHARECOGIDA").toLocalTime()),
							LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),
											 rs.getTime("FECHADEVOLUCION").toLocalTime()),
							Integer.parseInt(rs.getString("MODALIDADALQUILER").trim()),
							rs.getString("CATEGORIA"),
							rs.getString("CLIENTEREALIZA"),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));
					listaReservaDTO.add(reDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}
	//
	public List<ReservaDTO> obtenerReservas() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA");						
			connManager.close();
	  	  
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
				
			try{				
				while (rs.next()){

					ReservaDTO reDTO = new ReservaDTO(
							rs.getInt("ID"),
							LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),
											 rs.getTime("FECHARECOGIDA").toLocalTime()),
							LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),
											 rs.getTime("FECHADEVOLUCION").toLocalTime()),
							Integer.parseInt(rs.getString("MODALIDADALQUILER").trim()),
							rs.getString("CATEGORIA"),
							rs.getString("CLIENTEREALIZA"),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));
					listaReservaDTO.add(reDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){ throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){ throw e;}

	}
	public ReservaDTO buscarReserva(int identificador)throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA  where  ID ="+identificador);						
			connManager.close();
	  	  
				
			try{				

					ReservaDTO reDTO = new ReservaDTO(
							rs.getInt("ID"),
							LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),
											 rs.getTime("FECHARECOGIDA").toLocalTime()),
							LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),
											 rs.getTime("FECHADEVOLUCION").toLocalTime()),
							Integer.parseInt(rs.getString("MODALIDADALQUILER").trim()),
							rs.getString("CATEGORIA"),
							rs.getString("CLIENTEREALIZA").trim(),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));
				
				return reDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
	}
	public void crearReserva(ReservaDTO reserva) throws DAOExcepcion{
		try{
			connManager.connect();
			connManager.queryDB("insert into RESERVA values ("
																			+reserva.getId()+",'"
																			+DateUtil.format(reserva.getFechaRecogida())+"','"
																			+DateUtil.format(reserva.getFechaDevolucion())+"',"
																			+reserva.getModalidadAlquiler()+",'"
																			+reserva.getNombreCategoria()+"','"
																			+reserva.getDniCliente()+"',"
																			+reserva.getIdSucursalRecogida()+","
																			+reserva.getIdSucursalDevolucion()+")");						
			connManager.close();
	  	  
		}
		catch (SQLException e){	System.out.println(e); throw new DAOExcepcion(e);}	

	}

}
