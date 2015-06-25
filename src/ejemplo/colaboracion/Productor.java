package ejemplo.colaboracion;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 24/06/2015.
 * Clase 23
 */
public class Productor extends Thread {
    private Buffer b;

    public Productor(Buffer b) {
        this.b = b;
    }

    //la logica del Thread
    public void run() {
        for (int i = 0; i < 10; i++) {
            String queProducir = Buffer.productos[i];
            try {
                int dormir = (int) (Math.random() * 10000);
                TimeUnit.MILLISECONDS.sleep(dormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " produce ... " + queProducir);
            b.producir(queProducir);
        }
    }
}
