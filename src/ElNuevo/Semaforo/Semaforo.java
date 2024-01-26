package ElNuevo.Semaforo;

public class Semaforo {

private boolean verde = true;

public synchronized void esperarVerde() throws InterruptedException {
        while (!verde) {
        wait();
        }
        }

public synchronized void esperarRojo() throws InterruptedException {
        while (verde) {
        wait();
        }
        }

public synchronized void cambiarAVerde() {
        verde = true;
        notifyAll();
        }

public synchronized void cambiarARojo() {
        verde = false;
        notifyAll();
        }
        }

