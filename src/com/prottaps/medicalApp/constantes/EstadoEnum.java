package com.prottaps.medicalApp.constantes;

public enum EstadoEnum {

    ACTIVO(1), INACTIVO(2);
    private Integer estadoBase;

    EstadoEnum(Integer estadoBase) {
        this.estadoBase = estadoBase;
    }

    public Integer getEstadoBase() {
        return estadoBase;
    }
}