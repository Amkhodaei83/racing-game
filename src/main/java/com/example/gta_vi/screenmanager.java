package com.example.gta_vi;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.List;

public class screenmanager{

    int cooldown=0 ;
    boolean end = false ;
    Pane pane1 = new Pane();
    Pane pane2 = new Pane();
    Pane pane3 = new Pane();
    int safe = 20 ;
    @FXML
    Pane pane ;
    @FXML
    Label scoreB;
    @FXML
    ProgressBar gasBar , heartBar ;

    @FXML
    public void initialize(){
        pane3.getChildren().add(gasBar);
        pane3.getChildren().add(heartBar);
        pane3.getChildren().add(scoreB);

        game game = new game();
        PlayerManager.getCorrentplayer().setGame(game);
        generator generator = new generator(pane2) ;
        System.out.println(gas.getList());


        Image image = new Image(getClass().getResourceAsStream("images/map/map (1).png"));
        road first = new road(0 , -15208+960 , image , 50000 );
        first.addtopane(pane1);

        Timeline finish = new Timeline(new KeyFrame(new Duration(47000),actionEvent -> { //47000
            if (!end) {
                game.setWin();
                game.setDurination();
                game.finished();
                game.addscore(2500);
                Stage newStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("finish.fxml"));
                Scene newScene;
                PlayerManager.write();
                end =true ;
                try {
                    newScene = new Scene(fxmlLoader.load(), 600, 200);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                newStage.setTitle("score");
                newStage.setScene(newScene);
                newStage.show();


                Stage currentStage = (Stage) pane.getScene().getWindow();
                currentStage.close();
            }}));
        finish.setCycleCount(1);
        finish.play();



        playercar mainplayer = new playercar(new Image(getClass().getResourceAsStream("images/cars/player ("+((int)(Math.random()*3+1))+").png")), "1");
        mainplayer.addtopane(pane2);

        Timeline genaratar = new Timeline(new KeyFrame(new Duration(200), actionEvent -> {
            generator.start( 50  );
        }));
        genaratar.setCycleCount(-1);
        genaratar.play();


        Timeline panerequest = new Timeline(new KeyFrame(new Duration(1),actionEvent -> {
            pane.requestFocus();
        }));
        panerequest.setCycleCount(-1);
        panerequest.play();

        Timeline gasconter = new Timeline(new KeyFrame(new Duration(1000),actionEvent -> {
            game.gasmm();
        }));
        gasconter.setCycleCount(-1);
        gasconter.play();
        Timeline gasconter1 = new Timeline(new KeyFrame(new Duration(1400),actionEvent -> {
            game.gasmm();
        }));
        gasconter1.setCycleCount(-1);
        gasconter1.play();
        pane.setOnMouseClicked(event -> {
            if (cooldown>5){
                game.addscore(-10);
                cooldown=0;
                mainplayer.shoot(5000 , pane2 );
            }

        });
Timeline untochable = new Timeline(new KeyFrame(new Duration(100),actionEvent -> {
    safe--;
}));
untochable.setCycleCount(-1);
untochable.play();



        pane.setOnScroll(event -> {




            System.out.println("speed");




        });

        pane.setOnKeyPressed(keyEvent -> {

            if(keyEvent.getCode()== KeyCode.A){
                mainplayer.moovetoleft();
            }

            else if(keyEvent.getCode()== KeyCode.D){
                mainplayer.moovetowrite();

            }
        });
        Timeline panerequest1 = new Timeline(new KeyFrame(new Duration(100),actionEvent -> {



            game.addscore(17);
            cooldown++ ;
        }));
        panerequest1.setCycleCount(-1);
        panerequest1.play();

        pane.getChildren().add(pane1);
        pane.getChildren().add(pane2);
        pane.getChildren().add(pane3);

        Timeline checker =  new Timeline(new KeyFrame(new Duration(1), actionEvent -> {
            scoreB.setText(String.valueOf(game.getScore()));
            gasBar.setProgress(game.getGas()/20.0);
            heartBar.setProgress(game.getHeart()/10.0);




            if (checkConflict((List<ImageView>) normalcar.getList() , (ImageView) mainplayer )){
                if (safe<0)
                game.hertmm();
            }
            if (checkConflict((List<ImageView>) terroristcar.getList() , (ImageView) mainplayer )){
                if (safe<0){
                game.hertmm();
                game.hertmm();
                game.hertmm();}
            }
            if (checkConflict((List<ImageView>) soldiercar.getList() , (ImageView) mainplayer )){
                if (safe<0) {
                    game.hertmm();
                    game.hertmm();
                }
            }
            if (checkConflict((List<ImageView>) gas.getList() , (ImageView) mainplayer )){
                if (game.getGas()<20) {

                    game.gaspp();

                }else{
                    game.itemscore();
                }
            }
            if (checkConflict((List<ImageView>) heart.getList() , (ImageView) mainplayer )){
                if (game.getHeart()<=10) {
                    game.heartpp();
                }else{
                    game.itemscore();
                }
            }
            if (checkConflict((List<ImageView>) speed.getList() , (ImageView) mainplayer )){
                game.addscore(33);
                
            }
            if (checkConflict((List<ImageView>) power.getList() , (ImageView) mainplayer )){
                game.addscore(57);
                safe=20;
            }
            if (checkConflict((List<ImageView>) terroristbomb.getList() , (ImageView) mainplayer )){
                if (safe<0){
                game.hertmm();game.hertmm();
            }}
            if (checkConflict((List<ImageView>) soldierfireball.getList() , (ImageView) mainplayer )){
                if (safe<0){  game.hertmm();
            }}
            if (checkConflictfire((List<ImageView>) soldiercar.getList() , (List<ImageView>) playerfireball.getList() )){
                game.killed();
            }
            if (checkConflictfire((List<ImageView>) terroristcar.getList() , (List<ImageView>) playerfireball.getList() )){

                game.killed();
            }
            if (checkConflictfire((List<ImageView>) normalcar.getList() , (List<ImageView>) playerfireball.getList() )){
                game.killed();
            }
            if (game.getHeart()<=0&&!end){
                end=true;
                game.setDurination();
                game.finished();
                Stage newStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("finish.fxml"));
                Scene newScene;
                PlayerManager.write();
                try {
                    newScene = new Scene(fxmlLoader.load(), 600, 200);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                newStage.setTitle("score");
                newStage.setScene(newScene);
                newStage.show();


                Stage currentStage = (Stage) pane.getScene().getWindow();
                currentStage.close();
            }
            if (game.getGas()<=0&&!end){
                end=true;
                game.finished();
                game.setDurination();
                Stage newStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("finish.fxml"));
                Scene newScene;
                PlayerManager.write();
                try {
                    newScene = new Scene(fxmlLoader.load(), 600, 200);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                newStage.setTitle("score");
                newStage.setScene(newScene);
                newStage.show();


                Stage currentStage = (Stage) pane.getScene().getWindow();
                currentStage.close();
            }



        }));
        checker.setCycleCount(-1);
        checker.play();
        Timeline killer =  new Timeline(new KeyFrame(new Duration(1), actionEvent -> {
            if (end){
                checker.stop();
                panerequest1.stop();
                gasconter.stop();
                panerequest.stop();
                genaratar.stop();
                finish.stop();
            }
        }));
        killer.setCycleCount(-1);
        killer.play();
    }

    private Boolean checkConflict(List<ImageView> list  , ImageView  y ) {

            for (ImageView x : list) {
                if (x.getBoundsInParent().intersects(y.getBoundsInParent())){
                    pane2.getChildren().remove(x);
                    list.remove(x);

                    return true;
                }
            }return false ;
    }

    private Boolean checkConflictfire(List<ImageView> list  , List<ImageView> list2 ) {
    for (ImageView y : list2){
            for (ImageView x : list) {
                if (x.getBoundsInParent().intersects(y.getBoundsInParent())){

                    if (x.getClass().equals(terroristcar.class)){
                        ((terroristcar) x).shoot(1900 , pane2);
                    }
                    pane2.getChildren().remove(x);
                    pane2.getChildren().remove(y);
                    list2.remove(y);
                    list.remove(x);
                    return true;
                }
            }
        }
    return false ;
    }
}
