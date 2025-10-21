package com.digetbi.generador.dto;

public class Log {
  private String codigoOrden;
  
  private String mensaje;
  
  private String detalle;
  
  public Log() {}
  
  public Log(String codigoOrden, String mensaje, String detalle) {
    this.codigoOrden = codigoOrden;
    this.mensaje = mensaje;
    this.detalle = detalle;
  }
  
  public String getCodigoOrden() {
    return this.codigoOrden;
  }
  
  public void setCodigoOrden(String codigoOrden) {
    this.codigoOrden = codigoOrden;
  }
  
  public String getMensaje() {
    return this.mensaje;
  }
  
  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }
  
  public String getDetalle() {
    return this.detalle;
  }
  
  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }
}
