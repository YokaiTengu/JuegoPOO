package Modelo.Personajes;

import Modelo.Base.PersonajeBase;
import Modelo.Interfaces.IArma;
import Modelo.Interfaces.IPersonaje;

public class Guerrero extends PersonajeBase {
    public Guerrero(String nombre, IArma arma) {
        super(nombre, arma);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Guerrero: " + nombre + " con " + arma.obtenerDano() + " - HP: 120");
    }

	@Override
	public void atacar(IPersonaje oponente, int dano) {
		// TODO Auto-generated method stub
		
	}
}