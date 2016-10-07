/**
 * RolservicioImpl.java
 * 
 * Thu Sep 26 17:13:37 ECT 2013
 */
package com.prottaps.medicalApp.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.prottaps.medicalApp.constantes.EstadoEnum;
import com.prottaps.medicalApp.crud.ServicioCrud;
import com.prottaps.medicalApp.modelo.Rol;

@Stateless(name = "RolServicio")
@LocalBean
public class RolServicio {
	@EJB
	ServicioCrud servicioCrud;

	public List<Rol> devuelveRolesActivos() {
		Rol rol = new Rol();
		rol.setEstado(EstadoEnum.ACT);
		return servicioCrud.findOrder(rol);
	}

	public List<Rol> obtieneRolesActivos() {
		Rol rol = new Rol();
		rol.setEstado(EstadoEnum.ACT);
		return servicioCrud.findOrder(rol);
	}
	
}
