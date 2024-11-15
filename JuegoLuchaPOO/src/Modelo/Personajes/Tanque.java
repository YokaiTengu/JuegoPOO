package Modelo.Personajes;

import Modelo.Base.PersonajeBase;
import Modelo.Interfaces.IArma;
import Modelo.Interfaces.IPersonaje;

public class Tanque extends PersonajeBase {
    public Tanque(String nombre, IArma arma) {
        super(nombre, arma);
        this.tipo = "Tanque";
        this.puntosDeVida = 150; // Vida base del Tanque, mayor resistencia
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