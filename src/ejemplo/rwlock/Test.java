package ejemplo.rwlock;

/**
 * Created by Ricardo on 26/06/2015
 * Clase 24
 */
public class Test {
    static RWLock rw = new RWLock(" * ");

    public static void main(String[] args) {
        System.out.println("\n * * * Inicio ");
        Thread t1 = new Thread(Test::lector);
        Thread t2 = new Thread(Test::escritorX);
        Thread t3 = new Thread(Test::escritorY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
        }
        System.out.println("\n * * * Fin ");
    }

    public static void lector() {
        for ( int i=0; i < 10;i++) {
            System.out.println( Thread.currentThread().getId()
                    + " Leyendo --> " + rw.getValue()    );
        }
    }

    public static void escritorX() {
        for ( int i=0; i < 10;i++) {
            rw.setValue(" X"+i);
        }
    }

    public static void escritorY() {
        for ( int i=0; i < 10;i++) {
            rw.setValue(" Y"+i);
        }
    }
}

