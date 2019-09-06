package com.seventeam.gsf.config;

import com.seventeam.gsf.domain.Consulta;
import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.repository.ConsultaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ConsultaDao ConsultaRepo;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        pushConsulta();
    }


    private void pushConsulta() throws Exception
    {
        ConsultaRepo.deleteAll();

        Paciente paciente = new Paciente();

        int ix = 0;
        Consulta consulta1 = new Consulta("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
        Consulta consulta2 = new Consulta("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
        Consulta consulta3 = new Consulta("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
        Consulta consulta4 = new Consulta("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
        Consulta consulta5 = new Consulta("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
        Consulta consulta6 = new Consulta("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);
        Consulta consulta7 = new Consulta("TIPO"+ix++, sdf.parse("25/10/2019"),sdf.parse("26/10/2019"), paciente);

        ConsultaRepo.saveAll(Arrays.asList(
                consulta1,consulta2,consulta3,consulta4,consulta5,consulta6,consulta7));
    }
}
