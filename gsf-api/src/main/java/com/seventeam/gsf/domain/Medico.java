package com.seventeam.gsf.domain;


import com.seventeam.gsf.Utils.*;

import javax.persistence.*;

@Entity
@Table(name = "medico")
public class Medico extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "crm")
    private String crm;

    @Column(name = "nome")
    private String nome;

    //relação 1
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    //relação 2
    //(ManyToMany) OneToMany -> keys medico <-> paciente (table)


    //Relaçao 3
    //(OneToMany) Medico -> Procedimento


    public Medico() {
    }

    public Medico(String nome,String cmr,  Usuario usuario) {
        this.nome = nome;
        this.crm = cmr;
        this.usuario = usuario;

        if (this.usuario == null)
        {
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

    public static String generateCRM(){
        //Padrão CRM = 52-83199-9 = x-y-z

        int numberX = UtilsNumbers.getRandomIntegerBetweenRange(0,99);
        String xStr = UtilsString.formatNumberFixedLenght(numberX, 2);

        int numberY = UtilsNumbers.getRandomIntegerBetweenRange(0,99999);
        String yStr = UtilsString.formatNumberFixedLenght(numberY, 5);

        int numberZ = UtilsNumbers.getRandomIntegerBetweenRange(0,9);
        String zStr = UtilsString.formatNumberFixedLenght(numberZ, 1);

        String CRM = UtilsString.msgFormat("{0}-{1}-{2}",xStr, yStr, zStr);

        return CRM;
    };
}
