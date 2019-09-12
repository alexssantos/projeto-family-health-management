package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;
import com.seventeam.gsf.repository.PerfilDao;
import org.apache.tomcat.PeriodicEventListener;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
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
}
