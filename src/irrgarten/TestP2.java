/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Diego
 */
public class TestP2 {
    public static void main(String[] args) {
        //Probar instancias de Monster, Player, Labyrinth y Game.
       
        //probando monster
        // Crear una instancia de Monster
        Monster monster = new Monster("Monster1", Dice.randomIntelligence(), Dice.randomStrength());

        // Imprimir el estado inicial del monstruo
        System.out.println("Estado inicial del monstruo:");
        System.out.println(monster);

        // Probar el método attack
        float attackPower = monster.attack();
        System.out.println("Poder de ataque del monstruo: " + attackPower);

        /*// Probar el método defend
        float receivedAttack = 2.0f;
        boolean defended = monster.defend(receivedAttack); // Completa la implementación de este método
        if (defended) {
            System.out.println("El monstruo se defendió del ataque.");
        } else {
            System.out.println("El monstruo no pudo defenderse del ataque.");
        }

        // Reducir la salud del monstruo
        //monster.gotWounded();
        */
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

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Probar clase Player
        
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
        System.out.println("Columna: " + player.getCol());

        // Realizar un ataque y mostrar la fuerza de ataque del jugador
        float attackStrength = player.attack();
        System.out.println("Fuerza de ataque del jugador: " + attackStrength);

        // Realizar una defensa simulada con un ataque recibido
        float receivedAttack = 5.0f; // Valor simulado
       // System.out.println("El jugador ha defendido el ataque: " + player.defend(receivedAttack));
       
       
        System.out.println("\n");

        // Mostrar el estado actual del jugador
        System.out.println("Estado actual del jugador:");
        System.out.println(player.toString());

        // Realizar una resurrección del jugador
        player.resurrect();
        System.out.println("El jugador ha sido resucitado.");

        // Mostrar el estado después de la resurrección
        System.out.println("Estado después de la resurrección:");
        System.out.println(player.toString());
        
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }
}
