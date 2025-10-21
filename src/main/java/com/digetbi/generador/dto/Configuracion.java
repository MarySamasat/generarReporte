package com.digetbi.generador.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Configuracion {
	  private String nombre;
	  private String valor;
	  
	  public Configuracion() {}

	@Override
	public String toString() {
		return "Configuracion{" +
				"nombre='" + nombre + '\'' +
				", valor='" + valor + '\'' +
				'}';
	}
}
