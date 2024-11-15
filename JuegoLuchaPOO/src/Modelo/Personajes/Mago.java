package Modelo.Personajes;

import Modelo.Base.PersonajeBase;
import Modelo.Interfaces.IArma;
import Modelo.Interfaces.IPersonaje;

public class Mago extends PersonajeBase {
    public Mago(String nombre, IArma arma) {
        super(nombre, arma);
        this.tipo = "Mago";
        this.puntosDeVida = 80;
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