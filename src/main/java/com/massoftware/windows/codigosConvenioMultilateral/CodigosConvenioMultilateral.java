package com.massoftware.windows.codigosConvenioMultilateral;

import com.massoftware.windows.UtilModel;

public class CodigosConvenioMultilateral {

	private Integer codigoCm;
	private String codigoConvenio;
	private String descripcion;


	public Integer getCodigoCm() {
		return codigoCm;
	}


	public void setCodigoCm(Integer codigoCm) {
		this.codigoCm = codigoCm;
	}


	public String getCodigoConvenio() {
		return codigoConvenio;
	}


	public void setCodigoConvenio(String codigoConvenio) {
		this.codigoConvenio = UtilModel.format(codigoConvenio);
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = UtilModel.format(descripcion);
	}


	@Override
	public String toString() {
		return "(" + codigoCm + ") " + codigoConvenio;
	}

}
