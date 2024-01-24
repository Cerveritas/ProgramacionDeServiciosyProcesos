package ElNuevo.CosasMandadas;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MostrarInterfacesDeRedAmpliado {

    public static void main(String[] args) {
        try {
            // Obtener todas las interfaces de red
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();

                // Mostrar información de la interfaz
                System.out.println("Nombre de la interfaz: " + networkInterface.getName());
                System.out.println("Nombre visual de la interfaz: " + networkInterface.getDisplayName());
                System.out.println("ID de la interfaz: " + networkInterface.getIndex());
                System.out.println("Dirección MAC de la interfaz: " + getMacAddress(networkInterface));
                System.out.println("MTU de la interfaz: " + networkInterface.getMTU());

                // Mostrar información de la configuración IP
                System.out.println("Configuración IP:");
                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                    InetAddress address = interfaceAddress.getAddress();
                    InetAddress broadcast = interfaceAddress.getBroadcast();
                    short prefixLength = interfaceAddress.getNetworkPrefixLength();

                    System.out.println("  Dirección IP: " + address.getHostAddress());
                    System.out.println("  Máscara de red: " + getSubnetMask(prefixLength));
                    System.out.println("  Dirección de broadcast: " + (broadcast != null ? broadcast.getHostAddress() : "No disponible"));
                }

                System.out.println("--------------------------------------------------");
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la dirección MAC de la interfaz de red
    private static String getMacAddress(NetworkInterface networkInterface) throws SocketException {
        byte[] mac = networkInterface.getHardwareAddress();
        if (mac == null) {
            return "No disponible";
        }

        // Formatear la dirección MAC
        StringBuilder macAddress = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }

        return macAddress.toString();
    }

    // Método para obtener la máscara de subred a partir de la longitud del prefijo
    private static String getSubnetMask(short prefixLength) {
        int subnetMask = 0xffffffff << (32 - prefixLength);
        return String.format("%d.%d.%d.%d",
                (subnetMask & 0xff000000) >>> 24,
                (subnetMask & 0x00ff0000) >>> 16,
                (subnetMask & 0x0000ff00) >>> 8,
                subnetMask & 0x000000ff);
    }
}