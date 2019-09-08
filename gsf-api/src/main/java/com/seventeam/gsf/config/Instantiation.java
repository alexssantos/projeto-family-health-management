package com.seventeam.gsf.config;

import com.seventeam.gsf.Utils.UtilsNumbers;
import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;
import com.seventeam.gsf.repository.MedicoDao;
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
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private MedicoDao medicoDao;

    public static List<Usuario> usuarioList = new ArrayList<>();
    public static List<Paciente> pacienteList = new ArrayList<>();

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        pushUsuarioToDb();
        pushPacienteToDb();
        pusuMedicoToDb();
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

        Usuario alexUser = new Usuario("alex@gmail.com", "123", EnumUsuarioPerfil.PACIENTE);
        Paciente alex = new Paciente("Alex Santos", sdf.parse("25/10/2019"),sdf.parse("30/10/2019"), alexUser);

        Usuario brunaUser = new Usuario("bruna@gmail.com", "123", EnumUsuarioPerfil.PACIENTE);
        Paciente bruna = new Paciente("Bruna Dolavale", sdf.parse("01/05/2019"),sdf.parse("15/05/2019"), brunaUser);

        Usuario matheusUser = new Usuario("matheus@gmail.com", "123", EnumUsuarioPerfil.PACIENTE);
        Paciente matheus = new Paciente("Matheus Gomes", sdf.parse("02/06/2019"),sdf.parse("16/06/2019"), matheusUser);

        Usuario thaisUser = new Usuario("thais@gmail.com", "123", EnumUsuarioPerfil.PACIENTE);
        Paciente thais = new Paciente("Thais Machado", sdf.parse("03/07/2019"),sdf.parse("17/07/2019"), thaisUser);

        try
        {
            pacienteDao.deleteAll();

            pacienteDao.saveAll(Arrays.asList(
                    alex, bruna, matheus, thais
            ));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pusuMedicoToDb()
    {
        List<Medico> medicoList = new ArrayList<>();
        int qtdMedicos = 10;

        for (int i=0; i<qtdMedicos; i++)
        {
            Medico medicoX = new Medico(
                    UtilsString.msgFormat("Medico-{0}",i),
                    Medico.generateCRM(),
                    new Usuario(
                            UtilsString.msgFormat("medico-{0}@gmail.com",i),
                            "123",
                            EnumUsuarioPerfil.MEDICO)
            );

            medicoList.add(medicoX);
        }

        try
        {
            medicoDao.deleteAll();

            medicoDao.saveAll(medicoList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
