package ejemplo.uno;

/**
 * Created by Ricardo on 19/06/2015.
 * Clase 22
 */

/**
 * Primera Forma : extends Thread
 * Segunda Forma : implements Runnable
 */
class Test01 {
    public static void main(String[] args) throws InterruptedException {
        QueMiedo qm = new QueMiedo();
        Thread t = new Thread(qm);
        t.setName("Threadsito");
        t.setPriority(Thread.MAX_PRIORITY);

        QueMiedo qm2 = new QueMiedo();
        Thread t2 = new Thread(qm2);
        t2.setName("Threadson");
        t.setPriority(Thread.MIN_PRIORITY);

        t.start();
        t2.start();

        //Detener la ejecucion del hilo principal hasta que t termine
        //WAIT, SIGNAL
        //Broadcast
        t.join();
        t2.join();
        System.out.println("Termine !");
    }
}
