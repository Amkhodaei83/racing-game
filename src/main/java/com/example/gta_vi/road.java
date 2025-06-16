package com.example.gta_vi;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class road extends screenobject {

    private final int speed;

    public road(int x, int y, Image img , int speed) {
        super(x, y, img);
        this.speed = speed ;

        final Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline.setAutoReverse(true);
        KeyValue keyValue = new KeyValue(this.translateYProperty(), 15208);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(speed), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

}
