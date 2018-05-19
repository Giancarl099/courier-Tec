/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courier;

import Estructuras.LQueue;
import Estructuras.Nodo;

/**
 *
 * @author Maria Jose M.
 */
public class Autoservicio {
    public String nombre, correo, tipoUsuario, tipoPaquete;
    public int num_tiquete;
    public int totalPerecedero, totalNoPerecedero, totalR, totalM, totalD, totalE = 0;
    public LQueue<Cliente> colaUsuarios;
   
   
    //calcular el total de cliente perecedero y no perecederos que llegan al establecimiento
    public void autoservicio(String TipoPaquete, String TipoUsuario) {
        this.tipoPaquete = TipoPaquete;
        this.tipoPaquete = TipoUsuario;
        if (TipoPaquete == "P"){
            totalPerecedero ++;
           }
        else {
            totalNoPerecedero ++;
        }
    }
    //Metodo para que se vea en intefaz cuantos usuarios perecederos hay
    public String TotalP (){
        System.out.println("Tipo de estructura que utiliza: " +"*HEAP o COLA*"+ "\n"
        +"Cantidad de Clientes en la cola: "+ totalPerecedero);
        return "Tipo de estructura que utiliza: " +"*HEAP o COLA*"+ "\n"
        +"Cantidad de Clientes en la cola: "+ totalPerecedero;
    }
    //Metodo para que se vea en intefaz cuantos usuarios NO perecederos hay
    public String TotalNP (){
        System.out.println("Tipo de estructura que utiliza: " +"*HEAP o COLA*"+ "\n"
        +"Cantidad de Clientes en la cola: "+ totalNoPerecedero);
        return "Tipo de estructura que utiliza: " +"*HEAP o COLA*"+ "\n"
        +"Cantidad de Clientes en la cola: "+ totalNoPerecedero;
    }
    
    
     /*metodo de autoservicio en donde se generan las estadisticas de cantidad de boletos y genera el codigo del tiquete*/
    public Autoservicio(){
        colaUsuarios = new LQueue<Cliente>();
 
      
        if (this.tipoPaquete == "P"){
            if (num_tiquete>=99){
                num_tiquete = -1;    
            }
            totalPerecedero ++;
            num_tiquete ++;
            
        if (this.tipoUsuario == "R"){
            totalR ++;
        } else if(this.tipoUsuario == "D"){
            totalD ++;
        } else if(this.tipoUsuario == "M"){
            totalM ++;
        } else if (this.tipoUsuario == "E"){
            totalE ++;
        }    
        
        } else if (this.tipoPaquete == "NP"){
            if (num_tiquete>=99){
                num_tiquete = -1;
            }
            totalNoPerecedero ++;
            num_tiquete ++;
            
        if (this.tipoUsuario == "R"){
            totalR ++;
        } else if(this.tipoUsuario == "D"){
            totalD ++;
        } else if(this.tipoUsuario == "M"){
            totalM ++;
        } else if (this.tipoUsuario == "E"){
            totalE ++;
        }
           
        }
    }
    
    public String autoservicio (String name, String email, String paquete, String cliente){
        this.nombre = name;
        this.correo = email;
        this.tipoUsuario = cliente;
        this.tipoPaquete = paquete;
        colaUsuarios = new LQueue<Cliente>();
        
        //calcular el numero de clientes segun el tipo de producto
        if (tipoPaquete == "P"){
            totalPerecedero ++;
        }
        else if (tipoPaquete == "NP"){
            totalNoPerecedero ++;
        }
        
        //calcular cantidad de clientes segun su condicion fisica
        if (this.tipoUsuario == "R"){
            totalR ++;
        } else if(this.tipoUsuario == "D"){
            totalD ++;
        } else if(this.tipoUsuario == "M"){
            totalM ++;
        } else if (this.tipoUsuario == "E"){
            totalE ++;
        }    
        return nombre;
    }
    
    /*metodo totales que devuelve las estadisticas*/
    public String totales(){
        System.out.println("El total de tiquetes Perecederos vendidos es:" + totalPerecedero + "\n" +        
               "El total de tiquetes No Perecederos vendidos es:" + totalNoPerecedero + "\n" +
                "El total de personas Regulares es:" + totalR + "\n" + 
                "El total de personas Discapacitadas es:" + totalD + "\n" +
                "El total de personas Embarazadas es:" + totalE + "\n" + 
                "El total de personas Mayores es:" + totalM);
        
        
        return("El total de tiquetes Perecederos vendidos es:" + totalPerecedero + "\n" +        
               "El total de tiquetes No Perecederos vendidos es:" + totalNoPerecedero + "\n" +
                "El total de personas Regulares es:" + totalR + "\n" + 
                "El total de personas Discapacitadas es:" + totalD + "\n" +
                "El total de personas Embarazadas es:" + totalE + "\n" + 
                "El total de personas Mayores es:" + totalM);
    }
    
 /*metodo que devuelve la cola de usuarios*/
    public LQueue<Cliente> getColaUsuarios() {
        return colaUsuarios;
    }
    
     /*metodo que setea la cola de usuarios*/
    public void setColaUsuarios(LQueue<Cliente> colaUsuarios) {
        this.colaUsuarios = colaUsuarios;
    }
    /*metodos get y set de los atributos de la clase*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipoUsuario = tipo_usuario;
    }

    public void setTipo_paquete(String tipo_paquete) {
        this.tipoPaquete = tipo_paquete;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTipo_usuario() {
        return tipoUsuario;
    }

    public String getTipo_paquete() {
        return tipoPaquete;
    }

    public int getNum_tiquete() {
        return num_tiquete;
    }


    public void setNum_tiquete(int num_tiquete) {
        this.num_tiquete = num_tiquete;
    }


    public int getTotalPerecedero() {
        return totalPerecedero;
    }

    public int getTotalNoPerecedero() {
        return totalNoPerecedero;
    }

    public int getTotalR() {
        return totalR;
    }

    public int getTotalM() {
        return totalM;
    }

    public int getTotalD() {
        return totalD;
    }

    public int getTotalE() {
        return totalE;
    }

    public void setTotalPerecedero(int totalPerecedero) {
        this.totalPerecedero= totalPerecedero;
    }

    public void setTotalNP(int totalNP) {
        this.totalNoPerecedero = totalNP;
    }

    public void setTotalR(int totalR) {
        this.totalR = totalR;
    }

    public void setTotalM(int totalM) {
        this.totalM = totalM;
    }

    public void setTotalD(int totalD) {
        this.totalD = totalD;
    }

    public void setTotalE(int totalE) {
        this.totalE = totalE;
    }

    
  
    
    
}


