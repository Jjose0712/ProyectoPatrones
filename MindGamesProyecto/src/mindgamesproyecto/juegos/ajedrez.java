/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindgamesproyecto.juegos;

import mindgamesproyecto.enums.PIEZAS_AJEDREZ;


/**
 *
 * @author GSolano3
 */
public class ajedrez implements juegoInter{
//    @Override
//    public void juego(){//test
//        System.out.println("Soy ajedrez");
//    }
    
    public Pieza definePiezas(PIEZAS_AJEDREZ pieza,boolean blanca,int x, int y){ 
        switch(pieza){ 
            case PEON: 
                Pieza peon = new Pieza(pieza.name(), blanca?"♙":"♟",blanca); 
                peon.setX(x); 
                peon.setY(y); 
                peon.setComer((p)->{ 
                    int avanza = 0; 
                    if(peon.getBlanca()){ 
                        avanza = 1; 
                    } else{ 
                        avanza = -1; 
                    } 
                    if((peon.getX()+avanza)==p.getX()){ 
                        if(((peon.getY()-avanza)==p.getY())||((peon.getY()+avanza)==p.getY())){ 
                            return true; 
                        } 
                    } 
                    return false; 
                }); 
                return peon; 
            case ALFIL: 
                Pieza alfil = new Pieza(pieza.name(), blanca?"♗":"♝",blanca); 
                alfil.setX(x); 
                alfil.setY(y); 
                alfil.setComer((p)->{ 
                     
                    for(int xF = -1; xF<2 ;xF+=2){ 
                        for(int yF = -1; yF<2;yF+=2){ 
                            if(movimientoDiagonal(alfil.getX(), alfil.getY(), p.getX(), p.getY(), xF, yF)){ 
                                return true; 
                            } 
                        } 
                    } 
                    return false; 
                }); 
                return alfil; 
            case CABALLO: 
                Pieza caballo = new Pieza(pieza.name(), blanca?"♘":"♞",blanca); 
                caballo.setX(x); 
                caballo.setY(y); 
                caballo.setComer((p)->{ 
                    int yF = 1; 
                    for(int xF=-2; xF < 3; xF+=1){ 
                        if(xF != 0){ 
                            if(movimientoCaballo(caballo.getX(), caballo.getY(), p.getX(), p.getY(), xF, yF)){ 
                               return true;  
                            } 
                        } 
                        if(xF<0){ 
                            yF++; 
                        }else{ 
                            if(xF>=0){ 
                                yF--; 
                            } 
                        } 
                    } 
                    return false; 
                }); 
                return caballo; 
            case TORRE: 
                Pieza torre = new Pieza(pieza.name(), blanca?"♖":"♜",blanca); 
                torre.setX(x); 
                torre.setY(y); 
                torre.setComer((p)->{ 
                    if(movimientoDiagonal(torre.getX(), torre.getY(), p.getX(), p.getY(), 0, -1)){ 
                        return true; 
                    } 
                    if(movimientoDiagonal(torre.getX(), torre.getY(), p.getX(), p.getY(), 0, 1)){ 
                        return true; 
                    } 
                    if(movimientoDiagonal(torre.getX(), torre.getY(), p.getX(), p.getY(), -1, 0)){ 
                        return true; 
                    } 
                    if(movimientoDiagonal(torre.getX(), torre.getY(), p.getX(), p.getY(), 1, 0)){ 
                        return true; 
                    } 
                    return false; 
                }); 
                return torre; 
            case REINA: 
                Pieza reina = new Pieza(pieza.name(), blanca?"♕":"♛",blanca); 
                reina.setX(x); 
                reina.setY(y); 
                reina.setComer((p)->{ 
                    for(int xF = -1; xF<2 ;xF+=2){ 
                        for(int yF = -1; yF<2;yF+=2){ 
                            if(movimientoDiagonal(reina.getX(), reina.getY(), p.getX(), p.getY(), xF, yF)){ 
                                return true; 
                            } 
                        } 
                    } 
                    if(movimientoDiagonal(reina.getX(), reina.getY(), p.getX(), p.getY(), 0, -1)){ 
                        return true; 
                    } 
                    if(movimientoDiagonal(reina.getX(), reina.getY(), p.getX(), p.getY(), 0, 1)){ 
                        return true; 
                    } 
                    if(movimientoDiagonal(reina.getX(), reina.getY(), p.getX(), p.getY(), -1, 0)){ 
                        return true; 
                    } 
                    if(movimientoDiagonal(reina.getX(), reina.getY(), p.getX(), p.getY(), 1, 0)){ 
                        return true; 
                    } 
                    return false; 
                }); 
                return reina; 
            case REY: 
                Pieza rey = new Pieza(pieza.name(), blanca?"♔":"♚",blanca); 
                rey.setX(x); 
                rey.setY(y); 
                rey.setComer((p)->{ 
                     
                    for(int xF = -1; xF<2 ;xF+=2){ 
                        for(int yF = -1; yF<2;yF+=2){ 
                            if(movimientoRey(rey.getX(), rey.getY(), p.getX(), p.getY(), xF, yF)){ 
                                return true; 
                            } 
                        } 
                    } 
                    if(movimientoRey(rey.getX(), rey.getY(), p.getX(), p.getY(), 1, 0)){ 
                        return true; 
                    } 
                    if(movimientoRey(rey.getX(), rey.getY(), p.getX(), p.getY(), 0, 1)){ 
                        return true; 
                    } 
                    if(movimientoRey(rey.getX(), rey.getY(), p.getX(), p.getY(), 0, -1)){ 
                        return true; 
                    } 
                    if(movimientoRey(rey.getX(), rey.getY(), p.getX(), p.getY(), -1, 0)){ 
                        return true; 
                    } 
                    return false; 
                }); 
                return rey; 
        } 
        return null; 
    } 
     
    public boolean movimientoDiagonal(int x, int y,int xB,int yB,int incX, int incY){ 
        for(int xF = x,yF=y; xF < 8 && yF < 8 && xF>=0 && yF>=0; xF+=incX,yF+=incY){ 
            if(xB == xF && yB == yF){ 
                return true; 
            } 
        } 
        return false; 
    } 
     
    public boolean movimientoCaballo(int x, int y,int xB,int yB,int incX, int incY){ 
        return (((x+incX)==xB) &&(((y+incY)==yB)||(y-incY)==yB)); 
    } 
     
    public boolean movimientoRey(int x, int y, int xB, int yB,int incX, int incY){ 
            return (((x+incX) == xB)&&((y+incY)==yB)); 
    } 

    @Override
    public boolean comer(Pieza p) {
        return true;
    }
}
