package com.vicente.vmotion;

import com.vicente.vmotion.ControllerViews.LoginViewController;
import com.vicente.vmotion.ControllerViews.MainManagement;
import com.vicente.vmotion.Management.ControllerViewInterface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.InputStreamReader;
import java.util.Objects;


public class Main extends Application {
    public BorderPane root;

    @Override
    public void start(Stage stage) throws IOException {
        if (MainManagement.connectServer()) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("Views/LoginView.fxml")));
            root = loader.load();
            Scene scene = new Scene(root, 1200, 800);

            LoginViewController loginViewController = loader.getController();
            loginViewController.setMainApp(this);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}