package com.seventeam.gsf.repository;

import com.seventeam.gsf.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteDao extends JpaRepository<Paciente, Integer> {
}
