module es.liernisarraoa.gestiondepersonasmodal {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.liernisarraoa.gestiondepersonasmodal.Modelo to javafx.base;
    opens es.liernisarraoa.gestiondepersonasmodal to javafx.fxml;
    exports es.liernisarraoa.gestiondepersonasmodal;
    exports es.liernisarraoa.gestiondepersonasmodal.Controlador;
    opens es.liernisarraoa.gestiondepersonasmodal.Controlador to javafx.fxml;
}