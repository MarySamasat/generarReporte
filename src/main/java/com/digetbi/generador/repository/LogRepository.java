package com.digetbi.generador.repository;

import com.digetbi.generador.dto.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepository {
    private final JdbcTemplate jdbcTemplate;

    public LogRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean insertar(Log log) {
        String sql = "INSERT INTO TB_LOG_CORREO_APPS (log_correo_apps_mensaje, log_correo_apps_codigo_informe, log_correo_apps_detalle) VALUES (?, ?, ?)";

        int filasAfectadas = jdbcTemplate.update(sql,
                log.getMensaje(),
                log.getCodigoOrden(),
                log.getDetalle()
        );

        return filasAfectadas > 0;
    }
}
