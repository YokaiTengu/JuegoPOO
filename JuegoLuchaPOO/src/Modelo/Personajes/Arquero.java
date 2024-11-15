package Modelo.Personajes;

import Modelo.Base.PersonajeBase;
import Modelo.Interfaces.IArma;
import Modelo.Interfaces.IPersonaje;

public class Arquero extends PersonajeBase {
    public Arquero(String nombre, IArma arma) {
        super(nombre, arma);
        this.tipo = "Arquero";
        this.puntosDeVida = 90;
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