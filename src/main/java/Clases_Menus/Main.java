package Clases_Menus;

import Clases_Entidades.Gato;
import Clases_Herramientas.Consola;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    //Atributos:
    private static ArrayList<Gato> arreglo_gatos = new ArrayList<>();
    private static CampoEntrenamiento campo_entrenamiento;
    //Funciones:
    public static void main(String[] args){
        int opcion = 0;
        while(opcion != 9){
            opcion = opcionesLobby();
            lobby(opcion);
        }
    }

    public static int opcionesLobby(){
        Consola.limpiar();
        Scanner MyScanner = new Scanner(System.in);
        System.out.println("|------------------------------|");
        System.out.println("|           mewgatos           |");
        System.out.println("|------------------------------|");
        System.out.println("|1. Crear nuevo gato           |");
        System.out.println("|2. Ver tus gatos              |");
        System.out.println("|3. Campo de entrenamiento     |");
        System.out.println("|9. Salir                      |");
        System.out.println("|------------------------------|");
        System.out.print("Ingresa una opcion: ");
        return MyScanner.nextInt();
    }

    public static void lobby(int opcion){
        switch(opcion){
            case 1 -> {arreglo_gatos.add(new Gato(true));}
            case 2 -> {mostrarGatos();}
            case 3 -> {campo_entrenamiento = new CampoEntrenamiento(arreglo_gatos);}
            case 9 -> {}
            default -> {}
        }
    }

    public static void mostrarGatos(){
        Consola.limpiar();
        System.out.println("|------------------------------|");
        System.out.println("|            Gatos!            |");
        System.out.println("|------------------------------|");
        if(arreglo_gatos.isEmpty()){
            System.out.println("[Algo terrible ha pasado!] No tienes gatos...");
            Consola.esperar();
            return;
        }
        for(Gato gato : arreglo_gatos){
            System.out.println("|Apodo: " + gato.apodo());
            System.out.println("|------------------------------|");
            System.out.println("|Fuerza: " + (gato.fuerza()));
            System.out.println("|HP: " + (gato.hp_maximo()));
            System.out.println("|Suerte: " + (gato.suerte()));
            System.out.println("|Defensa: " + (gato.defensa()));
            System.out.println("|------------------------------|");
        }
        Consola.esperar();
    }

}
