package com.massoftware.windows.subCtaCte;

import com.massoftware.windows.UtilModel;

public class SubCtaCteFiltro {

	private Integer subCtaCte;
	private String nombre;

	public Integer getSubCtaCte() {
		return subCtaCte;
	}

	public void setSubCtaCte(Integer subCtaCte) {
		this.subCtaCte = subCtaCte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}

	@Override
	public String toString() {
		return "SubCtaCteFiltro [subCtaCte=" + subCtaCte + ", nombre=" + nombre + "]";
	}

}
