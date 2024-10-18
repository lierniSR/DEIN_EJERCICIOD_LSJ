package es.liernisarraoa.gestiondepersonasmodal.Controlador;

import es.liernisarraoa.gestiondepersonasmodal.Modelo.Persona;
import es.liernisarraoa.gestiondepersonasmodal.VentanaModal.NuevaPersona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ControladorModal {

    private Scene escenaAplicacion = NuevaPersona.getScene();
    private Stage modal = NuevaPersona.getStage();
    private static Persona p = null;
    private String errores = "";

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private TextField edadTextField;

    public void guardarPersona(ActionEvent actionEvent) {
        verificacionPersona();
        if(errores.isEmpty()){
            p = new Persona(nombreTextField.getText(), apellidoTextField.getText(), Integer.valueOf(edadTextField.getText()));
            modal.close();
        } else {
            alertaError();
        }
    }

    public void cerrarModal(ActionEvent actionEvent) {
        p = null;
        modal.close();
    }

    private void verificacionPersona() {
        errores = "";
        escenaAplicacion = NuevaPersona.getScene();
        if (nombreTextField.getText().isEmpty()) {
            errores += "El campo nombre es obligatorio.\n";
        }
        if (apellidoTextField.getText().isEmpty()) {
            errores += "El campo apellidos es obligatorio.\n";
        }
        if (edadTextField.getText().isEmpty()) {
            errores += "El campo edad es obligatorio";
        } else {
            try {
                Integer edad = Integer.parseInt(edadTextField.getText());
            } catch (NumberFormatException e) {
                errores += "El campo edad tiene que ser númerico.\n";
            }
        }
    }

    private void alertaError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(escenaAplicacion.getWindow());
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(errores);
        alert.showAndWait();
    }

    public static Persona getP(){
        return p;
    }
}
