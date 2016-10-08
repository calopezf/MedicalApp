/*
 * BaseCtrl.java Oct 22, 2014
 *
 * Copyright (c) 2014-2015 Saviasoft. Biodimed.
 * All rights reserved.
 *
 */
package com.prottaps.medicalApp.ctrl.base;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.security.jacc.PolicyContext;
import javax.security.jacc.PolicyContextException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Daniel Cardenas
 *
 */
public class BaseCtrl implements Serializable {

	private static final long serialVersionUID = -6460393949605780321L;

	private Date currentDate;

	/**
	 * Retorna el usuario remoto
	 * 
	 * @return
	 */
	public String getRemoteUser() {

		return getExternalContext().getRemoteUser();

	}

	/**
	 * Retorna el external context
	 * 
	 * @return
	 */
	protected ExternalContext getExternalContext() {

		return getFacesContext().getExternalContext();

	}

	/**
	 * Retorna el contexto de JSF
	 * 
	 * @return
	 * 
	 */
	protected FacesContext getFacesContext() {

		return (FacesContext.getCurrentInstance());

	}

	/**
	 * Retorna el context path
	 * 
	 * @return
	 * 
	 */
	protected String getContextPath() {
		return getHttpServletRequest().getContextPath();
	}

	/**
	 * Retorna el http servlet request
	 * 
	 * @return
	 * 
	 */
	protected HttpServletRequest getHttpServletRequest() {
		return ((HttpServletRequest) getExternalContext().getRequest());
	}

	protected HttpServletResponse getHttpServletResponse() {
		return ((HttpServletResponse) getExternalContext().getResponse());
	}

	/**
	 * Returna el request parameter
	 * 
	 * @return
	 * 
	 */
	protected String getHttpServletRequestParam(String paramName) {
		return getHttpServletRequest().getParameter(paramName);
	}

	/**
	 * 
	 * Params se envia null si no hay parametros
	 * 
	 * @param key
	 * 
	 * @param params
	 * 
	 * @return
	 * 
	 */
	protected String getBundleMensajes(String key, Object params[]) {

		Locale locale = getFacesContext().getViewRoot().getLocale();

		ResourceBundle bundle = ResourceBundle.getBundle(
				"com.sigimo.base.resources.mensajes", locale,
				getCurrentClassLoader(params));

		String mensaje = bundle.getString(key);

		if (params != null && params.length > 0) {
			MessageFormat mf = new MessageFormat(mensaje, locale);
			mensaje = mf.format(params, new StringBuffer(), null).toString();
		}

		return mensaje;

	}

	/**
	 * @param defaultObject
	 * 
	 * @return
	 * 
	 */
	protected static ClassLoader getCurrentClassLoader(Object defaultObject) {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = defaultObject.getClass().getClassLoader();
		}
		return loader;

	}

	/**
	 * 
	 * Agrega un mensaje de error para mostrarlo en pantalla.
	 * 
	 * @param componentId
	 *            - null si se quiere mensaje global
	 * 
	 * @param summary
	 * 
	 * @param detail
	 * 
	 */
	protected void addErrorMessage(String componentId, String summary,
			String detail) {

		addMessage(componentId, summary, detail, FacesMessage.SEVERITY_ERROR);

	}

	private void addMessage(String componentId, String summary, String detail,
			Severity severity) {

		FacesMessage facesMsg = new FacesMessage(severity, summary, detail);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(componentId, facesMsg);
	}

	/**
	 * 
	 * Agrega un mensaje de error para mostrarlo en pantalla.
	 * 
	 * @param componentId
	 *            - null si se quiere mensaje global
	 * 
	 * @param summary
	 * 
	 * @param detail
	 * 
	 */
	protected void addInfoMessage(String componentId, String summary,
			String detail) {

		addMessage(componentId, summary, detail, FacesMessage.SEVERITY_INFO);

	}

	public Date getCurrentDate() {
		if (currentDate == null) {
			currentDate = new Date();
		}
		return currentDate;
	}

	public String getCurrentClientIpAddress() {
		String remoteIp = "";
		try {
			HttpServletRequest request = (HttpServletRequest) PolicyContext
					.getContext("javax.servlet.http.HttpServletRequest");
			if (request != null) {
				remoteIp = request.getRemoteAddr();
			}
		} catch (PolicyContextException e) {
		}
		// ServerConfigUtil.
		// String currentThreadName = Thread.currentThread().getName();
		// int begin = currentThreadName.indexOf('[') +1;
		// int end = currentThreadName.indexOf(']')-1;
		// String remoteClient = currentThreadName.substring(begin, end);
		return remoteIp;
	}
}