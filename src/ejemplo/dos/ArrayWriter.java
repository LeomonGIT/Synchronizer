package ejemplo.dos;

/**
 * Created by Ricardo on 19/06/2015.
 * Clase 22
 */
class ArrayWriter implements Runnable {
    private final SimpleArray compartido;
    private final int ini;

    public ArrayWriter(int valorInicio, SimpleArray a) {
        ini = valorInicio;
        compartido = a;
    }

    @Override
    public void run() {
        for (int i = ini; i < ini + 3; i++) {
            compartido.agregaReferencia(i);
            System.out.println(Thread.currentThread().getName() + "-->" + compartido);
        }
    }
}
