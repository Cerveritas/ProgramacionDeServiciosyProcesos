package ElNuevo.FilesSenders.FileSender;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class FileSenderClientGUI {
    private JButton SENDFILEButton;
    private JLabel ENVIODEFILELabel;
    private JPanel PanelPrincipal;


    public static void main(String[] args) {
        JFrame frame = new JFrame("FileSenderClientGUI");
        frame.setContentPane(new FileSenderClientGUI().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(200,200,400,200);




    }

    public FileSenderClientGUI() {

        SENDFILEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String FILE_PATH = "src/ElNuevo/FilesSenders/files/MySecretFile.txt"; // Cambia esto por la ruta de tu archivo

                try (Socket socket = new Socket("192.168.56.1", 2020); //PONER LA IP DEL SERVIDOR AL QUE VAYAMOSA ENVIAR EL MENSAJE
                     OutputStream outputStream = socket.getOutputStream();
                     FileInputStream fileInputStream = new FileInputStream(FILE_PATH)) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    System.out.println("Archivo enviado con éxito.");

                    if (JOptionPane.showConfirmDialog(PanelPrincipal, "El mensaje ha sido enviado con exito...") == 0){
                        System.exit(0);
                    }


                } catch (IOException e1) {
                    e1.printStackTrace();
                    if (JOptionPane.showConfirmDialog(PanelPrincipal, "ERROR!!! El mensaje no se ha podido enviar") == 0){
                        System.exit(0);
                    }

                }
            }
        });
    }
}
