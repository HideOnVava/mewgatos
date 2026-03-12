package Clases_Extras;

import Clases_Entidades.Gato;
import Clases_Herramientas.Consola;

import java.util.ArrayList;
import java.util.Scanner;

public class Campo_Entrenamiento {
    //Atributos de la clase:
    private ArrayList<Gato> arreglo_gatos;
    private Gato gato_heroe;
    private Gato gato_villano;
    //Constructores:
    public Campo_Entrenamiento(ArrayList<Gato> arreglo_gatos) {
        this.arreglo_gatos = arreglo_gatos;
    }
    //Metodos getter y setter:
    //Metodos:
    public void campoEntrenamiento_inicio() {
        Consola.limpiar();
        System.out.println("|------------------------------|");
        System.out.println("|       Campo Entrenamiento    |");
        System.out.println("|------------------------------|");
        campoEntrenamiento_escogerGatos();
        campoEntrenamiento_simularBatalla();
        campoEntrenamiento_declararGanador();
    }

    private void campoEntrenamiento_escogerGatos() {
        Scanner MyScanner = new Scanner(System.in);
        for(int i = 0; i < arreglo_gatos.size(); i++){
            Gato gato = arreglo_gatos.get(i);
            System.out.println("|ID " + (i) + ". " + gato.getApodo());
        }
        System.out.println("|------------------------------|");
        gato_heroe = seleccionarGatoValido("Selecciona el ID del héroe: ");
        gato_villano = seleccionarGatoValido("Selecciona el ID del villano: ");
        while(gato_heroe == gato_villano) {
            System.out.println("[Error] ¡Un gato no puede pelear contra sí mismo!");
            gato_villano = seleccionarGatoValido("Selecciona un ID diferente para el villano: ");
        }
        System.out.println("|------------------------------|");
        System.out.println("¡Combate listo: [" + gato_heroe.getApodo() + "] VS [" + gato_villano.getApodo() + "]!");
        Consola.esperar();
    }

    private Gato seleccionarGatoValido(String mensaje) {
        Scanner MyScanner = new Scanner(System.in);
        int id = -1;
        while(id < 0 || id >= arreglo_gatos.size()) {
            System.out.print(mensaje);
            if(MyScanner.hasNextInt()) {
                id = MyScanner.nextInt();
                if (id < 0 || id >= arreglo_gatos.size()) {
                    System.out.println("[Error] ID fuera de rango. Intenta de nuevo.");
                }
            }else {
                System.out.println("[Error] Entrada inválida. Ingresa un número.");
                MyScanner.next();
            }
        }
        return arreglo_gatos.get(id);
    }

    private void campoEntrenamiento_simularBatalla() {
        Consola.limpiar();
        gato_heroe.setRol("Héroe");
        gato_villano.setRol("Villano");
        gato_heroe.setGatoEnemigo(gato_villano);
        gato_villano.setGatoEnemigo(gato_heroe);

        System.out.println("|------------------------------|");
        System.out.println("|      ¡Comienza la Pelea!     |");
        System.out.println("|------------------------------|");
        Consola.esperar();
        int ronda = 1;
        Gato atacante = gato_heroe;
        Gato defensor = gato_villano;
        // Bucle principal de la pelea
        while (gato_heroe.isAlive() && gato_villano.isAlive()) {
            ejecutarTurno(atacante, defensor, ronda);
            Gato temporal = atacante;
            atacante = defensor;
            defensor = temporal;
            if (atacante == gato_heroe) {
                ronda++;
            }
        }
    }

    private void ejecutarTurno(Gato atacante, Gato defensor, int ronda) {
        Consola.limpiar();
        System.out.println("|------------------------------|");
        System.out.println("| Ronda " + ronda + " | Turno del " + atacante.rol());
        System.out.println("|------------------------------|");
        boolean esCritico = atacante.obtenerCritico();
        int daño = atacante.ataque(esCritico);
        System.out.println("| [" + atacante.getApodo() + "] ataca a [" + defensor.getApodo() + "]!");
        if(esCritico) {
            System.out.println("| ¡ES UN GOLPE CRÍTICO!");
        }
        System.out.println("| Ha infligido " + daño + " puntos de daño.");
        defensor.recibirDaño(daño);
        System.out.println("| [" + defensor.getApodo() + "] queda con " + defensor.getHp_actual() + "/" + defensor.calcularVidaMaxima() + " HP.");
        System.out.println("|------------------------------|");
        Consola.esperar();
    }

    private void campoEntrenamiento_declararGanador() {
        Consola.limpiar();
        Gato ganador = gato_heroe.isAlive() ? gato_heroe : gato_villano;
        System.out.println("|------------------------------|");
        System.out.println("|           ¡Ganador!          |");
        System.out.println("|------------------------------|");
        System.out.println("[¡Increíble!] El gato " + ganador.getApodo() + " ha vencido.");
        System.out.println("|------------------------------|");
        gato_heroe.restaurar();
        gato_villano.restaurar();
        Consola.esperar();
    }
}
