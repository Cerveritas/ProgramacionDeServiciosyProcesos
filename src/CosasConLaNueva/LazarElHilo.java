package CosasConLaNueva;

public class LazarElHilo {
    public static void main(String[] args) {


        Thread h1 = new Thread(new hiloEjemplo4("H1"));
        Thread h2 = new Thread(new hiloEjemplo4("H2"));

        h1.start();
        h2.start();


        try {
            h1.join();
            h2.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido");
        }
        System.out.println("Hilo principal terminado");


    }
}
