package Negocio;

import java.time.LocalDateTime;
import java.util.Date;

public class Reserva {
	int identificador;
	LocalDateTime fechaRecogida;
	LocalDateTime fechaDevolucion;
	int modalidadAlquiler;
	Entrega entrega;
	Sucursal lugarR, lugarD;
	Categoria categoriaAsociada;
	String dniCliente; 
	public String toString() {
		return "Reserva [identificador=" + identificador + ", fechaRecogida="
				+ fechaRecogida + ", fechaDevolucion=" + fechaDevolucion
				+ ", modalidadAlquiler=" + modalidadAlquiler + ", entrega="
				+ entrega + ", lugarR=" + lugarR + ", lugarD=" + lugarD
				+ ", categoriaAsociada=" + categoriaAsociada + "]";
	}
	public Reserva(int identificador, LocalDateTime fechaRecogida, LocalDateTime fechaDevolucion,
			int modalidadAlquiler,String dniCliente, Categoria categoriaAsociada, Sucursal lugarR, Sucursal lugarD) {
		super();
		this.identificador = identificador;
		this.fechaRecogida = fechaRecogida;
		this.fechaDevolucion = fechaDevolucion;
		this.modalidadAlquiler = modalidadAlquiler;
		this.categoriaAsociada = categoriaAsociada;
		this.lugarR = lugarR;
		this.lugarD = lugarD;
		this.dniCliente = dniCliente;
	}
	
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public Categoria getCategoriaAsociada() {
		return categoriaAsociada;
	}
	public void setCategoriaAsociada(Categoria categoriaAsociada) {
		this.categoriaAsociada = categoriaAsociada;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public LocalDateTime getFechaRecogida() {
		return fechaRecogida;
	}
	public void setFechaRecogida(LocalDateTime fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}
	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public int getModalidadAlquiler() {
		return modalidadAlquiler;
	}
	public void setModalidadAlquiler(int modalidadAlquiler) {
		this.modalidadAlquiler = modalidadAlquiler;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	public Sucursal getLugarR() {
		return lugarR;
	}
	public void setLugarR(Sucursal lugarR) {
		this.lugarR = lugarR;
	}
	public Sucursal getLugarD() {
		return lugarD;
	}
	public void setLugarD(Sucursal lugarD) {
		this.lugarD = lugarD;
	}
}
