package com.massoftware.windows.bonificacionProductos;

import com.massoftware.windows.UtilModel;


public class BonificacionProductosFiltro {

	private Integer grupoBonif;
	private Integer bonifProducto;
	private String descripcion;


	public Integer getGrupoBonif() {
		return grupoBonif;
	}


	public void setGrupoBonif(Integer grupoBonif) {
		this.grupoBonif = grupoBonif;
	}


	public Integer getBonifProducto() {
		return bonifProducto;
	}


	public void setBonifProducto(Integer bonifProducto) {
		this.bonifProducto = bonifProducto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = UtilModel.format(descripcion);
	}


	@Override
	public String toString() {
		return "BonificacionProductosFiltro [GrupoBonif=" + grupoBonif + ", BonifProducto="+ bonifProducto +", descripcion=" + descripcion + "]";
	}

}
