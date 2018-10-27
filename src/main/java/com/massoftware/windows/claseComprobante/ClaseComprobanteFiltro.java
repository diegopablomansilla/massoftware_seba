package com.massoftware.windows.claseComprobante;

import com.massoftware.windows.UtilModel;

public class ClaseComprobanteFiltro {

	private Integer numero;
	private String nombre;

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

	@Override
	public String toString() {
		return "ClaseComprobanteFiltro [numero=" + numero + ", nombre=" + nombre + "]";
	}

}
