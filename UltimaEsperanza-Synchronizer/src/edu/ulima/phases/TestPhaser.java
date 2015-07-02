
package edu.ulima.phases;

import java.util.concurrent.Phaser;

/**
 * Si es una fase, se usa barrier; caso contrario (>1 fase) phaser. Ya que da mayor control en control de fases.
 * 
 */
public class TestPhaser {

    static int CUANTOS_HILOS=3;
    public static void main(String[] args) {
        Phaser phaser = new Phaser(CUANTOS_HILOS);
        
        for (int i = 0; i < CUANTOS_HILOS; i++) {
            phaser.register();//registra nuevo
            String nombre ="PARTICIPANTE-"+i;
            TareaPhaser t = new TareaPhaser(phaser, nombre);//asigna un nuevo hilo sincronicador con cada phaser y su nombre
            t.start();
        }//del for
        //aqui de-registramos todos
        phaser.arriveAndDeregister();//
    }
    
}
