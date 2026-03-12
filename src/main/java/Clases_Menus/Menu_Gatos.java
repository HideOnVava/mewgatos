package Clases_Menus;

import Clases_Entidades.Gato;
import Clases_Herramientas.Consola;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu_Gatos {
    //Atributos de la clase:
    private ArrayList<Gato> arreglo_gatos;
    private Gato gato;
    private int indice_gato;
    //Constructores:
    public Menu_Gatos(ArrayList<Gato> arreglo_gatos) {
        this.arreglo_gatos = arreglo_gatos;
        int indice_gato = 0;
    }
    //Metodos getter y setter:
    public void menuGatos_inicio() {
        gato = arreglo_gatos.get(indice_gato); // ! Agregamos al gato actual.
        char opcion_usuario = ' ';
        while(opcion_usuario != 'X') {
            opcion_usuario = menuGatos_opciones();
            menuGatos_switch(opcion_usuario);
        }
    }

    public void menuGatos_switch(char opcion_usuario) {
        switch(opcion_usuario) {
            case '1' -> {
                menuGatos_mostrarPerfil();
                Consola.esperar();
            }
            case '2' -> {
                // En mantenimiento hasta la 0.3
            }
            case '3' -> {
                // En mantenimiento hasta la 0.2b
            }
            case 'A' -> {
                if((indice_gato - 1) == -1) {
                    indice_gato = (arreglo_gatos.size() - 1);
                }else {
                    indice_gato--;
                }
            }
            case 'D' -> {
                if((indice_gato + 1) == arreglo_gatos.size()) {
                    indice_gato = 0;
                }else {
                    indice_gato++;
                }
            }
            case 'X' -> {

            }
            default -> {

            }
        }
    }

    public void menuGatos_mostrarPerfil() {
        gato.mostrarGato();
    }

    public char menuGatos_opciones() {
        Consola.limpiar();
        Scanner MyScanner = new Scanner(System.in);
        // ! Metodo para mostrar todo sobre el gato actual.
        System.out.println("|------------------------------|");
        System.out.println("          Gato [" + gato.getApodo() + "]");
        System.out.println("          HP: " + gato.getHp_actual() + "/" + gato.calcularVidaMaxima());
        System.out.println("|------------------------------|");
        System.out.println("|1. Perfil                     |");
        System.out.println("|2. Mochila                    |");
        System.out.println("|3. Puntos de habilidad        |");
        System.out.println("|A. Anterior gato              |");
        System.out.println("|D. Siguiente gato             |");
        System.out.println("|X. Regresar                   |");
        System.out.println("|------------------------------|");
        System.out.print("Ingresa una opcion: ");
        return MyScanner.next().charAt(0);
    }
}
