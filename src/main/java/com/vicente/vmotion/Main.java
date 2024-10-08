package com.vicente.vmotion;

import com.vicente.vmotion.ControllerViews.LoginViewController;
import com.vicente.vmotion.ControllerViews.MainViewController;
import com.vicente.vmotion.Management.ControllerViewInterface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private BorderPane root;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("Views/LoginView.fxml")));
        root = loader.load();
        Scene scene = new Scene(root, 1200, 800);

        LoginViewController loginViewController = loader.getController();
        loginViewController.setMainApp(this);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void showView(String viewName) {
        try {
            System.out.println(getClass().getResource("Views/" + viewName + ".fxml"));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/" + viewName + ".fxml"));
            Parent view = loader.load();

            // Obtener el controlador y pasarle la referencia a la clase Main
            Object controller = loader.getController();
            ((ControllerViewInterface) controller).setMainApp(this);

            // Cambiar la vista al nuevo nodo
            root.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}