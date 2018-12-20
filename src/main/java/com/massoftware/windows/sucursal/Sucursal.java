package com.massoftware.windows.sucursal;


import com.massoftware.windows.UtilModel;

public class Sucursal {


	private Integer sucursal;
	private String nombre;
	private String abreviatura;
	private Integer tipoSucursal;
	private String ctasClieDesde;
	private String ctasClieHasta;
	private Integer cantCaracteresClie;
	private boolean numericoClie;
	private boolean permiteCambioClie;
	private Integer ctasClieOcasionalDesde;
	private Integer ctasClieOcasionalHasta;
	private String ctasProvDesde;
	private String ctasProvHasta;
	private Integer cantCaracteresProv;
	private boolean numericoProv;
	private boolean permiteCambioProv;
	private Integer nroCobranzaDesde;
	private Integer nroCobranzaHasta;
	
	
	
	public Integer getSucursal() {
		return sucursal;
	}


	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
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


	public Integer getTipoSucursal() {
		return tipoSucursal;
	}


	public void setTipoSucursal(Integer tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}


	public String getCtasClieDesde() {
		return ctasClieDesde;
	}


	public void setCtasClieDesde(String ctasClieDesde) {
		this.ctasClieDesde = UtilModel.format(ctasClieDesde);
	}


	public String getCtasClieHasta() {
		return ctasClieHasta;
	}


	public void setCtasClieHasta(String ctasClieHasta) {
		this.ctasClieHasta = UtilModel.format(ctasClieHasta);
	}


	public Integer getCantCaracteresClie() {
		return cantCaracteresClie;
	}


	public void setCantCaracteresClie(Integer cantCaracteresClie) {
		this.cantCaracteresClie = cantCaracteresClie;
	}


	public boolean isNumericoClie() {
		return numericoClie;
	}


	public void setNumericoClie(boolean numericoClie) {
		this.numericoClie = numericoClie;
	}


	public boolean isPermiteCambioClie() {
		return permiteCambioClie;
	}


	public void setPermiteCambioClie(boolean permiteCambioClie) {
		this.permiteCambioClie = permiteCambioClie;
	}


	public Integer getCtasClieOcasionalDesde() {
		return ctasClieOcasionalDesde;
	}


	public void setCtasClieOcasionalDesde(Integer ctasClieOcasionalDesde) {
		this.ctasClieOcasionalDesde = ctasClieOcasionalDesde;
	}


	public Integer getCtasClieOcasionalHasta() {
		return ctasClieOcasionalHasta;
	}


	public void setCtasClieOcasionalHasta(Integer ctasClieOcasionalHasta) {
		this.ctasClieOcasionalHasta = ctasClieOcasionalHasta;
	}


	public String getCtasProvDesde() {
		return ctasProvDesde;
	}


	public void setCtasProvDesde(String ctasProvDesde) {
		this.ctasProvDesde = UtilModel.format(ctasProvDesde);
	}


	public String getCtasProvHasta() {
		return ctasProvHasta;
	}


	public void setCtasProvHasta(String ctasProvHasta) {
		this.ctasProvHasta = UtilModel.format(ctasProvHasta);
	}


	public Integer getCantCaracteresProv() {
		return cantCaracteresProv;
	}


	public void setCantCaracteresProv(Integer cantCaracteresProv) {
		this.cantCaracteresProv = cantCaracteresProv;
	}


	public boolean isNumericoProv() {
		return numericoProv;
	}


	public void setNumericoProv(boolean numericoProv) {
		this.numericoProv = numericoProv;
	}


	public boolean isPermiteCambioProv() {
		return permiteCambioProv;
	}


	public void setPermiteCambioProv(boolean permiteCambioProv) {
		this.permiteCambioProv = permiteCambioProv;
	}


	public Integer getNroCobranzaDesde() {
		return nroCobranzaDesde;
	}


	public void setNroCobranzaDesde(Integer nroCobranzaDesde) {
		this.nroCobranzaDesde = nroCobranzaDesde;
	}


	public Integer getNroCobranzaHasta() {
		return nroCobranzaHasta;
	}


	public void setNroCobranzaHasta(Integer nroCobranzaHasta) {
		this.nroCobranzaHasta = nroCobranzaHasta;
	}


	@Override
	public String toString() {
		return "(" + sucursal + ") " + nombre;
	}

	
	
}
