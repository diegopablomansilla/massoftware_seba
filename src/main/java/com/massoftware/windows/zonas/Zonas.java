package com.massoftware.windows.zonas;

import java.math.BigDecimal;

import com.massoftware.windows.UtilModel;

public class Zonas {

	private String zona;
	private String nombre;
	private BigDecimal bonificacion;
	private BigDecimal recargo;
	

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}

	public BigDecimal getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(BigDecimal bonificacion) {
		this.bonificacion = bonificacion;
	}

	public BigDecimal getRecargo() {
		return recargo;
	}

	public void setRecargo(BigDecimal recargo) {
		this.recargo = recargo;
	}

	@Override
	public String toString() {
		return "(" + zona + ") " + nombre;
	}

}
