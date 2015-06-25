package ejemplo.tipodehilos;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 24/06/2015.
 * Clase 23
 */
public class TestDaemons {
    public static void main(String[] args) {
        System.out.println("\n Iniciando Main");
        //En Java 7 y 8 se pueden crear hilos asi...
        //Tiene que ser un metodo estatico que devuelva void, Clase:metodo
        Thread t = new Thread(TestDaemons::corre);
        //Cuando es true, es un daemon thread
        //El hilo termina cuando el main termina
        t.setDaemon(false);
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n Terminando Main");
    }

    public static void corre() {
        int contador = 1;
        while (true) {
            try {
                System.out.println(Thread.currentThread() + " " + contador++);
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                //Cuando el DAemon es true, esto no se ejecuta
                System.out.println("finally");
            }
        }
    }
}
