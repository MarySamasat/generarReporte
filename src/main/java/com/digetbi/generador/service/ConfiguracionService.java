package com.digetbi.generador.service;

import com.digetbi.generador.dto.Informe;
import com.digetbi.generador.dto.Log;
import com.digetbi.generador.jasper.AbstractJasperReports;
import com.digetbi.generador.repository.*;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class ConfiguracionService {

    private final ConfiguracionRepository configuracionRepository;
    private final LogRepository logRepository;
    private final InformeRepository informeRepository;
    private final FormularioRepository formularioRepository;
    private final LogGenerarPdfRepository generarPdfRepository;
    private final AbstractJasperReports abstractJasperReports;

    public ConfiguracionService(ConfiguracionRepository configuracionRepository, LogRepository logRepository,
                                InformeRepository informeRepository, FormularioRepository formularioRepository,
                                LogGenerarPdfRepository generarPdfRepository, AbstractJasperReports abstractJasperReports) {
        this.configuracionRepository = configuracionRepository;
        this.logRepository = logRepository;
        this.informeRepository = informeRepository;
        this.formularioRepository = formularioRepository;
        this.generarPdfRepository = generarPdfRepository;
        this.abstractJasperReports = abstractJasperReports;
    }

    public String valorConfiguracion(String clave) {
        String valor = configuracionRepository.valorConfiguracion(clave);
        return valor;
    }

    public void insertarLog(Log log) {
        logRepository.insertar(log);
    }

    public void generarReporte(String codigoInforme) {
        if (codigoInforme.isEmpty())
            throw new IllegalArgumentException("El código de informe es obligatorio");
        Informe informe = informeRepository.obtenerInforme(codigoInforme);
        String pathImagenesFirma = valorConfiguracion("path imagen");
        String pathArchivoJRXML = valorConfiguracion("path JRXML");
        String reporte = recuperarNombreReporte(informe.getTipoInforme());
        String strCodigoFormulario = informe.getCodigoFormulario();
        String strCodigoOrdenServicio = informe.getCodigoOrdenServicio();
        String numeroFormulario = informe.getNumeroForulario();
        String fechaActual = formularioRepository.retornoFechaFormulario(strCodigoFormulario, informe.getTipoInforme());
        String pathFormularioPDF = valorConfiguracion("path PDF");
        Integer strNumeroIntento = generarPdfRepository.numeroIntentoLogGenerar(codigoInforme);
        String nombreReporte =  String.valueOf(numeroFormulario) + strNumeroIntento + ".pdf";
        String pathPdf = String.valueOf(pathFormularioPDF) + nombreReporte;
        abstractJasperReports.crearReporte(pathImagenesFirma, pathArchivoJRXML, reporte, strCodigoFormulario,
                strCodigoOrdenServicio, numeroFormulario, fechaActual, pathPdf);
        System.out.println("Que pacho");
    }

    public String recuperarNombreReporte(String tipoFormulario) {
        String nombreReporte = "";
        switch (tipoFormulario) {
            case "ITR-MO":
                nombreReporte= "reporteITRMO";
            break;
            case "ITR-MS":
                nombreReporte= "reporteITRMS";
            break;
            case "ITR-RR":
                nombreReporte= "reporteITRR";
            break;
            case "ITR-IPM":
                nombreReporte= "reporteITRIP";
            break;
            case "ITR-M":
                nombreReporte= "reporteITRM";
            break;
            case "ITR-RMAA":
                nombreReporte= "reporteITRMAA";
            break;
            case "ITR-RR-AA":
                nombreReporte= "reporteITRRAA";
            break;
            case "ITR-IPM-AA":
                nombreReporte= "reporteITRIPMAA";
            break;
            case "ITR-MP-AA":
                nombreReporte= "reporteITRMPAA";
            break;
        }
        return nombreReporte;
    }

    public Integer obtenerIdFormulario(Informe informe) {
        String codigoOS = informe.getCodigoOrdenServicio();
        String tipoFormulario = informe.getTipoInforme();
        return formularioRepository.recuperarIdFormulario(codigoOS, tipoFormulario);

    }

    private String parsearFechaStr(String fechaFormulario) throws ParseException {
        String fechaActual = "";
        SimpleDateFormat formato, formateador = new SimpleDateFormat(
                "EEEE, d 'de' MMMM 'del' yyyy", new Locale("es", "ES"));
        String fechaFrm = fechaFormulario.replace("/", "-");
        String[] separadas = fechaFrm.split("-");
        char[] caracteres = separadas[0].toCharArray();
        if (caracteres.length == 2) {
            formato = new SimpleDateFormat("dd-MM-yyyy", new Locale("es", "ES"));
        } else {
            formato = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
        }
        Date fechaEnvio = formato.parse(fechaFrm);
        Date date1 = fechaEnvio;
        fechaActual = formateador.format(fechaEnvio);
        String inicio = "";
        String restante = "";
        inicio = fechaActual.substring(0, 1);
        restante = fechaActual.substring(1);
        return String.valueOf(inicio.toUpperCase()) + restante;
    }
}
