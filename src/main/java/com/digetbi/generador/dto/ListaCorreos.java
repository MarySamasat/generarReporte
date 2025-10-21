package com.digetbi.generador.dto;

public class ListaCorreos {
  private String usuario;
  
  private String codEmpleado;
  
  private String codOrden;
  
  private Boolean copia;
  
  private Boolean destinatario;
  
  public ListaCorreos() {}
  
  public ListaCorreos(String usuario, String codEmpleado, String codOrden, Boolean copia, Boolean destinatario) {
    this.usuario = usuario;
    this.codEmpleado = codEmpleado;
    this.codOrden = codOrden;
    this.copia = copia;
    this.destinatario = destinatario;
  }
  
  public String getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
  
  public String getCodEmpleado() {
    return this.codEmpleado;
  }
  
  public void setCodEmpleado(String codEmpleado) {
    this.codEmpleado = codEmpleado;
  }
  
  public String getCodOrden() {
    return this.codOrden;
  }
  
  public void setCodOrden(String codOrden) {
    this.codOrden = codOrden;
  }
  
  public Boolean getCopia() {
    return this.copia;
  }
  
  public void setCopia(Boolean copia) {
    this.copia = copia;
  }
  
  public Boolean getDestinatario() {
    return this.destinatario;
  }
  
  public void setDestinatario(Boolean destinatario) {
    this.destinatario = destinatario;
  }
}
