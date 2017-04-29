/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindgamesproyecto.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GSolano3
 */
public enum juegosEnum {
    Ajedrez (1),
    Go(2),
    Tablero(3);
    
    private static Map<Integer, juegosEnum> map = new HashMap<Integer, juegosEnum>();
    
    static {
        for (juegosEnum jueEnum : juegosEnum.values()) {
            map.put(jueEnum.juegosNumber, jueEnum);
        }
    }
    
    private int juegosNumber;
    
    private juegosEnum(int pJuegosNumber){ 
        this.juegosNumber = pJuegosNumber;
    }
    
    public static juegosEnum valueOf( int pJuegosNumber ){
        return map.get(pJuegosNumber);
    }
}
