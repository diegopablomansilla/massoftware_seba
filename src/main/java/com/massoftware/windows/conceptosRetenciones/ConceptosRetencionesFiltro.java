package com.massoftware.windows.conceptosRetenciones;



public class ConceptosRetencionesFiltro {

	private Integer tipoRetencion;
	private String nombreRetencion;


	public Integer getTipoRetencion() {
		return tipoRetencion;
	}


	public void setTipoRetencion(Integer tipoRetencion) {
		this.tipoRetencion = tipoRetencion;
	}


	public String getNombreRetencion() {
		return nombreRetencion;
	}


	public void setNombreRetencion(String nombreRetencion) {
		this.nombreRetencion = nombreRetencion;
	}


	@Override
	public String toString() {
		return "ConceptosRetencionesFiltro [tipoRetencion=" + tipoRetencion + "]";
	}

}
