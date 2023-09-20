/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Diego
 */
public class Weapon {
    
    private float power;
    private int uses;
    
    /**
     * @brief Constructor con parametros
     * @param p_power Valor del poder
     * @param p_uses Valor del tipo del int de usos
     */
    Weapon(float p_power, int p_uses){
        power = p_power;
        uses = p_uses;
    }

     /**
     * @brief Método de instancia público sin parámetros llamado attack que devuelve un número en
     *      coma flotante representando la intensidad del ataque del jugador
     * @return power
     */
    public final float attack(){
        if(uses>0){
            uses--;
            return power;
        }else{
            return 0;
        }
    }
    
     /**
     * @brief Método toString
     * @return String x
     */
    public String toString(){
        String x = null;
        return x;
    }
}
