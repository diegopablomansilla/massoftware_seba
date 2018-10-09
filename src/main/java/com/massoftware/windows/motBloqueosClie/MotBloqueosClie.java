package com.massoftware.windows.motBloqueosClie;


import com.massoftware.windows.UtilModel;

public class MotBloqueosClie {

	private String motivoBloqueo;
	private String detalle;
	private Integer clasifCliente;




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

	public Integer getClasifCliente() {
		return clasifCliente;
	}

	public void setClasifCliente(Integer clasifCliente) {
		this.clasifCliente = clasifCliente;
	}

	@Override
	public String toString() {
		return "(" + motivoBloqueo + ") " + detalle;
	}

}
