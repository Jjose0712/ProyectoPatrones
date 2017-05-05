/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindgamesproyecto.juegos;

/**
 *
 * @author GSolano3
 */
public class Pieza {
    private String nombre; 
    private String imagen; 
    private Boolean blanca = true; 
    private int x; 
    private int y; 
    private juegoInter comer; 
    public Pieza(String nombre, String imagen, Boolean blanca, int x, int y, juegoInter comer){ 
        setNombre(nombre); 
        setImagen(imagen); 
        setBlanca(blanca); 
        setX(x); 
        setY(y); 
        setComer(comer); 
    } 
     
    public Pieza(String nombre, String imagen){ 
        this(nombre, imagen, null, 0,0,null); 
    } 
     
    public Pieza(String nombre, String imagen, Boolean blanca){ 
        this(nombre, imagen, blanca, 0,0,null); 
    } 
 
    public String getNombre() { 
        return nombre; 
    } 

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    } 

    public String getImagen() { 
        return imagen; 
    } 
 
    public void setImagen(String imagen) { 
        this.imagen = imagen; 
    } 
 
    public Boolean getBlanca() { 
        return blanca; 
    } 
 
    public void setBlanca(Boolean blanca) { 
        this.blanca = blanca; 
    } 
 
    public int getX() { 
        return x; 
    } 
  
    public void setX(int x) { 
        this.x = x; 
    } 
 
    public int getY() { 
        return y; 
    } 
 
    public void setY(int y) { 
        this.y = y; 
    } 
  
    public juegoInter getComer() { 
        return comer; 
    } 
 
    public void setComer(juegoInter comer) { 
        this.comer = comer; 
    } 
}
