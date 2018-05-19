/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courier;

/**
 *
 * @author giank
 */
import Estructuras.Colas;
import courier.tipoPaquete;
import courier.tipoVentana;
import courier.Seguridad.contador;
public class prueba {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        Colas<String> nn=new Colas<>();
        nn.enqueque("NP-0-E");
        nn.enqueque("NP-0-R");
        nn.enqueque("P-0-D");
        nn.enqueque("P-0-M");
        nn.enqueque("P-0-R");
       
      Entregas nuevo=new Entregas();
      nuevo.setFichas(nn);
      nuevo.crearVentanas(tipoVentana.colaPrioridad, tipoPaquete.percedero, 3);
      nuevo.Atendiendo();
      nuevo.LiberaryAtenderPrincipal();
       



      
       
     
       
        
       
        
       }
    
}
