package com.massoftware.windows.condicionesDeVentas;

import com.massoftware.windows.UtilModel;

public class CondicionesDeVentasFiltro {

	private Integer condDeVenta;
	private String detalle;

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

	@Override
	public String toString() {
		return "CondDeVentaFiltro [condDeVenta=" + condDeVenta + ", detalle=" + detalle + "]";
	}

}
