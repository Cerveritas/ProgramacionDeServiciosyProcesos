package ElNuevo.Semaforo;

public class Proceso implements Runnable {

        private Semaforo semaforo;
        private String mensaje;

        public Proceso(Semaforo semaforo, String mensaje) {
            this.semaforo = semaforo;
            this.mensaje = mensaje;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    semaforo.esperarVerde();
                    System.out.println(mensaje);
                    Thread.sleep(1000); // Simula el trabajo del proceso
                    semaforo.cambiarARojo();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

