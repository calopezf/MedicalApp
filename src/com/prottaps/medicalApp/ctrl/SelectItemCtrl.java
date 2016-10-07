/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prottaps.medicalApp.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import com.prottaps.medicalApp.constantes.EstadoCivilEnum;
import com.prottaps.medicalApp.constantes.EstadoEnum;
import com.prottaps.medicalApp.constantes.RolEnum;

/**
 *
 * @author juan
 */
@ManagedBean(name = "selectItemCtrl")
public class SelectItemCtrl extends BaseCtrl {

	private static final long serialVersionUID = 1L;

	private List<SelectItem> estadoEnum;
	private List<SelectItem> rolEnum;
	private List<SelectItem> estadoCivil;
	private List<SelectItem> pais;
	private List<SelectItem> tipoIdentificacion;

	public List<SelectItem> getEstadoEnum() {
		if (estadoEnum == null) {
			estadoEnum = new ArrayList<SelectItem>();
			for (EstadoEnum e : EstadoEnum.values()) {
				estadoEnum.add(new SelectItem(e, e.toString()));
			}
		}
		return estadoEnum;
	}

	public void setEstadoEnum(List<SelectItem> estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	public List<SelectItem> getRolEnum() {
		if (rolEnum == null) {
			rolEnum = new ArrayList<SelectItem>();
			for (RolEnum re : RolEnum.values()) {
				rolEnum.add(new SelectItem(re, re.toString()));
			}
		}
		return rolEnum;
	}

	public void setRolEnum(List<SelectItem> rolEnum) {
		this.rolEnum = rolEnum;
	}

	public List<SelectItem> getEstadoCivil() {
		if (estadoCivil == null) {
			estadoCivil = new ArrayList<SelectItem>();
			for (EstadoCivilEnum ec : EstadoCivilEnum.values()) {
				estadoCivil.add(new SelectItem(ec, ec.getEtiqueta()));
			}
		}
		return estadoCivil;
	}

	public void setEstadoCivil(List<SelectItem> estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
