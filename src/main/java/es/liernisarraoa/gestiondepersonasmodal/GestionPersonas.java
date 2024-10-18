package es.liernisarraoa.gestiondepersonasmodal;

import es.liernisarraoa.gestiondepersonasmodal.Controlador.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal que inicia la aplicación de Gestión de Personas.
 * Extiende la clase Application de JavaFX.
 *
 * @author Lierni
 * @version 1.0
 */
public class GestionPersonas extends Application {
    /** Escena principal de la aplicación. */
    private static Scene scene;

    /**
     * Método que inicia la aplicación JavaFX.
     * Carga el archivo FXML, configura la escena y muestra la ventana principal.
     *
     * @param stage El escenario principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestionPersonas.class.getResource("gestionDePersonasPrincipal.fxml"));
        scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Gestion de Personas");
        stage.getIcons().add(new Image(String.valueOf(GestionPersonas.class.getResource("/Imagenes/agenda.png"))));
        stage.setScene(scene);
        stage.show();

        //Obtener el controlador y pasar la escena; Esto sirve para que escenaAplicacion de HelloController no de null
        HelloController controlador = fxmlLoader.getController();
        controlador.setScene(scene);
    }

    /**
     * Método principal que lanza la aplicación.
     *
     * @param args Argumentos de línea de comando (no se utilizan).
     */
    public static void main(String[] args) {
        launch();
    }
}