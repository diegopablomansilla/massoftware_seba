package com.massoftware.windows.bonificacionGrupos;

import com.massoftware.windows.UtilModel;

public class BonificacionGruposFiltro {

	private Integer grupoBonif;
	private String descripcion;

	public Integer getGrupoBonif() {
		return grupoBonif;
	}


	public void setGrupoBonif(Integer grupoBonif) {
		this.grupoBonif = grupoBonif;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = UtilModel.format(descripcion);
	}


	@Override
	public String toString() {
		return "BonificacionGruposFiltro [codigo=" + grupoBonif + " - descripción="+ descripcion +"]";
	}

}


