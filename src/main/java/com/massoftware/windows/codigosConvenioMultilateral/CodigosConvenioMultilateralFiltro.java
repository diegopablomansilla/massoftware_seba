package com.massoftware.windows.codigosConvenioMultilateral;

import com.massoftware.windows.UtilModel;

public class CodigosConvenioMultilateralFiltro {

	private Integer codigoCm;
	private String descripcion;

	public Integer getCodigoCm() {
		return codigoCm;
	}

	public void setCodigoCm(Integer codigoCm) {
		this.codigoCm = codigoCm;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = UtilModel.format(descripcion);
	}

	@Override
	public String toString() {
		return "CodConvMultilateralFiltro [codigoCm=" + codigoCm + ", codigo descripcioó=" + descripcion + "]";
	}

}
