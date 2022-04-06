package com.n4mbot.master.home;

import com.n4mbot.master.chats.alexa.AlexaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

public class HomeController {

    @FXML
    private Button closeButton;
    @FXML
    private Button alexa;
    @FXML
    private Button alexaHome;

    public void showAlexa(ActionEvent event) {
        showButtonOnAction(alexa, AlexaApplication.class.getResource("alexa.fxml"));
    }

    public void showAlexaHome(ActionEvent event) {
        showButtonOnAction(alexaHome, AlexaApplication.class.getResource("alexa.fxml"));
    }

    public void closeHomeOnAcion(ActionEvent e){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

        private void showButtonOnAction(Button button, URL url){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(url);
                Scene scene = new Scene(fxmlLoader.load());
                Stage primaryStage = new Stage();
                primaryStage.setTitle("N4MBot");
                primaryStage.initStyle(StageStyle.UNDECORATED);
                primaryStage.setScene(scene);
                primaryStage.show();
                Stage stage = (Stage) button.getScene().getWindow();
                stage.close();
            } catch (Exception ed) {
                ed.printStackTrace();
            }
        }
}

