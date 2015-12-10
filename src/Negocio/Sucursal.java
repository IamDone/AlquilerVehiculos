package Negocio;


import java.util.HashMap;

public class Sucursal {
int id;	
String direccion;
public HashMap<Integer, Reserva> listaRecogida = new HashMap<Integer, Reserva>();
public HashMap<Integer, Reserva> listaDevolucion = new HashMap<Integer, Reserva>();



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getDireccion() {
	return direccion;
}



public void setDireccion(String direccion) {
	this.direccion = direccion;
}



public HashMap<Integer, Reserva> getListaRecogida() {
	return listaRecogida;
}



public void setListaRecogida(HashMap<Integer, Reserva> listaRecogida) {
	this.listaRecogida = listaRecogida;
}



public HashMap<Integer, Reserva> getListaDevolucion() {
	return listaDevolucion;
}



public void setListaDevolucion(HashMap<Integer, Reserva> listaDevolucion) {
	this.listaDevolucion = listaDevolucion;
}



public Sucursal(int id, String direccion){
	this.id = id;
	this.direccion = direccion;
}



@Override
public String toString() {
	return "Sucursal [id=" + id + ", direccion=" + direccion + "]";
}

}
