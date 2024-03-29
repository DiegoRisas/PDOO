/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import static irrgarten.Directions.DOWN;
import static irrgarten.Directions.LEFT;
import static irrgarten.Directions.RIGHT;
import static irrgarten.Directions.UP;
import java.util.ArrayList;

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
    * @param eR Fila donde esta la casilla salida, tiene que ser menor a nR
    * @param eC Columna donde esta la casilla salida, tiene que ser menor a nC
    */
   public Labyrinth(int nR, int nC, int eR, int eC){
       this.nRows= nR;
       this.nCols=nC;
       
       if(eR<nR){
           this.exitRow=eR;
       }else this.exitRow = nR-1;
       
       if(eC<nC){
           this.exitCol = eC;
       }else this.exitCol = nC-1;
       
       LabyrinthSquare = new char[nR][nC];
       MonsterSquare = new Monster[nR][nC];
       PlayerSquare = new Player[nR][nC];
       
       for (int i = 0; i < nRows; i++) {
           for (int j = 0; j < nCols; j++) {
               LabyrinthSquare[i][j]=EMPTY_CHAR;
           }
       }
       
       LabyrinthSquare[eR][eC] = EXIT_CHAR;
       
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
           position[0] = Dice.randomPost(nRows-1);
           position[1] = Dice.randomPost(nCols-1);
       } while (!emptyPos(position[0], position[1]));
       
       return position;
   }
    ///////////////////////////////////////////////////////////////////////////////////////////// P3*
   private Monster putPlayer2D(int oldRow, int oldCOl, int row, int col, Player player){

       Monster output = null;
       
       if(canStepOn(row, col)){
            if(posOK(oldRow, oldCOl)){
               Player p = PlayerSquare[oldRow][oldCOl];
               
               if(p == player){
                   updateOldPos(oldRow, oldCOl);
                   PlayerSquare[oldRow][oldCOl] = null;
               }
           }
            
           if(monsterPos(row, col)){
               LabyrinthSquare[row][col] = COMBAT_CHAR;
               output = MonsterSquare[row][col];
           }else{
               LabyrinthSquare[row][col] = player.getNumber();
           }
           PlayerSquare[row][col] = player;
           player.setPos(row, col);
       }       
       
       return output;
   }
   
   
   //Metodos publicos
   public void spreadPlayers(ArrayList<Player> players){

       for (int i = 0; i < players.size(); i++) {
           int[] pos = randomEmptyPos();
           putPlayer2D(-1, -1, pos[0], pos[1], players.get(i));
       }
   }
    ///////////////////////////////////////////////////////////////////////////////////////////// *P3

   public boolean haveAWinner(){
        return LabyrinthSquare[exitRow][exitCol] != EXIT_CHAR && PlayerSquare[exitRow][exitCol] != null;
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
                } else{
                    result += LabyrinthSquare[i][j];  // Espacio para caracteres que sobren
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
            System.err.println("\n No se ha podido guardar el monstruo en" + row + "," + col);
       } 
    }
   
    ///////////////////////////////////////////////////////////////////////////////////////////// P3*
   public Monster putPlayer(Directions direction, Player player){

       int oldRow = player.getRow();
       int oldCol = player.getCol();
       
       int[] newPos = dir2Pos(oldRow, oldCol, direction);
       
       return putPlayer2D(oldRow, oldCol, newPos[0], newPos[1], player);
       
   }

   public void addBlock(Orientation orientation, int startRow, int startCol, int length){
       int row, col, incRow, incCol;
        if(orientation == Orientation.VERTICAL){
            incRow = 1;
            incCol = 0;
        }else{
            incRow = 0;
            incCol = 1;
        }
        
        row = startRow;
        col = startCol;
        
        while(posOK(row, col) && emptyPos(row, col) && (length > 0)){
            LabyrinthSquare[row][col] = BLOCK_CHAR;
            length -= 1;
            row += incRow;
            col += incCol;
        }
   }

   public ArrayList<Directions> validMoves(int row, int col){

       ArrayList<Directions> output = new ArrayList();
       
       if(canStepOn(row+1, col)) output.add(Directions.DOWN);
       if(canStepOn(row-1, col)) output.add(Directions.UP);
       if(canStepOn(row, col+1)) output.add(Directions.RIGHT);
       if(canStepOn(row, col-1)) output.add(Directions.LEFT);

       return output;
   }
    ///////////////////////////////////////////////////////////////////////////////////////////// *P3
}
