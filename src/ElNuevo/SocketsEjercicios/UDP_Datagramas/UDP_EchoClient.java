package ElNuevo.SocketsEjercicios.UDP_Datagramas;

import java.io. BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net. InetAddress;
import java.net.SocketException;
public class UDP_EchoClient {
    private final static int MAX_BYTES = 1400;
    private final static String COD_TEXTO = "UTF-8";
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("ERROR, indicar: host_servidor puerto, eg. localhost 1789");
            /* ex. localhost 1789*/
            System.exit(1);
        }
        String nomHost = args[0];
        int numPuerto = Integer.parseInt (args[1]);

        try (DatagramSocket clientSocket = new DatagramSocket ();
        InputStreamReader isrStdIn = new InputStreamReader (System.in,
                COD_TEXTO);
        BufferedReader brStdIn = new BufferedReader (isrStdIn)) {
            String lineaLeida;
            System.out.println("Introducir líneas. Línea vacía para terminar.");
            System.out.print("Linea>");
            while ((lineaLeida = brStdIn.readLine()) != null
                    && lineaLeida.length() > 0) {
                InetAddress IPServidor = InetAddress.getByName (nomHost);
                byte[] b= lineaLeida.getBytes (COD_TEXTO);
                DatagramPacket paqueteEnviado = new DatagramPacket(
                        b, b.length, IPServidor, numPuerto);
                clientSocket.connect (IPServidor, numPuerto);
                clientSocket.send(paqueteEnviado);
                byte[] datosRecibidos = new byte[MAX_BYTES];
                DatagramPacket paqueteRecibido = new DatagramPacket(
                datosRecibidos, datosRecibidos.length);
                clientSocket.receive (paqueteRecibido);

                String respuesta = new String (paqueteRecibido.getData(),
                        0, paqueteRecibido.getLength(), COD_TEXTO);
                System.out.println("El puerto  al que se conecta el cliente es:"+paqueteEnviado.getPort());

                System.out.printf("Datagrama recibido de %s  :%d:   \n",
                                paqueteRecibido.getAddress().getHostAddress(),
                                paqueteRecibido.getPort() );
                System.out.print("Línea>" );
            }
        } catch (SocketException ex) {
                System.out.println("Excepción de sockets");
                ex.printStackTrace();
            } catch (IOException ex) {
                System.out.println("Excepción de E/S");
                ex.printStackTrace();

            }
        }
    }


