/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MindGames.Enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GSolano3
 */
public enum Juegos {
    Ajedrez (1),
    Go(2),
    Tablero(3);
    
    private static Map<Integer, Juegos> map = new HashMap<Integer, Juegos>();
    
    static {
        for (Juegos jueEnum : Juegos.values()) {
            map.put(jueEnum.juegosNumber, jueEnum);
        }
    }
    
    private int juegosNumber;
    
    private Juegos(int pJuegosNumber){ 
        this.juegosNumber = pJuegosNumber;
    }
    
    public static Juegos valueOf( int pJuegosNumber ){
        return map.get(pJuegosNumber);
    }
}
