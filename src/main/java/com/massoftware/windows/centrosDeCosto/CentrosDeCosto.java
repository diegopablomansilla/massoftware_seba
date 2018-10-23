package com.massoftware.windows.centrosDeCosto;


import com.massoftware.windows.UtilModel;

public class CentrosDeCosto {

	private Integer numero;
	private String nombre;
	private Integer apropiacionContable;
	private Boolean tipo;
	private String proyectoComentario;
	private Boolean proyectoActivo;
	private String nombreTipo;
	
	
	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	public Integer getApropiacionContable() {
		return apropiacionContable;
	}


	public void setApropiacionContable(Integer apropiacionContable) {
		this.apropiacionContable = apropiacionContable;
	}


	public Boolean getTipo() {
		return tipo;
	}


	public void setTipo(Boolean tipo) {
		this.tipo = UtilModel.format(tipo);
	}


	public String getProyectoComentario() {
		return proyectoComentario;
	}


	public void setProyectoComentario(String proyectoComentario) {
		this.proyectoComentario = UtilModel.format(proyectoComentario);
	}


	public Boolean getProyectoActivo() {
		return proyectoActivo;
	}


	public void setProyectoActivo(Boolean proyectoActivo) {
		this.proyectoActivo = UtilModel.format(proyectoActivo);
	}


	public String getNombreTipo() {
		return nombreTipo;
	}


	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}


	@Override
	public String toString() {
		return "(" + numero + ") " + nombre;
	}

}
