package com.seventeam.gsf.services;


import com.seventeam.gsf.domain.Permissao;
import com.seventeam.gsf.repository.PermissaoDao;
import com.seventeam.gsf.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissaoService {

	@Autowired
	PermissaoDao dao;

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

}
