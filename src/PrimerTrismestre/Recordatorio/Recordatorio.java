package PrimerTrismestre.Recordatorio;

public class Recordatorio {


    //atributos

    private int edad;
    private String nombre;

    //constructor

    public Recordatorio(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }


    //getters and y setter


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}