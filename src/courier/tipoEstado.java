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
public enum tipoEstado {
    libre("L"),
    ocupado("O");
    private final String estado;
    tipoEstado(String t){
        estado=t;
    }
    public String getEstado(){
        return estado;
    }
    
}
