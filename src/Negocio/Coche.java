package Negocio;

public class Coche {
 private String matricula;
 private double km;
public Coche(String matricula, double km) {
	
	this.matricula = matricula;
	this.km = km;
}
public String getMatricula() {
	return matricula;
}
public void setMatricula(String matricula) {
	this.matricula = matricula;
}
public double getKm() {
	return km;
}
public void setKm(double km) {
	this.km = km;
}
 
}
