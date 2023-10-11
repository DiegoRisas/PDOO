package irrgarten;


/**
 *
 * @author Diego
 */
public class Monster {
    
    private static int INITIAL_HEALTH = 5;
    private String name;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    
    /**
     * @brief Constructor con parametros
     * @param name
     * @param intelligence
     * @param strength 
     */
    public Monster(String name, float intelligence, float strength) {
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = INITIAL_HEALTH;
        this.row = -1;
        this.col = -1;
    }
    
    /**
     * @brief Metodo comprobador
     * @return si es monstruo esta muerto o no
     */
    public boolean dead(){
        return health <= 0;
    }
    
    /**
     * @brief Genera el resultado haciendo uso del metodo intensity del dado.
     * @return ataque del monstruo
     */
    public float attack() {
        Dice dice = new Dice(); 
        return dice.intensity(strength);
    }
    
    /**
     * @brief 
     * @param receivedAttack
     * @return 
     */
    public boolean defend(float receivedAttack){
        throw new UnsupportedOperationException(); //   completar
    }
    
    /**
     * @brief Modificado en unica llamada de los atibutos col y row
     * @param r fila
     * @param c columna
     */
    public void setPos(int r, int c){
        row = r;
        col = c;
    }
    
    /**
     * @brief  Genera un representación del estado completo del monstruo
     * @return cadena representando al monstruo
     */
    public String toString() {
        String monsterStatus = "Monster Name: " + name + "\n";
        monsterStatus += "Intelligence: " + intelligence + "\n";
        monsterStatus += "Strength: " + strength + "\n";
        monsterStatus += "Health: " + health + "\n";
        monsterStatus += "Row: " + row + "\n";
        monsterStatus += "Column: " + col + "\n";
        monsterStatus += "Is Dead: " + dead() + "\n";
        return monsterStatus;
    }
    
    /**
     * @brief Este método decrementa en una unidad la salud del monstruo.
     */
    private void gotWounded(){
        health -= 1;
    }
            
}
