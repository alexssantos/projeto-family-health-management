package com.seventeam.gsf.config;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;
import com.seventeam.gsf.repository.PacienteDao;
import com.seventeam.gsf.repository.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PacienteDao pacienteDao;
    private UsuarioDao usuarioDao;

    public static List<Usuario> usuarioList = new ArrayList<>();
    public static List<Paciente> pacienteList = new ArrayList<>();

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        pushUsuarioToDb();
        pushPacienteToDb();
    }


    private void pushUsuarioToDb() throws Exception
    {
        usuarioDao.deleteAll();
        Usuario alexUser = new Usuario("alex@gmail.com", "123", EnumUsuarioPerfil.MEDICO);

        usuarioList.addAll(Arrays.asList(
                alexUser
        ));

        usuarioDao.save(alexUser);
    }


    private void pushPacienteToDb() throws Exception
    {
        pacienteDao.deleteAll();


        Paciente alex = new Paciente("Alex Santos", sdf.parse("25/10/2019"),sdf.parse("30/10/2019"), usuarioList.get(0));
        //Paciente bruna = new Paciente("Bruna Dolavale", sdf.parse("01/05/2019"),sdf.parse("15/05/2019"));
        //Paciente matheus = new Paciente("Matheus Gomes", sdf.parse("02/06/2019"),sdf.parse("16/06/2019"));
        //Paciente thais = new Paciente("Thais Machado", sdf.parse("03/07/2019"),sdf.parse("17/07/2019"));

        pacienteDao.saveAll(Arrays.asList(
                alex
                //bruna,
                //matheus,
                //thais
        ));
    }
}
