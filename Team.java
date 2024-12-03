
package com.mycompany.gofo;


import java.util.ArrayList;
/**
 * this is team class .
 * @author Rahma Ahmed
 * @version 1.0
 * @since June 2021
 */
public class Team {

    ArrayList<Player> teamsplayer = new ArrayList<Player>() ;
    int numberTeam;

    /**
     * this function to add new player
     * @param p
     */
    public void addPlayer(Player p){
        for (int i=0; i<numberTeam; i++){
            teamsplayer.set(i, p) ;
        }
    }
}
