package com.vicente.vmotion.ControllerViews;

import com.vicente.vmotion.Main;
import com.vicente.vmotion.Management.ControllerViewInterface;
import com.vicente.vmotion.Management.Ordenes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.imageio.IIOException;

import java.io.IOException;

import static com.vicente.vmotion.Management.Comun.*;

public class RegisterViewController implements ControllerViewInterface {

    @FXML
    public PasswordField contrasenaField;
    @FXML
    public TextField usuarioField;
    @FXML
    public Button crearButton;
    @FXML
    public ChoiceBox choiceBox;
    public PasswordField repeatContrasenaField;

    private Main mainApp;

    @FXML
    private void initialize(){

        crearButton.setOnAction(e -> comprobarRegistro());
        setChoiceBox();
    }

    private void setChoiceBox() {
        choiceBox.setItems(roleChoiceBox());
        choiceBox.setValue(roleChoiceBox().getFirst());
    }

    private void comprobarRegistro() {
        // TODO TENEMOS QUE COMPROBAR CADA UNO DE LOS REGISTROS, SE HA ESCRITO USUARIO, LAS CONTRASEÑAS COINCIDEN Y SI YA E EN BD
        // 1.- E usuario
        enviarDatos(Ordenes.REGISTRAR.toString());
        String resultado = recibirDatos().toString();
        // System.out.println("resultado = " + resultado);

        if ( Boolean.parseBoolean(resultado) && comprobarUsuario() && comprobarContrasena()){


            enviarDatos( usuarioField.getText() );
            enviarDatos( contrasenaField.getText() );
            enviarDatos( choiceBox.getValue().toString() );
        } else {
            mostrarMensaje("Error creando el usuario");
        }
    }

    private void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Retorna si el texto de las contraseñasField son las mismas
    private Boolean comprobarContrasena() {
        return !mismoTexto(contrasenaField.getText(), repeatContrasenaField.getText());
    }
    private Boolean comprobarUsuario() {
        enviarDatos(Ordenes.EXISTEUSER); // 1- STRING
        enviarDatos(usuarioField.getText()); // 2- STRING
        return Boolean.parseBoolean(recibirDatos().toString()); // 3- BOOLEAN
    }



    @Override
    public void setMainApp(Main app) {
        this.mainApp = app;
    }

    @Override
    public void enviarDatos(Object o) {
        MainManagement.enviarDatos(o);
    }

    @Override
    public Object recibirDatos() {
        try {
            return MainManagement.recibirDatos();
        } catch (IOException ioe){
            ioe.printStackTrace();
            return null;
        }
    }
}
