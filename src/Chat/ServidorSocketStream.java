package Chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocketStream extends Thread{
    @Override
    public void run() {
        System.out.println("Creando socket servidor");
        boolean continuar = true;
        while (continuar) {
            try (ServerSocket serverSocket = new ServerSocket();) {
                InetSocketAddress addr = new InetSocketAddress("10.230.163.75", 5555);
                //asigna el socket a una dirección y puerto
                serverSocket.bind(addr);
                try (Socket newSocket = serverSocket.accept();
                     InputStream is = newSocket.getInputStream();
                     OutputStream os = newSocket.getOutputStream();
                     // Flujos que manejan caracteres
                     InputStreamReader isr = new InputStreamReader(is);
                     OutputStreamWriter osw = new OutputStreamWriter(os);
                     // Flujos de líneas
                     BufferedReader bReader = new BufferedReader(isr);
                     PrintWriter pWriter = new PrintWriter(osw);) {
                    String mensaje = bReader.readLine();
                    System.out.println(mensaje);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
