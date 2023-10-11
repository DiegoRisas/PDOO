/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import java.util.Random;

/**
 *
 * @author Diego
 */
public class Dice {
    
    private static int MAX_USES = 5; //(número máximo de usos de armas y escudos)
    private static float MAX_INTELLIGENCE = 10.0f; //(valor máximo para la inteligencia de jugadores y monstruos)
    private static float MAX_STRENGTH = 10.0f; //(valor máximo para la fuerza de jugadores y monstruos)
    private static float RESURRECT_PROB = 0.3f; //(probabilidad de que un jugador sea resucitado en cada turno)
    private static int WEAPONS_REWARD = 2; //(numero máximo de armas recibidas al ganar un combate)
    private static int SHIELDS_REWARD = 3; //(numero máximo de escudos recibidos al ganar un combate)
    private static int HEALTH_REWARD = 5; //(numero máximo de unidades de salud recibidas al ganar un combate)
    private static int MAX_ATTACK = 3; //(máxima potencia de las armas)
    private static int MAX_SHIELD = 2; //(máxima potencia de los escudos)
    
    private static Random generator = new Random();
    
    
   
     /**
     * @brief Método de instancia público que devuelve un numero de fila o columna
     * @param max Numero de filas o columnas maximo ( se numeran comenzando por el 0 )
     * @return numero de de fila o columna
     */
    public static int randomPost (int max){
        return generator.nextInt(max+1);
    }

    
     /**
     * @brief Método de instancia público que determina que jugador empieza
     * @param nplayers Numero de jugadores ( se numeran comenzando por el 0 )
     * @return numero de jugador
     */
    public static  int whoStarts (int nplayers){
        return generator.nextInt(nplayers+1);
    }
 
     /**
     * @brief Método de instancia público que genera un numero aleatorio de inteligencia
     * @return float de inteligencia
     */
    public static float randomIntelligence(){
        return generator.nextFloat() * MAX_INTELLIGENCE;
    }
 
     /**
     * @brief Método de instancia público que genera un numero aleatorio de fuerza
     * @return float de fuerza
     */
    public static float randomStrength(){
        return generator.nextFloat() * MAX_STRENGTH;
    }
    
    
     /**
     * @brief Método de instancia público que genera un numero aleatorio y si es menor que 0.3 devuelve true.
     * @return resurrecion si o no
     */
    public static boolean resurrectPlayer(){
        double probabilidad = generator.nextDouble();
        return probabilidad <= RESURRECT_PROB;
    }

     /**
     * @brief Método de instancia público que genera un numero aleatorio de armas
     * @return numero de armas ganadas
     */
    public static int weaponsReward(){
        return generator.nextInt(WEAPONS_REWARD+1);
    }
    
     /**
     * @brief Método de instancia público que genera un numero aleatorio de escudos
     * @return numero de escudos ganados
     */
    public static int shieldsReward(){
        return generator.nextInt(SHIELDS_REWARD+1);
    }
        
     /**
     * @brief Método de instancia público que genera un numero aleatorio de vida
     * @return vida ganada
     */
    public static int healthReward(){
        return generator.nextInt(HEALTH_REWARD+1);
    }    
    
     /**
     * @brief Método de instancia público que genera un numero aleatorio de poder de arma
     * @return poder de arma
     */
    public static float weaponPower(){
        return generator.nextFloat()*MAX_ATTACK;
    }

     /**
     * @brief Método de instancia público que genera un numero aleatorio de fuerza de escudo
     * @return fuerza de escudo
     */
    public static float shieldPower(){
        return generator.nextFloat()*MAX_SHIELD;
    }
  
     /**
     * @brief Método de instancia público que genera un numero aleatorio de usos
     * @return usos a dar
     */
    public static int usesLeft(){
        return generator.nextInt(MAX_USES+1);
    }   
    
     /**
     * @brief Método de instancia público que genera la competencia aplicada
     * @param competence
     * @return competencia [0,comptence[
     */
    public static float intensity(float competence){
        return generator.nextFloat()*competence;
    }
    
     /**
     * @brief Método de instancia público que devuelve true inversamente proporcional a lo cercano del maximo de usos introducido.
     * @param usesLeft usos que le quedan a un arma o escudo
     * @return resurrecion si o no
     */
    public static boolean discardElement(int usesLeft){
        if(usesLeft == 0) return true;
        
        double probabilidadDescarte = 1.0/ (usesLeft+1);
        
        double numAleatorio = generator.nextDouble();
        
        return numAleatorio <= probabilidadDescarte;
    }
    
}
    

