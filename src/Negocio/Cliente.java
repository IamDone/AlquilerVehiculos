package Negocio;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class Cliente {
	String identificador, 
		nombreyApellidos,
		direccion,
		poblacion,
		digitosTC,
	    codPostal;
	LocalDateTime fechaCarnetConducir;
	int mesTC,
		a�oTC,
		cvcTC;
	String tipoTC;
	private HashMap<Integer, Reserva> listaReserva = new HashMap<Integer, Reserva>();
	
	public Cliente(String identificador, String nombreyApellidos, String direccion, String poblacion,
			String codPostal, LocalDateTime fechaCarnetConducir, String digitosTC, int mesTC,
			int a�oTC, int cvcTC, String tipoTC) {
		super();
		this.identificador = identificador;
		this.nombreyApellidos = nombreyApellidos;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codPostal = codPostal;
		this.fechaCarnetConducir = fechaCarnetConducir;
		this.digitosTC = digitosTC;
		this.mesTC = mesTC;
		this.a�oTC = a�oTC;
		this.cvcTC = cvcTC;
		this.tipoTC = tipoTC;
		
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombreyApellidos() {
		return nombreyApellidos;
	}
	public void setNombreyApellidos(String nombreyApellidos) {
		this.nombreyApellidos = nombreyApellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public LocalDateTime getFechaCarnetConducir() {
		return fechaCarnetConducir;
	}
	public void setFechaCarnetConducir(LocalDateTime fechaCarnetConducir) {
		this.fechaCarnetConducir = fechaCarnetConducir;
	}
	public String getDigitosTC() {
		return digitosTC;
	}
	public void setDigitosTC(String digitosTC) {
		this.digitosTC = digitosTC;
	}
	public int getMesTC() {
		return mesTC;
	}
	public void setMesTC(int mesTC) {
		this.mesTC = mesTC;
	}
	public int getA�oTC() {
		return a�oTC;
	}
	public void setA�oTC(int a�oTC) {
		this.a�oTC = a�oTC;
	}
	public int getCvcTC() {
		return cvcTC;
	}
	public void setCvcTC(int cvcTC) {
		this.cvcTC = cvcTC;
	}
	public String getTipoTC() {
		return tipoTC;
	}
	public void setTipoTC(String tipoTC) {
		this.tipoTC = tipoTC;
	}

	public HashMap<Integer, Reserva> getListaReserva() {
		return listaReserva;
	}

	public void setListaReserva(HashMap<Integer, Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}

	@Override
	public String toString() {
		return "Cliente [identificador=" + identificador
				+ ", nombreyApellidos=" + nombreyApellidos + ", direccion="
				+ direccion + ", poblacion=" + poblacion + ", digitosTC="
				+ digitosTC + ", codPostal=" + codPostal
				+ ", fechaCarnetConducir=" + fechaCarnetConducir + ", mesTC="
				+ mesTC + ", a�oTC=" + a�oTC + ", cvcTC=" + cvcTC + ", tipoTC="
				+ tipoTC + "]";
	}
	
}
