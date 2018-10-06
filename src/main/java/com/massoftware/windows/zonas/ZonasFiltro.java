package com.massoftware.windows.zonas;

import com.massoftware.windows.UtilModel;

public class ZonasFiltro {

	private String zona;
	private String nombre;

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = UtilModel.format(zona);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}

	@Override
	public String toString() {
		return "ZonasFiltro [zona=" + zona + ", nombre=" + nombre + "]";
	}

}
