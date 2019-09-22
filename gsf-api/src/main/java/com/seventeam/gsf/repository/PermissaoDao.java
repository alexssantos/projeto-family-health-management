package com.seventeam.gsf.repository;

import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.domain.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoDao extends JpaRepository<Permissao, Integer> {

	public List<Permissao> getByPerfil(Perfil perfil);
}
