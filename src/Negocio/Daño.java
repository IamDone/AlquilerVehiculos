package Negocio;

public class Da�o {
	String zona;
	String Descripcion;
	
	public Da�o(String zona, String descripcion) {
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
