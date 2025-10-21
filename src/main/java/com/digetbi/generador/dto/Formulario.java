package com.digetbi.generador.dto;

public class Formulario {
  private String codigoFormulario;
  
  private String grupoFormulario;
  
  private String fechaFormulario;
  
  public Formulario() {}
  
  public Formulario(String codigoFormulario, String grupoFormulario, String fechaFormulario) {
    this.codigoFormulario = codigoFormulario;
    this.grupoFormulario = grupoFormulario;
    this.fechaFormulario = fechaFormulario;
  }
  
  public String getCodigoFormulario() {
    return this.codigoFormulario;
  }
  
  public void setCodigoFormulario(String codigoFormulario) {
    this.codigoFormulario = codigoFormulario;
  }
  
  public String getGrupoFormulario() {
    return this.grupoFormulario;
  }
  
  public void setGrupoFormulario(String grupoFormulario) {
    this.grupoFormulario = grupoFormulario;
  }
  
  public String getFechaFormulario() {
    return this.fechaFormulario;
  }
  
  public void setFechaFormulario(String fechaFormulario) {
    this.fechaFormulario = fechaFormulario;
  }
}
