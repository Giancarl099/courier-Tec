/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courier;

import java.util.ArrayList;
import java.util.List;
import Estructuras.Colas;
/**
 *
 * @author mac
 */
public class Ficha {
    public int Numero;
    //private String Cliente;
    public int Codigo;
    int numD = 0;
    int numM = 0;
    int numE = 0;
    int numR = 0;
    Colas<String> listaDes=new Colas<>();
    Colas<String> listaMay=new Colas<>();
    Colas<String> listaEmb=new Colas<>();
    Colas<String> listaReg=new Colas<>();
    List<String> listaD = new ArrayList<String>();
    List<String> listaM = new ArrayList<String>();
    List<String> listaE = new ArrayList<String>();
    List<String> listaR = new ArrayList<String>();
    List<List<String>> ArrayGeneral=new ArrayList<>();
    Colas<Colas<String>> colaGeneral=new Colas<>();
    //Cliente cliente = new Cliente();
    private Cliente cliente;
    
    public Ficha() {
       }
    
    public Ficha(int Numero, String Cliente,int Codigo) {
        this.Numero = Numero;
        //this.Cliente = Cliente;
        this.Codigo = Codigo;
        }
    //metodo que no recibe el codigo 
    // qué hace código ?
    public Ficha(int Numero, Cliente cliente) {
        this.Numero = Numero;
        this.cliente = cliente;
        this.Codigo = Codigo;
        }
    
    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    //public String getCliente() {
        //return Cliente;
    //}

    //public void setCliente(String Cliente) {
        //this.Cliente = Cliente;
    //}

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
    public String getNumeroE() {
        if(numE == 99){
            numE = 0;
        }
        else{
            numE = numE+1;
        }
        return Integer.toString(numE);
    }
    public String getNumeroD() {
        if(numD == 99){
           numD = 0;
        }
        else{
            numD = numD+1;
        }
        return Integer.toString(numD);
    }
    public String getNumeroM() {
        if(numM == 99){
            numM = 0;
        }
        else{
            numM = numM+1;
        }
        return Integer.toString(numM);
    }
    public String getNumeroR() {
        if(numR == 99){
            numR = 0;
        }
        else{
            numR = numR+1;
        }
        return Integer.toString(numR);
    }
    
    public void generarFichaCliente(){
        
       String fichita = cliente.getFicha();
       if((fichita.substring(fichita.length() - 1)).equals("E")){
          fichita += "-"+getNumeroE();
          listaE.add(fichita);
          this.listaEmb.enqueque(fichita);
          //imprima la lista
           System.out.println("imprimiendo las FICHAS las COLAS");
           System.out.println(this.listaEmb.toString());
            System.out.println("imprimiendo las FICHAS los ARREGLOS");
           System.out.println(this.listaE.toString());
       }
       if((fichita.substring(fichita.length() - 1)).equals("R")){
          fichita += "-"+fichita+getNumeroR();
          
          listaR.add(fichita);
          this.listaReg.enqueque(fichita);
          //imprima la lista
           System.out.println("imprimiendo las FICHAS");
           System.out.println(this.listaReg.toString());
            System.out.println("imprimiendo las FICHAS los ARREGLOS");
           System.out.println(this.listaR.toString());
       }
       if((fichita.substring(fichita.length() - 1)).equals("M")){
          fichita += "-"+ fichita+getNumeroM();
          
          listaM.add(fichita);
          this.listaMay.enqueque(fichita);
          //imprima la lista
           System.out.println("imprimiendo las FICHAS");
           System.out.println(this.listaMay.toString());
            System.out.println("imprimiendo las FICHAS los ARREGLOS");
           System.out.println(this.listaM.toString());
       }
       if((fichita.substring(fichita.length() - 1)).equals("D")){
          fichita += "-"+fichita+getNumeroD();
          
          listaD.add(fichita);
          this.listaDes.enqueque(fichita);
          //imprima la lista
           System.out.println("imprimiendo las FICHAS");
           System.out.println(this.listaDes.toString());
            System.out.println("imprimiendo las FICHAS los ARREGLOS");
           System.out.println(this.listaD.toString());
       }
    
    }
    
       public void ingresarListaGeneral(){
         this.ArrayGeneral.add(listaE);
         this.ArrayGeneral.add(this.listaD);
         
         this.ArrayGeneral.add(listaM);
         this.ArrayGeneral.add(listaR);
           System.out.println("la lista de elementos es: "+ArrayGeneral);
           
       }
       
       public void ingresarColaGeneral(){
           this.colaGeneral.enqueque(this.listaDes);
           this.colaGeneral.enqueque(this.listaEmb);
           this.colaGeneral.enqueque(this.listaMay);
           this.colaGeneral.enqueque(this.listaReg);
           
           System.out.println("la lista de elementos es: "+colaGeneral);
           
       } 
    }

    

