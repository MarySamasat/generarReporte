package com.digetbi.generador.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FormularioRepository {
    private final JdbcTemplate jdbcTemplate;

    public FormularioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer recuperarIdFormulario(String codigoOS, String tipoFormulario) {
        String sql;

        switch (tipoFormulario) {
            case "ITR-MO":
                sql = "SELECT itr_mo_email_contacto2, itr_mo_fecha_formulario, itr_mo_id FROM TE_FORMULARIO_ITR_MO WHERE itr_mo_codigo_formulario = ?";
                break;
            case "ITR-MS":
                sql = "SELECT itr_ms_email_contacto2, itr_ms_fecha_formulario, itr_ms_id FROM TE_FORMULARIO_ITR_MS WHERE itr_ms_codigo = ?";
                break;
            case "ITR-RR":
                sql = "SELECT itr_rr_email_contacto2, itr_rr_fecha_formulario, itr_rr_id FROM TE_FORMULARIO_ITR_RR WHERE itr_rr_codigo_formulario = ?";
                break;
            case "ITR-IPM":
                sql = "SELECT itr_ipm_email_contacto2, itr_ipm_formulario_fecha, itr_ipm_id FROM TE_FORMULARIO_ITR_IPM WHERE itr_ipm_formulario_codigo = ?";
                break;
            case "ITR-M":
                sql = "SELECT itr_m_email_contacto2, itr_m_fecha_formulario, itr_m_id FROM TE_FORMULARIO_ITR_M WHERE itr_m_codigo = ?";
                break;
            case "ITR-RMAA":
                sql = "SELECT itr_rmaa_email_contacto2, itr_rmaa_fecha, itr_rmaa_id FROM TE_FORMULARIO_ITR_RMAA WHERE itr_rmaa_codigo_formulario = ?";
                break;
            case "ITR-MP-AA":
                sql = "SELECT itr_ms_aa_email_contacto2, itr_ms_aa_FormularioFecha, itr_ms_aa_id FROM TE_FORMULARIO_ITR_MS_AA WHERE itr_ms_aa_FormularioCodigo = ?";
                break;
            case "ITR-RR-AA":
                sql = "SELECT itr_rraa_email_contacto2, itr_rraa_fecha, itr_rraa_id FROM TE_FORMULARIO_ITR_RRAA WHERE itr_rraa_codigo_formulario = ?";
                break;
            case "ITR-IPM-AA":
                sql = "SELECT itr_ipm_email_contacto2, itr_ipm_formulario_fecha, itr_ipm_id FROM TE_FORMULARIO_ITR_IPM WHERE itr_ipm_formulario_codigo = ?";
                break;
            default:
                throw new IllegalArgumentException("Tipo de formulario no reconocido: " + tipoFormulario);
        }

        return jdbcTemplate.queryForObject(sql, new Object[]{codigoOS}, (rs, rowNum) -> rs.getInt(3));
    }

    public String retornoFechaFormulario(String codigoFormulario, String tipoFormulario) {
        String sql;

        switch (tipoFormulario) {
            case "ITR-MO":
                sql = "SELECT itr_mo_fax, itr_mo_fecha_formulario FROM TE_FORMULARIO_ITR_MO WHERE itr_mo_codigo_formulario = ?";
                break;
            case "ITR-MS":
                sql = "SELECT itr_ms_fax, itr_ms_fecha_formulario FROM TE_FORMULARIO_ITR_MS WHERE itr_ms_codigo = ?";
                break;
            case "ITR-RR":
                sql = "SELECT itr_rr_fax, itr_rr_fecha_formulario FROM TE_FORMULARIO_ITR_RR WHERE itr_rr_codigo_formulario = ?";
                break;
            case "ITR-IPM":
                sql = "SELECT itr_ipm_fax, itr_ipm_fecha_formulario FROM TE_FORMULARIO_ITR_IPM WHERE itr_ipm_codigo = ?";
                break;
            case "ITR-M":
                sql = "SELECT itr_m_fax, itr_m_fecha_formulario FROM TE_FORMULARIO_ITR_M WHERE itr_m_codigo = ?";
                break;
            case "ITR-RMAA":
                sql = "SELECT itr_rmaa_email_contacto2, itr_rmaa_fecha FROM TE_FORMULARIO_ITR_RMAA WHERE itr_rmaa_codigo_formulario = ?";
                break;
            case "ITR-MP-AA":
                sql = "SELECT itr_ms_aa_email_contacto2, itr_ms_aa_FormularioFecha FROM TE_FORMULARIO_ITR_MS_AA WHERE itr_ms_aa_FormularioCodigo = ?";
                break;
            case "ITR-RR-AA":
                sql = "SELECT itr_rraa_email_contacto2, itr_rraa_fecha FROM TE_FORMULARIO_ITR_RRAA WHERE itr_rraa_codigo_formulario = ?";
                break;
            case "ITR-IPM-AA":
                sql = "SELECT itr_ipm_email_contacto2, itr_ipm_formulario_fecha FROM TE_FORMULARIO_ITR_IPM WHERE itr_ipm_formulario_codigo = ?";
                break;
            default:
                throw new IllegalArgumentException("Tipo de formulario no reconocido: " + tipoFormulario);
        }

        return jdbcTemplate.queryForObject(sql, new Object[]{codigoFormulario}, (rs, rowNum) -> rs.getString(2));
    }


}
