package ejemplo.uno;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Ricardo on 19/06/2015.
 * Repasando
 */
class QueMiedoObserver implements Observer, Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " | " + i * i);
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
