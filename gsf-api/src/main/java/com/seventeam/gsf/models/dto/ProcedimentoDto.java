package com.seventeam.gsf.models.dto;

import com.seventeam.gsf.domain.Procedimento;
import com.seventeam.gsf.models.Form.ProcedimentoForm;
import com.seventeam.gsf.models.enums.ProcedimentoTipoEnum;

import java.util.Date;

public class ProcedimentoDto extends ProcedimentoForm {
	
	public ProcedimentoDto(Date dataFeito, ProcedimentoTipoEnum exameTipo, String descricao, Integer semanaInicial, Integer semanaFinal) {
		super(dataFeito, exameTipo, descricao, semanaInicial, semanaFinal);
	}
	
	public ProcedimentoDto(Procedimento obj) {
		super(
				obj.getDataFeito(),
				obj.getExameTipo(),
				obj.getDescricao(),
				obj.getSemanaInicial(),
				obj.getSemanaFinal()
		);
	}
}
