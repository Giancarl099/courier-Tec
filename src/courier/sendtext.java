/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author ERICKA
 */
public class sendtext {
    
        public sendtext (String Tipo_Paquete, String Tipo_Usuario, int num_tiquete, int numTelefono){
        
//        this.Tipo_Producto = "EC";

        System.out.print(" Su boleto es: " + Tipo_Paquete + "-" + Tipo_Usuario + "-" + num_tiquete );
        try{
                    // Construct data
                    String apiKey = "apikey=" + "ykkT6njbCUc-s3GXod0L7jBj23GAk3s6OA2g4EJcMC";
                    String message = "&message=" + "Le informamos que su boleto es el siguiente: " + Tipo_Paquete + "-" + Tipo_Usuario + "-" + num_tiquete;
                    String sender = "&sender=" + "Courier TEC";
                    String numbers = "&numbers=" + "506"+numTelefono;

                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                            JOptionPane.showMessageDialog(null, "Mensaje enviado");
                    }
                    rd.close();
        }
        catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

        }
    }
    
}
