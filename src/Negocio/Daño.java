package Negocio;

public class Daño {
	String zona;
	String Descripcion;
	
	public Daño(String zona, String descripcion) {
		super();
		this.zona = zona;
		Descripcion = descripcion;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}	
	
}
