package Modelo.Armas;

import Modelo.Interfaces.IArma;

public class Escudo implements IArma {
    private String nombre = "Escudo";
    private int danioBase = 10;  // Daño base bajo para un escudo

    @Override
    public int obtenerDano() {
        return danioBase;  // El escudo no añade daño extra
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int usarArma() {
        return danioBase;  // Retornamos el daño base del escudo
    }

    @Override
    public int getDanioBase() {
        return danioBase;
    }
}
