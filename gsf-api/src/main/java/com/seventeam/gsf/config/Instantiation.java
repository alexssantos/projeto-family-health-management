package com.seventeam.gsf.config;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.repository.PacienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PacienteDao pacienteDao;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        //pushPacienteToDb();
    }


    private void pushPacienteToDb() throws Exception
    {
        pacienteDao.deleteAll();

        Paciente alex = new Paciente("Alex Santos", sdf.parse("25/10/2019"),sdf.parse("30/10/2019"));
        Paciente bruna = new Paciente("Bruna Dolavale", sdf.parse("01/05/2019"),sdf.parse("15/05/2019"));
        Paciente matheus = new Paciente("Matheus Gomes", sdf.parse("02/06/2019"),sdf.parse("16/06/2019"));
        Paciente thais = new Paciente("Thais Machado", sdf.parse("03/07/2019"),sdf.parse("17/07/2019"));


        pacienteDao.saveAll(Arrays.asList(alex, bruna, matheus,thais));
    }
}
