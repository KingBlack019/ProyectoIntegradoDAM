package com.vicente.vmotion.ControllerViews;

import com.vicente.vmotion.Main;
import com.vicente.vmotion.Management.Comun;
import com.vicente.vmotion.Management.ControllerViewInterface;
import com.vicente.vmotion.Management.Ordenes;
import com.vicente.vmotion.Model.Usuarios;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.imageio.IIOException;

import java.io.IOException;

import static com.vicente.vmotion.Management.Comun.*;

public class RegisterViewController implements ControllerViewInterface {

    @FXML
    public PasswordField contrasenaField;
    public TextField usuarioField;
    public Button crearButton;
    public ChoiceBox choiceBox;
    public PasswordField repeatContrasenaField;
    public TextField primerApellidoField;
    public TextField segundoApellidoField;
    public TextField emailField;

    private Main mainApp;

    @FXML
    private void initialize() {

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
        Usuarios userPrueba = new Usuarios("r", "r", "r", "r", "r", Comun.getFechaActual());

        enviarDatos(Ordenes.EXISTE_USUARIO.toString());
        enviarDatos(userPrueba.getNombre());

        // enviarDatos(usuarioField.getText()); // ENVIAR USUARIO
        String resultado = recibirDatos().toString();
        if (Boolean.parseBoolean(resultado)) {

            enviarDatos(Ordenes.CREAR_USUARIO.toString()); // ENVIAR ORDEN
            // todo se le envia datos para ver si existe usuario por lo tanto el comando primero es si existe dicho usuario


            Usuarios usuario = new Usuarios();
            Usuarios usuarioRegister = new Usuarios(usuarioField.getText(), primerApellidoField.getText(), segundoApellidoField.getText(),
                    contrasenaField.getText(), emailField.getText(), Comun.getFechaActual());
            String cadena = usuario.crearCadena(userPrueba);

            enviarDatos(cadena);
            enviarDatos(choiceBox.getValue().toString());
        } else {
            mostrarMensaje("Error creando el usuario");
        }
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Retorna si el texto de las contraseñasField son las mismas
    private Boolean comprobarContrasena() {
        System.out.println("COMPROBARCONTRASENA");
        return !mismoTexto(contrasenaField.getText(), repeatContrasenaField.getText());
    }

    private Boolean comprobarUsuario() {
        System.out.println("COMPROBARUSUARIO");
        enviarDatos(Ordenes.EXISTE_USUARIO); // 1- STRING
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
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }


}
