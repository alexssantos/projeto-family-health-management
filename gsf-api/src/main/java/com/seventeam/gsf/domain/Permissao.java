package com.seventeam.gsf.domain;

import javax.persistence.*;

@Entity
@Table(name = "permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "acao")
    private String acao;


    // RELATOINSHIPS
    @ManyToOne
    @JoinColumn(name="perfil_id", nullable=false)
    private Perfil perfil;


    // CONSTRUTOR
    public Permissao(String acao) {
        this.acao = acao;
    }


    public Integer getId() {
        return id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
}
