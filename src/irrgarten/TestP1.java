/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

public class TestP1 {
    public static void main(String[] args) {
        
        ///////////////////////// Crear instancias de la clase Weapon
        Weapon weapon1 = new Weapon(10.0f, 5);
        Weapon weapon2 = new Weapon(8.0f, 1);

        // Usar el método attack() de las armas
        float attackPower1 = weapon1.attack();
        float attackPower2 = weapon2.attack();
        System.out.println("Ataque de weapon1: " + attackPower1);
        System.out.println("Ataque de weapon2: " + attackPower2);

        // Usar el método discard() de las armas
        boolean discard1 = weapon1.discard();
        boolean discard2 = weapon2.discard();
        System.out.println("¿weapon1 debe ser descartada? " + discard1);
        System.out.println("¿weapon2 debe ser descartada? " + discard2);

        // Mostrar las representaciones en cadena de las armas
        System.out.println("weapon1: " + weapon1.toString());
        System.out.println("weapon2: " + weapon2.toString());
        
        
        
        /////////////////////// Crear instancias de la clase Shield
        System.out.println("\n");           //lineaTEST

        Shield shield1 = new Shield(0.75f, 3);
        Shield shield2 = new Shield(0.60f, 5);
        
        // Usar el método protect() en las instancias de Shield
        float protection1 = shield1.protect();
        float protection2 = shield2.protect();
        
        System.out.println("Protección de shield1: " + protection1);
        System.out.println("Protección de shield2: " + protection2);
        
        // Verificar si los escudos deben ser descartados
        boolean discard1s = shield1.discard();
        boolean discard2s = shield2.discard();
        
        System.out.println("¿Shield1 debe ser descartado? " + discard1s);
        System.out.println("¿Shield2 debe ser descartado? " + discard2s);
        
        // Imprimir la representación en cadena de las instancias de Shield
        System.out.println("Datos de shield1: " + shield1.toString());
        System.out.println("Datos de shield2: " + shield2.toString());
               
        
        ///////////////////////////// Crear una instancia de la clase Dice
        Dice dice = new Dice();

        // Usar métodos de la instancia de Dice
        int randomPostResult = dice.randomPost(10);
        int whoStartsResult = dice.whoStarts(4);
        float randomIntelligenceResult = dice.randomIntelligence();
        float randomStrengthResult = dice.randomStrength();
        boolean resurrectPlayerResult = dice.resurrectPlayer();
        int weaponsRewardResult = dice.weaponsReward();
        int shieldsRewardResult = dice.shieldsReward();
        int healthRewardResult = dice.healthReward();
        float weaponPowerResult = dice.weaponPower();
        float shieldPowerResult = dice.shieldPower();
        int usesLeftResult = dice.usesLeft();
        float intensityResult = dice.intensity(5.0f);
        boolean discardElementResult = dice.discardElement(3);

        // Imprimir los resultados
        System.out.println("\n");       //lineaTEST

        System.out.println("randomPostResult: " + randomPostResult);
        System.out.println("whoStartsResult: " + whoStartsResult);
        System.out.println("randomIntelligenceResult: " + randomIntelligenceResult);
        System.out.println("randomStrengthResult: " + randomStrengthResult);
        System.out.println("resurrectPlayerResult: " + resurrectPlayerResult);
        System.out.println("weaponsRewardResult: " + weaponsRewardResult);
        System.out.println("shieldsRewardResult: " + shieldsRewardResult);
        System.out.println("healthRewardResult: " + healthRewardResult);
        System.out.println("weaponPowerResult: " + weaponPowerResult);
        System.out.println("shieldPowerResult: " + shieldPowerResult);
        System.out.println("usesLeftResult: " + usesLeftResult);
        System.out.println("intensityResult: " + intensityResult);
        System.out.println("discardElementResult: " + discardElementResult);
   
    }
}






