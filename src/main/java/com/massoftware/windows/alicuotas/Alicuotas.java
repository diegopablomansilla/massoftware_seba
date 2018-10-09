package com.massoftware.windows.alicuotas;

import java.math.BigDecimal;

import com.massoftware.windows.UtilModel;

public class Alicuotas {

	private Integer codigo;
	private String descripcion;
	private BigDecimal porcentaje;
	private BigDecimal porcentaje2;
	private BigDecimal porcentaje3;
	private BigDecimal porcentaje4;
	private BigDecimal importeFijo;
	private boolean anticipoIva;
	private String cuentaCtbleVta;
	private String cuentaCtbleCompra;
	private Integer totalizaVarFact;
	private Integer tipoDePercepcion;
	private boolean convenioMultiLateral;
	private Integer ejercicio;
	private Integer tipoDeAlicuota;
	private BigDecimal basePorcentaje;
	private String codigoIIBBAfip;
	
	
	
	
	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = UtilModel.format(descripcion);
	}


	public BigDecimal getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}


	public BigDecimal getPorcentaje2() {
		return porcentaje2;
	}


	public void setPorcentaje2(BigDecimal porcentaje2) {
		this.porcentaje2 = porcentaje2;
	}


	public BigDecimal getPorcentaje3() {
		return porcentaje3;
	}


	public void setPorcentaje3(BigDecimal porcentaje3) {
		this.porcentaje3 = porcentaje3;
	}


	public BigDecimal getPorcentaje4() {
		return porcentaje4;
	}


	public void setPorcentaje4(BigDecimal porcentaje4) {
		this.porcentaje4 = porcentaje4;
	}


	public BigDecimal getImporteFijo() {
		return importeFijo;
	}


	public void setImporteFijo(BigDecimal importeFijo) {
		this.importeFijo = importeFijo;
	}


	public boolean getAnticipoIva() {
		return anticipoIva;
	}


	public void setAnticipoIva(boolean anticipoIva) {
		this.anticipoIva = anticipoIva;
	}


	public String getCuentaCtbleVta() {
		return cuentaCtbleVta;
	}


	public void setCuentaCtbleVta(String cuentaCtbleVta) {
		this.cuentaCtbleVta = UtilModel.format(cuentaCtbleVta);
	}


	public String getCuentaCtbleCompra() {
		return cuentaCtbleCompra;
	}


	public void setCuentaCtbleCompra(String cuentaCtbleCompra) {
		this.cuentaCtbleCompra = UtilModel.format(cuentaCtbleCompra);
	}


	public Integer getTotalizaVarFact() {
		return totalizaVarFact;
	}


	public void setTotalizaVarFact(Integer totalizaVarFact) {
		this.totalizaVarFact = totalizaVarFact;
	}


	public Integer getTipoDePercepcion() {
		return tipoDePercepcion;
	}


	public void setTipoDePercepcion(Integer tipoDePercepcion) {
		this.tipoDePercepcion = tipoDePercepcion;
	}


	public boolean getConvenioMultiLateral() {
		return convenioMultiLateral;
	}


	public void setConvenioMultiLateral(boolean convenioMultiLateral) {
		this.convenioMultiLateral = convenioMultiLateral;
	}


	public Integer getEjercicio() {
		return ejercicio;
	}


	public void setEjercicio(Integer ejercicio) {
		this.ejercicio = ejercicio;
	}


	public Integer getTipoDeAlicuota() {
		return tipoDeAlicuota;
	}


	public void setTipoDeAlicuota(Integer tipoDeAlicuota) {
		this.tipoDeAlicuota = tipoDeAlicuota;
	}


	public BigDecimal getBasePorcentaje() {
		return basePorcentaje;
	}


	public void setBasePorcentaje(BigDecimal basePorcentaje) {
		this.basePorcentaje = basePorcentaje;
	}


	public String getCodigoIIBBAfip() {
		return codigoIIBBAfip;
	}


	public void setCodigoIIBBAfip(String codigoIIBBAfip) {
		this.codigoIIBBAfip = UtilModel.format(codigoIIBBAfip);
	}


	@Override
	public String toString() {
		return "(" + codigo + ") " + descripcion;
	}

}
