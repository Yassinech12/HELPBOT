package com.n4mbot.master.home;

import com.n4mbot.master.chats.alexa.AlexaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;
import org.controlsfx.glyphfont.FontAwesome;

public class HomeController {

    @FXML
    private Button closeButton;
    @FXML
    private Button alexa;
    @FXML
    private Button alexaHome;

    public void showAlexa(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AlexaApplication.class.getResource("alexa.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage primaryStage = new Stage();
            primaryStage.setTitle("N4MBot");
            primaryStage.setScene(scene);
            primaryStage.show();
            Stage stage = (Stage) alexa.getScene().getWindow();
            stage.close();

        } catch (Exception ed) {
            ed.printStackTrace();
        }
    }
    public void showAlexaHome(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AlexaApplication.class.getResource("alexa.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage primaryStage = new Stage();
            primaryStage.setTitle("N4MBot");
            primaryStage.setScene(scene);
            primaryStage.show();
            Stage stage = (Stage) alexaHome.getScene().getWindow();
            stage.close();

        } catch (Exception ed) {
            ed.printStackTrace();
        }
    }

        public void closeHomeOnAcion(ActionEvent e){
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
}

