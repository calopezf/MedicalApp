package com.prottaps.medicalApp.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.prottaps.medicalApp.constantes.EstadoEnum;

@Entity
@Table(name = "ROL", schema = "sch_surti")
public class Rol implements Serializable {

    @Id
    @Column(name = "id")
    private String id;//atado a RolEnum
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "usuario_rol", joinColumns = {
//        @JoinColumn(name = "rol_id", referencedColumnName = "id")},
//    inverseJoinColumns =
//    @JoinColumn(name = "usuario_id", referencedColumnName = "id"))
//    private List<Usuario> usuarios;
//    public List<Usuario> getUsuarios() {
//        return usuarios;
//    }
//
//    public void setUsuarios(List<Usuario> usuarios) {
//        this.usuarios = usuarios;
//    }
    public EstadoEnum isEstado() {
        return getEstado();
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public EstadoEnum getEstado() {
        return estado;
    }

}