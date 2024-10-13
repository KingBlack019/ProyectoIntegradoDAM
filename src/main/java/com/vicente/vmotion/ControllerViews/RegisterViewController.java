package com.vicente.vmotion.ControllerViews;

import com.vicente.vmotion.Main;
import com.vicente.vmotion.Management.ControllerViewInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterViewController implements ControllerViewInterface {

    @FXML
    public PasswordField contrasenaField;
    @FXML
    public TextField usuarioField;
    @FXML
    public Button crearButton;
    @FXML
    public PasswordField repeatContrasenaField1;

    private Main mainApp;

    @FXML
    private void initialize(){

        crearButton.setOnAction(e -> comprobarRegistro());
    }

    private void comprobarRegistro() {
        // TODO TENEMOS QUE COMPROBAR CADA UNO DE LOS REGISTROS, SE HA ESCRITO USUARIO, LAS CONTRASEÑAS COINCIDEN Y SI YA E EN BD
        // 1.- E usuario

    }

    private void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void comprobarContrasena() {
    }

    private void comprobarUsuario() {
    }


    @Override
    public void setMainApp(Main app) {
        this.mainApp = app;
    }
}
