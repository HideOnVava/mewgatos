package Clases_Herramientas;

import java.util.Scanner;

public class Consola {

    public static void limpiar() {
        for(int i = 0; i < 15; i++){
            System.out.println();
        }
    }

    public static void esperar() {
        Scanner MyScanner = new Scanner(System.in);
        System.out.print("Presiona [enter] para continuar...");
        MyScanner.nextLine();
    }

    public static void esperar2() {
        Scanner MyScanner = new Scanner(System.in);
        MyScanner.nextLine();
    }
}
