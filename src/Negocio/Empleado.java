package Negocio;

import java.util.HashMap;

public class Empleado {
	private String nombre;
	private String administrador;
	public HashMap<String, Entrega> listaEntrega = new HashMap<String, Entrega>();
	public HashMap<String, Devolucion> listaDevolucion = new HashMap<String, Devolucion>();
	
	public Empleado(String nombre, String administrador) {
		this.nombre = nombre;
		this.administrador = administrador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAdministrador() {
		return administrador;
	}
	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}
	public HashMap<String, Entrega> getListaEntrega() {
		return listaEntrega;
	}
	public void setListaEntrega(HashMap<String, Entrega> listaEntrega) {
		this.listaEntrega = listaEntrega;
	}
	public HashMap<String, Devolucion> getListaDevolucion() {
		return listaDevolucion;
	}
	public void setListaDevolucion(HashMap<String, Devolucion> listaDevolucion) {
		this.listaDevolucion = listaDevolucion;
	}

}
