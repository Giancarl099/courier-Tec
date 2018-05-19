/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//PLACIDO
package Estructuras;

import Estructuras.Nodos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author giank
 */

public class Colas<T> {
   private Nodos<T> inicio;
   private Nodos <T> fin;
   private int size;
  private int position;
   final String regex="R";
   private Nodos<T> current;
   public Colas(){
       inicio=new Nodos<>();
       fin=inicio;
       current=inicio;
       size=0;
       position=-1;
   }
   public void enqueque(T element){
      
                 Nodos<T> tFront = this.inicio;
        int tSize = this.size;
        int pos=this.position;
        while(tSize != 0){
            if(tFront.getNext().getElement().equals(element)){
                System.out.println ("No su puede agragar elementos iguales");
            }
            tFront = tFront.getNext();
            tSize--;
            pos--;
        }
        
        this.fin.setNext(new Nodos<>(element,null));
        this.fin=fin.getNext();
        this.size++;
        this.position++;
    }
    
       public void remove(int num){
        int tam=this.size;
        int pos=0;
        if ( num>this.size||num<0){
           System.out.print("error");
        }
        else{
            Nodos<T> tempo=this.inicio;
            Nodos<T> nTemp=this.inicio.getNext();
            while(pos!=num){
                 tempo=tempo.getNext();
                 nTemp=nTemp.getNext();
                 pos++;
                    
                }
            tempo.setNext(nTemp.getNext());
            if(nTemp==this.fin){
                this.fin=tempo;
            }
            this.size--;
            
                
            }
      
    
}
public int getPos(T element){
    Nodos<T> tempo=this.inicio.getNext();
    int pos=0;
    while(tempo.getElement()!=element){
        if (tempo==this.fin){
            return -1;
        }
        tempo=tempo.getNext();
        pos++;
    
}
    return pos;
}
public T dequeue(){
        int tamaño=size;
        if(this.size == 0){
            return null;
           
        }
        T temp = this.inicio.getNext().getElement();
        Nodos<T> nTemp = this.inicio.getNext();
        this.inicio.setNext(nTemp.getNext());
        if (this.fin == nTemp){
            this.fin = this.inicio;
        }
        this.size--;
        return temp;
    }
public String Strings(){
    Nodos<T> tempo=this.inicio.getNext();
    int tam=this.size;
    while(tam!=0){
        System.out.print(tempo.getElement());
        tempo=tempo.getNext();
        tam--;
        
    }
    return ("Fin de lista");
}
public int getSize(){
    return this.size;
}
public void setSize(int num){
    this.size=num;
}
public T getFirst(){
    if(this.size==0){
        System.out.print("Lista vacia");
        return null;
    }
    else{
        return this.inicio.getNext().getElement();
    }
    
}
public boolean Vacio(){
    boolean bandera=false;
    if(this.size==0){
        bandera=true;
    }
    return bandera;
}
public String toString(){
        String result = "**LQueue**\n";
        Nodos<T> tFront = this.inicio;
        int tSize = this.size;
        while(tSize != 0){
            result+= tFront.getNext().getElement() + " ";
            tFront = tFront.getNext();
            tSize--;
        }
        return result;
    }
//ingresa una posicion y devuelve el elemnto en esa posicion
    public T getElementfrom(int pos) {
        int num=0;
        Nodos<T> tempo=this.inicio.getNext();
        while(num!=pos){
            tempo=tempo.getNext();
            num++;
           
            }
        return tempo.getElement();
        }
  



 
    }
    






