package Negocio;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class Entrega {
	LocalDateTime fecha;
	String tipoSeguro;
	int kms;
	String combustible;
	Devolucion devolucion;
	public HashMap<String, Da�o> listaDa�o = new HashMap<String, Da�o>();
	public Entrega(LocalDateTime fecha, String tipoSeguro, int kms, String combustible) {
		super();
		this.fecha = fecha;
		this.tipoSeguro = tipoSeguro;
		this.kms = kms;
		this.combustible = combustible;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getTipoSeguro() {
		return tipoSeguro;
	}
	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	public int getKms() {
		return kms;
	}
	public void setKms(int kms) {
		this.kms = kms;
	}
	public String getCombustible() {
		return combustible;
	}
	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	public Devolucion getDevolucion() {
		return devolucion;
	}
	public void setDevolucion(Devolucion devolucion) {
		this.devolucion = devolucion;
	}
	public HashMap<String, Da�o> getListaDa�o() {
		return listaDa�o;
	}
	public void setListaDa�o(HashMap<String, Da�o> listaDa�o) {
		this.listaDa�o = listaDa�o;
	}
	
	
	
}
