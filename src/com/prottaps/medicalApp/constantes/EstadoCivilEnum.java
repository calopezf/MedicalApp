/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prottaps.medicalApp.constantes;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author saviasoft4
 */
public enum EstadoCivilEnum {
    
    SOLTERO("Soltero"), CASADO("Casado"), DIVORCIADO("Divorciado"), UNION_LIBRE("Uni\u00F3n Libre");
    
    private String etiqueta;
    
    private EstadoCivilEnum(String etiqueta){
        this.etiqueta=etiqueta;
    }

    public static List<EstadoCivilEnum> getEstadoCivilEnumList() {
        return Arrays.asList(EstadoCivilEnum.values());
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }   
}