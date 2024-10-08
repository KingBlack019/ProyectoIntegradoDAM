package com.vicente.vmotion.ControllerViews;

import com.vicente.vmotion.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainViewController {

    @FXML
    private Button logoutButton;

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void initialize() {
        logoutButton.setOnAction(e -> handleLogout());
    }

    private void handleLogout() {
        mainApp.showView("LoginView"); // Regresar a la vista de login
    }
}
