package com.digetbi.generador.repository;

import com.digetbi.generador.dto.Informe;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InformeRepository {

    private final JdbcTemplate jdbcTemplate;

    public InformeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Informe obtenerInforme(String codigoOS) {
        String sql = "SELECT informe_codigo, " +
                "informe_orden_servicio_codigo, " +
                "informe_orden_cod_doc, " +
                "informe_orden_servico_numero, " +
                "informe_tipo_informe, " +
                "informe_numero_formulario, " +
                "informe_nombre_archivo, " +
                "informe_cod_formulario, " +
                "informe_empresa " +
                "FROM TB_INFORME " +
                "WHERE informe_codigo = ? AND informe_cod_formulario IS NOT NULL";

        // No capturamos EmptyResultDataAccessException para que escale
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{codigoOS}, (rs, rowNum) -> {
                Informe informe = new Informe();
                informe.setCodigoInforme(rs.getString("informe_codigo"));
                informe.setCodigoOrdenServicio(rs.getString("informe_orden_servicio_codigo"));
                informe.setCodDoc(rs.getString("informe_orden_cod_doc"));
                informe.setNumeroOS(rs.getString("informe_orden_servico_numero"));
                informe.setTipoInforme(rs.getString("informe_tipo_informe"));
                informe.setNumeroForulario(rs.getString("informe_numero_formulario"));
                informe.setNombrePDF(rs.getString("informe_nombre_archivo"));
                informe.setCodigoFormulario(rs.getString("informe_cod_formulario"));
                informe.setCodigoEmpresa(rs.getString("informe_empresa"));
                return informe;
            });
        } catch (Exception e) {
            System.out.println("Consulta de informe " + e.getMessage());
            throw e;
        }
    }
}
