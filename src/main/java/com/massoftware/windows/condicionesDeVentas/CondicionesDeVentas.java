package com.massoftware.windows.condicionesDeVentas;


import com.massoftware.windows.UtilModel;


public class CondicionesDeVentas {
	private char modulo;
	private Integer condDeVenta;
	private String detalle;
	private String detalleTexto;
	private boolean llamaFondo;
	private String bonificacionProntoPago;
	private Integer ctaCteDiasTolerancia;
	private Integer diasProntoPago;
	private boolean esContado;
	private boolean activo;

	


	public char getModulo() {
		return modulo;
	}


	public void setModulo(char modulo) {
		this.modulo = modulo;
	}


	public Integer getCondDeVenta() {
		return condDeVenta;
	}


	public void setCondDeVenta(Integer condDeVenta) {
		this.condDeVenta = condDeVenta;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = UtilModel.format(detalle);
	}


	public String getDetalleTexto() {
		return detalleTexto;
	}


	public void setDetalleTexto(String detalleTexto) {
		this.detalleTexto = UtilModel.format(detalleTexto);
	}


	public boolean isLlamaFondo() {
		return llamaFondo;
	}


	public void setLlamaFondo(boolean llamaFondo) {
		this.llamaFondo = llamaFondo;
	}


	public String getBonificacionProntoPago() {
		return bonificacionProntoPago;
	}


	public void setBonificacionProntoPago(String bonificacionProntoPago) {
		this.bonificacionProntoPago = UtilModel.format(bonificacionProntoPago);
	}


	public Integer getCtaCteDiasTolerancia() {
		return ctaCteDiasTolerancia;
	}


	public void setCtaCteDiasTolerancia(Integer ctaCteDiasTolerancia) {
		this.ctaCteDiasTolerancia = ctaCteDiasTolerancia;
	}


	public Integer getDiasProntoPago() {
		return diasProntoPago;
	}


	public void setDiasProntoPago(Integer diasProntoPago) {
		this.diasProntoPago = diasProntoPago;
	}


	public boolean isEsContado() {
		return esContado;
	}


	public void setEsContado(boolean esContado) {
		this.esContado = esContado;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}







	@Override
	public String toString() {
		return "(" + condDeVenta + ") " + detalle;
	}

}
