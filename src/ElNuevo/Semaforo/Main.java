package ElNuevo.Semaforo;

public class Main {
    public static void main(String[] args) {

        /*El código simula la implementación de
        un semáforo en Java y la coordinación de dos procesos (hilos)
        que imprimen mensajes en la consola.*/

        Semaforo semaforo = new Semaforo();

        Thread hilo1 = new Thread(new Proceso(semaforo, "Hilo 1 - Verde"));
        Thread hilo2 = new Thread(new Proceso(semaforo, "Hilo 2 - Rojo"));

        hilo1.start();
        hilo2.start();

        try {
            // Simula la ejecución durante un tiempo
            Thread.sleep(5000);

            // Cambia a verde después de 5 segundos
            semaforo.cambiarAVerde();

            // Simula la ejecución durante otro tiempo
            Thread.sleep(5000);

            // Detiene los hilos
            hilo1.interrupt();
            hilo2.interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
