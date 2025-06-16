package com.example.gta_vi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerManager {
    private static List<player> allplayers = new ArrayList<>();


    public static player correntplayer;


    public static void read() {
        File playersFile = new File("players.txt");
        try (Scanner scanner = new Scanner(playersFile)) {
            while (scanner.hasNextLine()) {
                player player = new player(
                        scanner.nextLine(), // ID
                        scanner.nextLine(), // Last login
                        scanner.nextLine(), // National ID
                        scanner.nextLine(), // Time
                        scanner.nextLine(), // Password
                        scanner.nextLine()  // Name
                );
                allplayers.add(player);
                List<game> allgames = new ArrayList<>();
                File gameFile = new File("game_player" + player.getID() + ".txt");
                try (Scanner scannergame = new Scanner(gameFile)) {
                    while (scannergame.hasNextLine()) {
                        game game = new game(
                                scannergame.nextLine(), // Win
                                scannergame.nextLine(), // Loss
                                scannergame.nextLine(), // Gas
                                scannergame.nextLine(), // Heart
                                scannergame.nextLine(), // Durination
                                scannergame.nextLine(), // Kill
                                scannergame.nextLine(), // Score
                                scannergame.nextLine(), // Finished
                                scannergame.nextLine()  // Time started
                        );
                        allgames.add(game);
                    }
                }
                player.setAllgames(allgames);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void write() {
        try (PrintWriter fileWriter = new PrintWriter("players.txt")) {
            for (player p : allplayers) {
                fileWriter.println(p.getID());
                fileWriter.println(p.getLastlogin());
                fileWriter.println(p.getNationalID());
                fileWriter.println(p.getTime());
                fileWriter.println(p.getPasssword());
                fileWriter.println(p.getName());

                try (PrintWriter fileWritergame = new PrintWriter("game_player" + p.getID() + ".txt")) {
                    for (game g : p.getAllgames()) {
                        fileWritergame.println(g.getWin());
                        fileWritergame.println(g.getLoss());
                        fileWritergame.println(g.getGas());
                        fileWritergame.println(g.getHeart());
                        fileWritergame.println(g.getDurination());
                        fileWritergame.println(g.getKill());
                        fileWritergame.println(g.getScore());
                        fileWritergame.println(g.getFinished());
                        fileWritergame.println(g.getTime_started());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static player getCorrentplayer() {
        return correntplayer;
    }
    public static boolean logincheck(String text, String text1) {

        for (player a : allplayers){
            if (a.getName().equals(text)){
                if (a.getPasssword().equals(text1)){
                    correntplayer  = a ;
                    return true;
                }
            }
        }
        return false;
    }
    public static void setCorrentplayer(player correntplayer) {
        PlayerManager.correntplayer = correntplayer;
    }
    
    public static String login(String text, String text1) {

        for (player a : allplayers){
            if (a.getName().equals(text)){
                    return "password incorrect";
            }
        }
        return "username not found " ;
    }


    public static List<player> getAllplayers() {
        return allplayers;
    }

    public static void setAllplayers(player allplayers) {
        PlayerManager.allplayers.add(allplayers) ;
    }


    public static String getlastgamescore() {
        return String.valueOf(PlayerManager.getCorrentplayer().getAllgames().getLast().getScore());
    }
}
