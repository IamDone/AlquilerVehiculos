package Presentacion.control;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import persistencia.dto.ReservaDTO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Negocio.AlquilerVehiculos;
import Negocio.Reserva;
import Negocio.Sucursal;
import excepciones.DAOExcepcion;

public class ControladorListarReservasSucursal extends ControladorCasoDeUso {

	 @FXML
	 private TableView<ReservaDTO> reservas;
	 @FXML
	 private TableColumn<ReservaDTO, String> id;
	 @FXML
	 private TableColumn<ReservaDTO, String> col2,col3,col4;
	 @FXML
	 private Button cerrar;
	 @FXML
	 private ComboBox<String> listaSucursales;
	
	
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("LISTADO DE RESERVAS POR SUCURSAL");
		 cerrar.setOnAction(event -> stage.close());
		 try {
			listaSucursales.setItems(listarSuc(AlquilerVehiculos.newInstancia().getListaSucursal().values()));
		
		 } catch (DAOExcepcion e) {
			e.printStackTrace();
		}
		 
		 listaSucursales.setOnAction(a ->{ 
			 elegirSucursal();});	
		
	 }
	 //
	 private void elegirSucursal(){
		 try {
			 ObservableList<ReservaDTO> lista = FXCollections.observableArrayList();
				for ( ReservaDTO re : AlquilerVehiculos.newInstancia().getReservasPorSucursal(listaSucursales.getItems().indexOf(listaSucursales.getValue())+1)){
					lista.add(re);
				}
			this.reservas.getItems().clear();
			this.reservas.getItems().addAll(lista);
			
			} catch (DAOExcepcion e) {
				e.printStackTrace();
			}
		 id.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDniCliente()));
		 col2.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaRecogida().toString()));
		 col3.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaDevolucion().toString()));
		 col4.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(listaSucursales.getItems().get(param.getValue().getIdSucursalDevolucion()-1)));// -1 porque la lista empieza por 0
	 }
	 private ObservableList<String> listarSuc(Collection<Sucursal> l){
		 ObservableList<String> lista = FXCollections.observableArrayList();
				for(Sucursal ca:l){
					lista.add(ca.getDireccion());
				}
		return lista;
	}
}
