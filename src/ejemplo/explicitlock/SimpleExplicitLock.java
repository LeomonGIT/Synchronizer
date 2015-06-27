package ejemplo.explicitlock;

/**
 * Created by Ricardo on 26/06/2015.
 * Clase 23
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleExplicitLock {

    static long value = 0;
    private Lock myLock = new ReentrantLock();

    public void actualizaValor() {
        // Adquirir el lock
        myLock.lock();
        try {
            value++;
            System.out.println(Thread.currentThread() + " " + value);
        } finally {
            myLock.unlock();
        }
    }

}
