/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindgamesproyecto.juegos;

import mindgamesproyecto.enums.juegosEnum;

/**
 *
 * @author GSolano3
 */
public class juegosFabrica {
    
    public static juegoInter getJuego(int pTipoJuego)
    {
        if (juegosEnum.valueOf(pTipoJuego).equals(juegosEnum.Ajedrez))
          return new ajedrez();
        else if (juegosEnum.valueOf(pTipoJuego).equals(juegosEnum.Go))
          return new go();
        else if (juegosEnum.valueOf(pTipoJuego).equals(juegosEnum.Tablero))
          return new tablero();

        return null;
    }
}
