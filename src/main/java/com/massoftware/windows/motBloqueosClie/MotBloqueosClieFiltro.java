package com.massoftware.windows.motBloqueosClie;

import com.massoftware.windows.UtilModel;

public class MotBloqueosClieFiltro {

	private String motivoBloqueo;
	private String detalle;



	public String getMotivoBloqueo() {
		return motivoBloqueo;
	}


	public void setMotivoBloqueo(String motivoBloqueo) {
		this.motivoBloqueo = UtilModel.format(motivoBloqueo);
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = UtilModel.format(detalle);
	}




	@Override
	public String toString() {
		return "MotBloqueosClientes [motivoBloqueo=" + motivoBloqueo + ", detalle=" + detalle + "]";
	}

}
