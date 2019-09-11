package com.seventeam.gsf.config;

import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;
import com.seventeam.gsf.repository.MedicoDao;
import com.seventeam.gsf.repository.PacienteDao;
import com.seventeam.gsf.repository.PerfilDao;
import com.seventeam.gsf.repository.UsuarioDao;
import com.seventeam.gsf.services.PerfilService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;
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
    @Autowired
    private PerfilDao perfilDao;
    @Autowired
    private PerfilService perfilService;

    public static List<Usuario> usuarioList = new ArrayList<>();
    public static List<Paciente> pacienteList = new ArrayList<>();

    public Perfil perfilMedico;
    public Perfil perfilPaciente;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        deleteAllFromdatabase();

        perfilInstantiation();
        pushUsuarioToDb();
        pushPacienteToDb();
        pushMedicoToDb();
    }

    private void deleteAllFromdatabase()
    {
        // DELETE: ORDENADO POR FK NA BASE

        medicoDao.deleteAll();
        medicoDao.flush();

        pacienteDao.deleteAll();
        pacienteDao.flush();

        usuarioDao.deleteAll();
        usuarioDao.flush();

        //permissaoDao.deleteAll();
        //permissaoDao.flush();

        perfilDao.deleteAll();
        perfilDao.flush();
    }

    private void perfilInstantiation()
    {
        List<Perfil> perfilList = perfilDao.findAll();
        if (perfilList.size() > 0){
            return;
        }

        this.perfilMedico = new Perfil(EnumUsuarioPerfil.MEDICO);
        this.perfilPaciente = new Perfil(EnumUsuarioPerfil.PACIENTE);

        perfilDao.saveAll(Arrays.asList(perfilMedico, perfilPaciente));
        perfilDao.flush();
    }

    private void pushUsuarioToDb() throws Exception
    {
        List<Usuario> usuarioList = usuarioDao.findAll();
        if (usuarioList.size() > 0){
            return;
        }


        Usuario alexUser = new Usuario("alex@gmail.com", "123");

        List<Perfil> perfilList = perfilDao.findAll();
        Perfil perfil1 = perfilList.get(0);

        alexUser.setPerfil(perfil1);

        usuarioDao.saveAndFlush(alexUser);
    }


    private void pushPacienteToDb() throws Exception
    {
        PacienteDao dao = pacienteDao;
        Usuario alexUser = new Usuario("alex@gmail.com", "123");
        Paciente alex = new Paciente("Alex Santos", sdf.parse("25/10/2019"),sdf.parse("30/10/2019"), alexUser);

        Usuario brunaUser = new Usuario("bruna@gmail.com", "123");
        Paciente bruna = new Paciente("Bruna Dolavale", sdf.parse("01/05/2019"),sdf.parse("15/05/2019"), brunaUser);

        Usuario matheusUser = new Usuario("matheus@gmail.com", "123");
        Paciente matheus = new Paciente("Matheus Gomes", sdf.parse("02/06/2019"),sdf.parse("16/06/2019"), matheusUser);

        Usuario thaisUser = new Usuario("thais@gmail.com", "123");
        Paciente thais = new Paciente("Thais Machado", sdf.parse("03/07/2019"),sdf.parse("17/07/2019"), thaisUser);

        List<Paciente> list = new ArrayList<>(
                Arrays.asList(
                        alex, bruna, matheus, thais
                )
        );

        boolean isOk = trySave(dao, list);
        if (isOk){
            System.out.println(dao.findAll());
        }
    }

    private void pushMedicoToDb()
    {
        MedicoDao dao = medicoDao;
        List<Medico> medicoList = new ArrayList<>();
        int qtdMedicos = 10;

        for (int i=1; i <= qtdMedicos; i++)
        {
            Medico medicoX = new Medico(
                    UtilsString.msgFormat("Medico-{0}",i),
                    Medico.generateCRM(),
                    new Usuario(
                            UtilsString.msgFormat("medico-{0}@gmail.com",i),
                            "123"
                    )
            );

            medicoList.add(medicoX);
        }

        boolean isOk = trySave(medicoDao, medicoList);
        if (isOk){
            System.out.println(dao.findAll());
        }
    }

    public static <E extends Entity, D extends JpaRepository> boolean trySave(D dao, E entity)
    {
        List<E> list = new ArrayList<>();
        list.add(entity);

        return trySave(dao, list);
    }

    public static <D extends JpaRepository> boolean trySave(D dao, List<?> entityList)
    {
        boolean isOk = true;
        try {
            dao.save(entityList);
            dao.flush();
        }
        catch (Exception e)
        {
            isOk = false;
            e.printStackTrace();
        }

        return isOk;
    }
}
