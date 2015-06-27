package ejemplo.rwlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Ricardo on 26/06/2015.
 * Clase 23
 */
public class RWLock {
    private String value;
    // true indica que la politica de FAIR es FIFO
    private ReentrantReadWriteLock rwLock =
            new ReentrantReadWriteLock(true);
    private Lock rLock = rwLock.readLock();
    private Lock wLock = rwLock.writeLock();

    // constructor
    public RWLock(String value) {
        this.value = value;
    }

    // Setter & Getters
    public String getValue() {
        rLock.lock();
        try {
            return this.value;
        } finally {
            rLock.unlock();
        }
    }

    public void setValue(String value) {
        wLock.lock();
        try {
            this.value = this.value.concat(value);
        } finally {
            wLock.unlock();
        }

    }
}