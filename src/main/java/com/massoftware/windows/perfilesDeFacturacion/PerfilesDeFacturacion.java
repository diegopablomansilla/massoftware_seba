package com.massoftware.windows.perfilesDeFacturacion;

import java.math.BigDecimal;

import com.massoftware.windows.UtilModel;

public class PerfilesDeFacturacion {

	private Integer numero;
	private String nombre;
	private Integer claseCbte;
	private char presentacion;
	private char scrComprobante;
	private char scrFecha;
	private char scrMayorista;
	private char scrDescuento;
	private char scrBonifAcordada;
	private char scrCondDePago;
	private char scrProntoPago;
	private char scrCondDeVenta;
	private char scrListaPrecio;
	private char scrListaPrecioCtrlPrecioFactura;
	private char scrCarga;
	private char scrSubCtaCte;
	private char items;
	private char scrCargaRapida;
	private char scrIva;
	private char scrCantidad;
	private BigDecimal cantidad;
	private char scrDescuentoProd;
	private String descuentoProducto;
	private char scrPrecio;
	private char scrImporteFact;
	private char scrProvinciaConvMultiLat;
	private char scrUsuario;
	private char scrComprobanteRelacionado;
	private char scrCotizacion;
	private char scrMotivoNotaCredito;
	

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


	public Integer getClaseCbte() {
		return claseCbte;
	}


	public void setClaseCbte(Integer claseCbte) {
		this.claseCbte = claseCbte;
	}


	public char getPresentacion() {
		return presentacion;
	}


	public void setPresentacion(char presentacion) {
		this.presentacion = presentacion;
	}


	public char getScrComprobante() {
		return scrComprobante;
	}


	public void setScrComprobante(char scrComprobante) {
		this.scrComprobante = scrComprobante;
	}


	public char getScrFecha() {
		return scrFecha;
	}


	public void setScrFecha(char scrFecha) {
		this.scrFecha = scrFecha;
	}


	public char getScrMayorista() {
		return scrMayorista;
	}


	public void setScrMayorista(char scrMayorista) {
		this.scrMayorista = scrMayorista;
	}


	public char getScrDescuento() {
		return scrDescuento;
	}


	public void setScrDescuento(char scrDescuento) {
		this.scrDescuento = scrDescuento;
	}


	public char getScrBonifAcordada() {
		return scrBonifAcordada;
	}


	public void setScrBonifAcordada(char scrBonifAcordada) {
		this.scrBonifAcordada = scrBonifAcordada;
	}


	public char getScrCondDePago() {
		return scrCondDePago;
	}


	public void setScrCondDePago(char scrCondDePago) {
		this.scrCondDePago = scrCondDePago;
	}


	public char getScrProntoPago() {
		return scrProntoPago;
	}


	public void setScrProntoPago(char scrProntoPago) {
		this.scrProntoPago = scrProntoPago;
	}


	public char getScrCondDeVenta() {
		return scrCondDeVenta;
	}


	public void setScrCondDeVenta(char scrCondDeVenta) {
		this.scrCondDeVenta = scrCondDeVenta;
	}


	public char getScrListaPrecio() {
		return scrListaPrecio;
	}


	public void setScrListaPrecio(char scrListaPrecio) {
		this.scrListaPrecio = scrListaPrecio;
	}


	public char getScrListaPrecioCtrlPrecioFactura() {
		return scrListaPrecioCtrlPrecioFactura;
	}


	public void setScrListaPrecioCtrlPrecioFactura(char scrListaPrecioCtrlPrecioFactura) {
		this.scrListaPrecioCtrlPrecioFactura = scrListaPrecioCtrlPrecioFactura;
	}


	public char getScrCarga() {
		return scrCarga;
	}


	public void setScrCarga(char scrCarga) {
		this.scrCarga = scrCarga;
	}


	public char getScrSubCtaCte() {
		return scrSubCtaCte;
	}


	public void setScrSubCtaCte(char scrSubCtaCte) {
		this.scrSubCtaCte = scrSubCtaCte;
	}


	public char getItems() {
		return items;
	}


	public void setItems(char items) {
		this.items = items;
	}


	public char getScrCargaRapida() {
		return scrCargaRapida;
	}


	public void setScrCargaRapida(char scrCargaRapida) {
		this.scrCargaRapida = scrCargaRapida;
	}


	public char getScrIva() {
		return scrIva;
	}


	public void setScrIva(char scrIva) {
		this.scrIva = scrIva;
	}


	public char getScrCantidad() {
		return scrCantidad;
	}


	public void setScrCantidad(char scrCantidad) {
		this.scrCantidad = scrCantidad;
	}


	public BigDecimal getCantidad() {
		return cantidad;
	}


	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}


	public char getScrDescuentoProd() {
		return scrDescuentoProd;
	}


	public void setScrDescuentoProd(char scrDescuentoProd) {
		this.scrDescuentoProd = scrDescuentoProd;
	}


	public String getDescuentoProducto() {
		return descuentoProducto;
	}


	public void setDescuentoProducto(String descuentoProducto) {
		this.descuentoProducto = UtilModel.format(descuentoProducto);
	}


	public char getScrPrecio() {
		return scrPrecio;
	}


	public void setScrPrecio(char scrPrecio) {
		this.scrPrecio = scrPrecio;
	}


	public char getScrImporteFact() {
		return scrImporteFact;
	}


	public void setScrImporteFact(char scrImporteFact) {
		this.scrImporteFact = scrImporteFact;
	}


	public char getScrProvinciaConvMultiLat() {
		return scrProvinciaConvMultiLat;
	}


	public void setScrProvinciaConvMultiLat(char scrProvinciaConvMultiLat) {
		this.scrProvinciaConvMultiLat = scrProvinciaConvMultiLat;
	}


	public char getScrUsuario() {
		return scrUsuario;
	}


	public void setScrUsuario(char scrUsuario) {
		this.scrUsuario = scrUsuario;
	}


	public char getScrComprobanteRelacionado() {
		return scrComprobanteRelacionado;
	}


	public void setScrComprobanteRelacionado(char scrComprobanteRelacionado) {
		this.scrComprobanteRelacionado = scrComprobanteRelacionado;
	}


	public char getScrCotizacion() {
		return scrCotizacion;
	}


	public void setScrCotizacion(char scrCotizacion) {
		this.scrCotizacion = scrCotizacion;
	}


	public char getScrMotivoNotaCredito() {
		return scrMotivoNotaCredito;
	}


	public void setScrMotivoNotaCredito(char scrMotivoNotaCredito) {
		this.scrMotivoNotaCredito = scrMotivoNotaCredito;
	}


	@Override
	public String toString() {
		return "(" + numero + ") " + nombre;
	}

}
