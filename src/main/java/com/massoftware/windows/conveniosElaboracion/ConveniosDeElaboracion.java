package com.massoftware.windows.conveniosElaboracion;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.massoftware.windows.UtilModel;

public class ConveniosDeElaboracion {

	private Integer usuario;
	private Timestamp fechaIngresoSQL;
	private Integer convenio;
	private Integer tipoConvenio;
	private String detalle;
	private String cuenta;
	private BigDecimal fasonPorc;
	private BigDecimal mgLechePorc;
	private Integer tipoIdRemitoMateriaPrima1;
	private Integer tipoIdRemitoMateriaPrima2;
	private String codProdMateriaPrima;
	private String codProdMateriaGrasa;
	private Integer tipoIdRemitoProductoTerminado;
	private String codProdTerminado;
	private Integer tipoIdRemitoServicioElaboracion;
	private String codProdServicioElaboracion;
	private Integer tipoIdRemitoLeche;
	private Integer cuentaLeche;
	private Boolean activo;
	private Integer modalidadFason;
	private BigDecimal mgLechePolvo;
	private BigDecimal mgCrema;
	private BigDecimal sngLechePolvo;
	private BigDecimal sngCrema;
	private BigDecimal mermaProcesoProd;
	private BigDecimal mermaProcesoEnvaseProd;
	private Integer tipoIdRemitoTambos;
	private Integer tambo;
	private Date fechaConciliacionSQL;
	private Integer porcPvOpp;
	
	
	
	public Integer getUsuario() {
		return usuario;
	}



	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}



	public Timestamp getFechaIngresoSQL() {
		return fechaIngresoSQL;
	}



	public void setFechaIngresoSQL(Timestamp fechaIngresoSQL) {
		this.fechaIngresoSQL = fechaIngresoSQL;
	}



	public Integer getConvenio() {
		return convenio;
	}



	public void setConvenio(Integer convenio) {
		this.convenio = convenio;
	}



	public Integer getTipoConvenio() {
		return tipoConvenio;
	}



	public void setTipoConvenio(Integer tipoConvenio) {
		this.tipoConvenio = tipoConvenio;
	}



	public String getDetalle() {
		return detalle;
	}



	public void setDetalle(String detalle) {
		this.detalle = UtilModel.format(detalle);
	}



	public String getCuenta() {
		return cuenta;
	}



	public void setCuenta(String cuenta) {
		this.cuenta = UtilModel.format(cuenta);
	}



	public BigDecimal getFasonPorc() {
		return fasonPorc;
	}



	public void setFasonPorc(BigDecimal fasonPorc) {
		this.fasonPorc = fasonPorc;
	}



	public BigDecimal getMgLechePorc() {
		return mgLechePorc;
	}



	public void setMgLechePorc(BigDecimal mgLechePorc) {
		this.mgLechePorc = mgLechePorc;
	}



	public Integer getTipoIdRemitoMateriaPrima1() {
		return tipoIdRemitoMateriaPrima1;
	}



	public void setTipoIdRemitoMateriaPrima1(Integer tipoIdRemitoMateriaPrima1) {
		this.tipoIdRemitoMateriaPrima1 = tipoIdRemitoMateriaPrima1;
	}



	public Integer getTipoIdRemitoMateriaPrima2() {
		return tipoIdRemitoMateriaPrima2;
	}



	public void setTipoIdRemitoMateriaPrima2(Integer tipoIdRemitoMateriaPrima2) {
		this.tipoIdRemitoMateriaPrima2 = tipoIdRemitoMateriaPrima2;
	}



	public String getCodProdMateriaPrima() {
		return codProdMateriaPrima;
	}



	public void setCodProdMateriaPrima(String codProdMateriaPrima) {
		this.codProdMateriaPrima = UtilModel.format(codProdMateriaPrima);
	}



	public String getCodProdMateriaGrasa() {
		return codProdMateriaGrasa;
	}



	public void setCodProdMateriaGrasa(String codProdMateriaGrasa) {
		this.codProdMateriaGrasa = UtilModel.format(codProdMateriaGrasa);
	}



	public Integer getTipoIdRemitoProductoTerminado() {
		return tipoIdRemitoProductoTerminado;
	}



	public void setTipoIdRemitoProductoTerminado(Integer tipoIdRemitoProductoTerminado) {
		this.tipoIdRemitoProductoTerminado = tipoIdRemitoProductoTerminado;
	}



	public String getCodProdTerminado() {
		return codProdTerminado;
	}



	public void setCodProdTerminado(String codProdTerminado) {
		this.codProdTerminado = UtilModel.format(codProdTerminado);
	}



	public Integer getTipoIdRemitoServicioElaboracion() {
		return tipoIdRemitoServicioElaboracion;
	}



	public void setTipoIdRemitoServicioElaboracion(Integer tipoIdRemitoServicioElaboracion) {
		this.tipoIdRemitoServicioElaboracion = tipoIdRemitoServicioElaboracion;
	}



	public String getCodProdServicioElaboracion() {
		return codProdServicioElaboracion;
	}



	public void setCodProdServicioElaboracion(String codProdServicioElaboracion) {
		this.codProdServicioElaboracion = UtilModel.format(codProdServicioElaboracion);
	}



	public Integer getTipoIdRemitoLeche() {
		return tipoIdRemitoLeche;
	}



	public void setTipoIdRemitoLeche(Integer tipoIdRemitoLeche) {
		this.tipoIdRemitoLeche = tipoIdRemitoLeche;
	}



	public Integer getCuentaLeche() {
		return cuentaLeche;
	}



	public void setCuentaLeche(Integer cuentaLeche) {
		this.cuentaLeche = cuentaLeche;
	}



	public Boolean getActivo() {
		return activo;
	}



	public void setActivo(Boolean activo) {
		this.activo = activo;
	}



	public Integer getModalidadFason() {
		return modalidadFason;
	}



	public void setModalidadFason(Integer modalidadFazon) {
		this.modalidadFason = modalidadFazon;
	}



	public BigDecimal getMgLechePolvo() {
		return mgLechePolvo;
	}



	public void setMgLechePolvo(BigDecimal mgLechePolvo) {
		this.mgLechePolvo = mgLechePolvo;
	}



	public BigDecimal getMgCrema() {
		return mgCrema;
	}



	public void setMgCrema(BigDecimal mgCrema) {
		this.mgCrema = mgCrema;
	}



	public BigDecimal getSngLechePolvo() {
		return sngLechePolvo;
	}



	public void setSngLechePolvo(BigDecimal sngLechePolvo) {
		this.sngLechePolvo = sngLechePolvo;
	}



	public BigDecimal getSngCrema() {
		return sngCrema;
	}



	public void setSngCrema(BigDecimal sngCrema) {
		this.sngCrema = sngCrema;
	}



	public BigDecimal getMermaProcesoProd() {
		return mermaProcesoProd;
	}



	public void setMermaProcesoProd(BigDecimal mermaProcesoProd) {
		this.mermaProcesoProd = mermaProcesoProd;
	}



	public BigDecimal getMermaProcesoEnvaseProd() {
		return mermaProcesoEnvaseProd;
	}



	public void setMermaProcesoEnvaseProd(BigDecimal mermaProcesoEnvaseProd) {
		this.mermaProcesoEnvaseProd = mermaProcesoEnvaseProd;
	}



	public Integer getTipoIdRemitoTambos() {
		return tipoIdRemitoTambos;
	}



	public void setTipoIdRemitoTambos(Integer tipoIdRemitoTambos) {
		this.tipoIdRemitoTambos = tipoIdRemitoTambos;
	}



	public Integer getTambo() {
		return tambo;
	}



	public void setTambo(Integer tambo) {
		this.tambo = tambo;
	}



	public Date getFechaConciliacionSQL() {
		return fechaConciliacionSQL;
	}



	public void setFechaConciliacionSQL(Date fechaConciliacionSQL) {
		this.fechaConciliacionSQL = fechaConciliacionSQL;
	}



	public Integer getPorcPvOpp() {
		return porcPvOpp;
	}



	public void setPorcPvOpp(Integer porcPvOpp) {
		this.porcPvOpp = porcPvOpp;
	}



	@Override
	public String toString() {
		return "(" + convenio + ") " + detalle;
	}

}
