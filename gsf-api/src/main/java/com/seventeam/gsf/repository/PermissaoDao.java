package com.seventeam.gsf.repository;

import com.seventeam.gsf.domain.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoDao extends JpaRepository<Permissao, Integer> {
}
