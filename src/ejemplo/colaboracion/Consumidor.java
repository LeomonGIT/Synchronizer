package ejemplo.colaboracion;

/**
 * Created by Ricardo on 24/06/2015.
 * Clase 23
 */
public class Consumidor extends Thread {
    private Buffer b;

    public Consumidor(Buffer b) {
        this.b = b;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + " consume ... " + b.consumir());
        }
        Thread.yield();
    }
}
