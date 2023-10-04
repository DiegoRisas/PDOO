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
    
    public boolean dead(){
        return health <= 0;
    }
    
    public float attack() {
        Dice dice = new Dice(); 
        return dice.intensity(strength);
    }
    
    public boolean defend(float receivedAttack){
        throw new UnsupportedOperationException(); //   completar
    }
    
    public void setPos(int r, int c){
        row = r;
        col = c;
    }
    
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
        
    private void gotWounded(){
        health -= 1;
    }
            
}
