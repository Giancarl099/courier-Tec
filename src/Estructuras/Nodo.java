/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author mac
 */
public class Nodo <T>{
        //atributos de la clase nodo

    private String nombre;
    private String correo;
    private String clase;
    private String usuario;
    private Nodo<T> next;
    

    //Constructores de la clase nodo
    public Nodo() {
        this.nombre = null;
        this.correo = null;
        this.clase = null;
        this.usuario = null;
        this.next = null;
        
    }

    public Nodo(String nombre, String correo, String clase, String usuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.clase = clase;
        this.usuario = usuario;
        this.next = null;
    }

    public Nodo(String nombre, String correo, String clase, String usuario, Nodo<T> next) {
        this.nombre = nombre;
        this.correo = correo;
        this.clase = clase;
        this.usuario = usuario;
        this.next = next;
       
    }

    //metodos

    public String getnombre() {
        return this.nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getcorreo() {
        return this.correo;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }
    
    public String getclase() {
        return this.clase;
    }

    public void setclase(String clase) {
        this.clase = clase;
    }
    
    public String getusuario() {
        return this.usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public Nodo<T> getNext() {
        return this.next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }
    
}

    
