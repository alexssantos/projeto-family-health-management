package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.models.Form.MedicoForm;
import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;
import com.seventeam.gsf.repository.MedicoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoDao dao;
    
    @Autowired
    PerfilService perfilService;

    public void save(Medico obj)
    {
        if (obj != null){
            dao.save(obj);
        }
    }
	
	
	public Medico save(MedicoForm form)
	{
		// TODO: VALIDATE FORM.
		if (form == null){
			return null;
		}
		
		Medico obj = getMedicoByForm(form);
		save(obj);
		return obj;
	}

    public List<Medico> findAll()
    {
        return dao.findAll();
    }
	
	public Medico findById(Integer id)
	{
		Optional<Medico> obj = dao.findById(id);
		//TODO: obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
		return obj.orElse(new Medico());
	}
	
	public Medico getMedicoByForm(MedicoForm form)
	{
		Perfil perfilMedico = perfilService.getByTipoPerfil(EnumUsuarioPerfil.MEDICO);
		
		Usuario usuario = new Usuario(form.getLogin(),form.getPassword());
		usuario.setPerfil(perfilMedico);
		
		Medico medico = new Medico(
				form.getNome(),
				form.getCrm(),
				usuario);
		
		return medico;
	}
}
