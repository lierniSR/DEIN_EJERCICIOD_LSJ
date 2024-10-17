package es.liernisarraoa.gestiondepersonasmodal.VentanaModal;
import es.liernisarraoa.gestiondepersonasmodal.GestionPersonas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NuevaPersona extends Application {
    private static Scene scene;
    private static Stage modal;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestionPersonas.class.getResource("gestionDePersonasModal.fxml"));
        scene = new Scene(fxmlLoader.load(), 500, 300);
        stage.setTitle("Añadir persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.getIcons().add(new Image(String.valueOf(GestionPersonas.class.getResource("/Imagenes/agenda.png"))));
        stage.setScene(scene);
        modal = stage;
        stage.showAndWait();

    }

    public static Scene getScene(){
        return scene;
    }

    public static Stage getStage(){
        return modal;
    }

}
