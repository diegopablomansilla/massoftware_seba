package com.massoftware.windows.bonificacionGrupos;


import com.massoftware.windows.UtilModel;

public class BonificacionGrupos {

	private Integer grupoBonif;
	private String descripcion;
	private Integer lista;
	private Integer lista2;

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

	public Integer getLista() {
		return lista;
	}

	public void setLista(Integer lista) {
		this.lista = lista;
	}

	public Integer getLista2() {
		return lista2;
	}

	public void setLista2(Integer lista2) {
		this.lista2 = lista2;
	}

	@Override
	public String toString() {
		return "(" + grupoBonif + ") " + descripcion;
	}

}
