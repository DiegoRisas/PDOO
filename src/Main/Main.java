/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import UI.TextUI;
import controller.Controller;
import irrgarten.Game;


/**
 *
 * @author Diego
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextUI vista = new TextUI();
        
        Game juego = new Game(4);
        
        Controller controlador = new Controller(juego, vista);
        
        controlador.play();
       
    }
    
}
