package com.massoftware.windows.cargas;

import com.massoftware.windows.UtilModel;


public class CargasFiltro {

	private Integer carga;
	private String nombre;


	public Integer getCarga() {
		return carga;
	}


	public void setCarga(Integer carga) {
		this.carga = carga;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	@Override
	public String toString() {
		return "CargaFiltro [carga=" + carga + ", nombre=" + nombre + "]";
	}

}
