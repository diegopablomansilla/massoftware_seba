package com.massoftware.windows.subCtaCteProv;

import com.massoftware.windows.UtilModel;

public class SubCtaCteProvFiltro {

	private Integer subCtaCteProv;
	private String nombre;

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

	@Override
	public String toString() {
		return "SubCtaCteProvFiltro [subCtaCteProv=" + subCtaCteProv + ", nombre=" + nombre + "]";
	}

}
