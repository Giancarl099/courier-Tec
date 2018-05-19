/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
//PLACIDO
/**
 *
 * @author giank
 */
public class Nodos<T> {
    private T element;
    private Nodos<T> next;
    private Nodos<T> previous;
    private Nodos<T> izq;
    private Nodos<T> der;
    private Nodos<T> Padre;
    
     public Nodos(){
        this.element=null;
        this.next=null;
        this.previous=null;
        this.izq=null;
        this.der=null;
    }
     public Nodos( T element,Nodos<T> previous, Nodos<T> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;

        }
    public Nodos(T elemento,Nodos<T> next){
        this.element=elemento;
        this.next=next;
        this.previous=null;
    }
    public Nodos(T element){
        this.element=element;
    }
    public T getElement(){
        return element;
    }
    public void setElement(T element){
        this.element=element;
    }
    public Nodos<T> getNext(){
        return next;
    }
    public void setNext(Nodos<T> siguiente){
        next=siguiente;
    }
    public Nodos<T> getPrevious(){
        return previous;
    } 
   public void setPrevious(Nodos<T> anterior ){
       this.previous=anterior;
   }
   public void setIzq(Nodos<T> left){
       this.izq=left;
   }
   public Nodos<T> getIzq(){
       return this.izq;
   }
   public void setDer(Nodos<T> right){
       this.der=right;
   }
   public Nodos<T> getDer(){
       return this.der;
   }
   public boolean isLeaf(){
       if(this.der==null&&this.izq==null){
           return true;
       }
       else{
           return false;
       }
   }
   public Nodos<T> getPadre(){
       return this.Padre;
   }
   public void setPadre(Nodos<T> father){
       this.Padre=father;
   }
   
}
