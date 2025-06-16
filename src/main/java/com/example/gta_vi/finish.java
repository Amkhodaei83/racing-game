package com.example.gta_vi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class finish {

    @FXML
    Button start , menu ;
    @FXML
    Pane pane ;
    @FXML
    Label score ;

    @FXML
    public void initialize(){
        score.setText(String.valueOf(PlayerManager.getCorrentplayer().getAllgames().getLast().getScore()));
        start.setOnMouseClicked(event -> {

                Stage newStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
                Scene newScene;
                try {
                    newScene = new Scene( fxmlLoader.load() , 540 , 960 );
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                newStage.setTitle("login page");
                newStage.setScene(newScene);
                newStage.show();

                Stage currentStage = (Stage) pane.getScene().getWindow();
                currentStage.close();

            });
        menu.setOnMouseClicked(event -> {

                Stage newStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menu.fxml"));
                Scene newScene;
                try {
                    newScene = new Scene(fxmlLoader.load(), 540 , 960);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                newStage.setTitle("login page");
                newStage.setScene(newScene);
                newStage.show();

                Stage currentStage = (Stage) pane.getScene().getWindow();
                currentStage.close();

            });
    }
}
