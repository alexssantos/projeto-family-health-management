package com.seventeam.gsf.domain;

import com.seventeam.gsf.models.enums.PermissaoEnum;

import javax.persistence.*;

@Entity
@Table(name = "permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "acao", unique = true)
    private PermissaoEnum acao;


    // =======================
    // RELATIONSHIPS
    // =======================

//    @ManyToOne
//    @JoinColumn(name="perfil_id", nullable=false)
//    private Perfil perfil;


    // =======================
    // CONSTRUTOR
    // =======================

    public Permissao(PermissaoEnum acao) {
        this.acao = acao;
    }


    public Integer getId() {
        return id;
    }

    public PermissaoEnum getAcao() {
        return acao;
    }

    public void setAcao(PermissaoEnum acao) {
        this.acao = acao;
    }
}
