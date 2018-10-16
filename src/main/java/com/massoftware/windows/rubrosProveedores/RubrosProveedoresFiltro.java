package com.massoftware.windows.rubrosProveedores;

import com.massoftware.windows.UtilModel;

public class RubrosProveedoresFiltro {

	private Integer tipoDeProv;
	private String nombre;

	public Integer getTipoDeProv() {
		return tipoDeProv;
	}

	public void setTipoDeProv(Integer tipoDeProv) {
		this.tipoDeProv = tipoDeProv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}

	@Override
	public String toString() {
		return "RubrosProveedoresFiltro [tipoDeProv=" + tipoDeProv + ", nombre=" + nombre + "]";
	}

}
