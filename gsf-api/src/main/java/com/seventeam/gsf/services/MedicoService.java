package com.seventeam.gsf.services;

import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.models.Form.MedicoForm;
import com.seventeam.gsf.models.enums.PerfilTipoEnum;
import com.seventeam.gsf.repository.MedicoDao;
import com.seventeam.gsf.services.exception.ObjectNotFoundException;
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
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}
	
	public Medico getMedicoByForm(MedicoForm form)
	{
		Perfil perfilMedico = perfilService.getByTipoPerfil(PerfilTipoEnum.MEDICO);
		
		Usuario usuario = new Usuario(form.getLogin(),form.getPassword());
		usuario.setPerfil(perfilMedico);
		
		Medico medico = new Medico(
				form.getNome(),
				form.getCrm(),
				usuario);
		
		return medico;
	}
	
	public Medico updateMedicoByForm(MedicoForm form, Medico medToUpdate)
	{
		if (!UtilsString.isEmptyOrBlanck(form.getCrm())){
			medToUpdate.setCrm(form.getCrm());
		}
		
		if (!UtilsString.isEmptyOrBlanck(form.getNome())){
			medToUpdate.setNome(form.getNome());
		}
		
		if (!UtilsString.isEmptyOrBlanck(form.getLogin())){
			medToUpdate.getUsuario().setLogin(form.getLogin());
		}
		
		if (!UtilsString.isEmptyOrBlanck(form.getPassword())){
			medToUpdate.getUsuario().setPassword(form.getPassword());
		}
		
		return medToUpdate;
	}
	
	// TODO: update
	public Medico update(MedicoForm form, Integer id)
	{
		// TODO: VALIDATE FORM.
		Medico medToUpdate = findById(id);
		Medico newMedico = updateMedicoByForm(form, medToUpdate);
		save(newMedico);
		
		return newMedico;
	}
	
	// TODO: DELETE
	public void delete(Integer id)
	{
		Medico medToDelete = findById(id);
		dao.delete(medToDelete);
	}
	
	public Medico getByCrm(String crm){
    	List<Medico> objList = dao.getMedicoByCrm(crm);
    	
    	return objList.stream().findFirst().get();
	}
	
}
