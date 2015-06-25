package ejemplo.concurrencia;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 24/06/2015.
 * Clase 23
 */
public class Test {
    //static ContadorSynchronized cs = new ContadorSynchronized();
    static ContadorAtomico cs = new ContadorAtomico();

    public static void main(String[] args) {
        System.out.println("\n *** Inicinado MAIN");
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(Test::corre);
            t1.setDaemon(false);
            t1.start();
        }
    }

    public static void corre() {
        while (true) {
            try {
                System.out.println(Thread.currentThread() + "--> " + cs.next());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
