/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Diego
 */
public class Shield {
    
    private float protection;
    private int uses;
    
    /**
     * @brief Constructor con parametros
     * @param p_protect Valor de protecion del escudo
     * @param p_uses Valor del tipo del int de usos
     */
    Shield(float p_protect, int p_uses){
        protection = p_protect;
        uses = p_uses;
    }
    
     /**
     * @brief Método de instancia público sin parámetros llamado protect que devuelve un número en
     *      coma flotante representando la intensidad de defensa del jugador
     * @return protection
     */
    public final float protect(){
        if(uses>0){
            uses--;
            return protection;
        }else{
            return 0;
        }
    }
    
     /**
     * @brief Método de instancia público que decide si un escudo debe ser descartado
     * @return true or false
     */
    boolean discard(){
        return Dice.discardElement(this.uses);
    }
    
     /**
     * @brief Metodo toString
     * @return String x
     */
    public String toString(){
        return "S[" + protection + "," + uses + "]";
    }    
}
