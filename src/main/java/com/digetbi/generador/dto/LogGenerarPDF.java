package com.digetbi.generador.dto;

public class LogGenerarPDF {
  private String codigoInforme;
  
  private String motivoGenera;
  
  private String mensageGenera;
  
  private String nombreArchivo;
  
  private int numeroIntento;
  
  public LogGenerarPDF() {}
  
  public LogGenerarPDF(String codigoInforme, String motivoGenera, String mensageGenera, String nombreArchivo, int numeroIntento) {
    this.codigoInforme = codigoInforme;
    this.motivoGenera = motivoGenera;
    this.mensageGenera = mensageGenera;
    this.nombreArchivo = nombreArchivo;
    this.numeroIntento = numeroIntento;
  }
  
  public LogGenerarPDF(String codigoInforme, String motivoGenera, String mensageGenera, String nombreArchivo) {
    this.codigoInforme = codigoInforme;
    this.motivoGenera = motivoGenera;
    this.mensageGenera = mensageGenera;
    this.nombreArchivo = nombreArchivo;
  }
  
  public String getCodigoInforme() {
    return this.codigoInforme;
  }
  
  public void setCodigoInforme(String codigoInforme) {
    this.codigoInforme = codigoInforme;
  }
  
  public String getMotivoGenera() {
    return this.motivoGenera;
  }
  
  public void setMotivoGenera(String motivoGenera) {
    this.motivoGenera = motivoGenera;
  }
  
  public String getMensageGenera() {
    return this.mensageGenera;
  }
  
  public void setMensageGenera(String mensageGenera) {
    this.mensageGenera = mensageGenera;
  }
  
  public String getNombreArchivo() {
    return this.nombreArchivo;
  }
  
  public void setNombreArchivo(String nombreArchivo) {
    this.nombreArchivo = nombreArchivo;
  }
  
  public int getNumeroIntento() {
    return this.numeroIntento;
  }
  
  public void setNumeroIntento(int numeroIntento) {
    this.numeroIntento = numeroIntento;
  }
}
