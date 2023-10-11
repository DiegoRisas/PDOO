/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Diego
 */
public class Labyrinth {
    
    private static char BLOCK_CHAR = 'X';
    private static char EMPTY_CHAR = '-';
    private static char MONSTER_CHAR = 'M';
    private static char COMBAT_CHAR = 'C';
    private static char EXIT_CHAR = 'E';
    private static int ROW = 0;
    private static int COL = 1;
    
    private int nRows;
    private int nCols;
    private int exitRow;
    private int exitCol;
    
    //Matrices que represetan las tablas de información del juego
    
   private Monster[][] MonsterSquare;
   private Player[][] PlayerSquare;
   private char[][] LabyrinthSquare;
   
   
   
   //Metodos publicos
   
   /**
    * @brief Constructor con parametros
    * @param nR numeroFilas
    * @param nC numeroColumnas
    * @param eR Fila donde esta la casilla salida
    * @param eC Columna donde esta la casilla salida
    */
   public Labyrinth(int nR, int nC, int eR, int eC){
       this.nRows= nR;
       this.nCols=nC;
       this.exitRow=eR;
       this.exitCol=eC;
   }
   
   public void spreadPlayers(Player[] players){
       
   }
   
   public boolean haveAWinner(){
       
   }
   
   public String toString(){
       
   }
   
   public void addMonster(int row, int col, Monster monster){
       
   }
}
