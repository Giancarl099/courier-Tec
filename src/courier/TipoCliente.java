/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courier;

/**
 *
 * @author mac
 */
public enum TipoCliente {
    Embarazada("E"),
    MayorE("M"),
    Regular("R"),
    Desc("D");
    private final String tipoC;
     TipoCliente(String tipo){
        tipoC=tipo;
    }
     public String getTipoC(){
         return tipoC;
     }
    
}
