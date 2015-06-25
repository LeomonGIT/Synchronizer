package ejemplo.tipodehilos;

/**
 * Created by Ricardo on 24/06/2015.
 * Clase 23
 */
public class TestGrupos {
    public static void main(String[] args) {
        //Obtener el hilo principal del programa
        Thread t1 = Thread.currentThread();
        ThreadGroup tg1 = t1.getThreadGroup();

        System.out.println("Current Thread :" + t1.getName());
        System.out.println("Current Thread Group: " + tg1.getName());

        Thread t2 = new Thread("Dos");
        ThreadGroup tg2 = t2.getThreadGroup();
        System.out.println("Thread :" + t2.getName());
        System.out.println("Thread Group: " + tg2.getName());

        ThreadGroup tg3= new ThreadGroup("FOX");
        //Asignar un hilo a este grupo
        Thread t3 = new Thread(tg3,"Pokemon");
        System.out.println("Thread :" + t3.getName());
        System.out.println("Thread Group: " + tg3.getName());

    }
}
