package com.n4mbot.master.chats.alexa;

import com.n4mbot.master.home.HomeApplication;
//import com.n4mbot.service.DetectIntentTexts;
import com.n4mbot.service.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.util.UUID;



import java.io.IOException;
import java.net.URL;



public class AlexaController {

    @FXML
    private Button goBack;
    @FXML
    private TextField messgaeTextField;
    @FXML
    private VBox clientVBox;
    @FXML
    private VBox robotVBox;

    private Main main = new Main();
    static  int i;

    public void goBackOnAction(ActionEvent event) {
        showButton(goBack, HomeApplication.class.getResource("home.fxml"));
    }


    public void send2() throws IOException {
        String message = messgaeTextField.getText();
        if (!message.isEmpty()) {
            clientVBox.getChildren().add(addLebelToVBoxClient(message));
            messgaeTextField.clear();
            robotVBox.getChildren().add(addLebelToVBoxRobot(main.send(message, main.bot)));
        }
    }

    private Label addLebelToVBoxClient(String message){
        Label label = new Label();
        label.setText(message);
        label.setPadding(new Insets(20,0,0, 0));
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setLayoutX(256.0);
        label.setLayoutY(67.0);
        label.setPrefHeight(30.0);
        label.setPrefWidth(347.0);
        label.setFont(Font.font("System", FontPosture.findByName("BOLD"),14));
        label.setTextFill(Paint.valueOf("WHITE"));
        label.setStyle("-fx-background-radius: 20px" + ";-fx-background-color: Transparent");
        return label;
    }

    private Label addLebelToVBoxRobot(String message){
        Label label = new Label();
        label.setText(message);
        label.setPadding(new Insets(20,0,0, 0));
        label.setAlignment(Pos.CENTER_LEFT);
        label.setLayoutX(256.0);
        label.setLayoutY(67.0);
        label.setPrefHeight(30.0);
        label.setPrefWidth(347.0);
        label.setFont(Font.font("System", FontPosture.findByName("BOLD"),14));
        label.setTextFill(Paint.valueOf("WHITE"));
        label.setStyle("-fx-background-radius: 20px" + ";-fx-background-color: Transparent");
        return label;
    }

    private void showButton(Button button, URL url){
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