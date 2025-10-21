package com.digetbi.generador.repository;

import com.digetbi.generador.dto.Log;
import com.digetbi.generador.dto.LogGenerarPDF;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogGenerarPdfRepository {

    private final JdbcTemplate jdbcTemplate;

    public LogGenerarPdfRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean insertar(Log log) {
        String sql = "INSERT INTO TB_LOG_CORREO_APPS (log_correo_apps_mensaje, log_correo_apps_codigo_informe, log_correo_apps_detalle) VALUES (?, ?, ?)";
        int n = jdbcTemplate.update(sql, log.getMensaje(), log.getCodigoOrden(), log.getDetalle());
        return n > 0;
    }

    public boolean insertarLogPDF(LogGenerarPDF log) {
        String sql = "INSERT INTO TB_LOG_GENERAR_PDF (log_generar_pdf_codigo_informe, log_generar_pdf_motivo, log_generar_pdf_mensaje, log_generar_pdf_nombre_archivo, log_generar_pdf_numero) VALUES (?, ?, ?, ?, ?)";
        int n = jdbcTemplate.update(sql,
                log.getCodigoInforme(),
                log.getMotivoGenera(),
                log.getMensageGenera(),
                log.getNombreArchivo(),
                log.getNumeroIntento());
        return n > 0;
    }

    public int numeroIntentoLogGenerar(String codigoInforme) {
        String sql = "SELECT TOP 1 log_generar_pdf_numero FROM TB_LOG_GENERAR_PDF WHERE log_generar_pdf_codigo_informe = ? ORDER BY log_generar_pdf_id DESC";

        Integer numeroIntento = jdbcTemplate.query(
                sql,
                new Object[]{codigoInforme},
                rs -> {
                    if (rs.next()) {
                        return rs.getInt(1);
                    } else {
                        return 0; // Valor por defecto si no hay resultados
                    }
                });

        return numeroIntento != null ? numeroIntento : 0;
    }


}
