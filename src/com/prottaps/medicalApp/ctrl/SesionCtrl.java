///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prottaps.medicalApp.ctrl;
//
//import java.util.List;
//
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//
//import com.prottaps.medicalApp.modelo.Usuario;
//
///**
// *
// * @author juan
// */
//@ManagedBean(name = "sesionCtrl")
//@SessionScoped
//public class SesionCtrl extends BaseCtrl {
//
//    @EJB
////    private UsuarioServicio usuarioServicio;
//    private Usuario usuarioLogueado;
//
//    public void idleListener() {
//        System.out.println("invalida la sesion");
//        //invalidate session 
//        getHttpServletRequest().getSession(false).invalidate();
//    }
//
//
//    public Usuario getUsuarioLogueado() {
//        if (usuarioLogueado == null) {
////            usuarioLogueado = usuarioServicio.findByPk(getRemoteUser());
//        }
//        return usuarioLogueado;
//    }
//
//    public void setUsuarioLogueado(Usuario usuarioLogueado) {
//        this.usuarioLogueado = usuarioLogueado;
//    }
//}