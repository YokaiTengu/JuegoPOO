package Modelo.Armas;

import Modelo.Interfaces.IArma;

public class Hacha implements IArma {
    private String nombre = "Hacha";
    private int dano = 30;

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