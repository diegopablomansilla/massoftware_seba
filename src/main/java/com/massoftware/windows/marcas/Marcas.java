package com.massoftware.windows.marcas;

import com.massoftware.windows.UtilModel;

public class Marcas {

	private Integer numero;
	private String nombre;
	private String abreviatura;
	private String planilla;
	private Integer hoja;
	private Integer primeraFila;
	private Integer ultimaFila;
	private String columnaCodigo;
	private String columnaDescripcion;
	private String columnaCodigoBarra;
	private String columnaSinonimo;
	private String columnaPrecioLista;
	private String columnaPrecioCompra;
	private String columnaFamilia;
	private String columnaPeso;
	private String columnaCantPorBulto;
	private String columnaIva;
	private String columnaAplicativo;
	private String columnaPrecioDeCosto;
	
	
	
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

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = UtilModel.format(abreviatura);
	}

	
	public String getPlanilla() {
		return planilla;
	}

	public void setPlanilla(String planilla) {
		this.planilla = UtilModel.format(planilla);
	}

	public Integer getHoja() {
		return hoja;
	}

	public void setHoja(Integer hoja) {
		this.hoja = hoja;
	}

	public Integer getPrimeraFila() {
		return primeraFila;
	}

	public void setPrimeraFila(Integer primeraFila) {
		this.primeraFila = primeraFila;
	}

	public Integer getUltimaFila() {
		return ultimaFila;
	}

	public void setUltimaFila(Integer ultimaFila) {
		this.ultimaFila = ultimaFila;
	}

	public String getColumnaCodigo() {
		return columnaCodigo;
	}

	public void setColumnaCodigo(String columnaCodigo) {
		this.columnaCodigo = UtilModel.format(columnaCodigo);
	}

	public String getColumnaDescripcion() {
		return columnaDescripcion;
	}

	public void setColumnaDescripcion(String columnaDescripcion) {
		this.columnaDescripcion = UtilModel.format(columnaDescripcion);
	}

	public String getColumnaCodigoBarra() {
		return columnaCodigoBarra;
	}

	public void setColumnaCodigoBarra(String columnaCodigoBarra) {
		this.columnaCodigoBarra = UtilModel.format(columnaCodigoBarra);
	}

	public String getColumnaSinonimo() {
		return columnaSinonimo;
	}

	public void setColumnaSinonimo(String columnaSinonimo) {
		this.columnaSinonimo = UtilModel.format(columnaSinonimo);
	}

	public String getColumnaPrecioLista() {
		return columnaPrecioLista;
	}

	public void setColumnaPrecioLista(String columnaPrecioLista) {
		this.columnaPrecioLista = UtilModel.format(columnaPrecioLista);
	}

	public String getColumnaPrecioCompra() {
		return columnaPrecioCompra;
	}

	public void setColumnaPrecioCompra(String columnaPrecioCompra) {
		this.columnaPrecioCompra = UtilModel.format(columnaPrecioCompra);
	}

	public String getColumnaFamilia() {
		return columnaFamilia;
	}

	public void setColumnaFamilia(String columnaFamilia) {
		this.columnaFamilia = UtilModel.format(columnaFamilia);
	}

	public String getColumnaPeso() {
		return columnaPeso;
	}

	public void setColumnaPeso(String columnaPeso) {
		this.columnaPeso = UtilModel.format(columnaPeso);
	}

	public String getColumnaCantPorBulto() {
		return columnaCantPorBulto;
	}

	public void setColumnaCantPorBulto(String columnaCantPorBulto) {
		this.columnaCantPorBulto = UtilModel.format(columnaCantPorBulto);
	}

	public String getColumnaIva() {
		return columnaIva;
	}

	public void setColumnaIva(String columnaIva) {
		this.columnaIva = UtilModel.format(columnaIva);
	}

	public String getColumnaAplicativo() {
		return columnaAplicativo;
	}

	public void setColumnaAplicativo(String columnaAplicativo) {
		this.columnaAplicativo = UtilModel.format(columnaAplicativo);
	}

	public String getColumnaPrecioDeCosto() {
		return columnaPrecioDeCosto;
	}

	public void setColumnaPrecioDeCosto(String columnaPrecioDeCosto) {
		this.columnaPrecioDeCosto = UtilModel.format(columnaPrecioDeCosto);
	}

	@Override
	public String toString() {
		return "(" + numero + ") " + nombre;
	}

}
