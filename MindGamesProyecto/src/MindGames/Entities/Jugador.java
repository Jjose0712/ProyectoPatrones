/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MindGames.Entities;

/**
 *
 * @author ajuarez
 */
public class Jugador {
    public int id;
    public String nombre;
    public int puntaje;
    public String correo;
    public String contrasenna;
    public String nombreUsuario;
    
    public int getId() {
        return id;
    }
    public String getNombre(){
         return nombre;
    }
    public int getPuntaje(){
        return puntaje;
    }
    public String getCorreo(){
        return correo;
    }
    public String getContrasenna(){
        return contrasenna;
    }
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
