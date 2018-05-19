/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;



 //@author giank
 

public class LQueue<T> {
    public Nodo <T>front;
    public Nodo<T> rear;
    public int size;
    private Nodo<T> tmp;
    public Nodo <T>tmp2;
 
    public LQueue(){
        this.front = new Nodo<T>();
        this.front.setNext(null);
        this.rear = this.front;
        this.size = 0;
    }
    public void enqueue(Nodo<T> Object){
            if (size==0){
                this.rear.setNext(Object);
                this.rear= rear.getNext();
                this.rear.setNext(null);
                this.size++;
            }
            else {
                if(Object.getusuario()=="[D] Discapacitado"){
                    Object.setNext(front.getNext());
                    this.front.setNext(Object);
                    this.size++;
                }
                if(Object.getusuario()=="[E] Mujer Embarazada"){
                   tmp=front.getNext();
                   while(true){
                       if(tmp==rear){
                           tmp.setNext(Object);
                           Object.setNext(null);
                           rear=rear.getNext();
                           this.size++;
                           break;
                       }
                       else if(tmp.getNext().getusuario()== "[D] Discapacitado"){
                           tmp=tmp.getNext();
                       }
                       else{
                           Object.setNext(tmp.getNext());
                           tmp.setNext(Object);
                           this.size++;
                           break;
                       }
                   }
                }
                if(Object.getusuario()== "[M] Adulto Mayor"){
                    tmp=front.getNext();
                    while(true){
                       if(tmp==rear){
                           tmp.setNext(Object);
                           Object.setNext(null);
                           rear=rear.getNext();
                           this.size++;
                           break;
                       }
                       else if((tmp.getNext().getusuario()== "[D] Discapacitado")||(tmp.getNext().getusuario()== "[E] Mujer Embarazada")){
                           tmp=tmp.getNext();
                       }
                       else{
                           Object.setNext(tmp.getNext());
                           tmp.setNext(Object);
                           this.size++;
                           break;
                       }
                   }
                }
                if(Object.getusuario()=="[R] Regular"){
                    this.rear.setNext(Object);
                    this.rear=rear.getNext();
                    this.size++;
                }
                }
                
                
                
                  
                   
           }
    public void dequeue(){
        this.front=front.getNext();
    } 
                    
                
                
            
    public String toString(){
        String result = "**LQueue**\n";
        Nodo tFront = this.front;
        int tSize = this.size;
        while(tSize != 0){
            result+= tFront.getNext().getusuario() + " ";
            tFront = tFront.getNext();
            tSize--;
        }
        return result;
    }
    public int size(){
        return this.size;
    }
    public void clear(){
		this.front = new Nodo<>();
		this.rear = this.front;
		this.size = 0;
	}
    
    public Nodo<T> first(){
		if(this.size == 0){
			System.out.println("Queue is empty");
			return null;
		}
		return this.front;
	}
}

   