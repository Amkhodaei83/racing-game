package com.example.gta_vi;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class game extends PlayerManager  {
    private int  win ,  loss , gas, heart, durination , kill , score ;
    private boolean finished ;
    private String time_started ;

    public game(String win, String loss, String gass, String herts, String durination, String kill, String score, String finished, String time_started) {
        this.win = Integer.parseInt(win);
        this.loss = Integer.parseInt(loss);
        this.gas = Integer.parseInt(gass);
        this.heart = Integer.parseInt(herts);
        this.durination = Integer.parseInt(durination);
        this.kill = Integer.parseInt(kill);
        this.score = Integer.parseInt(score);
        this.finished = Boolean.parseBoolean(finished);
        this.time_started = time_started;
    }

    public game() {
        this.time_started = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        win = 0 ;
        loss = 0 ;
        finished = false ;
        gas = 20 ;
        heart = 10 ;
        durination = 0 ;
        kill = 0 ;
        score = 0 ;
    }

    public void setWin(){
        this.win = 1 ;
    }

    public void setDurination() {
        LocalTime startTime = LocalTime.parse(this.time_started, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime currentTime = LocalTime.now();

        Duration duration = Duration.between(startTime, currentTime);

        long millis = duration.toMillis();

        this.durination = (int) millis;
        System.out.println(millis);
    }

    public int getdurination(){
        return this.durination;
    }

    public void finished(){
        this.finished = true ;
    }
    public void addscore(int x ){
        this.score+= x ;
    }

    public void hertmm(){
        this.heart--;
        this.score-=30;
    }
    public void heartpp(){
        this.heart++;
        this.score+=100;
    }
    public void gaspp(){
        this.gas+=5;
        this.score+=100;
    }
    public String getTime_started() {
        return time_started;
    }

    public void setTime_started(String time_started) {
        this.time_started = time_started;
    }
    public void gasmm(){
        this.gas--;
    }
    public void killed(){
        this.kill++;
        this.score+=400;
    }
    public void itemscore(){
        this.score+=200;
    }

    public int getScore() {
        return score;
    }

    public int getWin() {
        return win;
    }
    public String getGameCondition() {
        if (this.getFinished()){
            if (this.win == 1) {
                return "Victory";
            } else {
                return "Death";
            }
        } else{
            return "In Progress";
    }}
    public int getLoss() {
        return loss;
    }

    public int getKill() {
        return kill;
    }

    public boolean getFinished() {
        return finished;
    }

    public int getGas() {
        return gas;
    }

    public int getHeart() {
        return heart;
    }

    public int getDurination() {
        return this.durination;
    }
    public int getDuration() {
        return this.durination;
    }



}
