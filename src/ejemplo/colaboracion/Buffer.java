package ejemplo.colaboracion;

/**
 * Created by Ricardo on 24/06/2015.
 * Clase 23
 */
public class Buffer {
    //Estructrura con los items a producutr
    public static final String[] productos = {
            "pan", "jamon", "queso", "alcohol", "sustancias prohibidas", "sangrecita", "higado", "sushi", "el men", " las rptas del examen"};

    //almmacena el producto actual en strock
    private String item;
    //flag que indica si hay stock o no
    private boolean hayStock;

    public Buffer() {
        hayStock = false;
    }

    public synchronized void producir(String val) {
        while (hayStock) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Asignamos que item debemos producir
        item = val;
        //Indicar que hay stock producto
        hayStock = true;
        //Notificar a los hijos que esten esperando
        notifyAll();
    }

    //Este es el metodo del consumidor
    public synchronized String consumir() {
        while (!hayStock) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hayStock = false;
        return item;
    }

}
