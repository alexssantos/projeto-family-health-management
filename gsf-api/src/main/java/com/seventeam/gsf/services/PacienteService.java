package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.models.Form.PacienteForm;
import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;
import com.seventeam.gsf.repository.PacienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteDao pacienteDao;
    @Autowired
    private PerfilService perfilService;

    public PacienteDao getDao()
    {
        return this.pacienteDao;
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
        //TODO: obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

        return obj.orElse(new Paciente());
    }

    public Paciente getPacienteByForm(PacienteForm form)
    {
        Perfil perfilPaciente = perfilService.getByTipoPerfil(EnumUsuarioPerfil.PACIENTE);

        Usuario usuario = new Usuario(form.login,form.password);
        usuario.setPerfil(perfilPaciente);

        Paciente paciente = new Paciente(
                form.nome,
                form.dataNascimento,
                form.dataGravidez,
                usuario);

        return paciente;
    }

    public void delete(Integer id)
    {
        findById(id);
        pacienteDao.deleteById(id);
    }
}
