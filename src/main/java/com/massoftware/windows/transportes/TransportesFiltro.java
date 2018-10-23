package com.massoftware.windows.transportes;

import com.massoftware.windows.UtilModel;


public class TransportesFiltro {

	private Integer transporte;
	private String nombre;


	public Integer getTransporte() {
		return transporte;
	}


	public void setSucursal(Integer transporte) {
		this.transporte = transporte;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	@Override
	public String toString() {
		return "TransporteFiltro [transporte=" + transporte + ", nombre=" + nombre + "]";
	}

}
