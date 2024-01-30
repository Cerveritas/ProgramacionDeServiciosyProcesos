package ElNuevo.SocketsEjercicios.DeLaPresentacion;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteSocketStream {
    public static void main(String[] args) {
        System.out.println("Creando socket cliente");
        try (Socket clientSocket = new Socket()) {
            System.out.println("Estableciendo la conexión");
            // Para indicar la dirección IP y el número de puerto del socket stream servidor
            // al que se desea conectar, el método connect() hace uso de un objeto
            // de la clase java.net.InetSocketAddress.
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            clientSocket.connect(addr);
            try (InputStream is = clientSocket.getInputStream();
                 OutputStream os = clientSocket.getOutputStream();
                 // Flujos que manejan caracteres
                 InputStreamReader isr = new InputStreamReader(is);
                 OutputStreamWriter osw = new OutputStreamWriter(os);
                 // Flujos de líneas
                 BufferedReader bReader = new BufferedReader(isr);
                 PrintWriter pWriter = new PrintWriter(osw)) {
                System.out.println("Enviando mensaje");
                String mensaje = "Hola guapo";
                pWriter.print(mensaje);
                pWriter.flush();
                System.out.println("Mensaje enviado");

            }
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
