package es.liernisarraoa.gestiondepersonasmodal.Controlador;

import es.liernisarraoa.gestiondepersonasmodal.Modelo.Persona;
import es.liernisarraoa.gestiondepersonasmodal.VentanaModal.NuevaPersona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador para la ventana modal de creación de una nueva persona.
 *
 * @author Lierni
 * @version 1.0
 */
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

    /**
     * Guarda la información de la nueva persona si los datos son válidos.
     * Si hay errores en los datos, muestra una alerta.
     *
     * @param actionEvent El evento que desencadena esta acción.
     */
    public void guardarPersona(ActionEvent actionEvent) {
        verificacionPersona();
        if(errores.isEmpty()){
            p = new Persona(nombreTextField.getText(), apellidoTextField.getText(), Integer.valueOf(edadTextField.getText()));
            modal.close();
        } else {
            alertaError();
        }
    }

    /**
     * Cierra la ventana modal sin guardar la información.
     *
     * @param actionEvent El evento que desencadena esta acción.
     */
    public void cerrarModal(ActionEvent actionEvent) {
        p = null;
        modal.close();
    }

    /**
     * Verifica que los datos ingresados para la nueva persona sean válidos.
     * Almacena los errores encontrados en la variable 'errores'.
     */
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

    /**
     * Muestra una alerta con los errores encontrados durante la verificación de datos.
     */
    private void alertaError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(escenaAplicacion.getWindow());
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(errores);
        alert.showAndWait();
    }

    /**
     * Obtiene la persona creada.
     *
     * @return La persona creada o null si no se ha creado ninguna.
     */
    public static Persona getP(){
        return p;
    }
}