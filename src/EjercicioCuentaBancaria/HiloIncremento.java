package EjercicioCuentaBancaria;

public class HiloIncremento extends Thread {

    private CuentaBancaria cuenta;

    public HiloIncremento(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            cuenta.ingreso(150);
        }
    }
}
