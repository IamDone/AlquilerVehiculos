package persistencia;

import excepciones.DAOExcepcion;
import Negocio.AlquilerVehiculos;
import Negocio.Categoria;
import Negocio.Sucursal;

public class DAOPersistenceTester {

	public static void main(String[] args) throws DAOExcepcion {
		AlquilerVehiculos instancia = new AlquilerVehiculos();	
		for(Categoria ca:instancia.getListaCategoria().values()){
			System.out.println(ca.toString());
		}
		for(Sucursal su:instancia.getListaSucursal().values()){
			System.out.println(su.toString());
		}
	}

}
