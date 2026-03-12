package Clases_Menus;

import Clases_Entidades.Gato;
import Clases_Extras.Campo_Entrenamiento;
import Clases_Herramientas.Consola;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    //Atributos de la clase:
    private static ArrayList<Gato> arreglo_gatos;
    private static Menu_Aventura menu_aventura;
    private static Menu_Gatos menu_gatos;
    private static Menu_Configuracion menu_configuracion;
    private static Campo_Entrenamiento campo_entrenamiento;

    //Funciones de la clase:
    public static void main(String[] args) {
        menu_configuracion_inicial(); // ! Iniciamos todo lo necesario.
        char opcion_usuario = ' ';
        while(opcion_usuario != 'X'){
            opcion_usuario = menu_opciones();
            menu_switch(opcion_usuario);
        }
    }

    public static void menu_switch(char opcion_usuario) {
        switch(opcion_usuario) {
            case '1' -> {
                menu_aventura.aventura_inicio();
            }
            case '2' -> {

            }
            case 'X' -> {

            }
            default -> {

            }
        }
    }

    public static char menu_opciones() {
        Consola.limpiar();
        Scanner MyScanner = new Scanner(System.in);
        System.out.println("|------------------------------|");
        System.out.println("|           Mewgatos           |");
        System.out.println("|------------------------------|");
        System.out.println("|1. Ir a la aventura           |");
        System.out.println("|2. Configuracion              |");
        System.out.println("|X. Salir                      |");
        System.out.println("|------------------------------|");
        System.out.print("Ingresa una opcion: ");
        return MyScanner.next().charAt(0);
    }

    //Metodos de inicio:
    public static void menu_configuracion_inicial() {
        // ! Iniciamos los objetos necesarios con el arreglo_gatos.
        arreglo_gatos = new ArrayList<>();
        menu_gatos = new Menu_Gatos(arreglo_gatos);
        menu_configuracion = new Menu_Configuracion(arreglo_gatos);
        campo_entrenamiento = new Campo_Entrenamiento(arreglo_gatos);
        menu_aventura = new Menu_Aventura(arreglo_gatos,campo_entrenamiento,menu_gatos);
    }
}
