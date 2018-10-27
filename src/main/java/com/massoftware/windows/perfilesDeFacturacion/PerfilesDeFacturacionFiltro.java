package com.massoftware.windows.perfilesDeFacturacion;


import com.massoftware.windows.claseComprobante.ClaseComprobante;


public class PerfilesDeFacturacionFiltro {

	private ClaseComprobante claseComprobante;
	private Integer numero;


	public ClaseComprobante getClaseComprobante() {
		return claseComprobante;
	}

	public void setClaseComprobante(ClaseComprobante claseCbte) {
		this.claseComprobante = claseCbte;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	@Override
	public String toString() {
		return "PerfilesDeFacturacionFiltro [claseCbte=" + claseComprobante + ", numero=" + numero + "]";
	}

}
