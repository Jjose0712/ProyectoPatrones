/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindgamesproyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import mindgamesproyecto.juegos.juegoInter;
import mindgamesproyecto.juegos.juegosFabrica;

/**
 *
 * @author GSolano3
 */
public class MindGamesProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        
        System.out.println("Digite el numero de juego del que desea jugar: 1.Ajedrez,2.Go,3.Tablero"); 
        opcion = Integer.parseInt(in.readLine());
        
        juegoInter game = juegosFabrica.getJuego(opcion);
        game.juego();
    }
}
