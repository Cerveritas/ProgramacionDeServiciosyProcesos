package EjercicioCuentaBancaria;

public class main {
    public static void main(String[] args)  {
        CuentaBancaria cuenta = new CuentaBancaria(0);

        HiloIncremento hiloIncremento = new HiloIncremento(cuenta);
        HiloDecremento hiloDecremento = new HiloDecremento(cuenta);

        hiloIncremento.start();
        hiloDecremento.start();


        try {
            hiloDecremento.join();
            hiloIncremento.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + cuenta.consultarSaldo());
    }
}
