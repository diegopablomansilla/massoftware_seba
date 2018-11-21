package com.massoftware.windows.motivoComentario;

import com.massoftware.windows.UtilModel;


public class MotivoComentarioFiltro {

	private Integer motivo;
	private String nombre;


	public Integer getMotivo() {
		return motivo;
	}


	public void setMotivo(Integer motivo) {
		this.motivo = motivo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	@Override
	public String toString() {
		return "MotivoComentariosFiltro [motivo=" + motivo + ", nombre=" + nombre + "]";
	}

}
