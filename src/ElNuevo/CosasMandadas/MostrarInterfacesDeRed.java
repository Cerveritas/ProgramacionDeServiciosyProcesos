package ElNuevo.CosasMandadas;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MostrarInterfacesDeRed {

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
}