package PrimerTrismestre.Recordatorio;

public class Auxiliar extends Recordatorio {


    private float salario;
    private final double PI = 3.14;


    public Auxiliar(int edad, String nombre, float salario) {
        super(edad, nombre);
        this.salario = salario;
    }


    // metodo funcion
    public float recalculo_salario(){

        return salario + 1000;
    }

    // metodo procedimiento

    public void imprimirSalario(){
        System.out.println("EL salario nuevo es "+salario);
    }


    // toString
    @Override
    public String toString() {
        return "Auxiliar{" +
                "salario=" + salario +
                ", PI=" + PI +
                '}';
    }
}
