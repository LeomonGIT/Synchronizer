package edu.ulima.phases;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/*
Phaser: Espera que todos acaben la fase en la que estan, para empezar la otra; ejemplo, esperar que 3 proveedoras lleguen al camion, 
para recien empezar con la fase de transporte.
*/

public class TareaPhaser extends Thread{
    private Phaser phaser;
    private String nombre;
    private static Random r = new Random();

    public TareaPhaser(Phaser phaser, String nombre) {
        this.phaser = phaser;
        this.nombre = nombre;
    }
    
    public void run(){
        System.err.println("Iniciando...");
        int dormirTime = r.nextInt(10)+1;
        
        try {
            TimeUnit.SECONDS.sleep(dormirTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("Esperando completar fase");
        
        phaser.arriveAndAwaitAdvance();
        
        
        System.err.println(" pasando la fase...");
    }
}
