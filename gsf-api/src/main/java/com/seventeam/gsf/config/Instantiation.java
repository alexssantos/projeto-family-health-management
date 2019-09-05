package com.seventeam.gsf.config;

import com.seventeam.gsf.domain.ConsultaDao;
import com.seventeam.gsf.domain.PacienteDao;
import com.seventeam.gsf.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ConsultaRepository ConsultaRepo;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        pushConsulta();
    }


    private void pushConsulta() throws Exception
    {
        ConsultaRepo.deleteAll();

        PacienteDao paciente = new PacienteDao();

//        int ix = 0;
//        ConsultaDao consulta1 = new ConsultaDao("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
//        ConsultaDao consulta2 = new ConsultaDao("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
//        ConsultaDao consulta3 = new ConsultaDao("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
//        ConsultaDao consulta4 = new ConsultaDao("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
//        ConsultaDao consulta5 = new ConsultaDao("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
//        ConsultaDao consulta6 = new ConsultaDao("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
//        ConsultaDao consulta7 = new ConsultaDao("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
//
//        ConsultaRepo.saveAll(Arrays.asList(
//                consulta1,consulta2,consulta3,consulta4,consulta5,consulta6,consulta7));
    }
}
