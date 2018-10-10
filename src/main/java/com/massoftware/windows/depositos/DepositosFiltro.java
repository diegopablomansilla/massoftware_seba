package com.massoftware.windows.depositos;

import com.massoftware.windows.UtilModel;
import com.massoftware.windows.sucursales.Sucursales;

public class DepositosFiltro {

	private Sucursales sucursal;
	private Integer deposito;
	private String nombre;

	
	public Sucursales getSucursal() {
		return sucursal;
	}


	public void setSucursal(Sucursales sucursal) {
		this.sucursal = sucursal;
	}


	public Integer getDeposito() {
		return deposito;
	}


	public void setDeposito(Integer deposito) {
		this.deposito = deposito;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	@Override
	public String toString() {
		return "DepositosFiltro [sucursal=" + sucursal + ", deposito=" + deposito
				+ ", nombre=" + nombre + "]";
	}

}
