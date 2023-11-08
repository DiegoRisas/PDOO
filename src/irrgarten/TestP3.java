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
public class TestP3 {
    
    public static void pruebaMonster(){
        //probando monster
        // Crear una instancia de Monster
        Monster monster = new Monster("Monster1", Dice.randomIntelligence(), Dice.randomStrength());

        // Imprimir el estado inicial del monstruo
        System.out.println("Estado inicial del monstruo:");
        System.out.println(monster);

        // Probar el método attack
        float attackPower = monster.attack();
        System.out.println("Poder de ataque del monstruo: " + attackPower);

        // Probar el método defend
        float receivedAttack = 2.0f;
        boolean defended = monster.defend(receivedAttack);
        if (defended) {
            System.out.println("El monstruo se defendió del ataque.");
        } else {
            System.out.println("El monstruo no pudo defenderse del ataque.");
        }
        
        // Comprobar si el monstruo está muerto
        boolean isDead = monster.dead();
        if (isDead) {
            System.out.println("El monstruo está muerto.");
        } else {
            System.out.println("El monstruo sigue vivo.");
        }

        // Cambiar la posición del monstruo
        monster.setPos(2, 3);

        // Imprimir el estado actual del monstruo
        System.out.println("Estado actual del monstruo:");
        System.out.println(monster);
      
        
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    }
    
    public static void pruebaPlayer(){
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Probar clase Player
        
        /*
        //crear armas y escudos para probar la clase jugador
        ArrayList<Weapon> weapons = new ArrayList();
        for (int i = 0; i <2; i++) {
            Weapon nuevo = new Weapon(Dice.randomStrength(), Dice.usesLeft());
            weapons.add(nuevo);
        }

       ArrayList<Shield> shields = new ArrayList();
        for (int i = 0; i <3; i++) {
            Shield nuevo = new Shield(Dice.shieldPower(), Dice.usesLeft());
            shields.add(nuevo);
        }        
        */
        // Crear un jugador
        Player player = new Player('1', Dice.randomIntelligence(), Dice.randomStrength());

        // Mostrar el estado inicial del jugador
        System.out.println("Estado inicial del jugador:");
        System.out.println(player.toString());

        // Mover al jugador a una posición (por ejemplo, fila 2, columna 3)
        player.setPos(2, 3);

        // Mostrar la nueva posición del jugador
        System.out.println("Nueva posición del jugador:");
        System.out.println("Fila: " + player.getRow());
        System.out.println("Columna: " + player.getCol() + "\n");

        
        //Recivir escudos y armas.
        
        player.receiveReward();
         
        System.out.println("Estado del jugador despues de recieve reward:");
        System.out.println(player.toString());
        
        
        // Realizar un ataque y mostrar la fuerza de ataque del jugador
        float attackStrength = player.attack();
        System.out.println("Fuerza de ataque del jugador: " + attackStrength + "\n");
        
        
        // Realizar una defensa simulada con un ataque recibido
        float receivedAttack = 5.0f; // Valor simulado
        player.defend(receivedAttack);
        System.out.println("Estado del jugador despues de defend:");
        System.out.println(player.toString());        

        Player nuevo = new Player('2', Dice.randomIntelligence(), Dice.randomStrength());
        while(!nuevo.dead()){
            nuevo.defend(20);
        }
        
        System.out.println("Estado del jugador nuevo muerto:");
        System.out.println(nuevo.toString());        
        
        // Realizar una resurrección del jugador
        nuevo.resurrect();
        System.out.println("El jugador ha sido resucitado.\n");

        // Mostrar el estado después de la resurrección
        System.out.println("Estado después de la resurrección:");
        System.out.println(nuevo.toString());
        
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    }

    public static void pruebaLabyrinth(){
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        // Crear una instancia de la clase Labyrinth
        int nFilas = Dice.randomPost(9);
        if(nFilas <4) nFilas = 4;
          
        Labyrinth labyrinth = new Labyrinth(nFilas, nFilas, nFilas-1, nFilas-1);
        
        //Creamos 1 jugador y monstruo para probar funciones del laberinto
        Monster monster = new Monster("Monster1", Dice.randomIntelligence(), Dice.randomStrength());
        Player player = new Player('1', Dice.randomIntelligence(), Dice.randomStrength());
        ArrayList<Player> array = new ArrayList();
        array.add(player);

        
        // Agregar un bloque en el laberinto (falta completar el método addBlock)
        labyrinth.addBlock(Orientation.VERTICAL, 1, 1, 3);

        // Imprimir el estado actual del laberinto después de agregar un bloque
        System.out.println("Estado del laberinto después de poner un bloqueo:");
        System.out.println(labyrinth.toString());

        
        // Agregar un monstruo
        labyrinth.addMonster(Dice.randomPost(nFilas-1), Dice.randomPost(nFilas-1), monster);

        // Imprimir el estado actual del laberinto
        System.out.println("Estado del laberinto despues de poner un monstruo:");
        System.out.println(labyrinth.toString());

                
        // Mover un jugador en el laberinto 
        labyrinth.spreadPlayers(array);
               
        
        // Imprimir el estado actual del laberinto después de mover al jugador
        System.out.println("Estado del laberinto después de mover al jugador:");
        System.out.println(labyrinth.toString());

        // Verificar si hay un ganador
        if (labyrinth.haveAWinner()) {
            System.out.println("¡El jugador ha ganado!");
        } else {
            System.out.println("No hay un ganador todavía.");
        }

        // Obtener los movimientos válidos para una posición
        ArrayList<Directions> validMoves = labyrinth.validMoves(1, 3);
        System.out.println("Movimientos válidos desde (1, 3): " + validMoves.toString());
    
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    }
    
    public static void pruebaGame(){
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

         // Crear una instancia del juego con 4 jugadores
        Game game = new Game(4);
        
                        
        // Mostrar el estado inicial del juego
        System.out.println(game.getGameState().toString());

        boolean finished;
        do{
            finished = game.nextStep(Directions.RIGHT);
            System.out.println(game.getLabyrinth().toString());
        }while(!finished);
        
        
        // Verificar si el juego ha terminado
        if (finished) {
            System.out.println("¡El juego ha terminado!");
        }else{
            System.out.println("¡El juego continua!");
        }

        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////"); 
    }
    
    public static void main(String[] args) {
        //Probar instancias de Monster, Player, Labyrinth y Game.
       
        //pruebaMonster();
        
        //pruebaPlayer();
        
        //pruebaLabyrinth();
       
        pruebaGame();
    }
}
