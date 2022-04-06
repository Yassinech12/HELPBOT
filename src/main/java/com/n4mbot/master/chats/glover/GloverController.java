package com.n4mbot.master.chats.glover;

import com.n4mbot.master.home.HomeApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;


public class GloverController {

    @FXML
    private Button goBack;
    @FXML
    private TextField messgaeTextField;
    @FXML
    private VBox clientVBox;

    public void goBackOnAction(ActionEvent event) {
        showButton(goBack, HomeApplication.class.getResource("home.fxml"));
    }

    @FXML
    private void sendMessageOnAction(ActionEvent e) {
        String message = messgaeTextField.getText();
//        String messageRespense = null;
        if (!message.isEmpty()){
            clientVBox.getChildren().add(addLebelToVBox(message));
            messgaeTextField.clear();
//            try {
//                String uuid = UUID.randomUUID().toString();
//                messageRespense = DetectIntentTexts.detectIntentText("newagent-ntqm", message, uuid, "fr");
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//            if (messageRespense != null){
//                clientVBox.getChildren().add(addLebelToVBox(messageRespense));
//            }
        }
    }

    private Label addLebelToVBox(String message){
        Label label = new Label();
        label.setText(message);
        label.setPadding(new Insets(20,0,0, 30));
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setLayoutX(256.0);
        label.setLayoutY(94.0);
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