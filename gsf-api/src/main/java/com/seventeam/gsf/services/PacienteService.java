package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.repository.PacienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteDao pacienteDao;

    public PacienteDao getDao()
    {
        return this.pacienteDao;
    }

    public void save(Paciente obj)
    {
        if (obj != null){
            pacienteDao.save(obj);
        }
    }

    public List<Paciente> findAll()
    {
        return pacienteDao.findAll();
    }

    public Paciente findById(Integer id)
    {
        Optional<Paciente> obj = pacienteDao.findById(id);

        return obj.orElse(new Paciente());
    }
}
