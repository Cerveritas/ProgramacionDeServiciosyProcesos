package ElNuevo.SocketsEjercicios;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientePresentacion {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: java ClientePresentacion <servidor> <puerto> <nombre>");
            //e.g IP_delServer(en nuestro caso localhost o la dirección IP 127.0.0.1) | Puerto | nombredelcliente
            // localhost 1789 esteesminombredecliente
            System.exit(1);
        }
        /* Pasar parámetros Servidor localhost , puerto 1789 nombrecliente*/
        //String servidor = args[0];
        String servidor = "127.0.0.1";
        //int puerto = Integer.parseInt(args[1]);
        int puerto = 1666;
        String nombre = args[2];

        try {
            Socket socket = new Socket(servidor, puerto);
            System.out.println("Conectado al servidor en " + servidor + ":" + puerto);

            // Enviar la presentación al servidor
            sendPresentation(socket, nombre);

        } catch (UnknownHostException e) {
            System.err.println("No se puede resolver el nombre del host: " + servidor);
        } catch (IOException e) {
            System.err.println("Error al conectar con el servidor: " + e.getMessage());
        }
    }

    private static void sendPresentation(Socket socket, String nombre) throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(nombre);
        System.out.println("Te has presentado al servidor como '" + nombre + "'.");

        // Puedes realizar otras acciones aquí según sea necesario
    }
}
