package Presentacion.control;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
//import java.util.logging.Level;
//import com.sun.javafx.logging.Logger;
import java.util.logging.Level;

//import org.hsqldb.persist.Logger;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Negocio.AlquilerVehiculos;
import Negocio.Cliente;

//import com.sun.javafx.logging.Logger;

public class ControladorCrearCliente extends ControladorCasoDeUso {
 private static final Logger LOG = Logger.getLogger(ControladorCrearCliente.class.getName());
 @FXML
 private TextField dni;
 @FXML
 private TextField nombreApellidos;
 @FXML
 private TextField direccion;
 @FXML
 private TextField añoTC;
 @FXML
 private TextField mesTC;
 @FXML
 private TextField codigoPostal;
 @FXML
 private TextField poblacion;
 @FXML
 private DatePicker fechaCarnet;
 @FXML
 private TextField cvc;
 @FXML
 private TextField tipoTarjeta;
 @FXML
 private TextField digitosTC;
 @FXML
 private Button aceptar;
 @FXML
 private Button cancelar;
 private Cliente nuevoCliente;
 @Override
 public void initialize(URL location, ResourceBundle resources) {
	 stage = new Stage(StageStyle.DECORATED);
	 stage.setTitle("CREAR CLIENTE");

	 cancelar.setOnAction(event -> stage.close());
	 aceptar.setOnAction(event -> {
	 nuevoCliente = new Cliente(dni.getText(), 
			 					nombreApellidos.getText(),
			 					direccion.getText(),
			 					poblacion.getText(), 
			 					codigoPostal.getText(),
			 					LocalDateTime.of(fechaCarnet.getValue(),  LocalTime.of(0, 0)), 
			 					digitosTC.getText(),
			 					Integer.parseInt(mesTC.getText()),
			 					Integer.parseInt(añoTC.getText()),
			 					Integer.parseInt(cvc.getText()), 
			 					tipoTarjeta.getText());
	 if (nuevoCliente != null) {
	 //Invocamos el servicio encargado de Crear un nuevo cliente
	
	try {
		AlquilerVehiculos.newInstancia().crearCliente(nuevoCliente);
	} catch (Exception e) {
		e.printStackTrace();
	}
	 //LOG.log(Level.INFO, "Se ha creado un nuevo Cliente: " +nuevoCliente);
	 } else {
	 //LOG.log(Level.INFO, "No se ha podido crear un nuevo cliente.");
	 }
	 stage.close();
	 });
 }
}