package es.liernisarraoa.gestiondepersonasmodal.Controlador;

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

/**
 * Controlador principal para la gestión de personas.
 * Implementa la interfaz Initializable para inicializar componentes JavaFX.
 *
 *
 * @author Lierni
 * @version 1.0
 *
 */
public class HelloController implements Initializable {
    /** Escena principal de la aplicación. */
    private Scene escenaAplicacion;

    /** Tabla que muestra la lista de personas. */
    @FXML
    private TableView<Persona> tablaPersonas;

    /** Columna para mostrar el nombre de la persona. */
    @FXML
    private TableColumn<Persona, String> columnaNombre;

    /** Columna para mostrar el apellido de la persona. */
    @FXML
    private TableColumn<Persona, String> columnaApellido;

    /** Columna para mostrar la edad de la persona. */
    @FXML
    private TableColumn<Persona, Integer> columnaEdad;

    /** Botón para agregar una nueva persona. */
    @FXML
    private Button btnAgregarPersona;

    /**
     * Maneja el evento de agregar una nueva persona.
     * Abre una ventana modal para ingresar los datos de la nueva persona.
     *
     * @param actionEvent El evento que desencadena esta acción.
     * @throws IOException Si ocurre un error al abrir la ventana modal.
     */
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

    /**
     * Establece la escena principal de la aplicación.
     *
     * @param scene La escena principal a establecer.
     */
    public void setScene(Scene scene){
        this.escenaAplicacion = scene;
    }

    /**
     * Muestra una alerta informativa cuando se añade una persona correctamente.
     */
    private void alertaAniadirPersona() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(escenaAplicacion.getWindow());
        alert.setHeaderText(null);
        alert.setTitle("Persona añadida");
        alert.setContentText("Persona añadida correctamente.");
        alert.showAndWait();
    }

    /**
     * Inicializa el controlador.
     * Configura la tabla de personas y sus columnas.
     *
     * @param url La ubicación utilizada para resolver rutas relativas para el objeto raíz, o null si no se conoce.
     * @param resourceBundle Los recursos utilizados para localizar el objeto raíz, o null si el objeto raíz no fue localizado.
     */
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