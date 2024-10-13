package com.vicente.vmotion.ControllerViews;

import com.vicente.vmotion.Main;
import com.vicente.vmotion.Management.ControllerViewInterface;
import javafx.scene.control.Button;

public class SettingsViewController implements ControllerViewInterface {
    public Button buttonUser;

    private Main mainApp;

    @Override
    public void setMainApp(Main app) {
        this.mainApp = app;
    }
}
