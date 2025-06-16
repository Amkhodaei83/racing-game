package com.example.gta_vi;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class screenobject extends ImageView {
    public screenobject(int x , int y  , Image img ){
        setLayoutX(x);
        setLayoutY(y);
        setImage(img);
    }
    public void addtopane(Pane pane){
        pane.getChildren().add(this);

    }


    public void removefromepane(Pane pane){
        pane.getChildren().remove(this);
    }

}
