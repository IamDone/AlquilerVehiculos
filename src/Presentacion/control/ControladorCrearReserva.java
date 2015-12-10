package Presentacion.control;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import excepciones.DAOExcepcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Negocio.AlquilerVehiculos;
import Negocio.Categoria;
import Negocio.Reserva;
import Negocio.Sucursal;

public class ControladorCrearReserva extends ControladorCasoDeUso {
	//private static final Logger LOG = Logger.getLogger(ControladorCrearReserva.class.getName());
	@FXML
    private ComboBox<String> lugarDev;
    @FXML
    private Button cancelar;
    @FXML
    private ComboBox<String> lugarRec;
    @FXML
    private ComboBox<String> modAlquiler;
    @FXML
    private Button aceptar;
    @FXML
    private DatePicker fechaR;
    @FXML
    private DatePicker fechaD;
    @FXML
    private TextField identificador;
    @FXML
    private ComboBox<String> catAsociada;
   // private Reserva nuevaReserva;
    	
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
   	 stage = new Stage(StageStyle.DECORATED);
   	 stage.setTitle("CREAR RESERVA");
   	 
	try {
   	 ObservableList<String> listaCat = listarCat(AlquilerVehiculos.newInstancia().getListaCategoria().values());
	 catAsociada.setItems(listaCat);
	 
	 ObservableList<String> listaSuc = listarSuc(AlquilerVehiculos.newInstancia().getListaSucursal().values());
	 lugarDev.setItems(listaSuc);
	 lugarRec.setItems(listaSuc);
	 
	 ObservableList<String> listaMod = listarMod();
	 modAlquiler.setItems(listaMod);
	 
	 
	 
   	 cancelar.setOnAction(event -> stage.close());
   	 aceptar.setOnAction(event -> {
   		
   		try {
			AlquilerVehiculos.newInstancia().crearReserva(		LocalDateTime.of(fechaR.getValue(),  LocalTime.of(0, 0)),
										LocalDateTime.of(fechaD.getValue(),  LocalTime.of(0, 0)),
										AlquilerVehiculos.newInstancia().encontrarS((String)lugarRec.getValue()),
										AlquilerVehiculos.newInstancia().encontrarS((String)lugarDev.getValue()),
										identificador.getText(),
										(String)catAsociada.getValue(),
										modAlquiler.getItems().indexOf(modAlquiler.getValue())+1);
			stage.close();
   		} catch (Exception e) {e.printStackTrace();}
   		});
	} catch (DAOExcepcion e) {
		e.printStackTrace();
	}
	
    }

    private ObservableList<String> listarCat(Collection<Categoria> l){
		 ObservableList<String> lista = FXCollections.observableArrayList();
				for(Categoria ca:l){
					lista.add(ca.getNombre());
				}
		return lista;
	}
    
    private ObservableList<String> listarSuc(Collection<Sucursal> l){
		 ObservableList<String> lista = FXCollections.observableArrayList();
				for(Sucursal ca:l){
					lista.add(ca.getDireccion());
				}
		return lista;
	}
    private ObservableList<String> listarMod(){
		 ObservableList<String> lista = FXCollections.observableArrayList();
		 lista.add("1");
		 lista.add("2");
		return lista;
	}
	
}
