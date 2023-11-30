package EjercicioCuentaBancaria;

public class CuentaBancaria {

    private double saldo;



    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double cantidad) {
        synchronized (this) {
            saldo += cantidad;
        }
    }

    public void retirar(double cantidad) throws Exception {
        synchronized (this) {
            if (saldo < cantidad) {
                throw new Exception("No hay suficiente saldo");
            }
            saldo -= cantidad;
        }
    }

    public double consultarSaldo() {
        synchronized (this) {
            return saldo;
        }
    }
}
