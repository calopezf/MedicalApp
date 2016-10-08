/**
 * PersonaservicioImpl.java
 * 
 * Thu Oct 31 09:35:44 ECT 2013
 */
package com.prottaps.medicalApp.servicio;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.prottaps.medicalApp.crud.ServicioCrud;
import com.prottaps.medicalApp.modelo.Persona;

@Stateless
@LocalBean
public class ServicioPersona {

	@EJB
	private ServicioCrud servicioCrud;
	
	public void insertPersonaPrueba() {
		Persona persona = new Persona();
		persona.setIdentificacion("1782934212");
		persona.setPrimerNombre("Mulo");
		persona.setPrimerApellido("Trolo");
		this.servicioCrud.insert(persona);
	}
}
