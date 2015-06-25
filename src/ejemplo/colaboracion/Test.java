package ejemplo.colaboracion;

/**
 * Created by Ricardo on 24/06/2015.
 * Clase 23
 */
public class Test {
    public static void main(String[] args) {
        Buffer b = new Buffer();
        Productor p1 = new Productor(b);
        Consumidor c1 = new Consumidor(b);

        p1.setName("Gi Wah");
        c1.setName("Gianfranco");

        p1.setPriority(Thread.MIN_PRIORITY);
        c1.setPriority(Thread.MAX_PRIORITY);

        System.out.println("\nSe abre la tiendita");
        p1.start();
        c1.start();

        try {
            p1.join();
            c1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSe cierra la tiendita");
    }
}
