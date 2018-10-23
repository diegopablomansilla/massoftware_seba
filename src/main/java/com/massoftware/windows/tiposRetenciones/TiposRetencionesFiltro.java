package com.massoftware.windows.tiposRetenciones;



public class TiposRetencionesFiltro {

	private Integer numero;
	private Integer gananciaIvaIngBruto;



	public Integer getNumero() {
		return numero;
	}



	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	public Integer getGananciaIvaIngBruto() {
		return gananciaIvaIngBruto;
	}



	public void setGananciaIvaIngBruto(Integer gananciaIvaIngBruto) {
		this.gananciaIvaIngBruto = gananciaIvaIngBruto;
	}



	@Override
	public String toString() {
		return "CentroDeCostoFiltro [numero=" + numero + ", gananciaIvaIngBruto=" + gananciaIvaIngBruto + "]";
	}

}
