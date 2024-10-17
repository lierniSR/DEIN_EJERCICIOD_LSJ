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
    private static Stage modal = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestionPersonas.class.getResource("gestionDePersonasModal.fxml"));
        scene = new Scene(fxmlLoader.load(), 500, 300);
        modal.setTitle("Añadir persona");
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.setResizable(false);
        modal.getIcons().add(new Image(String.valueOf(GestionPersonas.class.getResource("/Imagenes/agenda.png"))));
        modal.setScene(scene);
        modal.showAndWait();
    }

    public static Scene getScene(){
        return scene;
    }

    public static Stage getStage(){
        return modal;
    }

}
