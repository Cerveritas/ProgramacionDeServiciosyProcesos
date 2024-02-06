package ElNuevo.SocketsEjercicios.UDP_Datagramas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.net.InetAddress;

public class UDP_EchoServer {
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_RESET = "\u001B[0m";

        private final static int MAX_BYTES = 1400;
        private final static java.lang.String COD_TEXTO="UTF-8";
        public static void main(String[] args) {
            if (args.length < 1){
             System.err.println("ERROR, indicar: puerto.");
             /* eg.1789*/
               System.exit(1);
        }
        int numPuerto = Integer.parseInt (args[0]);
        //  int numPuerto = Integer.parseInt ("8080");

        try (
                DatagramSocket serverSocket=new DatagramSocket (numPuerto)) {
                System.out.printf("Creado socket de datagramas para puerto pasado como argumento  %s.\n",numPuerto);
                System.out.println("El Puerto del servidor desde el método getLocalPort() es:"+serverSocket.getLocalPort());

            while (true) {
                    System.out.println("Esperando datagramas.");
                    byte[] datosRecibidos= new byte[MAX_BYTES];
                    DatagramPacket paqueteRecibido= new DatagramPacket(
                        datosRecibidos, datosRecibidos.length);
                    serverSocket.receive (paqueteRecibido);
                    Date objDate = new Date(); // Current System Date and time is assigned to objDate
                    java.lang.String strDateFormat = "hh:mm:ss a dd-MMM-yyyy"; //Date format is Specified
                    SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); //Date format string is passed as an argument to the Date format object

                    System.out.println("Ha llegado un datagrama a las "+objSDF.format(objDate));

                    String lineaRecibida= new String (paqueteRecibido.getData(),
                            0, paqueteRecibido.getLength(), COD_TEXTO);
                    InetAddress IPCliente= paqueteRecibido.getAddress();
                    int puertoCliente= paqueteRecibido.getPort();
                    System.out.printf("Recibido datagrama de %s:%d"+ANSI_GREEN+"(%s)\n"+ANSI_RESET,
                                      IPCliente.getHostAddress(), puertoCliente, lineaRecibida);
                    System.out.println("El hostname es:"+InetAddress.getLocalHost().getHostName());
                    System.out.println("El Puerto es del cliente es:"+puertoCliente);

                    String respuesta="#" + lineaRecibida+"#";
                    byte[] b= respuesta.getBytes(COD_TEXTO);
                    DatagramPacket paqueteEnviado= new DatagramPacket(
                            b, b.length, IPCliente, puertoCliente);
                            serverSocket.send(paqueteEnviado);
        }
        } catch (SocketException ex) {
                System.out.println("Excepcion de sockets");
    } catch (IOException ex){
            System.out.println("Excepción de E/S");
ex.printStackTrace();
}
}
        }