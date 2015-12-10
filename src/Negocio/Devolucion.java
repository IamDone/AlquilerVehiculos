package Negocio;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class Devolucion {
	LocalDateTime fecha;
	float totalACobrar;
	float cobrado;
	int kms;
	String combustible;
	Entrega entrega;
	public HashMap<String, Da�o> listaDa�o = new HashMap<String, Da�o>();
	
	public Devolucion(LocalDateTime fecha, float totalACobrar, float cobrado, int kms,
			String combustible) {
		super();
		this.fecha = fecha;
		this.totalACobrar = totalACobrar;
		this.cobrado = cobrado;
		this.kms = kms;
		this.combustible = combustible;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public float getTotalACobrar() {
		return totalACobrar;
	}
	public void setTotalACobrar(float totalACobrar) {
		this.totalACobrar = totalACobrar;
	}
	public float getCobrado() {
		return cobrado;
	}
	public void setCobrado(float cobrado) {
		this.cobrado = cobrado;
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
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	public HashMap<String, Da�o> getListaDa�o() {
		return listaDa�o;
	}
	public void setListaDa�o(HashMap<String, Da�o> listaDa�o) {
		this.listaDa�o = listaDa�o;
	}
	
}
