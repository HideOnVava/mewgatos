package Clases_Entidades;

import Clases_Herramientas.Consola;

import java.util.Random;
import java.util.Scanner;

public class Gato {
    //Atributos de la clase Gato:
    private int fuerza;
    private int inteligencia;
    private int suerte;
    //Estadisticas de la clase Gato:
    private int nivel_actual;
    private int xp_actual;
    private int puntos_habilidad;
    private int hp_base;
    private int hp_maximo;
    private int hp_actual;
    private int defensa;
    //Atributos de la clase Gato:
    private String nombre; // El nombre del gato
    private String apodo; // Un apodo "amigable" del gato
    //Atributos en enfrentamiento:
    private Gato gato_enemigo;
    private String rol;
    //------------------------------ Historial del Gato ------------------------------
    private int combates; // ! Numero de combates total
    //Constructores:
    public Gato(String nombre, String apodo) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.nivel_actual = 1;
        this.xp_actual = 0;
        this.puntos_habilidad = 5;
        this.fuerza = 5;
        this.inteligencia = 5;
        this.suerte = 1;
        this.defensa = 0;
        this.hp_base = 20;
        this.hp_maximo = calcularVidaMaxima();
        this.hp_actual = hp_maximo;
    }
    //Getters y setters:
    public int calcularVidaMaxima() {
        int vida_maxima = hp_base + (fuerza * 2);
        return vida_maxima;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApodo() {
        return apodo;
    }
    public String rol(){return rol;}
    public int fuerza(){return fuerza;}
    public int hp_maximo(){return hp_maximo;}
    public int getHp_actual(){return hp_actual;}
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
        Random rnd = new Random();
        int chance = rnd.nextInt(1,10);
        if(suerte >= chance){
            return true;
        }
        return false;
    }

    public int ataque(boolean critico) {
        int daño_base = (fuerza);
        int daño_critico = 0;
        if(critico){
            daño_critico = (daño_base);
        }
        int daño_total = (daño_base + daño_critico);
        return daño_total;
    }

    public void recibirDaño(int daño) {
        daño = Math.max(1,(daño - defensa));
        hp_actual = (hp_actual - daño);
        hp_actual = Math.max(hp_actual,0);
    }

    public void mostrarGato() {
        Consola.limpiar();
        System.out.println("|------------------------------|");
        System.out.println("|            Perfil            |");
        System.out.println("|------------------------------|");
        System.out.println("|Nombre del gato: " + nombre);
        System.out.println("|Apodo del gato: " + apodo);
        System.out.println("|-----------Atributos----------|");
        System.out.println("|Fuerza: " + fuerza + " | Inteligencia: " + inteligencia);
        System.out.println("|Suerte: " + suerte + " | Defensa: " + defensa);
        System.out.println("|------------------------------|");
        System.out.println("|Nivel: " + nivel_actual + " | Experiencia: " + xp_actual + "/100");
        System.out.println("|Puntos de habilidad disponibles: " + puntos_habilidad);
        System.out.println("|------------------------------|");
    }
}
