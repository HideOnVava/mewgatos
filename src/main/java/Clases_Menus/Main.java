package Clases_Menus;

import Clases_Herramientas.Consola;

import java.util.Scanner;

public class Main{
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
            case 1 -> {}
            case 2 -> {}
            case 3 -> {}
            case 9 -> {}
            default -> {}
        }
    }

}
