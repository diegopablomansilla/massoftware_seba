package com.massoftware.windows.transportes;


import com.massoftware.windows.UtilModel;

public class Transportes {

	private Integer transporte;
	private String nombre;
	private String domicilio;
	private String codPostal;
	private String ciudad;
	private String telefono;
	private String fax;
	private String cuit;
	private String ingBruto;
	private String comentario;
	private String codigoPostal;
	private Integer ciudarNro;
	
	
	public Integer getTransporte() {
		return transporte;
	}


	public void setTransporte(Integer transporte) {
		this.transporte = transporte;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = UtilModel.format(nombre);
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = UtilModel.format(domicilio);
	}


	public String getCodPostal() {
		return codPostal;
	}


	public void setCodPostal(String codPostal) {
		this.codPostal = UtilModel.format(codPostal);
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = UtilModel.format(ciudad);
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = UtilModel.format(telefono);
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = UtilModel.format(fax);
	}


	public String getCuit() {
		return cuit;
	}


	public void setCuit(String cuit) {
		this.cuit = UtilModel.format(cuit);
	}


	public String getIngBruto() {
		return ingBruto;
	}


	public void setIngBruto(String ingBruto) {
		this.ingBruto = UtilModel.format(ingBruto);
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = UtilModel.format(comentario);
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = UtilModel.format(codigoPostal);
	}


	public Integer getCiudarNro() {
		return ciudarNro;
	}


	public void setCiudarNro(Integer ciudarNro) {
		this.ciudarNro = ciudarNro;
	}


	@Override
	public String toString() {
		return "(" + transporte + ") " + nombre;
	}

}
