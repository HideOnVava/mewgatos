package Clases_Menus;

import Clases_Entidades.Gato;
import Clases_Herramientas.Consola;

import java.util.ArrayList;
import java.util.Scanner;

public class CampoEntrenamiento{
    //Atributos:
    Scanner MyScanner = new Scanner(System.in);
    Gato heroe;
    Gato villano;
    ArrayList<Gato> arreglo;
    //Constructores:
    public CampoEntrenamiento(ArrayList<Gato> arreglo){
        this.arreglo = arreglo;
        newIniciar();
    }
    //Metodos:
    private void newIniciar(){
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
    private void newEscoger(){
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

    private void newBatallaR(){
        Consola.limpiar();
        heroe.setGatoEnemigo(villano);
        villano.setGatoEnemigo(heroe);
        System.out.println("|------------------------------|");
        System.out.println("|             Pelea!           |");
        System.out.println("|------------------------------|");
        boolean turno = true;
        // ! Simulamos una pelea mientras ambos esten vivos.
        while(heroe.isAlive() && villano.isAlive()){
            turnoActual(turno);
            turno = (!turno);
        }
        // ! Mostramos al vencedor!
    }

    private void turnoActual(boolean turno){
        if(turno){ // ! Turno del heroe.
            System.out.println("          Turno del Heroe " + heroe.apodo() + "!");
            int daño = heroe.ataca();
            System.out.println("El heroe ha realizado un ataque con " + daño + " de daño!");
            villano.recibirDaño(daño);
            System.out.println("El villano ha recibido el ataque!");
            System.out.println("Vida actual del villano: " + villano.hp_actual() + "/" + villano.hp_maximo());
        }else{ // ! Turno del villano!
            System.out.println("          Turno del Villano " + villano.apodo() + "!");
            int daño = villano.ataca();
            System.out.println("El villano ha realizado un ataque con " + daño + " de daño!");
            heroe.recibirDaño(daño);
            System.out.println("El heroe ha recibido el ataque!");
            System.out.println("Vida actual del heroe: " + heroe.hp_actual() + "/" + heroe.hp_maximo());
        }
        Consola.esperar();
        System.out.println("|------------------------------|");
    }

    private void newGanador(){
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
