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
public class Player {
    
    private static int MAX_WEAPONS = 2;
    private static int MAX_SHIELDS = 3;
    private static int INITIAL_HEALTH = 10;
    private static int HITS2LOSE = 3;
    
   private String name;
   private char number;
   private float intelligence;
   private float strength;
   private float health;
   private int row;
   private int col;
   private int consecutiveHits = 0;
   
   //Atributos de referencia 
   private ArrayList<Weapon> weapons = new ArrayList();
   private ArrayList<Shield> shields = new ArrayList();
   
   
   /**
    * @brief Constructor con parametros
    * @param number
    * @param intelligence
    * @param strength 
    */
    public Player(char number, float intelligence, float strength) {
        this.number = number;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = INITIAL_HEALTH;
        this.name = "Player #" + number; // Inicializar el nombre concatenando "Player #" y el número
        this.row = -1;
        this.col = -1;
    }
    
    
    
    //Metodos privados de utilidades
    
///////////////////////////////////////////////////////////////////////////////////////////// P3*
    private void receiveWeapon(Weapon w){

        for (int i = 0; i < weapons.size(); i++) {
            if(weapons.get(i).discard()){
                weapons.remove(i);
            }
        }
        int size = weapons.size();
        if(size < MAX_WEAPONS){
            weapons.add(w);
        }
    }
    
    private void receiveShield(Shield s){

        for (int i = 0; i < shields.size(); i++) {
            if(shields.get(i).discard()){
                shields.remove(i);
            }
        }
        int size = shields.size();
        if(size < MAX_SHIELDS){
            shields.add(s);
        }
    }
    
///////////////////////////////////////////////////////////////////////////////////////////// *P3
    
    private Weapon newWeapon(){
        Weapon w = new Weapon(Dice.weaponPower(), Dice.usesLeft());
        return w;
    }
    
    private Shield newShield(){
        Shield s = new Shield(Dice.shieldPower(), Dice.usesLeft());
        return s;        
    }
    
    private float sumWeapons(){
         float sum = 0;
        for (int i = 0; i < weapons.size(); i++) {
            sum += weapons.get(i).attack();
        }
        return sum;       
    }
    
    private float sumShields(){
        float sum = 0;
        for (int i = 0; i < shields.size(); i++) {
            sum += shields.get(i).protect();
        }
        return sum;
    }
    
    private float defensiveEnergy(){
        return sumShields()+intelligence;
    }
    
///////////////////////////////////////////////////////////////////////////////////////////// P3*
    private boolean manageHit(float receivedAttack){
        boolean lose;
        float defense = defensiveEnergy();
        if(defense < receivedAttack){
            this.gotWounded();
            incConsecutiveHits();
        }else{
            resetHits();
        }
        if((consecutiveHits == HITS2LOSE) || dead()){
            resetHits();
            lose = true;
        }else{
            lose = false;
        }
        
        return lose;
    }
///////////////////////////////////////////////////////////////////////////////////////////// *P3

    private void resetHits(){
        consecutiveHits = 0;
    }
    
    private void gotWounded(){
        health-=1;
    }
    
    private void incConsecutiveHits(){
        consecutiveHits+=1;
    }
    
    
    /**
     * @brief . Este método realiza las tareas asociadas a la resurrección.
     * Hace que las listas de armas y escudos sean listas vacías, que el nivel
     * de salud sea el determinado para el inicio del juego y el número consecutivo de impactos cero
     */
    public void resurrect(){
        health = INITIAL_HEALTH;
        consecutiveHits = 0;
        weapons.clear();
        shields.clear();
    }

    // Metodos consultores
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    
    public char getNumber(){
        return number;
    }
    
    //Metodo modificador de posición
    public void setPos(int r, int c){
        row = r;
        col = c;
    }
    
    /**
     * @brief Metodo comprobador
     * @return si el jugador esta muerto o no
     */
    public boolean dead(){
        return health <= 0;
    }
    
    /**
     * 
     * @param direction
     * @param validMoves
     * @return 
     */
    public Directions move(Directions direction, ArrayList<Directions> validMoves){

        int size = validMoves.size();
        boolean contained = validMoves.contains(direction);
        
        if((size > 0) && !contained){
            return validMoves.get(0);
        }else{
            return direction;
        }
    }
    
    /**
     * @brief Calcula la suma de la fuerza del jugador y la suma de lo aportado por sus armas
     * @return 
     */
    public float attack(){
        return strength + this.sumWeapons();
    }
    
    /**
     * @brief Este método delega su funcionalidad en el método manageHit
     * @param receivedAttack
     * @return 
     */
    public boolean defend(float receivedAttack){
        return manageHit(receivedAttack);
    }
    
 ///////////////////////////////////////////////////////////////////////////////////////////// P3*   
    /**
     * 
     */
    public void receiveReward(){

        int wReward = Dice.weaponsReward();
        int sReward = Dice.shieldsReward();
        
        for (int i = 0; i < wReward; i++) {
            Weapon wnew = newWeapon();
            receiveWeapon(wnew);
        }
        
        for (int i = 0; i < sReward; i++) {
            Shield snew = newShield();
            receiveShield(snew);
        }
        
        int extraHealth = Dice.healthReward();
        health += extraHealth;
    }
///////////////////////////////////////////////////////////////////////////////////////////// *P3
    
    /**
     * @brief Metodo toString
     * @return cadena de estado
     */
    public String toString() {
        String playerStatus = "Player Name: " + name + "\n";
        playerStatus += "Number: " + number + "\n";
        playerStatus += "Intelligence: " + intelligence + "\n";
        playerStatus += "Strength: " + strength + "\n";
        playerStatus += "Health: " + health + "\n";
        playerStatus += "Row: " + row + "\n";
        playerStatus += "Column: " + col + "\n";
        playerStatus += "Consecutive Hits: " + consecutiveHits + "\n";
        playerStatus += "Weapons: " + weapons.toString() + "\n";
        playerStatus += "Shields: " + shields.toString() + "\n";
        return playerStatus;
    }

}
