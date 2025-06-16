package com.example.gta_vi;

import java.util.ArrayList;
import java.util.List;

public class player extends PlayerManager {
    private String name , passsword , time  , nationalID ;
    private String lastlogin = null ;
    private int ID ;
    private static int i = 1 ;
    private List<game> allgames = new ArrayList<>() ;

    public String getPasssword() {
        return passsword;
    }

    public String getLastlogin() {
        return lastlogin;
    }

    public int getID() {
        return ID;
    }

    public player( String ID, String lastlogin, String nationalID, String time, String passsword, String name) {
        this.ID = Integer.parseInt(ID);
        this.lastlogin = lastlogin;
        this.nationalID = nationalID;
        this.time = time;
        this.passsword = passsword;
        this.name = name;
        i++;
    }

    public player(String name, String passsword, String ID, String time , int age) {

        this.name = name;
        this.passsword = passsword;
        this.nationalID = ID;
        this.time = time;
        this.ID = i++;
        this.lastlogin = time;

        PlayerManager.setAllplayers(this);

        System.out.println("player created");
    }

    public void setGame(game game )
    {
        allgames.add(game) ;
    }

    public void setAllgames(List<game> allgames) {
        this.allgames = allgames;
    }

    public List<game> getAllgames() {
        return allgames;
    }



    public int findhighscore(){
        int high = Integer.MIN_VALUE ;
        for (int i= 0 ; i < this.getAllgames().size() ; i++ ){
            for (game g : this.getAllgames() ){
                if (high < g.getScore()){
                    high=g.getScore();
                }
            }
        }
        return high ;
    }

    public static boolean is_taken(String name )
    {
        for (player p : getAllplayers() )
        {

            if (p.getName().equals(name))
            {
                return true ;
            }

        }
        return false ;
    }

    public String getName()
    {
        return name;
    }

    public static boolean valuecheck_name(String name  )
    {
        if (name.startsWith("1")||name.startsWith("2")||name.startsWith("3")||name.startsWith("4")||name.startsWith("5")||name.startsWith("6")||name.startsWith("7")||name.startsWith("8")||name.startsWith("9")||name.startsWith("0"))
        {
            return false ;
        }
        else if (name.isEmpty())
        {
            return false ;
        }
        else return !is_taken(name);
    }

    public static boolean valuecheck_nationalID(String IDnational ){

        return ((IDnational.length()) >= (10));

    }
    public static boolean valuecheck_password(String passsword ){
        if (passsword.length()<8)
        {return false;}
        return true;
    }
    public static boolean valuecheck_email( String email ){
        if (email.contains("@")&&email.contains(".")){
            return true ;
        }
        return false ;
    }



    public String getTime() {
        return time;
    }

    public String getNationalID() {
        return nationalID;
    }

}
