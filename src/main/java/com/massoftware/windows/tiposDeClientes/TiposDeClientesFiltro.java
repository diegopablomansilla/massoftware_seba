package com.massoftware.windows.tiposDeClientes;

import com.massoftware.windows.UtilModel;


public class TiposDeClientesFiltro {

	private Integer tipoDeCliente;
	private String nombre;



	public Integer getTipoDeCliente() {
		return tipoDeCliente;
	}



	public void setTipoDeCliente(Integer tipoDeCliente) {
		this.tipoDeCliente = tipoDeCliente;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}



	@Override
	public String toString() {
		return "TipoDeClienteFiltro [tipoDeCliente=" + tipoDeCliente + ", nombre=" + nombre + "]";
	}

}
