/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Game {
    
    private static final int MAX_ROUNDS = 10;
    private int currentPlayerIndex;
    private String log;
    
    // Referencias
    
    private Player currentPlayer;
    private ArrayList<Player> players = new ArrayList();
    
    private ArrayList<Monster> monsters = new ArrayList();
    
    private Labyrinth labyrinth;
    
    /**
     * @brief Constructor con parametros
     * @param nplayers 
     */
    public Game(int nplayers){
        
    }
}
