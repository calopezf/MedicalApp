/*
 * AdmisionCtrl.java Dec 7, 2014
 *
 * Copyright (c) 2014-2015 Saviasoft. Biodimed.
 * All rights reserved.
 *
 */
package com.prottaps.medicalApp.ctrl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.prottaps.medicalApp.ctrl.base.BaseCtrl;
import com.prottaps.medicalApp.servicio.PersonaServicio;

/**
 * @author Daniel Cardenas
 *
 */
@ManagedBean(name = "pruebaCtrl")
@ViewScoped
public class PruebaCtrl extends BaseCtrl implements Serializable {

	private static final long serialVersionUID = 7536975529010495547L;
	
	@EJB
	private PersonaServicio personaServicio;
	
	public void insertarPersonaPrueba() {
		this.personaServicio.insertPersonaPrueba();
	}

}