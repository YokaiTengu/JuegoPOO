package Modelo.Estrategias;

import java.util.Random;
import Modelo.Interfaces.IEstrategiaAtaque;

public class AtaqueFuerte implements IEstrategiaAtaque {
    private final Random rand = new Random();
    private final int MIN_DANO = 20;
    private final int MAX_DANO = 40;
    
    @Override
    public int calcularDano() {
        return rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
    }
}