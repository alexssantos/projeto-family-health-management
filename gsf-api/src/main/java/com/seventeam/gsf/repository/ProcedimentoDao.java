package com.seventeam.gsf.repository;

import com.seventeam.gsf.domain.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentoDao extends JpaRepository<Procedimento, Integer> {
}
