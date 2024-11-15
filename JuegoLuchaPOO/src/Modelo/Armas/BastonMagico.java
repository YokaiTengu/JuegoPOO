package Modelo.Armas;

import java.util.Random;
import Modelo.Interfaces.IArma;

public class BastonMagico implements IArma {
    private String nombre = "Bastón Mágico";
    private int danioBase = 20;
    private Random random = new Random();

    @Override
    public int usarArma() {
        int extraDanio = random.nextInt(10);  // Daño extra aleatorio de hasta 10 puntos
        return danioBase + extraDanio;
    }

    @Override
    public int getDanioBase() {
        return danioBase;
    }

    @Override
    public int obtenerDano() {
        return danioBase + random.nextInt(10); // Daño base más daño aleatorio
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}