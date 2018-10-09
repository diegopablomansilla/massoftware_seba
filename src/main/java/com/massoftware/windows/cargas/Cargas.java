package com.massoftware.windows.cargas;


import com.massoftware.windows.UtilModel;


public class Cargas {

	private Integer carga;
	private String nombre;
	private Integer transporte;

	
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


	public Integer getTransporte() {
		return transporte;
	}


	public void setTransporte(Integer transporte) {
		this.transporte = transporte;
	}


	@Override
	public String toString() {
		return "(" + carga + ") " + nombre;
	}

}
