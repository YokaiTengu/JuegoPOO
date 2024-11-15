package Modelo.Base;

import java.util.Random;
import Modelo.Interfaces.IPersonaje;
import Modelo.Interfaces.IArma;

public abstract class PersonajeBase implements IPersonaje {
    protected String nombre;
    protected int puntosDeVida;
    protected String tipo;
    protected IArma arma;
    protected Random random;

    public PersonajeBase(String nombre, IArma arma) {
        this.nombre = nombre;
        this.puntosDeVida = 100;
        this.arma = arma;  // Arma asignada al personaje
        this.random = new Random();
    }
    
    @Override
    public void atacar(IPersonaje oponente) {
        int dano = calcularDano();
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + 
                           " con " + arma.getNombre() + ", causando " + dano + " puntos de daño.");
    }
    
    public int calcularDano() {
        int tipoAtaque = random.nextInt(100);
        int ataqueBase = arma.obtenerDano(); // Daño base depende del arma equipada

        if (tipoAtaque < 20) {  // 20% de probabilidad de crítico
            return (int) (ataqueBase * 1.5);
        } else if (tipoAtaque < 60) {  // 40% de probabilidad de ataque fuerte
            return (int) (ataqueBase * 1.2);
        } else {  // 40% de probabilidad de ataque normal
            return ataqueBase;
        }
    }

    @Override
    public void recibirDano(int dano) {
        this.puntosDeVida = Math.max(0, this.puntosDeVida - dano);
    }
    
    @Override
    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }
    
    @Override
    public String getNombre() {
        return this.nombre;
    }
    
    @Override
    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
    
    @Override
    public IArma getArma() {
        return arma;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }
}
