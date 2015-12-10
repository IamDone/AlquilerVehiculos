package Presentacion.control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import excepciones.LogicaExcepcion;

public class ControladorPrincipal {
	 private static final String CREAR_CLIENTE = "/Presentacion/vista/crear-cliente.fxml";
	 private static final String LISTAR_RESERVAS_SUCURSAL = "/Presentacion/vista/listar-reservas-sucursal.fxml";
	 private static final String LISTAR_SUCURSALES = "/Presentacion/vista/listar-sucursales.fxml";
	 private static final String CREAR_RESERVA = "/Presentacion/vista/crear-reserva.fxml";

	 private Stage primaryStage;
	 @FXML
	 void listarSucursales(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_SUCURSALES,ControladorListarSucursales.class).show();
	 }
	 @FXML
	 void crearCliente(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(CREAR_CLIENTE, ControladorCrearCliente.class).show();
	 }
	 @FXML
	 void crearReserva(ActionEvent event) {
		 initCasoDeUso(CREAR_RESERVA, ControladorCrearReserva.class).show();
	 }
	 @FXML
	 void listarReservasSucursal(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_RESERVAS_SUCURSAL, ControladorListarReservasSucursal.class).show();
	 }
	 @FXML
	 void salir(ActionEvent event) {
		 Platform.exit();
	 }
	 public void setPrimaryStage(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	 }
	 private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista,Class<T> controlClass) {
	 return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass,
			 primaryStage, ControladorPrincipal.this); 
	 }
	 
	}