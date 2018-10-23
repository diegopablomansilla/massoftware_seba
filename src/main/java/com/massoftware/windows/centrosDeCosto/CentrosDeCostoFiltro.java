package com.massoftware.windows.centrosDeCosto;

import com.massoftware.windows.UtilModel;


public class CentrosDeCostoFiltro {

	private Integer numero;
	private String nombre;
	private Integer tipo;


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "CentroDeCostoFiltro [numero=" + numero + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}

}
