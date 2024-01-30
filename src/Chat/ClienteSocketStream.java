package Chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class ClienteSocketStream extends Thread{
    @Override
    public void run() {
        System.out.println("Creando socket cliente");
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            try (Socket clientSocket = new Socket()) {
                // Para indicar la dirección IP y el número de puerto del socket stream servidor
                // al que se desea conectar, el método connect() hace uso de un objeto
                // de la clase java.net.InetSocketAddress.
                InetSocketAddress addr = new InetSocketAddress("10.230.163.211", 5555);
                clientSocket.connect(addr);
                try (InputStream is = clientSocket.getInputStream();
                     OutputStream os = clientSocket.getOutputStream();
                     // Flujos que manejan caracteres
                     InputStreamReader isr = new InputStreamReader(is);
                     OutputStreamWriter osw = new OutputStreamWriter(os);
                     // Flujos de líneas
                     BufferedReader bReader = new BufferedReader(isr);
                     PrintWriter pWriter = new PrintWriter(osw)) {
                    System.out.print(">");
                    String mensaje = sc.nextLine();
                    pWriter.print(mensaje);
                    pWriter.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
