package com.massoftware.windows.unidadesDeMedida;

import java.math.BigDecimal;
import com.massoftware.windows.UtilModel;


public class UnidadesDeMedida {

	private Integer unidadDeMedida;
	private String nombre;
	private String abreviatura;
	private Integer unidadDeMedidaAfip;
	private Integer dimension;
	private BigDecimal escala;
	
	
	public Integer getUnidadDeMedida() {
		return unidadDeMedida;
	}


	public void setUnidadDeMedida(Integer unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	public String getAbreviatura() {
		return abreviatura;
	}


	public void setAbreviatura(String abreviatura) {
		this.abreviatura = UtilModel.format(abreviatura);
	}


	public Integer getUnidadDeMedidaAfip() {
		return unidadDeMedidaAfip;
	}


	public void setUnidadDeMedidaAfip(Integer unidadDeMedidaAfip) {
		this.unidadDeMedidaAfip = unidadDeMedidaAfip;
	}


	public Integer getDimension() {
		return dimension;
	}


	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}


	public BigDecimal getEscala() {
		return escala;
	}


	public void setEscala(BigDecimal escala) {
		this.escala = escala;
	}


	@Override
	public String toString() {
		return "(" + unidadDeMedida + ") " + nombre;
	}

}
