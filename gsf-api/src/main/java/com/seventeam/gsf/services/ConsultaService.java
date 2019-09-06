package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.Consulta;
import com.seventeam.gsf.repository.ConsultaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaDao ConsultaRepo;

    public List<Consulta> findAll(){
        return ConsultaRepo.findAll();
    }
}
