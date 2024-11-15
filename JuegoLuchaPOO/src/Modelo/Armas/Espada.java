package Modelo.Armas;

import Modelo.Interfaces.IArma;

public class Espada implements IArma {
    private String nombre = "Espada";
    private int dano = 20;

    @Override
    public int obtenerDano() {
        return dano;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

	@Override
	public int usarArma() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDanioBase() {
		// TODO Auto-generated method stub
		return 0;
	}
}

