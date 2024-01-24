package ElNuevo.CosasMandadas;

import java.net.InetAddress;
import java.net.UnknownHostException;

    public class MostrarInfoHostLocal {

        public static void main(String[] args) {
            try {
                // Obtener la información del host local
                InetAddress localHost = InetAddress.getLocalHost();

                // Mostrar el nombre del host
                System.out.println("Nombre del host: " + localHost.getHostName());

                // Mostrar la dirección IP del host
                System.out.println("Dirección IP del host: " + localHost.getHostAddress());

            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
