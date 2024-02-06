package ElNuevo.FilesSenders.FileSender;

import java.io.*;
import java.net.*;

public class FileSenderClient {

     public static void main(String[] args) {
        final String FILE_PATH = "src/ElNuevo/FilesSenders/files/MySecretFile.txt"; // Cambia esto por la ruta de tu archivo

        try (Socket socket = new Socket("10.230.163.114", 2020);
             OutputStream outputStream = socket.getOutputStream();
             FileInputStream fileInputStream = new FileInputStream(FILE_PATH)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Archivo enviado con éxito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}