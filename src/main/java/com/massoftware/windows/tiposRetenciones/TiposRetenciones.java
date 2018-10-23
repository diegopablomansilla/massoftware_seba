package com.massoftware.windows.tiposRetenciones;


import java.util.Date;

import com.massoftware.windows.UtilModel;

public class TiposRetenciones {

	private Integer tipoRetencion;
	private String nombre;
	private Integer cbteRetencionAfip;
	private Integer gananciaIvaIngBruto;
	private Integer proxCbteRetencion;
	private Integer cbteRetencionDesde;
	private Integer cbteRetencionHasta;
	private Integer emiteConstancia;
	private Integer destinoImpresion;
	private String formato;
	private String copias;
	private String cuentaFondo;
	private Integer tipoRetencionNumeracion;
	private Date fechaVencimientoSQL;
	private String nroAgenteRetencion;
	
	
	
	public Integer getTipoRetencion() {
		return tipoRetencion;
	}



	public void setTipoRetencion(Integer tipoRetencion) {
		this.tipoRetencion = tipoRetencion;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}



	public Integer getCbteRetencionAfip() {
		return cbteRetencionAfip;
	}



	public void setCbteRetencionAfip(Integer cbteRetencionAfip) {
		this.cbteRetencionAfip = cbteRetencionAfip;
	}



	public Integer getGananciaIvaIngBruto() {
		return gananciaIvaIngBruto;
	}



	public void setGananciaIvaIngBruto(Integer gananciaIvaIngBruto) {
		this.gananciaIvaIngBruto = gananciaIvaIngBruto;
	}



	public Integer getProxCbteRetencion() {
		return proxCbteRetencion;
	}



	public void setProxCbteRetencion(Integer proxCbteRetencion) {
		this.proxCbteRetencion = proxCbteRetencion;
	}



	public Integer getCbteRetencionDesde() {
		return cbteRetencionDesde;
	}



	public void setCbteRetencionDesde(Integer cbteRetencionDesde) {
		this.cbteRetencionDesde = cbteRetencionDesde;
	}



	public Integer getCbteRetencionHasta() {
		return cbteRetencionHasta;
	}



	public void setCbteRetencionHasta(Integer cbteRetencionHasta) {
		this.cbteRetencionHasta = cbteRetencionHasta;
	}



	public Integer getEmiteConstancia() {
		return emiteConstancia;
	}



	public void setEmiteConstancia(Integer emiteConstancia) {
		this.emiteConstancia = emiteConstancia;
	}



	public Integer getDestinoImpresion() {
		return destinoImpresion;
	}



	public void setDestinoImpresion(Integer destinoImpresion) {
		this.destinoImpresion = destinoImpresion;
	}



	public String getFormato() {
		return formato;
	}



	public void setFormato(String formato) {
		this.formato = UtilModel.format(formato);
	}



	public String getCopias() {
		return copias;
	}



	public void setCopias(String copias) {
		this.copias = UtilModel.format(copias);
	}



	public String getCuentaFondo() {
		return cuentaFondo;
	}



	public void setCuentaFondo(String cuentaFondo) {
		this.cuentaFondo = UtilModel.format(cuentaFondo);
	}



	public Integer getTipoRetencionNumeracion() {
		return tipoRetencionNumeracion;
	}



	public void setTipoRetencionNumeracion(Integer tipoRetencionNumeracion) {
		this.tipoRetencionNumeracion = tipoRetencionNumeracion;
	}



	public Date getFechaVencimientoSQL() {
		return fechaVencimientoSQL;
	}



	public void setFechaVencimientoSQL(Date fechaVencimientoSQL) {
		this.fechaVencimientoSQL = fechaVencimientoSQL;
	}



	public String getNroAgenteRetencion() {
		return nroAgenteRetencion;
	}



	public void setNroAgenteRetencion(String nroAgenteRetencion) {
		this.nroAgenteRetencion = UtilModel.format(nroAgenteRetencion);
	}



	@Override
	public String toString() {
		return "(" + tipoRetencion + ") " + nombre;
	}

}
