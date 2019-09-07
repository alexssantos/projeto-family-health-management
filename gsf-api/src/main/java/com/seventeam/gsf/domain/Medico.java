package com.seventeam.gsf.domain;


import javax.persistence.*;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "crm")
    private String crm;

    @Column(name = "nome")
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    //OneToMany - table medico-paciente-keys

    public Medico() {
    }

    public Medico(String nome,String cmr,  Usuario usuario) {
        this.nome = nome;
        this.crm = cmr;
        this.usuario = usuario;

        if (this.usuario == null){
            this.usuario = new Usuario();
        }
    }

    public Integer getId() {
        return id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
