package es.liernisarraoa.gestiondepersonasmodal;

import es.liernisarraoa.gestiondepersonasmodal.Controlador.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionPersonas extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestionPersonas.class.getResource("gestionDePersonasPrincipal.fxml"));
        scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Gestion de Personas");
        stage.getIcons().add(new Image(String.valueOf(GestionPersonas.class.getResource("/Imagenes/agenda.png"))));
        stage.setScene(scene);
        stage.show();

        //Obtener el controlador y pasar la escena
        HelloController controlador = fxmlLoader.getController();
        controlador.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}