/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Diego
 */
public class GameState {
    
    private String labyrinth;
    private String players;
    private String monsters;
    private int currentPlayer; //representa el índice del jugador actual
    private boolean winner;
    private String log;
    
    
    //Constructor
    public GameState(String labyrinth, String players, String monsters, int currentPlayer, boolean winner, String log) {
        this.labyrinth = labyrinth;
        this.players = players;
        this.monsters = monsters;
        this.currentPlayer = currentPlayer;
        this.winner = winner;
        this.log = log;
    }    
    
    
  // Consultores para acceder a los atributos
    public String getLabyrinth() {
        return labyrinth;
    }

    public String getPlayers() {
        return players;
    }

    public String getMonsters() {
        return monsters;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isWinner() {
        return winner;
    }

    public String getLog() {
        return log;
    }
    
    /*
    public static void main(String[] args) {
        // Ejemplo de uso: Crear una instancia de GameState
        GameState gameState = new GameState("Laberinto1", "Jugador1, Jugador2", "Monstruo1, Monstruo2", 0, false, "Inicio del juego.");
        
        // Consultar los atributos
        System.out.println("Laberinto: " + gameState.getLabyrinth());
        System.out.println("Jugadores: " + gameState.getPlayers());
        System.out.println("Monstruos: " + gameState.getMonsters());
        System.out.println("Jugador actual: " + gameState.getCurrentPlayer());
        System.out.println("¿Hay un ganador?: " + gameState.isWinner());
        System.out.println("Registro de eventos: " + gameState.getLog());
    }
    */
}
