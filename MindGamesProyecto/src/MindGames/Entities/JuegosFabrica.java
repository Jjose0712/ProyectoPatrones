/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MindGames.Entities;

import MindGames.Enums.Juegos;

/**
 *
 * @author GSolano3
 */
public class JuegosFabrica {
    
    public static IJuego getJuego(int pTipoJuego)
    {
        if (Juegos.valueOf(pTipoJuego).equals(Juegos.Ajedrez))
          return new Ajedrez();
        else if (Juegos.valueOf(pTipoJuego).equals(Juegos.Go))
          return new Go();
        else if (Juegos.valueOf(pTipoJuego).equals(Juegos.Tablero))
          return new Tablero();

        return null;
    }
}
