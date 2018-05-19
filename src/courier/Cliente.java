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
 * @author mac
 */
public class Cliente {
    // ATRIBUTOS
    public String nombre, correo, tipo_usuario, Tipo_Producto, numTelefono;
    public int num_tiquete = -1;
    public int totalP, totalNP, totalR, totalM, totalD, totalE = 0;
    public TipoCliente TipoCliente;
    public tipoPaquete TipoPaquete;
    
    //Constructores
    //PUEDE QUE ESTE CONSTRUCTOR SE PUEDA BORRAR, tengo que revisar si aun lo necesito
    //MJM 
    public Cliente (String pnombre, String pcorreo_electronico,String num,String ptipo_producto, String ptipo_usuario){ 
        
         nombre = pnombre;
         correo = pcorreo_electronico;
         numTelefono = num;
         tipo_usuario = ptipo_usuario;
         Tipo_Producto = ptipo_producto;
    }
    
    //a la hora de conectar os datos en la interfaz es dificil conectar datos
    //de diferente clase, por lo que voy a cambiar tipo paquete y usuario a STR
    
      public Cliente (String pnombre, String pcorreo_electronico,String ptipo_producto, String ptipo_usuario){ 
        
         nombre = pnombre;
         correo = pcorreo_electronico;
         tipo_usuario = ptipo_usuario;
         Tipo_Producto = ptipo_producto;
    }
    
   //constructor utilizado por CLASE FICHA 
    // es el que recibe 4 parametros
      //dificultad para leer datos de tipo usuario y paquete
      
      /*  public Cliente (String pnombre, String pcorreo_electronico,TipoCliente tipoCliente, tipoPaquete TipoP){
      
      nombre = pnombre;
      correo = pcorreo_electronico;
      TipoCliente = tipoCliente;
      TipoPaquete =TipoP;
      }*/
 
 
    //Metodos
    // Asignar e imprimir boleto

    public String getNombre() {
        return this.nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public String getTipo_Producto() {
        return Tipo_Producto;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public int getNum_tiquete() {
        return num_tiquete;
    }


    public int getTotalNP() {
        return totalNP;
    }

    public int getTotalP() {
        return totalP;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public void setTipo_producto(String Tipo_producto) {
        this.Tipo_Producto = Tipo_producto;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setNum_tiquete(int num_tiquete) {
        this.num_tiquete = num_tiquete;
    }

    public void setTotalP(int totalP) {
        this.totalP = totalP;
    }

    public void setTotalNP(int totalNP) {
        this.totalNP = totalNP;
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
   public TipoCliente getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(TipoCliente TipoCliente) {
        this.TipoCliente = TipoCliente;
    }

    public tipoPaquete getTipoPaquete() {
        return this.TipoPaquete;
    }

    public void setTipoPaquete(tipoPaquete TipoPaquete) {
        this.TipoPaquete = TipoPaquete;
    }
    // cree otro metodo con diferente tipo de dato para ver si asi es mas
    //facil la manipulacion
    
    /*public String getFicha(){
    return this.TipoPaquete+"-"+ this.TipoCliente;
    }*/
    
    public String getFicha (){
        return this.Tipo_Producto+"-"+this.tipo_usuario;
    }
}
