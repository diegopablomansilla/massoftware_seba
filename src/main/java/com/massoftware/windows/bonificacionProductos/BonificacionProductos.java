package com.massoftware.windows.bonificacionProductos;

import java.math.BigDecimal;

import com.massoftware.windows.UtilModel;

public class BonificacionProductos {

	private Integer grupoBonif;
	private Integer bonifProducto;
	private String descripcion;
	private BigDecimal porcentaje;
	
	
	public Integer getGrupoBonif() {
		return grupoBonif;
	}


	public void setGrupoBonif(Integer grupoBonif) {
		this.grupoBonif = grupoBonif;
	}


	public Integer getBonifProducto() {
		return bonifProducto;
	}


	public void setBonifProducto(Integer bonifProducto) {
		this.bonifProducto = bonifProducto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = UtilModel.format(descripcion);
	}


	public BigDecimal getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}


	@Override
	public String toString() {
		return "(" + grupoBonif + " - "+ bonifProducto +") " + descripcion;
	}

}
