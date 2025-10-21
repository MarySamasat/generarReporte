package com.digetbi.generador.dto;

public class ConfiguracionEmail {
  private String asuntoCorreo;
  
  private String cuerpoCorreo;
  
  public ConfiguracionEmail() {}
  
  public ConfiguracionEmail(String asuntoCorreo, String cuerpoCorreo) {
    this.asuntoCorreo = asuntoCorreo;
    this.cuerpoCorreo = cuerpoCorreo;
  }
  
  public String getAsuntoCorreo() {
    return this.asuntoCorreo;
  }
  
  public void setAsuntoCorreo(String asuntoCorreo) {
    this.asuntoCorreo = asuntoCorreo;
  }
  
  public String getCuerpoCorreo() {
    return this.cuerpoCorreo;
  }
  
  public void setCuerpoCorreo(String cuerpoCorreo) {
    this.cuerpoCorreo = cuerpoCorreo;
  }
}
