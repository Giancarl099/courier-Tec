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
public enum tipoVentana {
    colaPrioridad("CP"),
    arbolBinarioH("H");
    private final String tipoV;
    tipoVentana(String tipo){
        tipoV=tipo;
    }
    public String getTipoV(){
        return tipoV;
    }
    
    
}
