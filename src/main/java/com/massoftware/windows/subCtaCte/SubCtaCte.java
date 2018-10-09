package com.massoftware.windows.subCtaCte;

import java.math.BigDecimal;

import com.massoftware.windows.UtilModel;

public class SubCtaCte {
	private Integer subCtaCte;
	private String nombre;
	private boolean ctaCteGral;
	private String ctaCtbleVta;
	private String ctaFondo;
	private Integer apropContable;
	private Integer plazoMaximoBloqueo;
	private BigDecimal montoABloquear;
	private Integer door;
	private Integer ejercicio;
	private Integer moneda;
	

	

	public Integer getSubCtaCte() {
		return subCtaCte;
	}

	public void setSubCtaCte(Integer subCtaCte) {
		this.subCtaCte = subCtaCte;
	}

	public boolean isCtaCteGral() {
		return ctaCteGral;
	}

	public void setCtaCteGral(boolean ctaCteGral) {
		this.ctaCteGral = ctaCteGral;
	}

	public String getCtaCtbleVta() {
		return ctaCtbleVta;
	}

	public void setCtaCtbleVta(String ctaCtbleVta) {
		this.ctaCtbleVta = UtilModel.format(ctaCtbleVta);
	}

	public String getCtaFondo() {
		return ctaFondo;
	}

	public void setCtaFondo(String ctaFondo) {
		this.ctaFondo = UtilModel.format(ctaFondo);
	}

	public int getApropContable() {
		return apropContable;
	}

	public void setApropContable(Integer apropContable) {
		this.apropContable = apropContable;
	}

	public Integer getPlazoMaximoBloqueo() {
		return plazoMaximoBloqueo;
	}

	public void setPlazoMaximoBloqueo(Integer plazoMaximoBloqueo) {
		this.plazoMaximoBloqueo = plazoMaximoBloqueo;
	}

	public BigDecimal getMontoABloquear() {
		return montoABloquear;
	}

	public void setMontoABloquear(BigDecimal montoABloquear) {
		this.montoABloquear = montoABloquear;
	}

	public Integer getDoor() {
		return door;
	}

	public void setDoor(Integer door) {
		this.door = door;
	}

	public int getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Integer ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Integer getMoneda() {
		return moneda;
	}

	public void setMoneda(Integer moneda) {
		this.moneda = moneda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}

	
	
	
	
	@Override
	public String toString() {
		return "(" + subCtaCte + ") " + nombre;
	}

}
