package Clases_Entidades;

import Clases_Herramientas.Consola;

import java.util.Random;
import java.util.Scanner;

public class Gato {
    //Atributos:
    Random rnd = new Random();
    Scanner MyScanner = new Scanner(System.in);
    Gato gato_enemigo; // ! El gato enemigo en el combate
    // ------------------------------ Estadisticas del Gato ------------------------------
    private int fuerza; // ! Fuerza (Para calcular el daño del ataque)
    private int hp_maximo; // ! Vida maxima (total) del gato
    private int hp_actual; // ! Vida actual del gato
    private int suerte; // ! Afecta al golpe critico. (1-5)
    private int defensa; // ! Tanquea puntos de daño.

    // ------------------------------ Atributos del Gato ------------------------------
    private String nombre; // El nombre del gato
    private String apodo; // Un apodo "amigable" del gato
    private String rol;

    //------------------------------ Historial del Gato ------------------------------
    private int combates; // Numero de combates total
    //Constructores:
    public Gato(boolean random) {
        newAtributos();
        if(random){
            newGatoR();
        }else{

        }
        newConfirmacion();
    }
    //Getters y setters:
    public String nombre(){return nombre;}
    public String apodo(){return apodo;}
    public String rol(){return rol;}
    public int fuerza(){return fuerza;}
    public int hp_maximo(){return hp_maximo;}
    public int hp_actual(){return hp_actual;}
    public int suerte(){return suerte;}
    public int defensa(){return defensa;}
    public Gato enemigo(){return gato_enemigo;}

    public void setGatoEnemigo(Gato gato) { gato_enemigo = gato; }
    public void restaurar(){hp_actual = hp_maximo;}
    public void setRol(String rol){this.rol = rol;}
    //Metodos:
    public boolean isAlive(){
        return hp_actual > 0;
    }

    public boolean obtenerCritico() {
        int chance = rnd.nextInt(1,10);
        if(suerte >= chance){
            return true;
        }
        return false;
    }

    public int ataque(boolean critico) {
        int daño_base = (fuerza);
        int daño_critico = 0;
        int chance = rnd.nextInt(1,10);
        if(critico){
            daño_critico = (daño_base);
        }
        int daño_total = (daño_base + daño_critico);
        return daño_total;
        // !!! gato_enemigo.recibirDaño(daño_total);
    }

    public void recibirDaño(int daño) {
        daño = Math.max(1,(daño - defensa));
        hp_actual = (hp_actual - daño);
        hp_actual = Math.max(hp_actual,0);
    }

    private void newGatoR() {
        //Metodo para obtener (random) las estadisticas del Gato
        fuerza = rnd.nextInt(6,11);
        hp_maximo = rnd.nextInt(20,35);
        hp_actual = hp_maximo;
        suerte = rnd.nextInt(2,5);
        defensa = rnd.nextInt(1,3);
    }

    private void newAtributos() {
        // Metodo para obtener los atributos basicos del Gato
        Consola.limpiar();
        System.out.println("|------------------------------|");
        System.out.println("|          Nuevo Gato!         |");
        System.out.println("|------------------------------|");
        System.out.print  ("|Ingresa su nombre: ");
        nombre = MyScanner.nextLine();
        System.out.print("|Ingresa su apodo: ");
        apodo = MyScanner.next();
    }

    private void newConfirmacion() {
        System.out.println("|------------------------------|");
        System.out.println("|           Atributos          |");
        System.out.println("|------------------------------|");
        System.out.println("|Fuerza: " + (fuerza));
        System.out.println("|HP: " + (hp_maximo));
        System.out.println("|Suerte: " + (suerte));
        System.out.println("|Defensa: " + (defensa));
        System.out.println("|------------------------------|");
        Consola.esperar();
    }
}
