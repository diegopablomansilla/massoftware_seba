package com.massoftware.windows.depositos;

import com.massoftware.windows.UtilModel;

public class Depositos {

	private Integer sucursal;
	private Integer deposito;
	private String nombre;
	private String abreviatura;
	private boolean depositoActivo;
	private Integer caja;
	private Integer modulo;
	private Integer depositoDondeAgrupa;
	private Integer doorNoConsultar;
	private Integer doorNoOperativo;
	

	public Integer getSucursal() {
		return sucursal;
	}


	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}


	public Integer getDeposito() {
		return deposito;
	}


	public void setDeposito(Integer deposito) {
		this.deposito = deposito;
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


	public boolean isDepositoActivo() {
		return depositoActivo;
	}


	public void setDepositoActivo(boolean depositoActivo) {
		this.depositoActivo = depositoActivo;
	}


	public Integer getCaja() {
		return caja;
	}


	public void setCaja(Integer caja) {
		this.caja = caja;
	}


	public Integer getModulo() {
		return modulo;
	}


	public void setModulo(Integer modulo) {
		this.modulo = modulo;
	}


	public Integer getDepositoDondeAgrupa() {
		return depositoDondeAgrupa;
	}


	public void setDepositoDondeAgrupa(Integer depositoDondeAgrupa) {
		this.depositoDondeAgrupa = depositoDondeAgrupa;
	}


	public Integer getDoorNoConsultar() {
		return doorNoConsultar;
	}


	public void setDoorNoConsultar(Integer doorNoConsultar) {
		this.doorNoConsultar = doorNoConsultar;
	}


	public Integer getDoorNoOperativo() {
		return doorNoOperativo;
	}


	public void setDoorNoOperativo(Integer doorNoOperativo) {
		this.doorNoOperativo = doorNoOperativo;
	}


	@Override
	public String toString() {
		return "(" + sucursal + "-" + deposito + ") " + nombre;
	}

}
