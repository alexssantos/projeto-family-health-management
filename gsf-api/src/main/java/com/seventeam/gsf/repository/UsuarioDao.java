package com.seventeam.gsf.repository;


import com.seventeam.gsf.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer> {
	
	public Usuario getByLogin(String login);
	
	public Usuario getByLoginAndPassword(String login, String password);
}
