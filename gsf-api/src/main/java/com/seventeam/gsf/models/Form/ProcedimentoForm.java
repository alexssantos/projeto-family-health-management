package com.seventeam.gsf.models.Form;

import com.seventeam.gsf.models.enums.ProcedimentoTipoEnum;

import java.io.Serializable;
import java.util.Date;

public class ProcedimentoForm implements Serializable {
	
	private Date dataFeito;
	private ProcedimentoTipoEnum exameTipo;
	private String descricao;
	private Integer semanaInicial;
	private Integer semanaFinal;
	
	public ProcedimentoForm(Date dataFeito, ProcedimentoTipoEnum exameTipo, String descricao, Integer semanaInicial, Integer semanaFinal) {
		this.dataFeito = dataFeito;
		this.exameTipo = exameTipo;
		this.descricao = descricao;
		this.semanaInicial = semanaInicial;
		this.semanaFinal = semanaFinal;
	}
	
	public Date getDataFeito() {
		return dataFeito;
	}
	
	public void setDataFeito(Date dataFeito) {
		this.dataFeito = dataFeito;
	}
	
	public ProcedimentoTipoEnum getExameTipo() {
		return exameTipo;
	}
	
	public void setExameTipo(ProcedimentoTipoEnum exameTipo) {
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
}
