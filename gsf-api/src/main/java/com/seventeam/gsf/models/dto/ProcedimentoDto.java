package com.seventeam.gsf.models.dto;

import com.seventeam.gsf.domain.Procedimento;
import com.seventeam.gsf.models.Form.ProcedimentoForm;
import com.seventeam.gsf.models.enums.ProcedimentoTipoEnum;

import java.util.Date;

public class ProcedimentoDto extends ProcedimentoForm {
	
	public ProcedimentoDto(Date dataFeito, ProcedimentoTipoEnum exameTipo, String descricao, Integer semanaInicial, Integer semanaFinal) {
		super(dataFeito, exameTipo, descricao,"Crmfake-0-123456-78","fakepacienteUsuario", semanaInicial, semanaFinal);
	}
	
	public ProcedimentoDto(Procedimento obj) {
		super(
				obj.getDataFeito(),
				obj.getExameTipo(),
				obj.getDescricao(),
				"Crmfake-0-123456-78", //obj.getMedico().getCrm()
				"fakepacienteUsuario", //obj.getpaciente()getUsaurio().getLogin()
				obj.getSemanaInicial(),
				obj.getSemanaFinal()
		);
	}
}
