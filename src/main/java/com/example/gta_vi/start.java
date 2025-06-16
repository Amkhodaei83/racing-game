package com.example.gta_vi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class start {
    static boolean end = true ;
    @FXML
    Button login , signin ;
    @FXML
    TextField username , password ;
    @FXML
    Pane pane ;
    @FXML
    Label label;
    @FXML
    public void initialize(){
        if (end){
            end = false ;
        PlayerManager.read();
        }
        login.setOnMouseClicked(event -> {
        if (PlayerManager.logincheck(username.getText(),password.getText())){
            Stage newStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menu.fxml"));
            Scene newScene;
            try {
                newScene = new Scene(fxmlLoader.load(), 540, 960);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            newStage.setTitle("welcom to gta VI");
            newStage.setScene(newScene);
            newStage.show();
            Stage currentStage = (Stage) pane.getScene().getWindow();
            currentStage.close();
        }else{
            System.out.println(PlayerManager.login(username.getText(),password.getText()));
            label.setText(PlayerManager.login(username.getText(),password.getText()));
        }});
        signin.setOnMouseClicked(event -> {
            Stage newStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("new_player.fxml"));
            Scene newScene;
            try {
                newScene = new Scene(fxmlLoader.load(), 540, 540);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            newStage.setTitle("sign up menu");
            newStage.setScene(newScene);
            newStage.show();


            Stage currentStage = (Stage) pane.getScene().getWindow();
            currentStage.close();
        });

    }
}
