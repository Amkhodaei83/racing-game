package com.example.gta_vi;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class menucontroller {
    Pane backgroundPane = new Pane();
    Pane upergroundPane = new Pane();
    int wallpaperi=0 ;
    private static final String[] wallapers = {"images/wallpapers/menu_wallpaper(1).gif" , "images/wallpapers/menu_wallpaper(2).gif" , "images/wallpapers/menu_wallpaper(3).gif" , "images/wallpapers/menu_wallpaper(4).gif" , "images/wallpapers/menu_wallpaper(5).gif" };
    private static final List<Image> preloadedWallpapers = new ArrayList<>();

    static {
        for (String wallpaperPath : wallapers) {
            preloadedWallpapers.add(new Image(menucontroller.class.getResourceAsStream(wallpaperPath)));
        }
    }
    Image wallpaper;
    private Timeline rainTimeline;
    private Clip backgroundMusicClip;
    @FXML
    Pane pane ;
    @FXML
    Button START , changeplayer ,  scores ,  newplayer , next;
    @FXML
    Label player_name ;
    @FXML
    public void initialize() {
        player_name.setText("Hello "+(PlayerManager.getCorrentplayer().getName())+", welcome to GTA VI.");
        sound();

        wallpaper = preloadedWallpapers.get(wallpaperi);

        BackgroundImage backgroundImage=new BackgroundImage(wallpaper, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1.0, 1.0, true, true, false, true));
        Background background = new Background(backgroundImage);
        pane.setBackground(background);



        pane.getChildren().add(backgroundPane);


        Image rain = new Image(getClass().getResourceAsStream("images/Rain_drop.png"));
        rainTimeline = new Timeline(new KeyFrame(Duration.millis(30), e -> {
            int gol = (int) (Math.random()*10)+2;
            for (int i = 0 ; i < gol ; i++) {
                        double rand = Math.random();
                        int x_pose = (int) (Math.random() * 1200);

                        ImageView imageView = new ImageView(rain);
                        imageView.setX(x_pose);
                        imageView.setY(0);
                        imageView.setFitHeight(73*rand+36);
                        imageView.setFitWidth(41*rand+20);

                        final Timeline timeline1 = new Timeline();
                        timeline1.setCycleCount(1);
                        timeline1.setAutoReverse(false);
                        final KeyValue kv1 = new KeyValue(imageView.yProperty(), 980 );
                        final KeyValue kv2 = new KeyValue(imageView.xProperty(), x_pose-200 );
                        final KeyFrame kf1 = new KeyFrame(Duration.millis(Math.random()*400+400), kv1 , kv2);
                        timeline1.getKeyFrames().add(kf1);
                        timeline1.play();


                        backgroundPane.getChildren().add(imageView);

                        Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(800), b -> {
                            backgroundPane.getChildren().remove(imageView);
                        }));
                        timeline3.setCycleCount(1);
                        timeline3.play();
                    }
                    pane.requestFocus();
                }));
        rainTimeline.setCycleCount(Timeline.INDEFINITE);
        rainTimeline.play();

        // Stop rain animation when the scene is closed
        pane.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene == null && oldScene != null) {
                if (rainTimeline != null) {
                    rainTimeline.stop();
                }
                // Stop and close the background music clip when the scene is unloaded
                if (backgroundMusicClip != null && backgroundMusicClip.isRunning()) {
                    backgroundMusicClip.stop();
                    backgroundMusicClip.close();
                }
            }
        });

        final Rectangle rect1 = new Rectangle(0, 0, 540, 980);
        upergroundPane.getChildren().addAll(START, changeplayer , scores ,newplayer , next );
        pane.getChildren().add(upergroundPane);

        START.setOnMouseClicked(event -> {
            Stage stage = new Stage() ;
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("game.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 540, 960);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("choos_acunt");
            stage.setScene(scene);
            stage.show();
            Stage currentStage = (Stage) pane.getScene().getWindow();
            currentStage.close();
//            lightning();
        });



        changeplayer.setOnMouseClicked(event -> {
            Stage stage = new Stage() ;
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("loginpage.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 300, 150);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("welcom_to_gta6");
            stage.setScene(scene);
            stage.show();
//            lightning();
            Stage currentStage = (Stage) pane.getScene().getWindow();
            currentStage.close();
        });
        scores.setOnMouseClicked(event -> {
            Stage stage = new Stage() ;
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("score_table.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 540, 540);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("choos_acunt");
            stage.setScene(scene);
            stage.show();
//            lightning();
        });
        newplayer.setOnMouseClicked(event -> {
            Stage stage = new Stage() ;
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("new_player.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 540, 540);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("choos_acunt");
            stage.setScene(scene);
            stage.show();
//            lightning();
        });

        pane.setOnMouseClicked(event -> {lightning();});


        next.setOnMouseClicked(event -> {
            wallpaperi++;
            if (wallpaperi>4){
                wallpaperi=0;
            }
            pane.getBackground().getImages().remove(wallpaper);
            wallpaper = preloadedWallpapers.get(wallpaperi);
            BackgroundImage backgroundImag=new BackgroundImage(wallpaper, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1.0, 1.0, true, true, false, true));
            Background backgroun = new Background(backgroundImag);
            pane.setBackground(backgroun);
        });

    }

    public void lightning(){
        final Rectangle rect1 = new Rectangle(0, 0, 540, 980);
        rect1.setFill(Color.WHITE);
        backgroundPane.getChildren().add(rect1);
        FadeTransition ft = new FadeTransition(Duration.millis(100), rect1);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(2);
        ft.setAutoReverse(false);
        ft.play();
        pane.setOnMouseReleased(event ->{
            pane.getChildren().remove(rect1);
            pane.requestFocus();
        } );
    }

    public void sound() {
        try (InputStream audioSrc = getClass().getResourceAsStream("/com/example/gta_vi/audioSrc.wav");
             InputStream bufferedIn = new BufferedInputStream(audioSrc);
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn)) {
            backgroundMusicClip = AudioSystem.getClip();
            backgroundMusicClip.open(audioStream);
            backgroundMusicClip.start();
            backgroundMusicClip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    backgroundMusicClip.close();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}