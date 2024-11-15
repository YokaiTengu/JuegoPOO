package Modelo.Personajes;

import Modelo.Base.PersonajeBase;
import Modelo.Interfaces.IArma;
import Modelo.Interfaces.IPersonaje;

public class Asesino extends PersonajeBase {
    public Asesino(String nombre, IArma arma) {
        super(nombre, arma);
        this.tipo = "Asesino";
        this.puntosDeVida = 70; 	// Vida base del Asesino, menor pero con alta velocidad y daño crítico
    }

	@Override
	public void atacar(IPersonaje oponente, int dano) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarInfo() {
		// TODO Auto-generated method stub
		
	}
}