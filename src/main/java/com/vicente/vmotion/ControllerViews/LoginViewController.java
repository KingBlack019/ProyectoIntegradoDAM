package com.vicente.vmotion.ControllerViews;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;

public class LoginViewController {
    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField contrasenaField;

    @FXML
    private Button entrarButton;

    private final String buttonStyle = "-fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 24;";

    @FXML
    private void initialize() {
        // Ejemplo de manejo de evento para el botón "Entrar"
        entrarButton.setOnAction(event -> {
            String usuario = usuarioField.getText();
            String contrasena = contrasenaField.getText();
            System.out.println("Usuario: " + usuario + ", Contraseña: " + contrasena);
            // Lógica adicional para manejar el login

            if(usuario.toLowerCase().trim().compareTo("vicente") != 0){
                mostrarMensaje("Nombre de usuario o contraseña incorrecto");
            }

        });

        entrarButton.setOnMouseEntered(dragEvent -> entrarButton.setStyle("-fx-background-color: deepskyblue;"+buttonStyle));
        entrarButton.setOnMouseExited(dragEvent -> entrarButton.setStyle("-fx-background-color: lightgreen;"+buttonStyle));
    }

    private void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
