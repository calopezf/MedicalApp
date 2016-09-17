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
public enum SexoEnum {
    
    MASCULINO, FEMENINO;

    public static List<SexoEnum> getSexoEnumList() {
        return Arrays.asList(SexoEnum.values());
    }
    
}
