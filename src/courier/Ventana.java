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
import courier.tipoEstado;
import courier.tipoPaquete;
import courier.tipoPaquete;
import courier.tipoVentana;
import courier.tipoVentana;

public class Ventana {
    int tiempo;
    tipoPaquete tipoP;
    tipoVentana tipoV;
    tipoEstado estado;
    int cantAtendidos;
    
     public Ventana(){
         
     }
     //Constructor de ventan de entregas
     public Ventana(tipoPaquete tipoPaq,tipoVentana tipoVent,tipoEstado estado){
         this.tipoP=tipoPaq;
         this.tipoV=tipoVent;
         this.estado=estado;
         this.cantAtendidos=0;
     }
     //construcotr de ventans de seguridad
     public Ventana(tipoPaquete tipoPaq,tipoVentana tipoVent,tipoEstado estado,int time){
         this.tiempo=time;
         this.tipoP=tipoPaq;
         this.tipoV=tipoVent;
         this.estado=estado;
         this.cantAtendidos=0;
     }
     //devueklvo el tiempo
     public int getTiempo(){
         return this.tiempo;
     }//asigna el tiempo
     public void setTiempo(int T){
         this.tiempo=T;
     }//devuelve el tipo de paquete que recibe la ventana
     public tipoPaquete gettipoP(){
         return this.tipoP;
     }//cambia el tipo de paquete que recibe la ventana
     public void setTipoP(tipoPaquete tp){
         this.tipoP=tp;
     }//devuelve que tipi de ventan es
     public tipoVentana getTipoV(){
         return this.tipoV;
     }//cambia el tipo de ventana
     public void settipoV(tipoVentana tv){
         this.tipoV=tv;
     }//regresa el estado de la ventana
     public tipoEstado getEstado(){
         return this.estado;
     }//cambia el estado de ventana
     public void setEstado (tipoEstado state){
         this.estado=state;
     }//devuelve la cantidad de atendidos
     public int getcantAtendidos(){
         return this.cantAtendidos;
     }//cambia la cantidad de atendidos de la ventan por el param cant
     public void setcantAtendidos(int cant){
         this.cantAtendidos=cant;
     }//aumenta la cantidad de atendidos por 1
     public void aumentarCant(){
         this.cantAtendidos++;
     }
 

     }
    
    

