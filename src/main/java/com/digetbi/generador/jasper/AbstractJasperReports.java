package com.digetbi.generador.jasper;


import com.digetbi.generador.conexion.Conexion;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Mariana Cuadrado - 17/6/2024
 * @version 1.0
 * @project EnvioCorreo
 **/

@Service
@Slf4j
public class AbstractJasperReports {


    private final DataSource dataSource;
    private static JasperReport report;

    private static JasperPrint reportFilled;

    private static JasperViewer viewer;
    @Autowired
    Conexion conexionB;

    @Autowired
    public AbstractJasperReports(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean crearReporte(String pathImagenFirma, String pathJRXML, String nombreJRXML, String codigoFormulario, String codigoOS, String numeroFormulario, String fechaFormulario, String pathPDF) {

        boolean resultado = false;
        Connection conexion = conexionB.getConnection();
        Path pathJRXMLs = Paths.get(pathJRXML+nombreJRXML+".jrxml");
        //Path reportPath = pathJRXMLs.resolve(nombreJRXML + ".jasper");

        try (InputStream reportStream = Files.newInputStream(pathJRXMLs)) {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            //JasperReport reportePrincipal = (JasperReport) JRLoader.loadObject(reportStream);

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("codigoFormulario", codigoFormulario);
            parametros.put("codigoOrdenServicio", codigoOS);
            parametros.put("numeroFormulario", numeroFormulario);
            parametros.put("fechaFormulario", fechaFormulario);
            parametros.put("pathImagen", pathImagenFirma);
            parametros.put("SUBREPORT_DIR", pathJRXML);

            agregarSubReporte(pathJRXML,parametros, "subReporteCiudad.jrxml","SUBREPORT_CIUDAD");
            agregarSubReporte(pathJRXML,parametros, "subReporteTecnicos.jrxml","SUBREPORT_TECNICOS");
            agregarSubReporte(pathJRXML,parametros, "subReporteAdjunto.jrxml","SUBREPORT_ADJUNTOS");


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexion);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathPDF);

            resultado = true;

        } catch (IOException e) {
            System.out.println("Error de IO: " + e.getMessage());
        } catch (JRException e) {
            System.out.println("Error de JasperReports: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return resultado;
    }

    private static void agregarSubReporte(String pathJRXML, Map<String, Object> parametros, String nombreReporte, String nombreParametro) throws IOException, JRException {
        Path pathSubReportCiudad = Paths.get(pathJRXML+nombreReporte);
        InputStream subReportCiudad = Files.newInputStream(pathSubReportCiudad);
        JasperReport subReport = JasperCompileManager.compileReport(subReportCiudad);
        parametros.put(nombreParametro, subReport);
    }


    public static void mostrarReporte() {
        viewer = new JasperViewer(reportFilled);
        viewer.setVisible(true);
    }

    public static Map<String,Object> guardarReporte(String codigoInforme, String path, int numeroIntento, String nombreArchivo) {
        boolean resultado = false;
        String mensaje="";
        try {
            JasperExportManager.exportReportToPdfFile(reportFilled, path);
            mensaje= "Reporte guardado exitosamente";
            resultado = true;
        } catch (JRException ex) {
            mensaje="Error al guardar reporte";
            resultado = false;
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", mensaje);
        respuesta.put("resultado", resultado);
        return respuesta;
    }

    public byte[] exportPdf(String reportTemplateDir, Long traCliId) {
        try (Connection connection = dataSource.getConnection()) {
            Path reportPath = Paths.get(reportTemplateDir, "ticket_amarillo.jrxml");
            try (InputStream reportStream = Files.newInputStream(reportPath)) {
                JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

                Map<String, Object> parameters = new HashMap<>();
                parameters.put("tic_tra_id", traCliId);
                parameters.put("IMAGES_DIR", Paths.get(reportTemplateDir, "images").toAbsolutePath().toString());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

                return JasperExportManager.exportReportToPdf(jasperPrint);
            } catch (IOException e) {

            }
        } catch (SQLException e) {

        } catch (JRException e) {

        }

        return null;
    }

    public byte[] exportPdfByTransactionId(Long traId) {
        try {
            InputStream jrxmlInput = getClass().getResourceAsStream("/ticketeventoshueca.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInput);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("tra_id", traId);
            Connection connection = dataSource.getConnection();
            //logger.info("Ejecutando consulta para generar PDF por transacción con tra_id: {}", traId);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            //logger.info("Consulta ejecutada exitosamente para tra_id: {}", traId);
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
            connection.close();
            return pdfBytes;
        } catch (Exception e) {
            //logger.error("Error al generar el PDF por transacción para tra_id: {}", traId, e);
            return null;
        }
    }
}
