package Controlador;

import Modelo.Interfaces.IPersonaje;
import Vista.ConsoleView;

public class JuegoController {
    private IPersonaje jugador1;
    private IPersonaje jugador2;
    private ConsoleView vista;
    
    public JuegoController(IPersonaje jugador1, IPersonaje jugador2, ConsoleView vista) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.vista = vista;
    }
    
    public void iniciarJuego() {
        vista.mostrarInicioJuego(
            jugador1.getNombre(), jugador1.getTipo(),
            jugador2.getNombre(), jugador2.getTipo()
        );
        
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            ejecutarTurno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                ejecutarTurno(jugador2, jugador1);
            }
        }
        
        IPersonaje ganador = jugador1.estaVivo() ? jugador1 : jugador2;
        vista.mostrarGanador(ganador.getNombre(), ganador.getTipo());
    }
    
    private void ejecutarTurno(IPersonaje atacante, IPersonaje defensor) {
        vista.mostrarTurno(atacante.getNombre(), atacante.getTipo(),
                          defensor.getNombre(), defensor.getPuntosDeVida());
        
        // Se obtiene el daño que el atacante inflige
        int dano = atacante.calcularDano();
        
        // Se realiza el ataque
        atacante.atacar(defensor);
        
        // Mostrar el resultado del ataque
        vista.mostrarResultadoAtaque(atacante.getNombre(), defensor.getNombre(),
                                     dano, defensor.getPuntosDeVida());
    }
}
