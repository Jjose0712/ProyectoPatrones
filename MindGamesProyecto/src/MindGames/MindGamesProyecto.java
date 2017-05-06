/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MindGames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import MindGames.Entities.Pieza;
import MindGames.Entities.Ajedrez;
import MindGames.Entities.JuegosFabrica;
import MindGames.Enums.PiezasAjedrez;
import MindGames.Entities.IJuego;
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
        
//        System.out.println("Digite el numero de juego del que desea jugar: 1.Ajedrez,2.Go,3.Tablero"); 
//        opcion = Integer.parseInt(in.readLine());
//        
//        juegoInter game = juegosFabrica.getJuego(opcion);
//        game.juego();
    
        Ajedrez aj = new Ajedrez(); 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Determina si una pieza puede comer a otra."); 
        System.out.println("Seleccione pieza Blanca:"); 
        menuPiezas(); 
        int piezaInt = sc.nextInt(); 
        imprimeTablero(null,null); 
        System.out.println("Selecciona la posicion X,Y(Separado por \",\"):"); 
        String posicion = sc.next(); 
        String[] posiciones = posicion.split(","); 
        Pieza piezaB = aj.definePiezas(PiezasAjedrez.values()[piezaInt], true, new Integer(posiciones[0]), new Integer(posiciones[1])); 
        System.out.println("Selecciona pieza Negra:"); 
        menuPiezas(); 
        piezaInt = sc.nextInt(); 
        imprimeTablero(piezaB, null); 
        System.out.println("Selecciona la posicion X,Y(Separado por \",\"):"); 
        posicion = sc.next(); 
        posiciones = posicion.split(","); 
        Pieza piezaN = aj.definePiezas(PiezasAjedrez.values()[piezaInt], true, new Integer(posiciones[0]), new Integer(posiciones[1])); 
        if(piezaB.getComer().comer(piezaN)){ 
            System.out.println(piezaB.getNombre()+"("+piezaB.getImagen()+")"+" blanca come a "+piezaN.getNombre()+"("+piezaN.getImagen()+")"); 
        } else { 
            if(piezaN.getComer().comer(piezaB)){ 
                System.out.println(piezaN.getNombre()+"("+piezaN.getImagen()+")"+" negro come a "+piezaB.getNombre()+"("+piezaB.getImagen()+")"); 
            } else { 
                System.out.println("No se comen."); 
            } 
        } 
        imprimeTablero(piezaB, piezaN); 
        /* 
        String dato = sc.next(); 
        System.out.println(dato);*/ 
    } 
    public static void menuPiezas(){ 
        System.out.println("Opciones pieza:"); 
        for(PiezasAjedrez pieza:PiezasAjedrez.values()){ 
            System.out.println(pieza.ordinal()+")"+pieza); 
        } 
    } 
    public static void imprimeTablero(Pieza a1, Pieza a2){ 
        Boolean negro = true; 
        System.out.println("  01234567"); 
        for(int Y= 0; Y < 8; Y++){ 
            for(int X = 0; X< 8; X++){ 
                if(a1 != null){ 
                    if(a1.getX()==X && a1.getY()==Y){ 
                        System.out.print(a1.getImagen()); 
                        negro = !negro; 
                        continue; 
                    }  
                }  
                if(a2!=null){ 
                    if(a2.getX()==X && a2.getY()==Y){ 
                        System.out.print(a2.getImagen()); 
                        negro = !negro; 
                        continue; 
                    }  
                } 
                if(negro){ 
                    System.out.print(((X==0)?Y+")":"")+"█"); 
                }else { 
                    System.out.print("░"); 
                } 
                negro = !negro; 
            } 
            System.out.println(); 
        } 
    } 
}
