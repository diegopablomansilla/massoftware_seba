package com.massoftware.windows.talonarios;


import java.sql.Timestamp;

import com.massoftware.windows.UtilModel;


public class Talonarios {
	private Integer multiProposito;
	private String nombre;
	private String letra;
	private Integer sucursal;
	private Long cai;
	private Timestamp vencimientoCaiSql;
	private String controlFiscal;
	private Integer primerNumero;
	private Integer ultimoNumero;
	private Integer proximoNumero;
	private boolean autoNumeracion;
	private boolean numeracionPreimpresa;
	private Integer diasAvisoVencimiento;
	private Integer alertaCantMinDeCpbtes;
	private Timestamp ultimaFechaSql;
	private Integer doorNoCambiar;
	private boolean rg10098;
	

	public Integer getMultiProposito() {
		return multiProposito;
	}


	public void setMultiProposito(Integer multiProposito) {
		this.multiProposito = multiProposito;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	public String getLetra() {
		return letra;
	}


	public void setLetra(String letra) {
		this.letra = UtilModel.format(letra);
	}


	public Integer getSucursal() {
		return sucursal;
	}


	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}


	public Long getCai() {
		return cai;
	}


	public void setCai(Long cai) {
		this.cai = cai;
	}


	public Timestamp getVencimientoCaiSql() {
		return vencimientoCaiSql;
	}


	public void setVencimientoCaiSql(Timestamp vencimientoCaiSql) {
		this.vencimientoCaiSql = vencimientoCaiSql;
	}


	public String getControlFiscal() {
		return controlFiscal;
	}


	public void setControlFiscal(String controlFiscal) {
		this.controlFiscal = UtilModel.format(controlFiscal);
	}


	public Integer getPrimerNumero() {
		return primerNumero;
	}


	public void setPrimerNumero(Integer primerNumero) {
		this.primerNumero = primerNumero;
	}


	public Integer getUltimoNumero() {
		return ultimoNumero;
	}


	public void setUltimoNumero(Integer ultimoNumero) {
		this.ultimoNumero = ultimoNumero;
	}


	public Integer getProximoNumero() {
		return proximoNumero;
	}


	public void setProximoNumero(Integer proximoNumero) {
		this.proximoNumero = proximoNumero;
	}


	public boolean isAutoNumeracion() {
		return autoNumeracion;
	}


	public void setAutoNumeracion(boolean autoNumeracion) {
		this.autoNumeracion = autoNumeracion;
	}


	public boolean isNumeracionPreimpresa() {
		return numeracionPreimpresa;
	}


	public void setNumeracionPreimpresa(boolean numeracionPreimpresa) {
		this.numeracionPreimpresa = numeracionPreimpresa;
	}


	public Integer getDiasAvisoVencimiento() {
		return diasAvisoVencimiento;
	}


	public void setDiasAvisoVencimiento(Integer diasAvisoVencimiento) {
		this.diasAvisoVencimiento = diasAvisoVencimiento;
	}


	public Integer getAlertaCantMinDeCpbtes() {
		return alertaCantMinDeCpbtes;
	}


	public void setAlertaCantMinDeCpbtes(Integer alertaCantMinDeCpbtes) {
		this.alertaCantMinDeCpbtes = alertaCantMinDeCpbtes;
	}


	public Timestamp getUltimaFechaSql() {
		return ultimaFechaSql;
	}


	public void setUltimaFechaSql(Timestamp ultimaFechaSql) {
		this.ultimaFechaSql = ultimaFechaSql;
	}


	public Integer getDoorNoCambiar() {
		return doorNoCambiar;
	}


	public void setDoorNoCambiar(Integer doorNoCambiar) {
		this.doorNoCambiar = doorNoCambiar;
	}


	public boolean isRg10098() {
		return rg10098;
	}


	public void setRg10098(boolean rg10098) {
		this.rg10098 = rg10098;
	}


	@Override
	public String toString() {
		return "(" + multiProposito + ") "+ letra +" - "+ nombre;
	}

}
