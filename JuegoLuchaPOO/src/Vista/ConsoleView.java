package Vista;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }
    
    public String solicitarNombreJugador(int numeroJugador) {
        System.out.print("Introduce el nombre del jugador " + numeroJugador + ": ");
        return scanner.nextLine();
    }

    private int obtenerSeleccionArma() {
        while (true) {
            try {
                int opcionArma = Integer.parseInt(scanner.nextLine());
                if (opcionArma == 1 || opcionArma == 2) {
                    return opcionArma;
                } else {
                    System.out.println("Por favor, elige una opción válida (1 o 2).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: ingresa un número válido.");
            }
        }
    }
	public int seleccionarDano() {
        while (true) {
            System.out.print("\nElige el daño a realizar (10-30): ");
            try {
                int dano = Integer.parseInt(scanner.nextLine());
                if (dano >= 10 && dano <= 30) {
                    return dano;
                }
                System.out.println("El daño debe estar entre 10 y 30.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
            }
        }
    }
    
    public void mostrarInicioJuego(String nombreJugador1, String tipoJugador1, 
                                  String nombreJugador2, String tipoJugador2) {
        System.out.println("\n¡La pelea comienza!");
        System.out.println(nombreJugador1 + " (" + tipoJugador1 + ") VS " + 
                         nombreJugador2 + " (" + tipoJugador2 + ")");
    }
    
    public void mostrarTurno(String nombreAtacante, String tipoAtacante, 
                            String nombreDefensor, int puntosVida) {
        System.out.println("\nTurno de " + nombreAtacante + " (" + tipoAtacante + ")");
        System.out.println(nombreDefensor + " tiene " + puntosVida + " puntos de vida.");
    }
    
    public void mostrarResultadoAtaque(String nombreAtacante, String nombreDefensor, 
                                     int dano, int puntosVidaRestantes) {
        System.out.println(nombreAtacante + " realiza " + dano + " puntos de daño a " + 
                         nombreDefensor + "!");
        System.out.println(nombreDefensor + " queda con " + puntosVidaRestantes + 
                         " puntos de vida.");
    }
    
    public void mostrarGanador(String nombreGanador, String tipoGanador) {
        System.out.println("\n¡" + nombreGanador + " (" + tipoGanador + ") ha ganado la pelea!");
    }
}