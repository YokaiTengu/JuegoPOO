package Modelo.Armas;

import java.util.Random;
import Modelo.Interfaces.IArma;

public class Dagas implements IArma {
    private String nombre = "Dagas";
    private int danioBase = 15;  // Daño base de las dagas
    private Random random = new Random();

    @Override
    public int usarArma() {
        int extraDanio = random.nextInt(5);  // Daño extra aleatorio de hasta 5 puntos
        return danioBase + extraDanio;
    }

    @Override
    public int getDanioBase() {
        return danioBase;
    }

    @Override
    public int obtenerDano() {
        return danioBase + random.nextInt(5); // Daño base más daño aleatorio
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
