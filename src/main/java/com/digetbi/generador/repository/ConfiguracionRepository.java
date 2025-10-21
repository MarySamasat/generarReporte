package com.digetbi.generador.repository;


import com.digetbi.generador.dto.Configuracion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConfiguracionRepository {
  private final JdbcTemplate jdbcTemplate;

  public ConfiguracionRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

    public List<Configuracion> obtener() {

      String sql = "select config_nombre, config_valor FROM TA_CONFIGURACION WHERE config_grupo = 'APPS' and config_inactivo = 0";
      List<Configuracion> listaConfiguracion = jdbcTemplate.query(sql,(rs, rowNum) -> {
        Configuracion config = new Configuracion();
        config.setNombre(rs.getString(0));
        config.setValor(rs.getString(1));
        return config;
      });

      return listaConfiguracion;
    }


  public String valorConfiguracion(String nombre) {

    String sql = "select config_valor FROM TA_CONFIGURACION WHERE config_grupo = 'APPS' and config_inactivo = 0 and config_nombre like '%" + nombre + "'";
    List<String> lista = jdbcTemplate.query(sql, (rs, rowNum) -> {
        return rs.getString(1);
    });

    return lista.isEmpty() ? null : lista.get(0);
  }
}
