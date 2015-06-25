package ejemplo.concurrencia;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ricardo on 24/06/2015.
 * Clase 23
 */
public class ContadorAtomico {
    private AtomicLong contador = new AtomicLong(0L);

    //No necesito usar synchronized
    //Tiene moetodos
    public long next() {
        return contador.incrementAndGet();
    }
}
