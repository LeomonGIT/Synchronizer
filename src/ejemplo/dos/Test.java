package ejemplo.dos;

/**
 * Created by Ricardo on 19/06/2015.
 * Clase 22
 */
class Test {
    public static void main(String[] args) throws InterruptedException {
        //Creamos la estructura comun
        SimpleArray sa = new SimpleArray(6);

        System.out.println("Iniciando");
        System.out.println(sa);


        Thread t1 = new Thread(new ArrayWriter(2, sa));
        t1.setName("Thread A");
        Thread t2 = new Thread(new ArrayWriter(11, sa));
        t2.setName("Thread B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Terminando");
        System.out.println(sa);
    }
}
