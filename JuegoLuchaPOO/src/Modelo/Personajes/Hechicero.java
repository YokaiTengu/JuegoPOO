package Modelo.Personajes;

import Modelo.Base.PersonajeBase;
import Modelo.Interfaces.IArma;
import Modelo.Interfaces.IPersonaje;

public class Hechicero extends PersonajeBase {
    public Hechicero(String nombre, IArma arma) {
        super(nombre, arma);
        this.tipo = "Hechicero";
        this.puntosDeVida = 80; // Vida base del Hechicero, menor resistencia pero alto daño
    }

    @Override
    public int calcularDano() {
        int danoBase = super.calcularDano();
        
        // El Hechicero tiene una probabilidad del 25% de aplicar un ataque mágico potenciado
        if (random.nextInt(100) < 25) {
            System.out.println("¡Ataque mágico potenciado!");
            return danoBase + 15; // Daño adicional debido a la magia
        }
        
        return danoBase;
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