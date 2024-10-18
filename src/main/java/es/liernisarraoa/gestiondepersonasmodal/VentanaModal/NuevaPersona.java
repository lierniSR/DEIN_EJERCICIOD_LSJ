package es.liernisarraoa.gestiondepersonasmodal.VentanaModal;

import es.liernisarraoa.gestiondepersonasmodal.GestionPersonas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase que representa una ventana modal para añadir una nueva persona.
 * Extiende de la clase Application de JavaFX.
 *
 * @author Lierni
 * @version 1.0
 */
public class NuevaPersona extends Application {
    private static Scene scene;
    private static Stage modal = new Stage();

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Método que se ejecuta al iniciar la aplicación.
     * Configura y muestra la ventana modal.
     *
     * @param stage El escenario principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestionPersonas.class.getResource("gestionDePersonasModal.fxml"));
        modal = stage;
        scene = new Scene(fxmlLoader.load(), 500, 300);
        modal.setTitle("Añadir persona");
        modal.setResizable(false);
        modal.getIcons().add(new Image(String.valueOf(GestionPersonas.class.getResource("/Imagenes/agenda.png"))));
        modal.setScene(scene);
        modal.showAndWait();
    }

    /**
     * Método para obtener la escena de la ventana modal.
     *
     * @return La escena de la ventana modal.
     */
    public static Scene getScene(){
        return scene;
    }

    /**
     * Método para obtener el escenario de la ventana modal.
     *
     * @return El escenario de la ventana modal.
     */
    public static Stage getStage(){
        return modal;
    }
}
