/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courier;

import Estructuras.Colas;
import courier.Ficha;
import courier.tipoEstado;
import courier.tipoPaquete;
import courier.tipoVentana;

/**
 *
 * @author giank
 */
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import courier.Seguridad.contador;
public class Seguridad {
   final String regex="N";
    private int tiempoMin;
    private int tiempMax;
    private int tiempo;
    private Timer timer=new Timer();
    private int segundos=0;
    private Colas<Ventana> VentanasS;
    private Colas<String> FichasNP;
    private Colas<String> FichasP;
    private Colas<String> Fichas;
    private int cantidadVP=0;
    private int cantidadVNP=0;
    private boolean banderaTime=false;
    private Colas<Colas<String>> ListasdeFichas;
    /**
     * constructor de la clase
     * @param tmax
     * @param tmin 
     */
    public Seguridad(int tmax,int tmin){
        int numero=0;
        if (numero<tmin){
            //genera un numeroo random con base a las entradas del constructor
            numero=(int)(Math.random()*tmax)+1;
        }
 
            this.tiempo=numero;
            this.FichasNP=new Colas<String>();
            this.FichasP=new Colas<String>();
            this.Fichas=new Colas<String>();
            this.VentanasS=new Colas<Ventana>();
            
            
     
        }
        /**
         * recibe una ventana y comienza a atender a los personas cada parametro tiempo de segundos
         * @param vent 
         */
        public void Contar(Ventana vent){
         contador nu=new contador();
          Colas<String> Fichas;
          
          //revisa que tipo de paquete la ventana recibe y segun esto le asigna una lista de fichas al atribto Fichas
          if (vent.gettipoP().equals(tipoPaquete.percedero)){
         Fichas=this.FichasP;}
          else{
              Fichas=this.FichasNP;
          }
          
        this.segundos=0;
        //crea un nuevo timer
        timer=new Timer();
        //se le asigna el atributo Fichas a lista con la que trabaja el metodo run
        nu.setFichas(Fichas);
        //se le asiigna la ventana con el cual se va a trabajar el metodo run
        nu.setVentana(vent);
        if(Fichas.Vacio()==true){
            vent.setEstado(tipoEstado.libre);
            timer.cancel();
            
        }
        else{
        timer.schedule(nu,0,(this.tiempo*1000));}
        vent.setEstado(nu.getestado());
        vent.setcantAtendidos(nu.getVentana().getcantAtendidos());
   
        
    }
         
         class contador extends TimerTask{
       private boolean bandera=false;
       private Colas<String> fichas;
       private Ventana n;
       //en cada segundo que pase se va a agarrar al cliente de la lista de fichas, se quitara el primer elmento de la lista hasta quedar vacia
        public void run(){
         if(fichas.Vacio()==false){  
         String current;
         n.setEstado(tipoEstado.ocupado);
         
         if (n.gettipoP().equals(tipoPaquete.noPercedero)){
             current=fichas.getFirst();
             n.aumentarCant();
             fichas.dequeue();
             
            
        
                     
             if(this.fichas.Vacio()==true){
                 
                 timer.cancel();
                 
              
                 
                 
             }
             System.out.print ("Cliente Atendido:"+current);
             timer.cancel();
            
             
                 
 
             
             
         }
         //revisa si la ventana es percedero y modifica la ventana y atiende al cliente
         else if(n.gettipoP().equals(tipoPaquete.percedero)){
             current=FichasP.getFirst();
             n.aumentarCant();
            fichas.dequeue();
            //si la lista de fichas es vacia detiene al cronometro
             if(this.fichas.Vacio()==true){
               
                 timer.cancel();
             }
             //imprime el cliente atendido
             System.out.print ("Cliente Atendido:"+current);
             
         }
            
            
           
        }
         //si la lista es vacia para el cronometro y lo cnacela
         else if(fichas.Vacio()==true){
             timer.cancel();
         }}
        //la asigna una lista de fichas al atributo fichas
        public void setFichas(Colas<String> lista){
            this.fichas=lista;
        }
        //devuelve la ventan parametro
        public Ventana getVentana(){
            return n;
        }
        /**
         * el atributo n es cambiado por el parametro ventana
         * @param nu 
         */
        public void setVentana(Ventana nu){
            this.n=nu;
           
        }
        //regresa el estado de la ventana
        public tipoEstado getestado(){
            return n.getEstado();
        }
        //regresa la cantidad de atendidos
        public int cantatendidos(){
            return n.getcantAtendidos();
        }
       
       


   
        
    }
     
    //crea lla ventanas con una cantidad exacta
    public void CrearVentanas(tipoVentana tv,tipoPaquete tp, int num){
        if (num>0){
            while(num!=0){
                
                Ventana nuevo=new  Ventana(tp,tv,tipoEstado.libre,this.tiempo);
                
                VentanasS.enqueque(nuevo);
                this.cantidadVP++;
                num--;
                
            }
        }
        else{
            System.out.print("cantidad no validad");
            
        }
    }

    

    
                 
         
     
     
         
         
            
           
            
        
    

   
   //devuelve los segundos
   public int getSegundos(){
       return this.segundos;
   }

   public void setFichas(Colas<String> nuevo){
       this.Fichas=nuevo;
   }
   /**
    * agarra una lista de String y revisa si la ficha es percedera o no percedera y las agrega a listas respectivas
    * @param nuevo 
    */
   public void setFichasPyNP(Colas<String> nuevo){
        Colas<String> tempo=nuevo;
         while(tempo.getSize()!=0){
             String n=tempo.getFirst();
             System.out.print(n);
             //revisa si la ficha es percedero y si es la ingresa a las fichasP
             if(this.esPercedero(n)==true){
                 this.FichasP.enqueque(n);
             }
             //si no lo es lo ingresa a la lista FichasNP
             else{
             this.FichasNP.enqueque(n);}
             
             tempo.dequeue();
         }
     }
       
   //regresa el numero random que se escogio como tiempo
   public int getTiempo(){
       return this.tiempo;
   }
   //asigna un int como tiempo
   public void setTiempo(int t){
       tiempo=t;
   }
   //revisa la cantidad de ventanas que tiene
   public int getCantidadVentanas(){
       return this.VentanasS.getSize();
   }
   //revisa cuantas ventan NP tiene
   public int getCantidadVentanasNP(){
       return this.cantidadVNP;
   }//revisa cuantas ventanas P tienen
   public int getCantidadVentanasP(){
       return this.cantidadVP;
   }//es un boolean que devuelve true si la ficha es percedero y false si no lo es
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
        return bandera;
         
        
            
    }//devuelvr la cantidad de ventansa creadas
             public int getCantVentanas(){
         return this.VentanasS.getSize();
     }
             //devuelve todas las fichas  y sus caracteristicas en medio de strings
    public String stringFichas(){
         Colas<String> tempo=this.Fichas;
         int num=0;
         while(this.Fichas.getSize()!=0){
             System.out.print(tempo.getFirst()+"#"+num);
             tempo.dequeue();
         }
         return "Fin de lista";
        
     }
    //devuelve la lista de todas lñas ventanas creadas
         public Colas<Ventana> getVentanasS(){
         return this.VentanasS;
     }/**
      * divide el atrbiuto tiewmpo entre la cantidad de clientes atendidos de la ventana parametro
      * @param V
      * @return 
      */
         public int getTiempoEspera(int num){
             Ventana V=this.VentanasS.getElementfrom(num);
             if(V.gettipoP().equals(tipoPaquete.percedero)){
                 return (this.tiempo/V.getcantAtendidos());
             }
             else{
                 return (this.tiempo/V.getcantAtendidos());
             }
         }
         //RETORNA LA CANTIDAD DE PERSONAS ATENDIDAS POR VENTANA
         public int getCantidadAtendidos(Ventana v){
             return v.cantAtendidos;
         }
          //Devuelve string de todas las ventans creadas
         public void StringVentanas(){
             int numP=0;
             int numNP=0;
             Colas<Ventana> tempo=this.VentanasS;
             Ventana n=this.VentanasS.getFirst();
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
         }
         //Busca en la lista de ventanaS la primera ventan de estado libre, y con ella ejecuta el metodo contar el cual va ir atendiendo a cada cliente de la lista Fichas
         public Ventana Atender(){
         //acomoda las fichas entre percedero y no percedero
         this.setFichasPyNP(this.Fichas);
         //crea una copia de VentnasS
         Colas<Ventana>tempo=this.VentanasS;
         int num=0;
         //revisa la lista VentanasS hasta encontrar una que este libre
         while(tempo.getElementfrom(num).equals(tipoEstado.ocupado)){
             //si num es igual a size significa que todas las ventanas estan ocupadas
            if(tempo.getSize()==num){
                System.out.print("Tods las ventanas estan ocupadas");
            } 
            num++;
            
            
         }
         //odicifica las ventansS para ajustar los estados de la Ventna
         this.VentanasS=tempo;
       
       //llama a la funcion contar que atendera al clinete priumero de la cola cada tiempo de segundos
         this.Contar(tempo.getFirst());
         //devuelve la ventana
         return tempo.getElementfrom(num);
         
     }
          /**
      * recibe una cola de colas de strings y se lo asigna al atributo lista de fichas
      * @param nuevo 
      */
     public void setLisatdeFichas(Colas<Colas<String>> nuevo){
         this.ListasdeFichas=nuevo;
         this.setFichas();
     }
     //hace una sola cola de las cola de colas, es decir agarra cada elemento de cada cola de la lista de colas y se la asigna al atributo Fichas
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
}
   
   


