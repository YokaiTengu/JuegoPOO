import java.util.Scanner;
import Modelo.Armas.*;
import Modelo.Interfaces.IArma;
import Modelo.Interfaces.IPersonaje;
import Modelo.Personajes.*;
import Controlador.JuegoController;
import Vista.ConsoleView;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Crear primer jugador
        int tipoPersonaje1 = seleccionarPersonaje(1);
        System.out.print("Ingresa el nombre de tu personaje: ");
        String nombre1 = scanner.nextLine();
        IPersonaje jugador1 = crearPersonaje(nombre1, tipoPersonaje1);
        System.out.println("¡Personaje creado: " + jugador1.getNombre() + "!");
        System.out.println("Tipo de arma: " + jugador1.getArma().getNombre());
        
        System.out.println("\n=== Crear Segundo Jugador ===\n");
        
        // Crear segundo jugador
        int tipoPersonaje2 = seleccionarPersonaje(2);
        System.out.print("Ingresa el nombre de tu personaje: ");
        String nombre2 = scanner.nextLine();
        IPersonaje jugador2 = crearPersonaje(nombre2, tipoPersonaje2);
        System.out.println("¡Personaje creado: " + jugador2.getNombre() + "!");
        System.out.println("Tipo de arma: " + jugador2.getArma().getNombre());
        
        // Iniciar el juego
        ConsoleView vista = new ConsoleView();
        JuegoController controlador = new JuegoController(jugador1, jugador2, vista);
        controlador.iniciarJuego();
    }
    
    private static String obtenerArmaUnica(int tipoPersonaje) {
        switch (tipoPersonaje) {
            case 1: return "Espada";
            case 2: return "Bastón Mágico";
            case 3: return "Arco";
            case 5: return "Escudo";
            default: return "Arma desconocida";
        }
    }
    
    private static int seleccionarArma(int tipoPersonaje) {
        if (tipoPersonaje == 4) {
            System.out.println("\nHas seleccionado: Asesino");
            System.out.println("El Asesino tiene las siguientes opciones de armas:");
            System.out.println("1. Dagas - Ataques rápidos, daño moderado");
            System.out.println("2. Hacha - Ataques lentos, daño alto");
            return obtenerSeleccionArma();
        } else if (tipoPersonaje == 6) {
            System.out.println("\nHas seleccionado: Hechicero");
            System.out.println("El Hechicero tiene las siguientes opciones de armas:");
            System.out.println("1. Bastón Mágico - Mejora habilidades mágicas");
            System.out.println("2. Hacha - Ofrece un ataque cuerpo a cuerpo poderoso");
            return obtenerSeleccionArma();
        } else {
            String arma = obtenerArmaUnica(tipoPersonaje);
            System.out.println("\nHas seleccionado un personaje con un solo tipo de arma:");
            System.out.println("Arma asignada: " + arma);
            return 1; // Solo hay una opción, así que devolvemos 1
        }
    }
    
    public static int seleccionarPersonaje(int numJugador) {
        while (true) {
            System.out.println("\n====== Selección de Personaje - Jugador " + numJugador + " ======");
            System.out.println("1. Guerrero (120 HP - Resistente) - 1 Arma: Espada");
            System.out.println("2. Mago (80 HP - Poderoso) - 1 Arma: Bastón Mágico");
            System.out.println("3. Arquero (90 HP - Preciso) - 1 Arma: Arco");
            System.out.println("4. Asesino (70 HP - Crítico) - 2 Armas: Dagas o Hacha");
            System.out.println("5. Tanque (150 HP - Resistente, ataques débiles) - 1 Arma: Escudo");
            System.out.println("6. Hechicero (90 HP - Habilidades especiales) - 2 Armas: Bastón Mágico o Hacha");
            System.out.print("Elige el número correspondiente a tu personaje (1-6): ");
            
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= 1 && opcion <= 6) {
                    return opcion; // Solo devolver la opción, sin llamar a seleccionarArma
                }
                System.out.println("Por favor, elige una opción válida entre 1 y 6.");
            } catch (NumberFormatException e) {
                System.out.println("Error: ingresa un número válido.");
            }
        }
    }

    private static IArma getSelectedWeapon(int tipo, int opcionArma) {
        if (tipo == 4) { // Asesino
            return (opcionArma == 1) ? new Dagas() : new Hacha();
        } else if (tipo == 6) { // Hechicero
            return (opcionArma == 1) ? new BastonMagico() : new Hacha();
        }
        
        // Para los demás personajes
        switch (tipo) {
            case 1: return new Espada();
            case 2: return new BastonMagico();
            case 3: return new Arco();
            case 5: return new Escudo();
            default: throw new IllegalArgumentException("Tipo de personaje no válido");
        }
    }

    public static IPersonaje crearPersonaje(String nombre, int tipo) {
    	 int opcionArma = 1; // Por defecto
    	    if (tipo == 4 || tipo == 6) {
    	        opcionArma = seleccionarArma(tipo); // Solo llamar aquí
    	    }
    	    
    	    IArma arma = getSelectedWeapon(tipo, opcionArma);
    	    System.out.println("Arma seleccionada para el personaje: " + arma.getNombre()); // Depuración

        
        switch (tipo) {
            case 1: return new Guerrero(nombre, arma);
            case 2: return new Mago(nombre, arma);
            case 3: return new Arquero(nombre, arma);
            case 4: return new Asesino(nombre, arma);
            case 5: return new Tanque(nombre, arma);
            case 6: return new Hechicero(nombre, arma);
            default: throw new IllegalArgumentException("Tipo de personaje no válido");
        }
    }

    private static int obtenerSeleccionArma() {
        while (true) {
            try {
                int opcionArma = Integer.parseInt(scanner.nextLine());
                if (opcionArma == 1 || opcionArma == 2) {
                    return opcionArma;
                }
                System.out.println("Por favor, elige una opción válida (1 o 2).");
            } catch (NumberFormatException e) {
                System.out.println("Error: ingresa un número válido.");
            }
        }
    }
}