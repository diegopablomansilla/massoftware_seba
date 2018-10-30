package com.massoftware.windows.conceptosRetenciones;


import java.math.BigDecimal;
import com.massoftware.windows.UtilModel;


public class ConceptosRetenciones {

	private Integer retencion;
	private String descripcion;
	private Integer tipoRetencion;
	private Integer baseDeCalculo;
	private Integer codigoActividadGananciaAfip;
	private Integer ganancia;
	private BigDecimal porcInscGanancia;
	private BigDecimal montoNoSujeto;
	private BigDecimal porcNoInscGanancia;
	private BigDecimal retencionMinima;
	private BigDecimal retencionMinimaNoInscGanancia;
	private Integer ingresoBruto;
	private Integer formaDeLiquidar;
	private BigDecimal importeFactura;
	private BigDecimal porcSobreFactura;
	private BigDecimal porcARetener;
	private BigDecimal porcARetenerConvenio;
	private Integer iva;
	private BigDecimal porcARetenerNormal;
	private BigDecimal porcARetenerSituacionNormal;
	

	
	public Integer getRetencion() {
		return retencion;
	}



	public void setRetencion(Integer retencion) {
		this.retencion = retencion;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = UtilModel.format(descripcion);
	}



	public Integer getTipoRetencion() {
		return tipoRetencion;
	}



	public void setTipoRetencion(Integer tipoRetencion) {
		this.tipoRetencion = tipoRetencion;
	}



	public Integer getBaseDeCalculo() {
		return baseDeCalculo;
	}



	public void setBaseDeCalculo(Integer baseDeCalculo) {
		this.baseDeCalculo = baseDeCalculo;
	}



	public Integer getCodigoActividadGananciaAfip() {
		return codigoActividadGananciaAfip;
	}



	public void setCodigoActividadGananciaAfip(Integer codigoActividadGananciaAfip) {
		this.codigoActividadGananciaAfip = codigoActividadGananciaAfip;
	}



	public Integer getGanancia() {
		return ganancia;
	}



	public void setGanancia(Integer ganancia) {
		this.ganancia = ganancia;
	}



	public BigDecimal getPorcInscGanancia() {
		return porcInscGanancia;
	}



	public void setPorcInscGanancia(BigDecimal porcInscGanancia) {
		this.porcInscGanancia = porcInscGanancia;
	}



	public BigDecimal getMontoNoSujeto() {
		return montoNoSujeto;
	}



	public void setMontoNoSujeto(BigDecimal montoNoSujeto) {
		this.montoNoSujeto = montoNoSujeto;
	}



	public BigDecimal getPorcNoInscGanancia() {
		return porcNoInscGanancia;
	}



	public void setPorcNoInscGanancia(BigDecimal porcNoInscGanancia) {
		this.porcNoInscGanancia = porcNoInscGanancia;
	}



	public BigDecimal getRetencionMinima() {
		return retencionMinima;
	}



	public void setRetencionMinima(BigDecimal retencionMinima) {
		this.retencionMinima = retencionMinima;
	}



	public BigDecimal getRetencionMinimaNoInscGanancia() {
		return retencionMinimaNoInscGanancia;
	}



	public void setRetencionMinimaNoInscGanancia(BigDecimal retencionMinimaNoInscGanancia) {
		this.retencionMinimaNoInscGanancia = retencionMinimaNoInscGanancia;
	}



	public Integer getIngresoBruto() {
		return ingresoBruto;
	}



	public void setIngresoBruto(Integer ingresoBruto) {
		this.ingresoBruto = ingresoBruto;
	}



	public Integer getFormaDeLiquidar() {
		return formaDeLiquidar;
	}



	public void setFormaDeLiquidar(Integer formaDeLiquidar) {
		this.formaDeLiquidar = formaDeLiquidar;
	}



	public BigDecimal getImporteFactura() {
		return importeFactura;
	}



	public void setImporteFactura(BigDecimal importeFactura) {
		this.importeFactura = importeFactura;
	}



	public BigDecimal getPorcSobreFactura() {
		return porcSobreFactura;
	}



	public void setPorcSobreFactura(BigDecimal porcSobreFactura) {
		this.porcSobreFactura = porcSobreFactura;
	}



	public BigDecimal getPorcARetener() {
		return porcARetener;
	}



	public void setPorcARetener(BigDecimal porcARetener) {
		this.porcARetener = porcARetener;
	}



	public BigDecimal getPorcARetenerConvenio() {
		return porcARetenerConvenio;
	}



	public void setPorcARetenerConvenio(BigDecimal porcARetenerConvenio) {
		this.porcARetenerConvenio = porcARetenerConvenio;
	}



	public Integer getIva() {
		return iva;
	}



	public void setIva(Integer iva) {
		this.iva = iva;
	}



	public BigDecimal getPorcARetenerNormal() {
		return porcARetenerNormal;
	}



	public void setPorcARetenerNormal(BigDecimal porcARetenerNormal) {
		this.porcARetenerNormal = porcARetenerNormal;
	}



	public BigDecimal getPorcARetenerSituacionNormal() {
		return porcARetenerSituacionNormal;
	}



	public void setPorcARetenerSituacionNormal(BigDecimal porcARetenerSituacionNormal) {
		this.porcARetenerSituacionNormal = porcARetenerSituacionNormal;
	}



	@Override
	public String toString() {
		return "(" + retencion + ") " + descripcion;
	}

}
