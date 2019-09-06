package com.seventeam.gsf.repository;

import com.seventeam.gsf.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaDao extends JpaRepository<Consulta, Integer> {
}
