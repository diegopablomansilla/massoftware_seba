package com.massoftware.windows.conveniosElaboracion;

import com.massoftware.windows.UtilModel;


public class ConveniosDeElaboracionFiltro {

	private Integer convenio;
	private String cuenta;



	public Integer getConvenio() {
		return convenio;
	}



	public void setConvenio(Integer convenio) {
		this.convenio = convenio;
	}



	public String getCuenta() {
		return cuenta;
	}



	public void setCuenta(String cuenta) {
		this.cuenta = UtilModel.format(cuenta);
	}



	@Override
	public String toString() {
		return "ConveniosDeElaboracionFiltro [Convenio=" + convenio + ", cuenta=" + cuenta + "]";
	}

}
