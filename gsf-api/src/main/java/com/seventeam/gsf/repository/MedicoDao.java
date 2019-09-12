package com.seventeam.gsf.repository;

import com.seventeam.gsf.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoDao extends JpaRepository<Medico, Integer> {
}
