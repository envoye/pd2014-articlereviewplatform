package HibernatePackage;
// Generated 28/Jun/2014 15:34:25 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Conferenciapoolrevisores generated by hbm2java
 */
public class Conferenciapoolrevisores  implements java.io.Serializable {


     private Integer id;
     private Conferenciaedicao conferenciaedicao;
     private Investigador investigador;
     private Byte classificacao;
     private String estado;
     private Date dataInicioConvite;
     private Date dataFimConvite;
     private Set<Artigorevisao> artigorevisaos = new HashSet<Artigorevisao>(0);

    public Conferenciapoolrevisores() {
    }

	
    public Conferenciapoolrevisores(Conferenciaedicao conferenciaedicao, Investigador investigador) {
        this.conferenciaedicao = conferenciaedicao;
        this.investigador = investigador;
    }
    public Conferenciapoolrevisores(Conferenciaedicao conferenciaedicao, Investigador investigador, Byte classificacao, String estado, Date dataInicioConvite, Date dataFimConvite, Set<Artigorevisao> artigorevisaos) {
       this.conferenciaedicao = conferenciaedicao;
       this.investigador = investigador;
       this.classificacao = classificacao;
       this.estado = estado;
       this.dataInicioConvite = dataInicioConvite;
       this.dataFimConvite = dataFimConvite;
       this.artigorevisaos = artigorevisaos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Conferenciaedicao getConferenciaedicao() {
        return this.conferenciaedicao;
    }
    
    public void setConferenciaedicao(Conferenciaedicao conferenciaedicao) {
        this.conferenciaedicao = conferenciaedicao;
    }
    public Investigador getInvestigador() {
        return this.investigador;
    }
    
    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }
    public Byte getClassificacao() {
        return this.classificacao;
    }
    
    public void setClassificacao(Byte classificacao) {
        this.classificacao = classificacao;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getDataInicioConvite() {
        return this.dataInicioConvite;
    }
    
    public void setDataInicioConvite(Date dataInicioConvite) {
        this.dataInicioConvite = dataInicioConvite;
    }
    public Date getDataFimConvite() {
        return this.dataFimConvite;
    }
    
    public void setDataFimConvite(Date dataFimConvite) {
        this.dataFimConvite = dataFimConvite;
    }
    public Set<Artigorevisao> getArtigorevisaos() {
        return this.artigorevisaos;
    }
    
    public void setArtigorevisaos(Set<Artigorevisao> artigorevisaos) {
        this.artigorevisaos = artigorevisaos;
    }




}


