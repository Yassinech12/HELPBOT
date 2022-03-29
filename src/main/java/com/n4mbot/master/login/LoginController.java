package com.n4mbot.master.login;

import com.n4mbot.dao.DataBaseConnection;
import com.n4mbot.master.home.HomeApplication;
import com.n4mbot.master.register.RegisterApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.ResultSet;

public class LoginController {

    @FXML
    private Button login_sIncrireButton;
    @FXML
    private Button login_quitterButton;
    @FXML
    private TextField login_usernameTextField;
    @FXML
    private PasswordField login_passwordPasswordField;
    @FXML
    private Label login_messageLabel;
    @FXML
    private Label login_seConnecterButton;


    public void login_seConnecterButtonOnAction(ActionEvent e) {
        if (login_usernameTextField.getText().isBlank() == false && login_passwordPasswordField.getText().isBlank() == false) {
            validateLogin();
        } else {
            login_messageLabel.setText("Entrer votre nom d'utilisateur et mot de passe");
        }
    }

    @FXML
    public void login_quitterButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) login_quitterButton.getScene().getWindow();
        stage.close();
    }

    DataBaseConnection connectnow = new DataBaseConnection();

    @FXML
    public void validateLogin() {
        String username = login_usernameTextField.getText();
        String password = login_passwordPasswordField.getText();
        String verifyLogin = "SELECT count(1) from accounts where username = '" + login_usernameTextField.getText() + "' and password = '" + login_passwordPasswordField.getText() + "' ";
        try {
            ResultSet queryResult = connectnow.stm.executeQuery(verifyLogin);
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    login_messageLabel.setText("Bienvenue!");
                    afficherHome();
                } else {
                    login_messageLabel.setText("Nom d'utilisateur ou mot de passe incorrect.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afficherHome() {
        show(HomeApplication.class.getResource("Home.fxml"));
    }

    public void afficherCommencer(ActionEvent e) {
        showPerButton(login_sIncrireButton, RegisterApplication.class.getResource("register.fxml"));
    }

    private void showPerButton(Button button, URL url) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Stage primaryStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            primaryStage.setTitle("4MNBot");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void show(URL url) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Stage primaryStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            primaryStage.setTitle("4MNBot");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
} ////// FIN DE LA CLASSE LoginController
