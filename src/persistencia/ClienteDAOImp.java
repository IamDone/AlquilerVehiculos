package persistencia;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Util.DateUtil;
import persistencia.dto.ClienteDTO;
import excepciones.DAOExcepcion;

public class ClienteDAOImp implements IClienteDAO {


        protected ConnectionManager connManager;

		public ClienteDAOImp() throws DAOExcepcion {
			super();
			try{
			connManager= new ConnectionManager("alquilervehiculosBD");
			}
			catch (ClassNotFoundException e){	
				throw new DAOExcepcion(e);
				}
		}

		public ClienteDTO buscarCliente(String dni) throws DAOExcepcion {
			try{
				connManager.connect();
				ResultSet rs=connManager.queryDB("select * from CLIENTE where DNI= '"+dni+"'");
				connManager.close();
			
				if (rs.next())
					return new ClienteDTO(
								rs.getString("DNI").trim(),
								rs.getString("NOMBREAPELLIDOS"),
								rs.getString("DIRECCION"),
								rs.getString("POBLACION"),
								rs.getString("CODPOSTAL"),
								LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(),
										rs.getTime("FECHACARNETCONDUCIR").toLocalTime()),
								rs.getString("DIGITOSTC"),
								rs.getInt("MESTC"),
								rs.getInt("a\u00f1oTC"),
								rs.getInt("CVCTC"),
								rs.getString("TIPOTC"));



				else
					return null;	
			}
			catch (SQLException e){	throw new DAOExcepcion(e);}	
		}

		
		public void crearCliente(ClienteDTO cliente) throws DAOExcepcion {
			try{
				connManager.connect();
				connManager.queryDB("insert into CLIENTE values ('"
																				+cliente.getDni()+"','"
																				+cliente.getNombreyApellidos()+"','"
																				+cliente.getDireccion()+"','"
																				+cliente.getPoblacion()+"','"																				
																				+cliente.getCodPostal()+"','"
																				+DateUtil.format(cliente.getFechaCanetConducir())+"','"
																				+cliente.getDigitosTC()+"',"
																				+cliente.getMesTC()+","
																				+cliente.getAñoTC()+","
																				+cliente.getCvcTC()+",'"
																				+cliente.getTipoTC()+"')");						
				connManager.close();
			}catch (SQLException e){	System.out.println("fail D:\n"+e); throw new DAOExcepcion(e);}	
		}
		
		public List<ClienteDTO> obtenerClientes() throws DAOExcepcion {
			try{
				connManager.connect();
				ResultSet rs=connManager.queryDB("select * from CLIENTE");						
				connManager.close();
		  	  
				List<ClienteDTO> listaClienteDTO = new ArrayList<ClienteDTO>();
					
				try{				
					while (rs.next()){

						ClienteDTO clDTO = new ClienteDTO(
								rs.getString("DNI").trim(),
								rs.getString("NOMBREAPELLIDOS"),
								rs.getString("DIRECCION"),
								rs.getString("POBLACION"),
								rs.getString("CODPOSTAL"),
								LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate()
												,rs.getTime("FECHACARNETCONDUCIR").toLocalTime()),
								rs.getString("DIGITOSTC"),
								rs.getInt("MESTC"),
								rs.getInt("a\u00f1oTC"),
								rs.getInt("CVCTC"),
								rs.getString("TIPOTC")); 
						listaClienteDTO.add(clDTO);
					}
					return listaClienteDTO;
				}
				catch (Exception e){	throw new DAOExcepcion(e);}
			}
			catch (SQLException e){	throw new DAOExcepcion(e);}	
			catch (DAOExcepcion e){		throw e;}

		}

	}
