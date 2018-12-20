package com.massoftware.windows.sucursal;


import com.massoftware.windows.UtilModel;

public class SucursalFiltro {

	private Integer sucursal;
	private String nombre;


	public Integer getSucursal() {
		return sucursal;
	}


	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	@Override
	public String toString() {
		return "SucursalFiltro [sucursal=" + sucursal + ", nombre=" + nombre + "]";
	}

	
	
}
