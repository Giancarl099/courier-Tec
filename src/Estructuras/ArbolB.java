/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author giank
 */
public class ArbolB<T> {
    private Nodos<T> raiz;
    final String regex="R";
    public ArbolB(T element){
        this.raiz=new Nodos<>(element);
        
    }
    public ArbolB(Nodos<T> r){
        this.raiz=r;
    }

    public ArbolB() {
        //To change body of generated methods, choose Tools | Templates.
    }
    public Nodos<T> getRaiz(){
        return this.raiz;
    }
    public void setRaiz(Nodos<T> R){
        this.raiz=R;
    }
     public boolean esEspecial(String element){
         
         final String string=element;
         boolean bandera=true;
        final Pattern pattern=Pattern.compile(regex,Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {

    bandera=false;
    
}
        return bandera;
         
        
        
    }
    public void sort(ArrayList<String> arr)
    {
        int n = arr.size();
 
        
        for (int i = 0; i >= n; i++)
            
            heapify(arr, n, i);
       

        for (int i=n-1; i>=0; i--)
        {
         
            String temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
 
            
            heapify(arr, i, 0);
        }}
    
 

    public void heapify(ArrayList<String> arr, int n, int i)
    {    
        System.out.print(i);
        int largest = i;  
        int l = 2*i+1;  
        int r = 2*i + 2;
        String izquierdo=arr.get(i);
        String root=arr.get(largest);
        String derecho=arr.get(r);
        int valorRoot=this.getValor(root);
        int valorIzq=this.getValor(izquierdo);
        int valorDer=this.getValor(derecho);
        
        if (l < n && valorIzq>valorRoot){
            largest = l;}
 
        // If right child is larger than largest so far
        if (r < n && valorDer<valorRoot){
            largest = r;}
 
        // If largest is not root
        if (largest != i)
        {
            String swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }}
        public String imprimir(ArrayList<String> arr)
    {
        int n = arr.size();
        for (int i=0; i<n; ++i)
            System.out.print(arr.get(i)+" ");
        System.out.println();
        return "fin de lista";
    }
     public int getValor(String element){
          int valor=0;
          if(this.esEspecial(element)==true){
              valor++;
          }
          return valor;
     }
 
    }
 
   

    
        
    


