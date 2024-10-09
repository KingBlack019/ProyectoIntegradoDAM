package com.vicente.vmotion.ControllerViews;

import com.vicente.vmotion.Main;
import com.vicente.vmotion.Management.ControllerViewInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class LoginViewController implements ControllerViewInterface {
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField contrasenaField;

    @FXML
    private Button entrarButton;


    private Main mainApp;

    private final String buttonStyle = "-fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 24;";


    @FXML
    private void initialize() {
        // Ejemplo de manejo de evento para el botón "Entrar"
        entrarButton.setOnAction(event -> {
            String usuario = usuarioField.getText();
            String contrasena = contrasenaField.getText();
            System.out.println("Usuario: " + usuario + ", Contraseña: " + contrasena);
            // Lógica adicional para manejar el login

            if(usuario.toLowerCase().trim().compareTo("a") != 0)
                mostrarMensaje("Nombre de usuario o contraseña incorrecto");
            else
                mainApp.showView("MainScreenView"); // Cambiar a la vista principal

        });

        setChoicheBox();

        entrarButton.setOnMouseEntered(dragEvent -> entrarButton.setStyle("-fx-background-color: lightgreen;"+buttonStyle));
        entrarButton.setOnMouseExited(dragEvent -> entrarButton.setStyle("-fx-background-color: deepskyblue;"+buttonStyle));
    }

    private void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @Override
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    private void setChoicheBox(){
        String[] opcionesArray = {"CONSUMIDOR", "OFERTANTE"};
        ObservableList<String> opciones = FXCollections.observableArrayList(opcionesArray);
        choiceBox.setItems(opciones);
        choiceBox.setValue("CONSUMIDOR");
    }
}
