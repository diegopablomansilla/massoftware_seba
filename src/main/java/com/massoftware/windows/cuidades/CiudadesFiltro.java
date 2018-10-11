package com.massoftware.windows.cuidades;

import com.massoftware.windows.UtilModel;
import com.massoftware.windows.paises.Paises;
import com.massoftware.windows.provincias.Provincias;

public class CiudadesFiltro {

	private Paises pais;
	private Provincias provincia;
	private Integer numero;
	private String nombre;
	

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}

	public Provincias getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}

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

	@Override
	public String toString() {
		return "CiudadesFiltro [pais=" + pais + ", numero=" + numero + ", nombre=" + nombre + "]";
	}

}
