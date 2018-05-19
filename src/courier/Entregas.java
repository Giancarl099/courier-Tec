/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courier;

/**
 *Mari si estas leyendo esto los metodos dinamico son Atendidos y liberarYAtenderPrincipal
 * @author giank
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Estructuras.Colas;
import courier.Ficha;
import courier.tipoEstado;
import courier.tipoPaquete;
import courier.tipoVentana;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class Entregas {
     
    private int cantidad;
    private Colas<Colas<String>> ListasdeFichas;
    private Colas<String> Fichas;
    private Colas<String> FichaNP;
    private Colas<String> FichasP; 
    private ArrayList<String> ArrayFichasP;
    private ArrayList<String> ArrayFichasNP;
    private ArrayList<String> ArrayFichas;
    private Colas<Ventana> VentanasE;
    private Colas<Ventana> VentanasArbol;
    private Colas<Ventana> VentanasCola;
    private java.util.Timer timer=new java.util.Timer();
    private int segundosNP;
    private int timeNP;
    private int segundosP;
    final String regex="N";
    public Entregas(){
        cantidad=1;
        this.VentanasE=new Colas<>();
        this.FichasP=new Colas<>();
        this.FichaNP=new Colas<>();
        this.Fichas=new Colas<>();
        this.ArrayFichasP=new ArrayList<>();
        this.ArrayFichasNP=new ArrayList<>();
    } 
    
     /**
      * crea una cantidad cant de ventasn segun el tipo de ventana y de paquete
      * @param tv
      * @param tp
      * @param cant 
      */
     public boolean crearVentanas(tipoVentana tv,tipoPaquete tp,int cant){
         this.VentanasE=new Colas<>();
         int num=cant;
         while(num!=0){
             Ventana nuevo=new Ventana(tp,tv,tipoEstado.libre);
             VentanasE.enqueque(nuevo);
            
             
             num--;
             
         }
         System.out.print("Fin de creacion");
        return true;
    
             
         }
      

    
/**
 * 
 * @param ventana
 * agarra el primer elemento de la lista de fichas coreespondientes a la ventana
 *///crear un go to pos
     public void Atender(Ventana V){
         
       this.setFichasPyNP();
         String current;
         //cambia el estado de la ventana a ocupado
         V.setEstado(tipoEstado.ocupado);
         //revisa si es no percedero
         if (V.gettipoP().equals(tipoPaquete.noPercedero)){
             current=FichaNP.getFirst();
             V.aumentarCant();
             FichaNP.dequeue();
             System.out.print ("Cliente Atendido:"+current);
             
         }
         //revisa si es percedero
         else if(V.gettipoP().equals(tipoPaquete.percedero)){
             current=FichasP.getFirst();
             V.aumentarCant();
             FichasP.dequeue();
             System.out.print ("Cliente Atendido:"+current);
             
         }
         
         
       
         
     }
     /**
      * recibe una ventana
      * @param ventana 
      */
     public void LiberaryAtender(Ventana V){
         
       //revissa si la venat es no percedero
         if(V.gettipoP().equals(tipoPaquete.noPercedero)){
             String n=this.FichaNP.getFirst();
             //quita el primer elemento de la lista de fichas no percederas
             FichaNP.dequeue();
            

             //si la lista no es vacia se vuelve a llamr al metodo atender
             if (FichaNP.Vacio()==false){
             Atender(V);
         }//si esta vacia se cambia el estado de la ventana a libre
             else{
                 V.setEstado(tipoEstado.libre);
             }}
         //revisa si es percedero
         else if (V.gettipoP().equals(tipoPaquete.percedero)){
             

             if(FichasP.Vacio()==false){
             
                 
                 Atender(V);
         }
             else{
                 V.setEstado(tipoEstado.libre);
             }
                 
         
     }
      
      
     
   }//hace una sola cola de las cola de colas, es decir agarra cada elemento de cada cola de la lista de colas y se la asigna al atributo Fichas
     public void setFichas(){
         Colas<Colas<String>>tempo=this.ListasdeFichas;
         this.Fichas=new Colas<>();
         while(tempo.getSize()!=0){
             Colas<String>temporal=tempo.getFirst();
             while(temporal.getSize()!=0){
                 String nuevo=temporal.getFirst();
                 this.Fichas.enqueque(nuevo);
                 temporal.dequeue();
             }
             tempo.dequeue();         }}
     /**
      * 
      * @param n
      * recibe una cola de strings y se lasigna al atributo Fichas
      */
      public void setFichas(Colas<String> n){
          this.Fichas=n;
      }
         
     //devuelve la lista con todas las ventanas creadas
     public Colas<Ventana> getVentanasE(){
         return this.VentanasE;
     }
     /**
      * recibe una cola de colas de strings y se lo asigna al atributo lista de fichas
      * @param nuevo 
      */
     public void setLisatdeFichas(Colas<Colas<String>> nuevo){
         this.ListasdeFichas=nuevo;
         this.setFichas();
     }//devuelve una cola de colas de strings
     public Colas<Colas<String>> getListadeFichas(){
         return this.ListasdeFichas;
     }
     /**
      * recibe una lista de strings y revisa si es percedero o no si lo es se asigna a la lista de percedero y si a la lista de no percederos
      * @param nuevo 
      */
     public void setFichasPyNP(){
         Colas<String> tempo=this.Fichas;
         while(tempo.getSize()!=0){
             String n=tempo.getFirst();
             System.out.print(n);
             if(this.esPercedero(n)==true){
                 this.FichasP.enqueque(n);
             }
             else{
             this.FichaNP.enqueque(n);}
             
             tempo.dequeue();
         }
     }
     
    //devuelve la lista de fichas percederas
     public Colas<String> getFichasP(){
         return this.FichasP;
     }
     //devuelve las fichas Np
     public Colas<String> getFichasNP(){
         return this.FichaNP;
     }
     public String stringFichas(){
         Colas<String> tempo=this.Fichas;
         while(this.Fichas.getSize()!=0){
             System.out.print(tempo.getFirst());
             tempo.dequeue();
         }
         return "Fin de lista";
        
     }
     //devuelve la cantidad de ventansa creadas
     public int getCantVentanas(){
         return this.VentanasE.getSize();
     }
     /**
      * 
      * @param current
      * el metodo recibe un string y revisa si es percedero, devuelve true y si no devuelve false
      * @return 
      */
     public boolean esPercedero(String current){
         final String string=current;
         boolean bandera=true;
        final Pattern pattern=Pattern.compile(regex,Pattern.MULTILINE);
     
         final Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
       
    }
    bandera=false;
    
}
        return bandera;}
         
        
        

     
     //regresa varios string con los nombrs y caracteristicas de las ventanas
         public String StringVentanas(){
             int numP=0;
             int numNP=0;
             Colas<Ventana> tempo=this.VentanasE;
             Ventana n=this.VentanasE.getFirst();
             while (tempo.getSize()!=0){
                 if(n.gettipoP().equals(tipoPaquete.percedero)){
                 System.out.print("Ventana"+n.gettipoP()+"#"+numP);
                 numP++;}
                 else{
                 System.out.print("Ventana"+n.gettipoP()+"#"+numNP);
                 numNP++;    
                 }
                 tempo.dequeue();
                
             }
         return ("Fin dde lissta");}
    //Metodo principal de atender , escoja la primera ventana libre y ejecuta el metodo Atender
     public Ventana Atendiendo(){
         this.setFichasPyNP();
         Colas<Ventana>tempo=this.VentanasE;
         int num=0;
         while(tempo.getElementfrom(num).equals(tipoEstado.ocupado)){
            if(tempo.getSize()==num){
                System.out.print("Tods las ventanas estan ocupadas");
            }
            num++;
            
            
         }
         this.Atender(tempo.getElementfrom(num));
         this.VentanasE=tempo;
         return tempo.getElementfrom(num);
         
     }
     //Busca y escoje la primera ventana ocupáda de la lista de ventanas y con esa ejecuta la funcion liberar Y atender
     public Ventana LiberaryAtenderPrincipal(){
         
         Colas<Ventana>tempo=this.VentanasE;
         int num=0;
         while(tempo.getElementfrom(num).equals(tipoEstado.libre)){
            if(tempo.getSize()==num){
                System.out.print("Tods las ventanas estan ocupadas");
            }
            num++;
            
            
         }
         this.LiberaryAtender(tempo.getElementfrom(num));
         this.VentanasE=tempo;
         return tempo.getElementfrom(num);
         
     }
     }
    
    
    
     
     
     
