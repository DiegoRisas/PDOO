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
        for (int i = 0; i < nplayers; i++) {
            players.add(new Player((char) (i + '0'), Dice.randomIntelligence(), Dice.randomStrength()));
        }
        currentPlayerIndex= Dice.whoStarts(nplayers-1);
        currentPlayer= players.get(currentPlayerIndex);
        
        /////////////////////
        //System.out.println(players.toString()); 
        
        //completar inicializar monsters
        /*
            Para inicializar el atributo contenedor de monstruos y configurar adecuadamente el juego, puedes seguir estos pasos en el constructor de la clase Game:

            Inicializa el atributo monsters. Para esto, puedes crear instancias de la clase Monster y agregarlas al ArrayList monsters. El número de monstruos a
            crear depende de tu lógica de juego. Asumiremos que deseas crear un monstruo por cada jugador:

            for (int i = 0; i < nplayers; i++) {
                monsters.add(new Monster("Monster " + i, Dice.randomIntelligence(), Dice.randomStrength()));
            }
        
            Luego, crea una instancia del laberinto labyrinth con las dimensiones adecuadas y otros parámetros que necesites. Asumiremos que nplayers se
            utiliza para definir las dimensiones del laberinto. Por ejemplo:

            labyrinth = new Labyrinth(nplayers, nplayers);
        
            Distribuye a los jugadores por el laberinto. Puedes crear un arreglo Player[] a partir de la lista de jugadores y luego pasar este arreglo al
            método spreadPlayers del laberinto. Asumiremos que la clase Labyrinth tiene un método spreadPlayers que acepta un arreglo de jugadores como argumento:

            Player[] playerArray = new Player[players.size()];
            playerArray = players.toArray(playerArray);
            labyrinth.spreadPlayers(playerArray);
        
            Finalmente, llama al método configureLabyrinth si es necesario para realizar alguna configuración adicional del laberinto. Este método debería
            ser implementado de acuerdo a tus requerimientos.
            Con estos pasos, habrás inicializado los contenedores de monstruos y jugadores, creado un laberinto y distribuido a los jugadores en el laberinto,
            lo que proporcionará un estado inicial para el juego. Asegúrate de ajustar los valores iniciales según tus necesidades específicas de juego.
        */
        
        
        labyrinth = new Labyrinth(nplayers, nplayers, nplayers-1, nplayers-1);
        
        /*
        Player[] convertirArray = new Player[players.size()];
        convertirArray = players.toArray(convertirArray);
        labyrinth.spreadPlayers(convertirArray);
        */
        configureLabyrinth();
        
        log = "-";
    }
    
 
    //Metodos privados
    
    private void configureLabyrinth(){

        int posMonster = Dice.randomPost(players.size()-1);
        Monster monster = new Monster("Monster1", Dice.randomIntelligence(), Dice.randomStrength());
        labyrinth.addMonster(posMonster, posMonster, monster); 
        monsters.add(monster);
        
       
    }
    
    private void nextPlayer(){
        currentPlayerIndex++;
        currentPlayer = players.get(currentPlayerIndex);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////// P3
    private Directions actualDirection(Directions preferredDirection){
        
        int currentRow = currentPlayer.getRow();
        int currentCol = currentPlayer.getCol();
        
        ArrayList<Directions> validMoves = labyrinth.validMoves(currentRow, currentCol);
        Directions output = currentPlayer.move(preferredDirection, validMoves);
        
        return output;     
    }
    
    
    private GameCharacter combat(Monster monster){

        GameCharacter winner = GameCharacter.PLAYER;
        int rounds = 0;
        
        float playerAttack = currentPlayer.attack();
        boolean lose = monster.defend(playerAttack);
        
        while(!lose && rounds<MAX_ROUNDS){
            winner = GameCharacter.MONSTER;
            rounds++;
            float monsterAttack = monster.attack();
            lose = currentPlayer.defend(monsterAttack);
            
            if(!lose){
                playerAttack = currentPlayer.attack();
                winner = GameCharacter.PLAYER;
                lose = monster.defend(playerAttack);
            }
        }
        logRounds(rounds, MAX_ROUNDS);
        return winner;
    }
    
    private void manageReward(GameCharacter winner){
        
        if(winner == GameCharacter.PLAYER){
            currentPlayer.receiveReward();
            logPlayerWon();
        }else{
            logMonsterWon();
        }
    }
    
    private void manageResurrection(){

        boolean resurrect = Dice.resurrectPlayer();
        
        if(resurrect){
            currentPlayer.resurrect();
            logResurrected();
        }else{
            logPlayerSkipTurn();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////// P3
    
    private void logPlayerWon(){
        String message = "El jugador " + currentPlayerIndex + " ha ganado el combate.";
        log += message + "\n";
    }
    
    private void logMonsterWon(){
        String message = "El monstruo ha ganado el combate al jugador " + currentPlayerIndex + ".";
        log += message + "\n";    
    }

    private void logResurrected(){
        String message = "El jugador " + currentPlayerIndex + " ha resucitado.";
        log += message + "\n";   
    }
    
    private void logPlayerSkipTurn(){
        String message = "El jugador " + currentPlayerIndex + " ha perdido el turno por estar muerto.";
        log += message + "\n";   
    }
    
    private void logPlayerNoOrders(){
        String message = "El jugador " + currentPlayerIndex + " no ha seguido las instrucciones del jugador humano(no fue posible).";
        log += message + "\n";   
    }
    
    private void logNoMonster(){
        String message = "El jugador " + currentPlayerIndex + " se ha movido a una celda vacía o no le ha sido posible moverse.";
        log += message + "\n";   
    }
    
    private void logRounds(int rounds, int max){
        String message = " El mensaje que se han producido rounds de max rondas de combate..";
        log += message + "\n";   
    }
    
    
    //Metodos publicos

    public boolean finished(){
        return labyrinth.haveAWinner();
    }
      ///////////////////////////////////////////////////////////////////////////////////////////// P3
  
    public boolean nextStep(Directions preferredDirection){

        boolean dead = currentPlayer.dead();
        
        if(!dead){
            Directions direction = actualDirection(preferredDirection);
            if(direction != preferredDirection) logPlayerNoOrders();
            
            Monster monster = labyrinth.putPlayer(direction, currentPlayer);
            
            if(monster == null){
                logNoMonster();
            }else{
                GameCharacter winner = combat(monster);
                manageReward(winner);
            }
        }else{
            manageResurrection();
        }
        boolean endGame = finished();
        if(!endGame){
            nextPlayer();
        }
        
        return endGame;
    }
        ///////////////////////////////////////////////////////////////////////////////////////////// P3

    public GameState getGameState(){
        String playersS = new String();
        String salto = "\n";
        for (int i = 0; i < players.size(); i++) {
            playersS += players.get(i).toString() + salto;
        }
        
        String monstersS = new String();
        for (int i = 0; i < monsters.size(); i++) {
            monstersS += monsters.get(i).toString() + salto;
        }

        GameState prueba = new GameState(labyrinth.toString(), playersS, monstersS, currentPlayerIndex, finished(), log);
        return prueba;
    }
       
}
