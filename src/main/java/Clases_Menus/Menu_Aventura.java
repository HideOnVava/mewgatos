package Clases_Menus;

import Clases_Entidades.Gato;
import Clases_Extras.Campo_Entrenamiento;
import Clases_Herramientas.Consola;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu_Aventura {
    //Atributos de la clase:
    private ArrayList<Gato> arreglo_gatos;
    private Campo_Entrenamiento campo_entrenamiento;
    private Menu_Gatos menu_gatos;
    //Constructores:
    public Menu_Aventura(ArrayList<Gato> arreglo_gatos, Campo_Entrenamiento campo_entrenamiento, Menu_Gatos menu_gatos) {
        this.arreglo_gatos = arreglo_gatos;
        this.campo_entrenamiento = campo_entrenamiento;
        this.menu_gatos = menu_gatos;
    }
    //Metodos getter y setter:
    //Metodos de la clase:
    public void aventura_inicio() {
        char opcion_usuario = ' ';
        while(opcion_usuario != 'X') {
            opcion_usuario = aventura_opciones();
            aventura_switch(opcion_usuario);
        }
    }

    public void aventura_switch(char opcion_usuario) {
        switch(opcion_usuario) {
            case '1' -> {
                aventura_añadirGato();
            }
            case '2' -> {
                if(aventura_validarGatos()){
                    break;
                }
                menu_gatos.menuGatos_inicio();
            }
            case '3' -> {
                campo_entrenamiento.campoEntrenamiento_inicio();
            }
            case 'X' -> {

            }
            default -> {

            }
        }
    }

    public boolean aventura_validarGatos() {
        Consola.limpiar();
        if(arreglo_gatos.isEmpty()) {
            System.out.println("|------------------------------|");
            System.out.println("|            Gatos!            |");
            System.out.println("|------------------------------|");
            System.out.println("| Algo horrible ha ocurrido!   |");
            System.out.println("| No hay gatos :c              |");
            System.out.println("|------------------------------|");
            Consola.esperar();
            return true;
        }
        return false;
    }

    public void aventura_añadirGato() {
        Consola.limpiar();
        Scanner MyScanner = new Scanner(System.in);
        // ! En este metodo exclusivamente se creeara un gato y añadira al arreglo_gatos.
        System.out.println("|------------------------------|");
        System.out.println("|          Nuevo gato          |");
        System.out.println("|------------------------------|");
        System.out.print("Nombra a tu gato: ");
        String nombre = MyScanner.nextLine();
        System.out.print("Ponle un apodo: ");
        String apodo = MyScanner.next();
        Gato gato = new Gato(nombre,apodo);
        gato.mostrarGato();
        Consola.esperar();
        arreglo_gatos.add(gato);
    }

    public char aventura_opciones() {
        Consola.limpiar();
        Scanner MyScanner = new Scanner(System.in);
        System.out.println("|------------------------------|");
        System.out.println("|           Aventura           |");
        System.out.println("|------------------------------|");
        System.out.println("|1. Crear nuevo gato           |");
        System.out.println("|2. Ver tus gatos              |");
        System.out.println("|3. Campo de entrenamiento     |");
        System.out.println("|X. Menu                       |");
        System.out.println("|------------------------------|");
        System.out.print("Ingresa una opcion: ");
        return MyScanner.next().charAt(0);
    }
}
