/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MindGames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import MindGames.Entities.Pieza;
import MindGames.Entities.Ajedrez;
import MindGames.Enums.PiezasAjedrez;


public class MindGamesProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        int jugador1 = 16;
        int jugador2 = 16;
        List<Pieza> piezasN = new ArrayList<Pieza>();
        List<Pieza> piezasB = new ArrayList<Pieza>();
//        System.out.println("Digite el numero de juego del que desea jugar: 1.Ajedrez,2.Go,3.Tablero"); 
//        opcion = Integer.parseInt(in.readLine());
//        
//        juegoInter game = juegosFabrica.getJuego(opcion);
//        game.juego();
    
        Ajedrez aj = new Ajedrez(); 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Determina si una pieza puede comer a otra."); 
        do{
        System.out.println("Seleccione pieza Blanca:"); 
        menuPiezas(); 
        int piezaInt = sc.nextInt(); 
        imprimeTablero(piezasB,piezasN); 
        System.out.println("Selecciona la posicion X,Y(Separado por \",\"):"); 
        String posicion = sc.next(); 
        String[] posiciones = posicion.split(","); 

        Pieza piezaB = aj.definePiezas(PiezasAjedrez.values()[piezaInt], true, new Integer(posiciones[0]), new Integer(posiciones[1])); 
        piezasB.add(piezaB);
        
        System.out.println("Selecciona pieza Negra:"); 
        menuPiezas(); 
        piezaInt = sc.nextInt(); 
        imprimeTablero(piezasB, piezasN); 
        System.out.println("Selecciona la posicion X,Y(Separado por \",\"):"); 
        posicion = sc.next(); 
        posiciones = posicion.split(","); 
        
        Pieza piezaN = aj.definePiezas(PiezasAjedrez.values()[piezaInt], true, new Integer(posiciones[0]), new Integer(posiciones[1])); 

        piezasN.add(piezaN);
        if(piezaB.getComer().comer(piezaN)){ 
            System.out.println(piezaB.getNombre()+"("+piezaB.getImagen()+")"+" blanca come a "+piezaN.getNombre()+"("+piezaN.getImagen()+")"); 
        } else { 
            if(piezaN.getComer().comer(piezaB)){ 
                System.out.println(piezaN.getNombre()+"("+piezaN.getImagen()+")"+" negro come a "+piezaB.getNombre()+"("+piezaB.getImagen()+")"); 
                jugador1--;
            } else { 
                System.out.println("No se comen.");
                jugador2--;
            } 
        } 
        imprimeTablero(piezasB, piezasN); 
        /* 
        String dato = sc.next(); 
        System.out.println(dato);*/ 
        }
        while(jugador1 != 0 && jugador2 != 0);
    } 
    public static void menuPiezas(){ 
        System.out.println("Opciones pieza:"); 
        for(PiezasAjedrez pieza:PiezasAjedrez.values()){ 
            System.out.println(pieza.ordinal()+")"+pieza); 
        } 
    } 
public static void imprimeTablero(List<Pieza> a1, List<Pieza> a2){ 
        Boolean negro = true; 
        System.out.println("  0 1 2 3 4 5 6 7"); 
        if(!a1.isEmpty() && !a2.isEmpty()){
       System.out.print("Posicion de las piezas Negras"); 
       System.out.println();
       for ( Pieza N : a2 ) {
        for(int Y= 0; Y < 8; Y++){ 
            for(int X = 0; X< 8; X++){ 
                    if(N.getX()==X && N.getY()==Y){ 
                        System.out.print(N.getImagen()); 
                        negro = !negro; 
                    }
                    else{
                    if(negro){ 
                        System.out.print(((X==0)?Y+")":"")+"█"); 
                    }else { 
                        System.out.print("░"); 
                    } 
                    negro = !negro;
                    }
            }
            System.out.println();
        }
         }
       System.out.print("Posicion de las piezas Blancas"); 
       System.out.println();
       for ( Pieza B : a1 ) {
        for(int Y= 0; Y < 8; Y++){ 
            for(int X = 0; X< 8; X++){  
                    if(B.getX()==X && B.getY()==Y){ 
                        System.out.print(B.getImagen()); 
                        negro = !negro; 
                    }
                    else{
                    if(negro){ 
                        System.out.print(((X==0)?Y+")":"")+"█"); 
                    }else { 
                        System.out.print("░"); 
                    } 
                    negro = !negro;
                    }
                 
            } 
            System.out.println();  
        } 
    }
       }
        else{
            for(int Y= 0; Y < 8; Y++){ 
            for(int X = 0; X< 8; X++){ 
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
}
