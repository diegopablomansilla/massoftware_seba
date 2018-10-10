package com.massoftware.windows.talonarios;

import com.massoftware.windows.UtilModel;

public class TalonariosFiltro {

	private Integer multiProposito;
	private String nombre;

	
	public Integer getMultiProposito() {
		return multiProposito;
	}


	public void setMultiProposito(Integer multiProposito) {
		this.multiProposito = multiProposito;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	@Override
	public String toString() {
		return "TalonariosFiltro [Nº=" + multiProposito + ", nombre=" + nombre + "]";
	}

}
