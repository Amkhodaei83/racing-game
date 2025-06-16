package com.example.gta_vi;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class playercar extends screenobject{
    private final String name;
    int locationx , locationy ;

    public playercar( Image img , String ID) {
        super(260, 960-150 , img);
        this.name = ID;
        this.locationx=260;
        this.locationy=810;
    }

    public int getLocationx() {
        return locationx;
    }

    public void setLocationx(int locationx) {
        this.locationx = locationx;
    }

    public int getLocationy() {
        return locationy;
    }

    public void setLocationy(int locationy) {
        this.locationy = locationy;
    }

    public void moovetowrite() {
        if (this.getLocationx()<270) {
            Timeline timeline = new Timeline();
            timeline.setCycleCount(1);
            timeline.setAutoReverse(true);
            KeyValue keyValue = new KeyValue(this.translateXProperty(), this.getX() + 75);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(200), keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
            this.setLocationx(345);
        }
    }

    public void moovetoleft() {
        if (this.getLocationx()>270) {
            Timeline timeline = new Timeline();
            timeline.setCycleCount(1);
            timeline.setAutoReverse(false);
            KeyValue keyValue = new KeyValue(this.translateXProperty(), this.getX() - 75);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(200), keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
            this.setLocationx(195);
        }
    }

    public void shoot (int speed , Pane pane ){

        int x ;

        if (this.getLocationx()<270){
            x=195;
        }else {
            x=345;
        }

       playerfireball pl =  new playerfireball( x+5 , new  Image(getClass().getResourceAsStream("images/player_fire_ball.gif" )), speed );
        pl.addtopane(pane);
        pl.garbage(pane , speed );

    }

    public void speed(){

    }
    public void power(){

    }
    public void hert(){

    }
    public void bomb(){

    }
    public void gass(){

    }
    public void damaged(){

    }


}
