package com.massoftware.windows.unidadesDeMedida;

import com.massoftware.windows.UtilModel;

public class UnidadesDeMedidaFiltro {

	private Integer unidadDeMedida;
	private String nombre;

	public Integer getUnidadDeMedida() {
		return unidadDeMedida;
	}

	public void setUnidadDeMedida(Integer unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}

	@Override
	public String toString() {
		return "UnidadesDeMedidaFiltro [unidadDeMedida=" + unidadDeMedida + ", nombre=" + nombre + "]";
	}

}
