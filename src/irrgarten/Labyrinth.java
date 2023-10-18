/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import static irrgarten.Directions.DOWN;
import static irrgarten.Directions.LEFT;
import static irrgarten.Directions.RIGHT;
import static irrgarten.Directions.UP;

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
   
   
  //Metodos privados
   
   private boolean posOK(int row, int col){
       return (row<nRows && row >= 0 ) && (col < nCols && col >=0);
   }
   
   private boolean emptyPos(int row, int col){
       return LabyrinthSquare[row][col] == EMPTY_CHAR;
   }
   
   private boolean monsterPos(int row, int col){
       return LabyrinthSquare[row][col] == MONSTER_CHAR;
   }

   private boolean exitPos(int row, int col){
       return LabyrinthSquare[row][col] == EXIT_CHAR;
   }
   
   private boolean combatPos(int row, int col){
       return LabyrinthSquare[row][col] == COMBAT_CHAR;
   } 
   
   private boolean canStepOn(int row, int col){
       return posOK(row, col) && (emptyPos(row, col) || monsterPos(row, col) || exitPos(row, col));
   } 
   
   private void updateOldPos(int row, int col){
       if(posOK(row, col)){
           if(combatPos(row, col)){
               LabyrinthSquare[row][col] = MONSTER_CHAR;
           }else{
               LabyrinthSquare[row][col] = EMPTY_CHAR;
           }
       }
   } 
   
   private int[] dir2Pos(int row, int col, Directions direction){
       int newRow = row, newCol = col;
       
       switch (direction){
           case LEFT:
               newCol--;
               break;
           case RIGHT:
               newCol++;
               break;
           case UP:
               newRow--;
               break;
           case DOWN:
               newRow++;
               break;
       }
       int[] newPosition = {newRow,newCol};
       return newPosition;
   }
   
   private int[] randomEmptyPos(){
       
       int[] position = new int[2];
       
       do{
           position[0] = Dice.randomPost(nRows);
           position[1] = Dice.randomPost(nCols);
       } while (emptyPos(position[0], position[1]));
       
       return position;
   }
   
   private Monster putPlayer2D(int oldRow, int oldCOl, int row, int col, Player player){
        throw new UnsupportedOperationException(); //   completar
   }
   
      //Metodos publicos

   
   public void spreadPlayers(Player[] players){
        throw new UnsupportedOperationException(); //   completar
   }
   
   public boolean haveAWinner(){
        return LabyrinthSquare[exitRow][exitCol] == EXIT_CHAR && PlayerSquare[exitRow][exitCol] != null;
   }
   
    public String toString() {

        String labyrinthStatus = "nRows: " + nRows + "\n";
        labyrinthStatus += "nCols: " + nCols + "\n";
        labyrinthStatus += "exitRow: " + exitRow + "\n";
        labyrinthStatus += "exitCol: " + exitCol + "\n";

        String result = "";

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                char cellChar = LabyrinthSquare[i][j];
                if (cellChar == BLOCK_CHAR) {
                    result += BLOCK_CHAR;
                } else if (cellChar == EMPTY_CHAR) {
                    result += EMPTY_CHAR;
                } else if (cellChar == MONSTER_CHAR) {
                    result += MONSTER_CHAR;
                } else if (cellChar == EXIT_CHAR) {
                    result += EXIT_CHAR;
                } else if (cellChar == COMBAT_CHAR) {
                    result += COMBAT_CHAR;
                } else {
                    result += " ";  // Espacio para caracteres que sobren
                }
            }
            result += "\n";  // Nueva Linea despues de cada row
        }

        return labyrinthStatus + "\n" + result;
    }
   
   public void addMonster(int row, int col, Monster monster){
       if(posOK(row, col) && emptyPos(row, col)){
           LabyrinthSquare[row][col] = MONSTER_CHAR;
           MonsterSquare[row][col] = monster;
           monster.setPos(row, col);
        }else{
           // System.out.println("\n No se ha podido guardar el monstruo en" + row + "," + col);
       }
    }
   
   
   public Monster putPlayer(Directions direction, Player player){
        throw new UnsupportedOperationException(); //   completar
   }
   
   public void addBlock(Orientation orientation, int startRow, int startCol, int length){
        throw new UnsupportedOperationException(); //   completar
   }

   public Directions[] validMoves(int row, int col){
        throw new UnsupportedOperationException(); //   completar
   }
      
}
