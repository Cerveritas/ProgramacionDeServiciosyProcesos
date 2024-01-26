package ElNuevo.SocketsEjercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPresentacion {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java ServidorPresentacion <puerto> <nombre>");
            System.exit(1);
        }
        /* Pasar parámetros  puerto 1789 nombreServer*/
        /* e.g. 1789 localhost*/
        int puerto = Integer.parseInt(args[0]);
        String nombre = args[1];

        try {
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor en espera en el puerto " + puerto + "...");

            while (true) {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clienteSocket.getInetAddress().getHostAddress());

                // Manejar la presentación del cliente
                handleClientPresentation(clienteSocket, nombre);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClientPresentation(Socket clienteSocket, String nombreServidor) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
        String nombreCliente = reader.readLine();

        System.out.println("Cliente '" + nombreCliente + "' se ha presentado ante el servidor cuyo nombre es:'" + nombreServidor + "'.");

        // Puedes realizar otras acciones aquí según sea necesario
    }
}
