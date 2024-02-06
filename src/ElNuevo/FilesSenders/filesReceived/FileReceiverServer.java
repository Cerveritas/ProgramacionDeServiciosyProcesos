package ElNuevo.FilesSenders.filesReceived;
import java.io.*;
        import java.net.*;

public class FileReceiverServer {
     public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2020);
             Socket socket = serverSocket.accept();
             InputStream inputStream = socket.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream("src/ElNuevofilesReceived/FilesSenders/MySecretFileReceived.txt")) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Archivo recibido con éxito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
