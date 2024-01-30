package Chat;


public class Main {

    public static void main(String[] args) {
        ServidorSocketStream servidor = new ServidorSocketStream();
        ClienteSocketStream cliente = new ClienteSocketStream();

        servidor.start();
        cliente.start();


    }
}
