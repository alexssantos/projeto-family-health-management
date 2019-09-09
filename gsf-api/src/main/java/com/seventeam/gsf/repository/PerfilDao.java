package com.seventeam.gsf.repository;

import com.seventeam.gsf.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilDao extends JpaRepository<Perfil, Integer> {
}
