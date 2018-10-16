package com.massoftware.windows.subCtaCteProv;

import com.massoftware.windows.UtilModel;

public class SubCtaCteProv {

	private Integer subCtaCteProv;
	private String nombre;
	private boolean ctaCteGeneral;
	private Integer apropiacionContable;
	
	
	public Integer getSubCtaCteProv() {
		return subCtaCteProv;
	}


	public void setSubCtaCteProv(Integer subCtaCteProv) {
		this.subCtaCteProv = subCtaCteProv;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	public boolean isCtaCteGeneral() {
		return ctaCteGeneral;
	}


	public void setCtaCteGeneral(boolean ctaCteGeneral) {
		this.ctaCteGeneral = ctaCteGeneral;
	}


	public Integer getApropiacionContable() {
		return apropiacionContable;
	}


	public void setApropiacionContable(Integer apropiacionContable) {
		this.apropiacionContable = apropiacionContable;
	}


	@Override
	public String toString() {
		return "(" + subCtaCteProv + ") " + nombre;
	}

}
