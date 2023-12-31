package EjercicioCuentaBancaria;

public class HiloDecremento extends Thread {

    private CuentaBancaria cuenta;

    public HiloDecremento(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                cuenta.retirar(100);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
