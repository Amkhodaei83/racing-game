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

public class terroristbomb extends screenobject{

    static List<ImageView> list = new ArrayList<>() ;
    private final int speed;
    Timeline timeline;

    public terroristbomb(int x, int y, Image img , int speed ) {
        super(x, y, img);
        this.speed= speed;
        timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);

        KeyValue keyValue = new KeyValue(this.translateYProperty(), 1000 );

        KeyFrame keyFrame = new KeyFrame(Duration.millis(speed), keyValue );
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        list.add(this);
    }
    public static List<ImageView> getList() {
        return (List<ImageView>) (list) ;
    }
    public void garbage(Pane pane , int speed){

        Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(speed), b -> {
            pane.getChildren().remove(this);
            list.remove(this);
            this.timeline.stop();
            this.timeline.getKeyFrames().clear();
            this.timeline = null;
        }));
        timeline3.setCycleCount(1);
        timeline3.setAutoReverse(false);
        timeline3.play();


    }
}
