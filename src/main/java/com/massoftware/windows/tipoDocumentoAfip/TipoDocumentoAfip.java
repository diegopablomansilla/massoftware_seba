package com.massoftware.windows.tipoDocumentoAfip;


import com.massoftware.windows.UtilModel;


public class TipoDocumentoAfip {

	private Integer tipo;
	private String descripcion;

	
	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = UtilModel.format(descripcion);
	}


	@Override
	public String toString() {
		return "(" + tipo + ") " + descripcion;
	}

}
