package com.seventeam.gsf.repository;

import com.seventeam.gsf.domain.ConsultaDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaDao, Integer> {
}
