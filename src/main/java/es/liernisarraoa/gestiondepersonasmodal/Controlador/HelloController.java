package es.liernisarraoa.gestiondepersonasmodal.Controlador;

import es.liernisarraoa.gestiondepersonasmodal.Modelo.Persona;
import es.liernisarraoa.gestiondepersonasmodal.VentanaModal.NuevaPersona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController  implements Initializable {
    @FXML
    private TableView<Persona> tablaPersonas;

    @FXML
    private TableColumn<Persona, String> columnaNombre;

    @FXML
    private TableColumn<Persona, String> columnaApellido;

    @FXML
    private TableColumn<Persona, Integer> columnaEdad;

    @FXML
    private Button btnAgregarPersona;


    public void agregarPersona(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        NuevaPersona modal = new NuevaPersona();
        modal.start(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tablaPersonas.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnaNombre.prefWidthProperty().bind(tablaPersonas.widthProperty().multiply(0.4));
        columnaApellido.prefWidthProperty().bind(tablaPersonas.widthProperty().multiply(0.4));
        columnaEdad.prefWidthProperty().bind(tablaPersonas.widthProperty().multiply(0.2));
    }
}