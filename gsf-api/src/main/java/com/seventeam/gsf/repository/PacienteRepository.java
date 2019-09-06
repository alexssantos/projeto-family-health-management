package com.seventeam.gsf.repository;

import com.seventeam.gsf.domain.PacienteDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteDao, Integer> {
}
