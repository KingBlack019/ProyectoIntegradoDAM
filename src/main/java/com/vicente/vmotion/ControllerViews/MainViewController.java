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
    public Label rolLabel;
    @FXML
    public Button settingsButton;
    @FXML
    private Button logoutButton;

    private Main mainApp;

    private String username;
    private String userRol;

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

    @FXML
    public void initialize() {
        bienvenidoLabel.setText("Bienvenido " + username + "!");
        rolLabel.setText("Rol: " + userRol);

        buttonActions();


        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
    }

    @FXML
    private void buttonActions() {
        logoutButton.setOnAction(e -> MainManagement.showView(mainApp, "LoginView"));
        settingsButton.setOnAction(e -> MainManagement.showView(mainApp, "SettingsView"));
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserRol(String userRol) {
        this.userRol = userRol;
    }
}
