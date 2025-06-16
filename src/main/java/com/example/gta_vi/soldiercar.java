package com.example.gta_vi;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class soldiercar extends screenobject {
    static List<ImageView> list = new ArrayList<>() ;
    private final int speed;
    Timeline timeline2;
    Timeline timeline;

    public soldiercar(int x, Image img , int speed ,Pane pane ) {

        super(x, -150 , img);
        this.speed= speed;
        timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        KeyValue keyValue = new KeyValue(this.translateYProperty(), 1200);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(speed), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        list.add(this);
        timeline2 = new Timeline(new KeyFrame(Duration.millis(50),actionEvent -> {
            if (list.contains(this)){
            if (Math.random()*250<20){
            this.shoot(1200 , pane );
            }}
        }));
        timeline2.setCycleCount(-1);
        timeline2.play();
    }
    public static List<ImageView> getList() {
        return (List<ImageView>) (list) ;
    }
    public void shoot (int speed , Pane pane ){


        double currentX = this.getLayoutX() + this.getTranslateX();
        double currentY = this.getLayoutY() + this.getTranslateY();

        soldierfireball pl = new soldierfireball((int)currentX+10 , (int)currentY+100, new Image(getClass().getResourceAsStream("images/enemy_fire_ball.gif")), speed );
        pl.shootupleft(pane);


        soldierfireball pl1 = new soldierfireball((int)currentX+10 , (int)currentY+100, new Image(getClass().getResourceAsStream("images/enemy_fire_ball.gif")), speed );
        pl1.shootupright(pane);

//        soldierfireball pl2 = new soldierfireball((int)currentX+10 , (int)currentY+100, new Image(getClass().getResourceAsStream("images/enemy_fire_ball.gif")), speed );
//        pl2.shootdownleft(pane);

//        soldierfireball pl3 = new soldierfireball((int)currentX+10 , (int)currentY+100, new Image(getClass().getResourceAsStream("images/enemy_fire_ball.gif")), speed );
//        pl3.shootdownright(pane);

    }


    public void garbage(Pane pane){

        Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(this.speed), b -> {
            pane.getChildren().remove(this);
            list.remove(this);
            this.timeline2.stop();
            this.timeline.stop();
            this.timeline.getKeyFrames().clear();
            this.timeline = null;
            this.timeline2 = null;
        }));
        timeline3.setCycleCount(1);
        timeline3.setAutoReverse(false);
        timeline3.play();

    }
}
