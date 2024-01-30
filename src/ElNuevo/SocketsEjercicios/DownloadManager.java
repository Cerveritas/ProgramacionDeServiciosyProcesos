package ElNuevo.SocketsEjercicios;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadManager {
    //public void downloadFile(
    public String downloadFile(
            String url_toDonwload,
            String fileName){
        System.out.println("downloading "
                +url_toDonwload+fileName);

        String content = new String();
        try {
            URL laUrl=new URL(url_toDonwload+fileName);
            System.out.println(laUrl);
            InputStream is=laUrl.openStream();
            InputStreamReader reader=
                    new InputStreamReader(is);
            BufferedReader bReader=
                    new BufferedReader(reader);
            FileWriter escritorFichero=
                    new FileWriter(fileName);
            String linea;
            while ((linea=bReader.readLine())!=null){
                escritorFichero.write(linea);
                content += linea + "\n";
                // System.out.println(""+linea);
            }
            escritorFichero.close();
            bReader.close();
            reader.close();
            is.close();
        } catch (MalformedURLException e) {
            System.out.println("URL mal escrita!");
            return "";
        } catch (IOException e) {
            System.out.println(
                    "Fallo en la lectura del fichero");
            return "";
        }
        return content;
    }
    public static void main (String[] args){
        DownloadManager gd=new DownloadManager();
            /*String url= "https://www.gutenberg.org/files/11/";
            String file="11-0.txt";
             */
        String url= "https://www.gutenberg.org/files/11/11-h/";
        String file="11-h.htm";

        System.out.println(gd.downloadFile(url,file));
    }
}
