package Modelo.Estrategias;

import java.util.Random;
import Modelo.Interfaces.IEstrategiaAtaque;

public class AtaqueNormal implements IEstrategiaAtaque {
    private final Random rand = new Random();
    private final int MIN_DANO = 10;
    private final int MAX_DANO = 30;
    
    @Override
    public int calcularDano() {
        return rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
    }
}