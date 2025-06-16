package com.example.gta_vi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class new_player {
    @FXML
    Pane pane ;
    @FXML
    Spinner age;
    @FXML
    TextField username , email ,national , password ;
    @FXML
    Button save ;
    @FXML
    Label lableemail , lablenationalcode , lablepassword , lableusername  ;

    @FXML
    public void initialize(){
        age.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1 , 99 , 1 ,1 ));
        save.setOnMouseClicked(event -> {

            lableusername.setText("");
            lablepassword.setText("");
            lablenationalcode.setText("");
            lableemail.setText("");

            if (player.valuecheck_name(username.getText())){
                if (player.valuecheck_password(password.getText())){
                    if (player.valuecheck_nationalID(national.getText())){
                        if(player.valuecheck_email(email.getText())){
                            player player = new player (
                                    username.getText(),
                                    password.getText(),
                                    national.getText(),
                                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) ,
                                    (Integer) age.getValue()
                            );

                            Stage newStage = new Stage();
                            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("loginpage.fxml"));
                            Scene newScene;
                            try {
                                newScene = new Scene(fxmlLoader.load(), 300, 150);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            newStage.setTitle("login page");
                            newStage.setScene(newScene);
                            newStage.show();

                            Stage currentStage = (Stage) pane.getScene().getWindow();
                            currentStage.close();


                        }
                        else {
                            lableemail.setText("email dosent contain (@ and .) ! ");
                        }
                    }
                    else {
                        lablenationalcode.setText("ID is shorter than 10 char !");
                    }
                }
                else {
                    lablepassword.setText("password is shorter than 8 char !");
                }
            }
            else {
                lableusername.setText("username is invalid or is taken !");
            }
        });
    }
}
