package com.digetbi.generador;

import com.digetbi.generador.dto.Log;
import com.digetbi.generador.service.ConfiguracionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class GeneradorReportesApplication implements CommandLineRunner {

    static String strCodigoInforme = "";
    static String base = "";
    private final ConfiguracionService configuracionService;
    public GeneradorReportesApplication(ConfiguracionService configuracionService) {
        this.configuracionService = configuracionService;

    }

    public static void main(String[] args) {
        SpringApplication.run(GeneradorReportesApplication.class, args);


    }

    @Override
    public void run(String... args) {       
        if (args.length > 0) {
        //if (true){
            try {
                strCodigoInforme = args[0];
                //strCodigoInforme = "001.001.001.31032025.060629";
                configuracionService.generarReporte(strCodigoInforme);
            }
            catch (Exception e) {
                Log log = new Log(strCodigoInforme, "No se generó el reporte",""+ e.getLocalizedMessage());
                configuracionService.insertarLog(log);
            }
        }
        else {
            Log log = new Log(strCodigoInforme, "No existe argumentos", "");
            configuracionService.insertarLog(log);
        }
    }

}
