package com.seventeam.gsf.services;


import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.domain.Permissao;
import com.seventeam.gsf.models.enums.PerfilTipoEnum;
import com.seventeam.gsf.repository.PermissaoDao;
import com.seventeam.gsf.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PermissaoService {

	@Autowired
	PermissaoDao dao;

	@Autowired
	PerfilService perfilService;

	public void save(Permissao obj)
	{
		if (obj != null){
			dao.save(obj);
		}
	}

	public List<Permissao> findAll()
	{
		return dao.findAll();
	}

	public Permissao findById(Integer id)
	{
		Optional<Permissao> obj = dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found. [Paciente]"));
	}

	public void delete(Integer id)
	{
		findById(id);
		dao.deleteById(id);
	}

	public List<Permissao> getByPerfil(String perfilStr)
	{
		PerfilTipoEnum tipoPerfil = PerfilService.perfilTipoEnumMap.get(perfilStr.toUpperCase());

		if (tipoPerfil == null)
		{
			throw new ObjectNotFoundException(
					UtilsString.msgFormat("Object Not Found. \nTipo Perfil '{0}'.", perfilStr)
			);
		}

		Perfil perfilPaciente = perfilService.getByTipoPerfil(tipoPerfil);
		if (perfilPaciente == null)
		{
			return new ArrayList<Permissao>();
		}

		List<Permissao> objList = dao.getByPerfil(perfilPaciente);
		return objList;
	}
}
