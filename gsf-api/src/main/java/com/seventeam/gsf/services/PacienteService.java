package com.seventeam.gsf.services;

import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.models.Form.PacienteForm;
import com.seventeam.gsf.models.enums.PerfilTipoEnum;
import com.seventeam.gsf.repository.PacienteDao;
import com.seventeam.gsf.repository.UsuarioDao;
import com.seventeam.gsf.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteDao pacienteDao;
    @Autowired
    private PerfilService perfilService;
    @Autowired
    private UsuarioDao usuarioDao;

    public PacienteService() {
    }

    public void save(Paciente obj) throws Exception
    {
        try {
            if (obj != null){
                obj.getUsuario().setPerfil(new Perfil(1, PerfilTipoEnum.PACIENTE));

                pacienteDao.save(obj);
            }
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }



    public List<Paciente> findAll()
    {
        return pacienteDao.findAll();
    }

    public Paciente findById(Integer id)
    {
        Optional<Paciente> obj = pacienteDao.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found. [Paciente]"));
    }
    
    public Paciente getByLogin(String login)
    {
        Usuario usuario = usuarioDao.getByLogin(login);
        Paciente paciente = pacienteDao.getByUsuario(usuario);
        return paciente;
    }

    public Paciente getPacienteByForm(PacienteForm form)
    {
        Perfil perfilPaciente = perfilService.getByTipoPerfil(PerfilTipoEnum.PACIENTE);

        Usuario usuario = new Usuario(form.getLogin(),form.getPassword());
        usuario.setPerfil(perfilPaciente);

        Paciente paciente = new Paciente(
                form.nome,
                form.dataNascimento,
                form.dataGravidez,
                usuario);

        return paciente;
    }
    
    public Paciente update(PacienteForm form, Integer id)
    {
        // TODO: VALIDATE FORM.
        Paciente pacToUpdate = findById(id);
        Paciente newPaciente = updatePacienteByForm(form, pacToUpdate);
        //save(newPaciente);
        
        return newPaciente;
    }
    
    public Paciente updatePacienteByForm(PacienteForm form, Paciente pacToUpdate)
    {
        if (!UtilsString.isEmptyOrBlanck(form.getNome())){
            pacToUpdate.setNome(form.getNome());
        }
        
        if (!UtilsString.isEmptyOrBlanck(form.getLogin())){
            pacToUpdate.getUsuario().setLogin(form.getLogin());
        }
        
        if (!UtilsString.isEmptyOrBlanck(form.getPassword())){
            pacToUpdate.getUsuario().setPassword(form.getPassword());
        }
    
        if (form.getDataGravidez() != null){
            pacToUpdate.setDataGravidez(form.getDataGravidez());
        }
    
        if (form.getDataNascimento() != null){
            pacToUpdate.setDataNascimento(form.getDataNascimento());
        }
        
        return pacToUpdate;
    }

//    public void delete(Integer id, String login) throws Exception
    public void delete(Integer id, String login) throws Exception
    {
        Paciente p = findById(id);
        if(p.getUsuario().getLogin().equals(login)){
            pacienteDao.deleteById(id);
        }else{
            throw new Exception("Ação não permitida");
        }

    }
}
