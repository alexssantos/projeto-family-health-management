package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.ConsultaDao;
import com.seventeam.gsf.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository ConsultaRepo;

    public List<ConsultaDao> findAll(){
        return ConsultaRepo.findAll();
    }
}
