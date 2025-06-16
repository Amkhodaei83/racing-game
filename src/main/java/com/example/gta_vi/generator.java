package com.example.gta_vi;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public  class generator {
    



static int[] location = {185,335};
private Pane pane;

    public generator(Pane pane2 ) {
        this.pane = pane2;
    }


    public void start( int speed){


        switch ((int) (Math.random()*10)){
            case 0:{
                Image im = new  Image(getClass().getResourceAsStream("images/cars/normal ("+((int)(Math.random()*7+1))+").png" ));
                normalcar normalcar = new normalcar( location[(int) (Math.random()*2)] , im , 1900 );
                normalcar.addtopane(this.pane);
                normalcar.garbage(this.pane);
                break;
            }
            case 1:{
                Image im = new  Image(getClass().getResourceAsStream("images/cars/soldier ("+((int)(Math.random()*7+1))+").png" ));
                soldiercar soldiercar = new soldiercar( location[(int) (Math.random()*2)] , im , 1900 , this.pane );
                soldiercar.addtopane(this.pane);
                soldiercar.garbage(this.pane);
                break;
            }
            case 2:{
                Image im = new  Image(getClass().getResourceAsStream("images/cars/terrorist ("+((int)(Math.random()*5+1))+").png" ));
                terroristcar terroristcar = new terroristcar( location[(int) (Math.random()*2)] , im , 1900 );
                terroristcar.addtopane(this.pane);
                terroristcar.garbage(this.pane);
                break;
            }
            case 3:{
                Image im = new  Image(getClass().getResourceAsStream("images/speed.png" ));
                speed speed1 = new speed( location[(int) (Math.random()*2)] , im , 1900 );
                speed1.addtopane(this.pane);
                speed1.garbage(this.pane);
                break;
            }case 4:{
                Image im = new  Image(getClass().getResourceAsStream("images/power.png" ));
                power power = new power( location[(int) (Math.random()*2)] , im , 1900 );
                power.addtopane(this.pane);
                power.garbage(this.pane);
                break;
            }case 5:{
                Image im = new  Image(getClass().getResourceAsStream("images/gas.png" ));
                gas gas = new gas( location[(int) (Math.random()*2)] , im , 1900 );
                gas.addtopane(this.pane);
                gas.garbage(this.pane);
                break;
            }case 6:{
                Image im = new  Image(getClass().getResourceAsStream("images/heart.gif" ));
                heart heart = new heart( location[(int) (Math.random()*2)] , im , 1900 );
                heart.addtopane(this.pane);
                heart.garbage(this.pane);
                break;
            }
            case 7:{
                                                                       //coin
                break;
            }
            default:{
                break;
            }
        }




    }
}
