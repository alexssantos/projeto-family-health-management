package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.repository.PacienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteDao pacienteDao;

    public void savePaciente(Paciente obj)
    {
        if (obj != null){
            pacienteDao.save(obj);
        }
    }

    public List<Paciente> findAll()
    {
        return pacienteDao.findAll();
    }
}
