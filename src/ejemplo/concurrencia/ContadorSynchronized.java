package ejemplo.concurrencia;

/**
 * Created by Ricardo on 24/06/2015.
 * Clase 23
 */
public class ContadorSynchronized {
    private long contador;

    public synchronized long next() {
        return ++contador;
    }
}
