package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.repository.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	public void saveUsuario(Usuario obj)
	{
		if (obj != null){
			usuarioDao.save(obj);
		}
	}

	public List<Usuario> findAll()
	{
		return usuarioDao.findAll();
	}
	
	public Usuario findOne(String login, String password){
		return usuarioDao.getByLoginAndPassword(login, password);
	}
}

