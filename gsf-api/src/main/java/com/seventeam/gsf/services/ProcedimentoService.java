package com.seventeam.gsf.services;

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
	
	public void save(Procedimento obj)
	{
		if (obj != null){
			dao.save(obj);
		}
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
		
		Procedimento obj = new Procedimento(form);
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
		
		Boolean hasTipo = procedimentoTipoEnumMap.containsKey(procTipo.toUpperCase());
		ProcedimentoTipoEnum procTipoEnum;
		if (hasTipo) {
			procTipoEnum = procedimentoTipoEnumMap.get(procTipo.toUpperCase());
		}
		else {
			procTipoEnum = null;
		}
		return procTipoEnum;
	}
	
	public static Map<String, ProcedimentoTipoEnum> procedimentoTipoEnumMap = Stream.of(new Object[][] {
				{ "VACINA", ProcedimentoTipoEnum.VACINA },
				{ "EXAME", ProcedimentoTipoEnum.EXAME },
			}).collect(Collectors.toMap(data -> (String) data[0], data -> (ProcedimentoTipoEnum) data[1]));
	
}
