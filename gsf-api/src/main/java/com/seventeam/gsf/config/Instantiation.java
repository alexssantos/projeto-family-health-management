package com.seventeam.gsf.config;

import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.domain.*;
import com.seventeam.gsf.models.enums.PerfilTipoEnum;
import com.seventeam.gsf.models.enums.PermissaoEnum;
import com.seventeam.gsf.repository.*;
import com.seventeam.gsf.services.PerfilService;
import com.seventeam.gsf.services.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    private PermissaoService permissaoService;

    public static List<Usuario> usuarioList = new ArrayList<>();
    public static List<Paciente> pacienteList = new ArrayList<>();

    public Perfil perfilMedico;
    public Perfil perfilPaciente;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception
    {
        initConfigs();
    
//        listAllFromDatabase();
//        deleteAllFromdatabase();
//        pushUsuarioToDb();
//        pushPacienteToDb();
//        pushMedicoToDb();
    }

    private void initConfigs()
    {
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        createProfiles();
        createPermissionsByProfiles();
    }
    
    private void createProfiles()
    {
        List<PerfilTipoEnum> enumTipoPerfilList = Arrays.asList(PerfilTipoEnum.values());
        List<Perfil> perfilOnDbList = perfilService.findAll();
        List<PerfilTipoEnum> enumOnDbList = perfilOnDbList
                .stream()
                .map(x -> x.getTipoPerfil())
                .distinct()
                .collect(Collectors.toList());
    
        List<Perfil> toSave = null;
        if (!(enumOnDbList.size() == enumTipoPerfilList.size()))
        {
            toSave = enumTipoPerfilList.stream()
                    .filter(x -> !enumOnDbList.contains(x))
                    .map(x -> new Perfil(x))
                    .collect(Collectors.toList());
        }
    
        PerfilDao dao = perfilDao;
        boolean hasToSave = (toSave != null) && (toSave.size() > 0);
        if (hasToSave)
        {
            trySave(dao, toSave);
        }
    
        List<Perfil> perfils = (hasToSave) ? dao.findAll() : perfilOnDbList;
        Perfil.allPerfis.addAll(perfils);
        
        this.perfilMedico = perfils.stream().filter(x -> x.getTipoPerfil() == PerfilTipoEnum.MEDICO).findFirst().get();
        this.perfilPaciente = perfils.stream().filter(x -> x.getTipoPerfil() == PerfilTipoEnum.PACIENTE).findFirst().get();
    }
    
    private void createPermissionsByProfiles()
    {
        //get all profiles
        List<Perfil> perfils = Perfil.allPerfis;
        
        List<Permissao> permissaoOnDbList = permissaoService.findAll();
    
        List<Permissao> toSave = new ArrayList<>();
        for (Perfil perfil: perfils)
        {
            PerfilTipoEnum perfilEnum = perfil.getTipoPerfil();
            boolean hasPerfilKey = PerfilService.perfilPermissaoMap.containsKey(perfilEnum);
            if (!hasPerfilKey)
            {
                continue;
            }
            
            List<PermissaoEnum> enumPermissionListOfPerfil = PerfilService.perfilPermissaoMap.get(perfilEnum);
            
            List<Permissao> permissaoByPerfilOnDb = permissaoOnDbList.stream().filter(x -> x.getPerfil().getTipoPerfil() == perfilEnum).collect(Collectors.toList());
            List<PermissaoEnum> permissaoEnumsByPerfilOnDb = permissaoByPerfilOnDb.stream().map(x -> x.getAcao()).distinct().collect(Collectors.toList());
            
            List<Permissao> notOnDb = enumPermissionListOfPerfil.stream()
                    .filter(x -> !permissaoEnumsByPerfilOnDb.contains(x))
                    .map(obj -> new Permissao(obj))
                    .collect(Collectors.toList()
            );
            
            notOnDb.forEach(obj -> {
                obj.setPerfil(perfil);
            });
            
            toSave.addAll(notOnDb);
        }
        
        if (toSave.size() < 1){
            return;
        }
    
        PermissaoDao dao = permissaoService.getDao();
        trySave(dao, toSave);
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

    private void listAllFromDatabase()
    {
        List<Perfil> perfils = perfilDao.findAll();
        List<Usuario> usuarios = usuarioDao.findAll();
        List<Paciente> pacientes = pacienteDao.findAll();
        List<Medico> medicos = medicoDao.findAll();


        perfils.forEach(item -> System.out.println(item));
        System.out.println("------------------------------\n\n");

        usuarios.forEach(item -> System.out.println(item));

        System.out.println("------------------------------\n\n");

        pacientes.forEach(item -> System.out.println(item));
        System.out.println("------------------------------\n\n");

        medicos.forEach(item -> System.out.println(item));
        System.out.println("------------------------------\n\n");
    }
    
    private void pushUsuarioToDb() throws Exception
    {
        UsuarioDao dao = usuarioDao;
        List<Usuario> usuarioList = dao.findAll();
        if (usuarioList.size() > 0){
            return;
        }

        Usuario alexUser = new Usuario("alex@gmail.com", "123");

        List<Perfil> perfilList = perfilDao.findAll();
        Perfil perfil1 = perfilList.get(0);
        alexUser.setPerfil(perfil1);

        trySave(dao, alexUser);
    }


    private void pushPacienteToDb() throws Exception
    {
        PacienteDao dao = pacienteDao;

        List<Perfil> perfilList = perfilDao.findAll();
        Perfil perfil1 = perfilList.get(0);

        Usuario alexUser = new Usuario("alex@gmail.com", "123");
        alexUser.setPerfil(perfil1);
        Paciente alex = new Paciente("Alex Santos", sdf.parse("25/10/2019"),sdf.parse("30/10/2019"), alexUser);

        Usuario brunaUser = new Usuario("bruna@gmail.com", "123");
        brunaUser.setPerfil(perfil1);
        Paciente bruna = new Paciente("Bruna Dolavale", sdf.parse("01/05/2019"),sdf.parse("15/05/2019"), brunaUser);

        Usuario matheusUser = new Usuario("matheus@gmail.com", "123");
        matheusUser.setPerfil(perfil1);
        Paciente matheus = new Paciente("Matheus Gomes", sdf.parse("02/06/2019"),sdf.parse("16/06/2019"), matheusUser);

        Usuario thaisUser = new Usuario("thais@gmail.com", "123");
        thaisUser.setPerfil(perfil1);
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

        List<Perfil> perfilList = perfilDao.findAll();
        Perfil perfil1 = perfilList.get(0);

        List<Medico> medicoList = new ArrayList<>();
        int qtdMedicos = 10;

        for (int i=1; i <= qtdMedicos; i++)
        {
            Usuario user = new Usuario(UtilsString.msgFormat("medico-{0}@gmail.com",i),"123");
            user.setPerfil(perfil1);

            Medico medicoX = new Medico(
                UtilsString.msgFormat("Medico-{0}",i),
                Medico.generateCRM(),
                user
            );

            medicoList.add(medicoX);
        }

        boolean isOk = trySave(medicoDao, medicoList);
        if (isOk){
            System.out.println(dao.findAll());
        }
    }

    public static <E, D extends JpaRepository> boolean trySave(D dao, E entity)
    {
        List<E> list = new ArrayList<>();
        list.add(entity);

        return trySave(dao, list);
    }

    public static <E, D extends JpaRepository<E, Integer>> boolean trySave(D dao, List<E> entityList)
    {
        boolean isOk = true;
        try {
            dao.saveAll(entityList);
            dao.flush();
        }
        catch (Exception e)
        {
            isOk = false;
            e.printStackTrace();
        }

        return isOk;
    }

    public static <E> void printAll(List<?> entityList)
    {
        if (entityList.size() < 1) return;

        for (Object item : entityList)
        {
            System.out.println("-----------------------------------");
            System.out.println(item);
            System.out.println("-----------------------------------");
        }
    }
}
