package com.massoftware.windows.cuidades;

import com.massoftware.windows.UtilModel;

public class Ciudades {

	private Integer numeroPais;
	private Integer numeroProvincia;
	private Integer numero;
	private String nombre;
	private String departamento;
	private Integer codigo;

	public Integer getNumeroPais() {
		return numeroPais;
	}

	public void setNumeroPais(Integer numeroPais) {
		this.numeroPais = numeroPais;
	}

	public Integer getNumeroProvincia() {
		return numeroProvincia;
	}

	public void setNumeroProvincia(Integer numeroProvincia) {
		this.numeroProvincia = numeroProvincia;
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


	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = UtilModel.format(departamento);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "(" + numeroPais + "-" + numeroProvincia + "-"+ numero +") " + nombre;
	}

}
