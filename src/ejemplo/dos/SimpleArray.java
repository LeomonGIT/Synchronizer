package ejemplo.dos;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ricardo on 19/06/2015.
 * Clase 22
 */
class SimpleArray {
    private final int[] a;
    private int index = 0;
    private final static Random randito = new Random();

    public SimpleArray(int size) {
        a = new int[size];
    }

    //Sección Critica: synchronized, se ejecuta una a la vez
    public synchronized void agregaReferencia(int valor) {
        int pos = index;
        //dormir el hilo una cantida de milisegundos
        try {
            Thread.sleep(randito.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a[pos] = valor;
        System.out.println(Thread.currentThread().getName() + "\t" + valor + "\t" + pos);
        System.out.println(Thread.currentThread().getName() + "\t Siguiente posicion: " + ++index);
    }

    @Override
    public String toString() {
        return Arrays.toString(a);
    }
}





