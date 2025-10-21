package com.digetbi.generador.dto;

public class Tecnico {
  private String codigoTecnico;
  
  private String nombreTecnico;
  
  private String emailTecnico;
  
  public Tecnico() {}
  
  public Tecnico(String codigoTecnico, String nombreTecnico, String emailTecnico) {
    this.codigoTecnico = codigoTecnico;
    this.nombreTecnico = nombreTecnico;
    this.emailTecnico = emailTecnico;
  }
  
  public String getCodigoTecnico() {
    return this.codigoTecnico;
  }
  
  public void setCodigoTecnico(String codigoTecnico) {
    this.codigoTecnico = codigoTecnico;
  }
  
  public String getNombreTecnico() {
    return this.nombreTecnico;
  }
  
  public void setNombreTecnico(String nombreTecnico) {
    this.nombreTecnico = nombreTecnico;
  }
  
  public String getEmailTecnico() {
    return this.emailTecnico;
  }
  
  public void setEmailTecnico(String emailTecnico) {
    this.emailTecnico = emailTecnico;
  }
}
