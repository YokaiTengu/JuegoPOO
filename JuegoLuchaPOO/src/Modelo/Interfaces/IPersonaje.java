package Modelo.Interfaces;

public interface IPersonaje {
	String getNombre();
    IArma getArma();
    void atacar(IPersonaje oponente, int dano);
    void recibirDano(int dano);
    boolean estaVivo();
    int getPuntosDeVida();
    String getTipo();
	void atacar(IPersonaje oponente);
	int calcularDano();
	void mostrarInfo();
}
