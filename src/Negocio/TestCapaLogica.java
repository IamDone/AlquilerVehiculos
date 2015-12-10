package Negocio;

import java.time.LocalDateTime;
import java.util.Date;

import excepciones.DAOExcepcion;

public class TestCapaLogica {
	
	public static void main(String args[]) throws DAOExcepcion{
		AlquilerVehiculos instancia = new AlquilerVehiculos();	
		//instancia.cargaSistema();
		
		//Reserva res1 = new Reserva(1, new Date(12/05/2016),new Date(15/05/2016), 1,);
		
		instancia.crearCliente("11111111A", "Pepito Grillo", "Hispanidad, 13", "Aldaia", "46960",LocalDateTime.of(1970,02,12,0,0), "12345678", 7, 2017, 123, "Visa");
		instancia.crearCliente("22222222B", "David Bisbal", "Valencia, 23", "Massamagrell", "46130", LocalDateTime.of(1970,02,12,0,0), "12348765", 10, 2024, 432, "American Express");
		instancia.crearReserva( LocalDateTime.of(1970,02,12,0,0), LocalDateTime.of(1998,02,12,0,0),1, 1,  "22222222B","sedán", 1);
		instancia.crearReserva( LocalDateTime.of(1970,02,12,0,0), LocalDateTime.of(1970,02,12,0,0) ,1 , 2,  "22222222B","economy", 2);
	
		for(Reserva re:instancia.listarReservaSucursal(1)){
			System.out.println(re.toString());
		}
	}
	
}
