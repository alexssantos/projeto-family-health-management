package com.seventeam.gsf.models.Form;

import com.seventeam.gsf.models.enums.ProcedimentoTipoEnum;
import com.seventeam.gsf.services.ProcedimentoService;

import java.io.Serializable;
import java.util.Date;

public class ProcedimentoForm implements Serializable {
	
	private Date dataFeito;
	private ProcedimentoTipoEnum exameTipoEnum;
	private String exameTipo;
	private String descricao;
	private String medicoCrm;
	private String pacienteUsuario;
	private Integer semanaInicial;
	private Integer semanaFinal;
	
	
	public ProcedimentoForm(Date dataFeito, String exameTipo, String descricao, String medicoCrm, String pacienteUsuario, Integer semanaInicial, Integer semanaFinal) {
		this.dataFeito = dataFeito;
		this.exameTipo = exameTipo;
		this.descricao = descricao;
		this.medicoCrm = medicoCrm;
		this.pacienteUsuario = pacienteUsuario;
		this.semanaInicial = semanaInicial;
		this.semanaFinal = semanaFinal;
		this.exameTipoEnum = ProcedimentoService.getProcedimentoTipoEnum(exameTipo);
	}
	
	public Date getDataFeito() {
		return dataFeito;
	}
	
	public void setDataFeito(Date dataFeito) {
		this.dataFeito = dataFeito;
	}
	
	public ProcedimentoTipoEnum getExameTipoEnum() {
		return exameTipoEnum;
	}
	
	public void setExameTipoEnum(ProcedimentoTipoEnum exameTipoEnum) {
		this.exameTipoEnum = exameTipoEnum;
	}
	
	public String getExameTipo() {
		return exameTipo;
	}
	
	public void setExameTipo(String exameTipo) {
		this.exameTipo = exameTipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getSemanaInicial() {
		return semanaInicial;
	}
	
	public void setSemanaInicial(Integer semanaInicial) {
		this.semanaInicial = semanaInicial;
	}
	
	public Integer getSemanaFinal() {
		return semanaFinal;
	}
	
	public void setSemanaFinal(Integer semanaFinal) {
		this.semanaFinal = semanaFinal;
	}
	
	public String getMedicoCrm() {
		return medicoCrm;
	}
	
	public void setMedicoCrm(String medicoCrm) {
		this.medicoCrm = medicoCrm;
	}
	
	public String getPacienteUsuario() {
		return pacienteUsuario;
	}
	
	public void setPacienteUsuario(String pacienteUsuario) {
		this.pacienteUsuario = pacienteUsuario;
	}
}
