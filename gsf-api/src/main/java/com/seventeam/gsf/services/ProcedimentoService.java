package com.seventeam.gsf.services;

import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Procedimento;
import com.seventeam.gsf.models.Form.ProcedimentoForm;
import com.seventeam.gsf.models.enums.ProcedimentoTipoEnum;
import com.seventeam.gsf.repository.ProcedimentoDao;
import com.seventeam.gsf.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProcedimentoService {
	
	@Autowired
	ProcedimentoDao dao;
	
	@Autowired
	MedicoService medicoService;
	@Autowired
	PacienteService pacienteService;
	
	public void save(Procedimento obj)
	{
		if (obj == null){
			throw new ObjectNotFoundException("Not Found");
		}
		
		
		dao.save(obj);
	}
	
	public List<Procedimento> findAll()
	{
		return dao.findAll();
	}
	
	public Procedimento findById(Integer id)
	{
		Optional<Procedimento> obj = dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}
	
	public Procedimento save(ProcedimentoForm form)
	{
		// TODO: VALIDATE FORM.
		
		if (form == null){
			return null;
		}
		
		Medico medico = medicoService.getByCrm(form.getMedicoCrm());
		Paciente paciente = pacienteService.getByLogin(form.getPacienteUsuario());
		
		Procedimento obj = new Procedimento(form, medico, paciente);
		save(obj);
		return obj;
	}
	
	public static String getProcedimentoTipoString(ProcedimentoTipoEnum procTipo)
	{
		Boolean contains = procedimentoTipoEnumMap.containsValue(procTipo);
		ProcedimentoTipoEnum returnEnum;
		if (contains) {
			returnEnum = procedimentoTipoEnumMap.values().stream()
					.filter(x -> x == procTipo)
					.findFirst()
					.get();
		}
		else {
			returnEnum = null;
		}
		
		return returnEnum.toString();
	}

	public static ProcedimentoTipoEnum getProcedimentoTipoEnum(String procTipo)
	{
		String procTipoUpper = procTipo.toUpperCase();
		Boolean hasTipo = procedimentoTipoEnumMap.containsKey(procTipoUpper);
		ProcedimentoTipoEnum procTipoEnum = null;
	
		if (hasTipo) {
			procTipoEnum = procedimentoTipoEnumMap.get(procTipoUpper);
		}
		else {
			String erroStr = UtilsString.msgFormat("Procedimento Tipo '{0}' não encontrado.", procTipoUpper);
			throw new ObjectNotFoundException(erroStr);
		}
		return procTipoEnum;
	}
	
	public static Map<String, ProcedimentoTipoEnum> procedimentoTipoEnumMap = Stream.of(new Object[][] {
				{ "VACINA", ProcedimentoTipoEnum.VACINA },
				{ "EXAME", ProcedimentoTipoEnum.EXAME },
			}).collect(Collectors.toMap(data -> (String) data[0], data -> (ProcedimentoTipoEnum) data[1]));
	
}
