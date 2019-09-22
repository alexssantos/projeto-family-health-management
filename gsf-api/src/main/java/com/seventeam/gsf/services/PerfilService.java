package com.seventeam.gsf.services;

import com.seventeam.gsf.domain.Perfil;
import com.seventeam.gsf.models.enums.PerfilTipoEnum;
import com.seventeam.gsf.models.enums.PermissaoEnum;
import com.seventeam.gsf.repository.PerfilDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PerfilService {

	@Autowired
	private PerfilDao dao;
	
	
	public PerfilService() {
	}
	
	public void save(Perfil obj){
		dao.save(obj);
	}

	public void saveMany(List<Perfil> list)
	{
		dao.saveAll(list);
	}
	
	public List<Perfil>  findAll(){
		return dao.findAll();
	}

	public Perfil getByTipoPerfil(PerfilTipoEnum tipo)
	{
		Perfil perfil = Perfil.allPerfis.stream()
				.filter(x -> x.getTipoPerfil() == tipo)
				.findFirst()
				.get();

		if (perfil != null)
		{
			return perfil;
		}

		perfil = new Perfil(tipo);
		dao.save(perfil);

		return perfil;
	}
	
	
	// =======================
	// STATICS
	// =======================

	public static Map<String, PerfilTipoEnum> perfilTipoEnumMap = Stream.of(new Object[][]
		{
			{"MEDICO", PerfilTipoEnum.MEDICO},
			{"PACIENTE",PerfilTipoEnum.PACIENTE },
			{"DESCONHECIDO",PerfilTipoEnum.DESCONHECIDO },
		})
		.collect(Collectors.toMap(
				key -> (String) key[0],
				value -> (PerfilTipoEnum) value[1]
		)
	);
	
//	FIXME: DEVERIA SER LIDO DE UM AQUIVO JSON, XML, ...
	//Map não pode ter keys repeditas.
	public static Map<PerfilTipoEnum, List<PermissaoEnum>> perfilPermissaoMap = Stream.of(new Object[][]
			{
//					PERMISSOES DO MEDIDO
					{PerfilTipoEnum.MEDICO, Arrays.asList(
									PermissaoEnum.ACAO_1,
									PermissaoEnum.ACAO_2,
									PermissaoEnum.ACAO_3,
									PermissaoEnum.ACAO_4,
									PermissaoEnum.ACAO_5,
									PermissaoEnum.ACAO_9,
									PermissaoEnum.ACAO_10,
									PermissaoEnum.EDITAR_PAGINA_1,
									PermissaoEnum.EDITAR_PAGINA_2
					)},
					
//					PERMISSOES DO PACIENTE
					{PerfilTipoEnum.PACIENTE, Arrays.asList(
							PermissaoEnum.ACAO_1,
							PermissaoEnum.ACAO_2,
							PermissaoEnum.ACAO_4,
							PermissaoEnum.ACAO_5,
							PermissaoEnum.ACAO_6,
							PermissaoEnum.ACAO_7,
							PermissaoEnum.ACAO_8,
							PermissaoEnum.EDITAR_PAGINA_1
					)},
			})
			.collect(Collectors.toMap(
					key -> (PerfilTipoEnum) key[0],
					value -> (List<PermissaoEnum>) value[1]
			)
	);
	
}
