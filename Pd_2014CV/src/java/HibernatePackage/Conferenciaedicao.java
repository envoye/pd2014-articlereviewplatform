package HibernatePackage;
// Generated 22/Jul/2014 21:12:36 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Conferenciaedicao generated by hbm2java
 */
public class Conferenciaedicao  implements java.io.Serializable {


     private Integer id;
     private Tema tema;
     private Conferencia conferencia;
     private String subNomeConferencia;
     private String descricao;
     private Date data;
     private String local;
     private String edicao;
     private Date dataLimiteSubmissao;
     private Short maxArtigosRevisor;
     private Short maxArtigos;
     private Boolean configuracaoEncerrada;
     private Set<Conferenciacomite> conferenciacomites = new HashSet<Conferenciacomite>(0);
     private Set<Conferenciaartigo> conferenciaartigos = new HashSet<Conferenciaartigo>(0);
     private Set<Conferenciapoolrevisores> conferenciapoolrevisoreses = new HashSet<Conferenciapoolrevisores>(0);

    public Conferenciaedicao() {
    }

	
    public Conferenciaedicao(Tema tema, Conferencia conferencia, String subNomeConferencia, String descricao) {
        this.tema = tema;
        this.conferencia = conferencia;
        this.subNomeConferencia = subNomeConferencia;
        this.descricao = descricao;
    }
    public Conferenciaedicao(Tema tema, Conferencia conferencia, String subNomeConferencia, String descricao, Date data, String local, String edicao, Date dataLimiteSubmissao, Short maxArtigosRevisor, Short maxArtigos, Boolean configuracaoEncerrada, Set<Conferenciacomite> conferenciacomites, Set<Conferenciaartigo> conferenciaartigos, Set<Conferenciapoolrevisores> conferenciapoolrevisoreses) {
       this.tema = tema;
       this.conferencia = conferencia;
       this.subNomeConferencia = subNomeConferencia;
       this.descricao = descricao;
       this.data = data;
       this.local = local;
       this.edicao = edicao;
       this.dataLimiteSubmissao = dataLimiteSubmissao;
       this.maxArtigosRevisor = maxArtigosRevisor;
       this.maxArtigos = maxArtigos;
       this.configuracaoEncerrada = configuracaoEncerrada;
       this.conferenciacomites = conferenciacomites;
       this.conferenciaartigos = conferenciaartigos;
       this.conferenciapoolrevisoreses = conferenciapoolrevisoreses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Tema getTema() {
        return this.tema;
    }
    
    public void setTema(Tema tema) {
        this.tema = tema;
    }
    public Conferencia getConferencia() {
        return this.conferencia;
    }
    
    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }
    public String getSubNomeConferencia() {
        return this.subNomeConferencia;
    }
    
    public void setSubNomeConferencia(String subNomeConferencia) {
        this.subNomeConferencia = subNomeConferencia;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public String getLocal() {
        return this.local;
    }
    
    public void setLocal(String local) {
        this.local = local;
    }
    public String getEdicao() {
        return this.edicao;
    }
    
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    public Date getDataLimiteSubmissao() {
        return this.dataLimiteSubmissao;
    }
    
    public void setDataLimiteSubmissao(Date dataLimiteSubmissao) {
        this.dataLimiteSubmissao = dataLimiteSubmissao;
    }
    public Short getMaxArtigosRevisor() {
        return this.maxArtigosRevisor;
    }
    
    public void setMaxArtigosRevisor(Short maxArtigosRevisor) {
        this.maxArtigosRevisor = maxArtigosRevisor;
    }
    public Short getMaxArtigos() {
        return this.maxArtigos;
    }
    
    public void setMaxArtigos(Short maxArtigos) {
        this.maxArtigos = maxArtigos;
    }
    public Boolean getConfiguracaoEncerrada() {
        return this.configuracaoEncerrada;
    }
    
    public void setConfiguracaoEncerrada(Boolean configuracaoEncerrada) {
        this.configuracaoEncerrada = configuracaoEncerrada;
    }
    public Set<Conferenciacomite> getConferenciacomites() {
        return this.conferenciacomites;
    }
    
    public void setConferenciacomites(Set<Conferenciacomite> conferenciacomites) {
        this.conferenciacomites = conferenciacomites;
    }
    public Set<Conferenciaartigo> getConferenciaartigos() {
        return this.conferenciaartigos;
    }
    
    public void setConferenciaartigos(Set<Conferenciaartigo> conferenciaartigos) {
        this.conferenciaartigos = conferenciaartigos;
    }
    public Set<Conferenciapoolrevisores> getConferenciapoolrevisoreses() {
        return this.conferenciapoolrevisoreses;
    }
    
    public void setConferenciapoolrevisoreses(Set<Conferenciapoolrevisores> conferenciapoolrevisoreses) {
        this.conferenciapoolrevisoreses = conferenciapoolrevisoreses;
    }




}


