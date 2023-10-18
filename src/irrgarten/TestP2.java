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
        Monster monster = new Monster("Monster1", 3.5f, 4.2f);

        // Imprimir el estado inicial del monstruo
        System.out.println("Estado inicial del monstruo:");
        System.out.println(monster);

        // Probar el método attack
        float attackPower = monster.attack();
        System.out.println("Poder de ataque del monstruo: " + attackPower);

        // Probar el método defend
        float receivedAttack = 2.0f;
        boolean defended = monster.defend(receivedAttack); // Completa la implementación de este método
        if (defended) {
            System.out.println("El monstruo se defendió del ataque.");
        } else {
            System.out.println("El monstruo no pudo defenderse del ataque.");
        }

        // Reducir la salud del monstruo
        //monster.gotWounded();

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
        
        
    }
}
