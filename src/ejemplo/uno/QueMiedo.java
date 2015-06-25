package ejemplo.uno;

/**
 * Created by Ricardo on 19/06/2015.
 * Semana 22
 */
class QueMiedo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " | " + i * i);
        }
    }
}
