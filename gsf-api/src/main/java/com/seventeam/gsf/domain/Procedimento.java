package com.seventeam.gsf.domain;

import com.seventeam.gsf.models.Form.ProcedimentoForm;
import com.seventeam.gsf.models.enums.ProcedimentoTipoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "procedimento")
public class Procedimento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "data_feito")
	private Date dataFeito;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private ProcedimentoTipoEnum exameTipo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "semana_inicial")
	private Integer semanaInicial;
	
	@Column(name = "semana_final")
	private Integer semanaFinal;
	
	
	// =======================
	// RELATIONSHIPS
	// =======================

	
//	@Column(name = "")
//	private
//
	
	// =======================
	// CONSTRUCTOR
	// =======================
	
	public Procedimento() {
	}
	
	public Procedimento(Date dataFeito, ProcedimentoTipoEnum exameTipo, String descricao, Integer semanaInicial, Integer semanaFinal) {
		this.dataFeito = dataFeito;
		this.exameTipo = exameTipo;
		this.descricao = descricao;
		this.semanaInicial = semanaInicial;
		this.semanaFinal = semanaFinal;
	}
	
	public Procedimento(ProcedimentoForm obj) {
		this.dataFeito = obj.getDataFeito();
		this.exameTipo = obj.getExameTipo();
		this.descricao = obj.getDescricao();
		this.semanaInicial = obj.getSemanaInicial();
		this.semanaFinal = obj.getSemanaFinal();
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
