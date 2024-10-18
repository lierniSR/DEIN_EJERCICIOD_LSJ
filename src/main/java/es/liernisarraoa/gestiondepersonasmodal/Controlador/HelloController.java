package es.liernisarraoa.gestiondepersonasmodal.Controlador;

import es.liernisarraoa.gestiondepersonasmodal.GestionPersonas;
import es.liernisarraoa.gestiondepersonasmodal.Modelo.Persona;
import es.liernisarraoa.gestiondepersonasmodal.VentanaModal.NuevaPersona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController  implements Initializable {
    private Scene escenaAplicacion;

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
        NuevaPersona modal = new NuevaPersona();
        Stage scene = new Stage();
        //Mejor poner la modalidad fuera, es decir en el metodo al que va a llamar a la ventana modal.
        scene.initModality(Modality.APPLICATION_MODAL);
        modal.start(scene);
        Persona personaAniadirTabla = ControladorModal.getP();
        if (!tablaPersonas.getItems().contains(personaAniadirTabla)) {
            alertaAniadirPersona();
            tablaPersonas.getItems().add(personaAniadirTabla);
            tablaPersonas.getSelectionModel().clearSelection();
        } else {
            if(personaAniadirTabla != null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(escenaAplicacion.getWindow());
                alert.setHeaderText(null);
                alert.setTitle("Persona duplicada");
                alert.setContentText("La persona no se puede añadir ya que existe en la tabla.");
                alert.showAndWait();
            }
        }
    }

    public void setScene(Scene scene){
        this.escenaAplicacion = scene;
    }

    private void alertaAniadirPersona() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(escenaAplicacion.getWindow());
        alert.setHeaderText(null);
        alert.setTitle("Persona añadida");
        alert.setContentText("Persona añadida correctamente.");
        alert.showAndWait();
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