package com.vicente.vmotion.ControllerViews;

import com.vicente.vmotion.Main;
import com.vicente.vmotion.Management.ControllerViewInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainViewController implements ControllerViewInterface {

    public Button buttonUser;
    public Label bienvenidoLabel;
    @FXML
    private Button logoutButton;

    private Main mainApp;

    @Override
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void initialize() {
        bienvenidoLabel.setText("Bienvenido ");
        logoutButton.setOnAction(e -> cerrarSesion());
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
    }

    @FXML
    private void cerrarSesion() {
        mainApp.showView("LoginView"); // Regresar a la vista de login
    }


}
