package com.seventeam.gsf.services;

import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.models.Form.PacienteForm;
import com.seventeam.gsf.models.enums.PerfilTipoEnum;
import com.seventeam.gsf.repository.PacienteDao;
import com.seventeam.gsf.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteDao pacienteDao;
    @Autowired
    private PerfilService perfilService;

    public PacienteService() {
    }

    public void save(Paciente obj)
    {
        if (obj != null){
            pacienteDao.save(obj);
        }
    }

    public Paciente save(PacienteForm form)
    {
        if (form == null){
            return null;
        }

        Paciente paciente = getPacienteByForm(form);
        save(paciente);
        return paciente;
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
        save(newPaciente);
        
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

    public void delete(Integer id)
    {
        findById(id);
        pacienteDao.deleteById(id);
    }
}
