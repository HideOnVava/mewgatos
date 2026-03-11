package Clases_Menus;

import Clases_Entidades.Gato;
import Clases_Herramientas.Consola;

import java.util.ArrayList;
import java.util.Scanner;

public class CampoEntrenamiento {
    //Atributos:
    Scanner MyScanner = new Scanner(System.in);
    Gato heroe;
    Gato villano;
    ArrayList<Gato> arreglo;
    //Constructores:
    public CampoEntrenamiento(ArrayList<Gato> arreglo) {
        this.arreglo = arreglo;
        newIniciar();
    }
    //Metodos:
    private void newIniciar() {
        Consola.limpiar();
        System.out.println("|------------------------------|");
        System.out.println("|       Campo Entrenamiento    |");
        System.out.println("|------------------------------|");
        if(arreglo.size() < 2){
            System.out.println("[Algo terrible ha pasado!] No tienes suficientes gatos...");
            Consola.esperar();
            return;
        }
        newEscoger();
        newBatallaR();
        newGanador();
    }
    private void newEscoger() {
        System.out.println("|Gatos!");
        for(int i = 0; i < arreglo.size(); i++){
            Gato gato = arreglo.get(i);
            System.out.println("|ID " + (i) + ". " + gato.apodo());
        }
        System.out.println("|------------------------------|");
        System.out.print("|Ingresa el (id) del heroe: ");
        heroe = arreglo.get(MyScanner.nextInt());
        System.out.print("|Ingresa el (id) del villano: ");
        villano = arreglo.get(MyScanner.nextInt());
        System.out.println("|------------------------------|");
        System.out.println("Has seleccionado a los contrincantes!");
        Consola.esperar();
    }

    private void newBatallaR() {
        Consola.limpiar();
        heroe.setRol("heroe");
        villano.setRol("villano");
        heroe.setGatoEnemigo(villano);
        villano.setGatoEnemigo(heroe);
        System.out.println("|------------------------------|");
        System.out.println("|             Pelea!           |");
        System.out.println("|------------------------------|");
        boolean orden_turno = true;
        int numero_ronda = 1;
        int contador = 1;
        // ! Simulamos una pelea mientras ambos esten vivos.
        while(heroe.isAlive() && villano.isAlive()){
            // ! turnoActual(orden_turno,numero_ronda);
            combate(orden_turno,numero_ronda);
            orden_turno = (!orden_turno);
            if(contador % 2 == 0){
                numero_ronda++;
            }
            contador++;
        }
        // ! Mostramos al vencedor!
    }

    private void combate(boolean orden_turno, int ronda) {
        Consola.limpiar();
        Gato gato;
        if(orden_turno){ gato = heroe;} else { gato = villano;}
        System.out.println("|------------------------------|");
        System.out.println("|Ronda " + ronda + " | Turno del " + gato.rol());
        System.out.println("|------------------------------|");
        boolean esCritico = gato.obtenerCritico();
        int daño = gato.ataque(esCritico);
        if(esCritico){
            System.out.println("|El gato " + gato.apodo() + " ha realizado un ataque critico!");
        }else{
            System.out.println("|El gato " + gato.apodo() + " ha realizado un ataque!");
        }
        System.out.println("|Ha infligido un total de: " + daño + " de daño!");
        gato.enemigo().recibirDaño(daño);
        System.out.println("|El gato " + gato.enemigo().apodo() + " ha terminado con una vida de " + gato.enemigo().hp_actual() + "/" + gato.enemigo().hp_maximo());
        System.out.println("|------------------------------|");
        Consola.esperar();
    }

    private void newGanador() {
        Consola.limpiar();
        Gato ganador;
        if(heroe.isAlive()){
            ganador = heroe;
        }else{
            ganador = villano;
        }
        // ! Regeneramos la vida de ambos.
        heroe.restaurar(); villano.restaurar();
        System.out.println("|------------------------------|");
        System.out.println("|           Ganador!           |");
        System.out.println("|------------------------------|");
        System.out.println("[Increible!] El gato " + ganador.apodo() + " ha vencido!!!");
        System.out.println("|------------------------------|");
        Consola.esperar();
    }
}
