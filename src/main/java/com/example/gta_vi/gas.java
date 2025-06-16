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

public class gas extends screenobject {
    static List<ImageView> list = new ArrayList<>() ;

    int speed ;

    public gas(int x, Image img , int speed ) {
        super(x, -150 , img);
        this.speed= speed;
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        KeyValue keyValue = new KeyValue(this.translateYProperty(), 1200);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(speed), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        list.add(this);

    }

    public static List<ImageView> getList() {
        return (List<ImageView>) (list) ;
    }


    public static void setList(List<ImageView> list) {
        gas.list = list;
    }

    public void garbage(Pane pane){
        Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(this.speed), b -> {
            pane.getChildren().remove(this);
            list.remove(this);
        }));
        timeline3.setCycleCount(1);
        timeline3.setAutoReverse(false);
        timeline3.play();

    }
}
