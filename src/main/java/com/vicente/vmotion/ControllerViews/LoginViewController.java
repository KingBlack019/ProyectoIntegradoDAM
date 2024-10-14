package com.vicente.vmotion.ControllerViews;

import com.vicente.vmotion.Main;
import com.vicente.vmotion.Management.ControllerViewInterface;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static com.vicente.vmotion.Management.Comun.roleChoiceBox;

public class LoginViewController implements ControllerViewInterface {
    @FXML
    public Button registerButton;
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
                MainManagement.showView(mainApp, "MainScreenView"); // Cambiar a la vista principal

        });

        registerButton.setOnAction(actionEvent -> {
            MainManagement.showView(mainApp, "RegisterView");
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

    @Override
    public void enviarDatos(Object o) {

    }

    @Override
    public Object recibirDatos() {
        return null;
    }


    private void setChoicheBox(){
        choiceBox.setItems(roleChoiceBox());
        choiceBox.setValue(roleChoiceBox().getFirst());
    }
}
