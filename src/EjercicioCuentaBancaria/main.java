package EjercicioCuentaBancaria;

public class main {
    public static void main(String[] args) throws InterruptedException {
        CuentaBancaria cuenta = new CuentaBancaria(1000);

        HiloIncremento hiloIncremento = new HiloIncremento(cuenta);
        HiloDecremento hiloDecremento = new HiloDecremento(cuenta);

        hiloIncremento.start();
        hiloDecremento.start();

        hiloIncremento.join();
        hiloDecremento.join();

        System.out.println("Saldo final: " + cuenta.consultarSaldo());
    }
}
