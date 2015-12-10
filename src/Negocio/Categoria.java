package Negocio;

import java.util.HashMap;

public class Categoria {
private Categoria superior;
private String nombre;
private double precioModIlimitado;
private double precioModKms;
private double precioKmModKms;
private double precioSeguroTRiesgo;
private double precioSeguroTerceros;
public HashMap<String, Coche> listaCoches = new HashMap<String, Coche>();
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public HashMap<String, Coche> getListaCoches() {
	return listaCoches;
}

public void setListaCoches(HashMap<String, Coche> listaCoches) {
	this.listaCoches = listaCoches;
}

public Categoria getSuperior() {
	return superior;
}

public Categoria(String nombre, double precioModIlimitado, double precioModKms,
		double precioKmModKms, double precioSeguroTRiesgo,
		double precioSeguroTerceros){
	this.nombre = nombre;
	this.precioModIlimitado = precioModIlimitado;
	this.precioModKms = precioModKms;
	this.precioKmModKms = precioKmModKms;
	this.precioSeguroTRiesgo = precioSeguroTRiesgo;
	this.precioSeguroTerceros = precioSeguroTerceros;
}

public double getPrecioModIlimitado() {
	return precioModIlimitado;
}
public void setPrecioModIlimitado(double precioModIlimitado) {
	this.precioModIlimitado = precioModIlimitado;
}
public double getPrecioModKms() {
	return precioModKms;
}
public void setPrecioModKms(double precioModKms) {
	this.precioModKms = precioModKms;
}
public double getPrecioKmModKms() {
	return precioKmModKms;
}
public void setPrecioKmModKms(double precioKmModKms) {
	this.precioKmModKms = precioKmModKms;
}
public double getPrecioSeguroTRiesgo() {
	return precioSeguroTRiesgo;
}
public void setPrecioSeguroTRiesgo(double precioSeguroTRiesgo) {
	this.precioSeguroTRiesgo = precioSeguroTRiesgo;
}
public double getPrecioSeguroTerceros() {
	return precioSeguroTerceros;
}
public void setPrecioSeguroTerceros(double precioSeguroTerceros) {
	this.precioSeguroTerceros = precioSeguroTerceros;
}
public void setSuperior(Categoria superior) {
	this.superior = superior;
	
}

@Override
public String toString() {
	return "Categoria [nombre=" + nombre
			+ ", precioModIlimitado=" + precioModIlimitado + ", precioModKms="
			+ precioModKms + ", precioKmModKms=" + precioKmModKms
			+ ", precioSeguroTRiesgo=" + precioSeguroTRiesgo
			+ ", precioSeguroTerceros=" + precioSeguroTerceros + "]";
}



}
