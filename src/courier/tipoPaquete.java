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
public enum tipoPaquete {
    percedero("P"),
    noPercedero("NP");
    
    private final String tipoP;
    tipoPaquete(String tipo){
        tipoP=tipo;
    }
    public String gettipoV(){
        return tipoP;
    }
   
    
}
