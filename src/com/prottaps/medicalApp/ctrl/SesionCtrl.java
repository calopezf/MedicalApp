/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prottaps.medicalApp.ctrl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.prottaps.medicalApp.modelo.Usuario;
import com.prottaps.medicalApp.servicio.ServicioUsuario;

/**
 *
 * @author cristian
 */
@ManagedBean(name = "sesionCtrl")
@SessionScoped
public class SesionCtrl extends BaseCtrl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ServicioUsuario usuarioServicio;
	private Usuario usuarioLogueado;

	public void idleListener() {
		System.out.println("invalida la sesion");
		// invalidate session
		getHttpServletRequest().getSession(false).invalidate();
	}

	public Usuario getUsuarioLogueado() {
		if (usuarioLogueado == null) {
			usuarioLogueado = usuarioServicio
					.obtieneUsuarioXCedula(getRemoteUser());
		}
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}
}