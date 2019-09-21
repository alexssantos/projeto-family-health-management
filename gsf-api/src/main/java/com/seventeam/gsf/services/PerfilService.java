package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.models.enums.PerfilTipoEnum;
import com.seventeam.gsf.repository.PerfilDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PerfilService {

	@Autowired
	private PerfilDao dao;

	private SessionFactory sessionFactory;

	public PerfilService() {
	}

	public void save(Perfil obj){
		dao.save(obj);
	}

	public List<Perfil>  findAll(){
		return dao.findAll();
	}

	public Perfil getByTipoPerfil(PerfilTipoEnum tipo)
	{
		Perfil perfil = Perfil.allPerfis.stream()
				.filter(x -> x.getTipoPerfil() == tipo)
				.findFirst()
				.get();

		if (perfil != null)
		{
			return perfil;
		}

		perfil = new Perfil(tipo);
		dao.save(perfil);

		return perfil;
	}
}
