package com.vicente.vmotion.ControllerViews;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {
    @FXML
    private BorderPane mainPane;

    public void setCenterContent(String fxml){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Node node = loader.load();
            mainPane.setCenter(node);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
