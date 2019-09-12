package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.repository.MedicoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    MedicoDao dao;

    public void save(Medico obj)
    {
        if (obj != null){
            dao.save(obj);
        }
    }

    public List<Medico> findAll()
    {
        return dao.findAll();
    }
}
