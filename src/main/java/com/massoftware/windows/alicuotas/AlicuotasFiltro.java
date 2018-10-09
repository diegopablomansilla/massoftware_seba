package com.massoftware.windows.alicuotas;

import com.massoftware.windows.UtilModel;


public class AlicuotasFiltro {

	private Integer codigo;
	private String descripcion;



	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = UtilModel.format(descripcion);
	}


	@Override
	public String toString() {
		return "AlicuotasFiltro [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

}
