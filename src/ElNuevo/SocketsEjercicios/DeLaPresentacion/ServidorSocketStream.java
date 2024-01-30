package ElNuevo.SocketsEjercicios.DeLaPresentacion;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocketStream {
    public static void main(String[] args) {
        System.out.println("Creando socket servidor");
        try (ServerSocket serverSocket = new ServerSocket();) {
            System.out.println("Realizando el bind");
            //10.230.163.75
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            //asigna el socket a una dirección y puerto
            serverSocket.bind(addr);
            System.out.println("Aceptando conexiones");
            try (Socket newSocket = serverSocket.accept();
                 InputStream is = newSocket.getInputStream();
                 OutputStream os = newSocket.getOutputStream();
                 // Flujos que manejan caracteres
                 InputStreamReader isr = new InputStreamReader(is);
                 OutputStreamWriter osw = new OutputStreamWriter(os);
                 // Flujos de líneas
                 BufferedReader bReader = new BufferedReader(isr);
                 PrintWriter pWriter = new PrintWriter(osw);) {
                System.out.println("Conexión recibida");



                String mensaje = bReader.readLine();
                System.out.println("Mensaje recibido: " + mensaje);
            }
            System.out.println("Cerrando el nuevo socket");
            System.out.println("Cerrando el socket servidor");
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
