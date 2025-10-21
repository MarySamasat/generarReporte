package com.digetbi.generador.dto;

public class Informe {
  private String codigoInforme;
  
  private String codigoOrdenServicio;
  
  private String numeroForulario;
  
  private String codDoc;
  
  private String numeroOS;
  
  private String tipoInforme;
  
  private String nombrePDF;
  
  private String codigoFormulario;
  
  private String codigoEmpresa;
  
  public Informe() {}
  
  public Informe(String codigoInforme, String codigoOrdenServicio, String numeroForulario, String codDoc, String numeroOS, String tipoInforme, String nombrePDF, String codigoFormulario, String codigoEmpresa) {
    this.codigoInforme = codigoInforme;
    this.codigoOrdenServicio = codigoOrdenServicio;
    this.numeroForulario = numeroForulario;
    this.codDoc = codDoc;
    this.numeroOS = numeroOS;
    this.tipoInforme = tipoInforme;
    this.nombrePDF = nombrePDF;
    this.codigoFormulario = codigoFormulario;
    this.codigoEmpresa = codigoEmpresa;
  }
  
  public String getCodigoInforme() {
    return this.codigoInforme;
  }
  
  public void setCodigoInforme(String codigoInforme) {
    this.codigoInforme = codigoInforme;
  }
  
  public String getCodigoOrdenServicio() {
    return this.codigoOrdenServicio;
  }
  
  public void setCodigoOrdenServicio(String codigoOrdenServicio) {
    this.codigoOrdenServicio = codigoOrdenServicio;
  }
  
  public String getNumeroForulario() {
    return this.numeroForulario;
  }
  
  public void setNumeroForulario(String numeroForulario) {
    this.numeroForulario = numeroForulario;
  }
  
  public String getCodDoc() {
    return this.codDoc;
  }
  
  public void setCodDoc(String codDoc) {
    this.codDoc = codDoc;
  }
  
  public String getNumeroOS() {
    return this.numeroOS;
  }
  
  public void setNumeroOS(String numeroOS) {
    this.numeroOS = numeroOS;
  }
  
  public String getTipoInforme() {
    return this.tipoInforme;
  }
  
  public void setTipoInforme(String tipoInforme) {
    this.tipoInforme = tipoInforme;
  }
  
  public String getNombrePDF() {
    return this.nombrePDF;
  }
  
  public void setNombrePDF(String nombrePDF) {
    this.nombrePDF = nombrePDF;
  }
  
  public String getCodigoFormulario() {
    return this.codigoFormulario;
  }
  
  public void setCodigoFormulario(String codigoFormulario) {
    this.codigoFormulario = codigoFormulario;
  }
  
  public String getCodigoEmpresa() {
    return this.codigoEmpresa;
  }
  
  public void setCodigoEmpresa(String codigoEmpresa) {
    this.codigoEmpresa = codigoEmpresa;
  }
  
  public String toString() {
    return "Informe{codigoInforme=" + this.codigoInforme + ", codigoOrdenServicio=" + this.codigoOrdenServicio + ", numeroForulario=" + this.numeroForulario + '}';
  }
}
