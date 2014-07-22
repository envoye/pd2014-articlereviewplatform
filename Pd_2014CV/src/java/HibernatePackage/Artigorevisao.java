package HibernatePackage;
// Generated 22/Jul/2014 21:12:36 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Artigorevisao generated by hbm2java
 */
public class Artigorevisao  implements java.io.Serializable {


     private Integer id;
     private Conferenciacomiteartigo conferenciacomiteartigo;
     private Conferenciapoolrevisores conferenciapoolrevisores;
     private Byte preferencia;
     private Boolean estadoRevisor;
     private Boolean estadoAuto;
     private Boolean estadoGc;
     private Byte pontuacao;
     private Set<Artigorevisaoitems> artigorevisaoitemses = new HashSet<Artigorevisaoitems>(0);

    public Artigorevisao() {
    }

	
    public Artigorevisao(Conferenciacomiteartigo conferenciacomiteartigo, Conferenciapoolrevisores conferenciapoolrevisores) {
        this.conferenciacomiteartigo = conferenciacomiteartigo;
        this.conferenciapoolrevisores = conferenciapoolrevisores;
    }
    public Artigorevisao(Conferenciacomiteartigo conferenciacomiteartigo, Conferenciapoolrevisores conferenciapoolrevisores, Byte preferencia, Boolean estadoRevisor, Boolean estadoAuto, Boolean estadoGc, Byte pontuacao, Set<Artigorevisaoitems> artigorevisaoitemses) {
       this.conferenciacomiteartigo = conferenciacomiteartigo;
       this.conferenciapoolrevisores = conferenciapoolrevisores;
       this.preferencia = preferencia;
       this.estadoRevisor = estadoRevisor;
       this.estadoAuto = estadoAuto;
       this.estadoGc = estadoGc;
       this.pontuacao = pontuacao;
       this.artigorevisaoitemses = artigorevisaoitemses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Conferenciacomiteartigo getConferenciacomiteartigo() {
        return this.conferenciacomiteartigo;
    }
    
    public void setConferenciacomiteartigo(Conferenciacomiteartigo conferenciacomiteartigo) {
        this.conferenciacomiteartigo = conferenciacomiteartigo;
    }
    public Conferenciapoolrevisores getConferenciapoolrevisores() {
        return this.conferenciapoolrevisores;
    }
    
    public void setConferenciapoolrevisores(Conferenciapoolrevisores conferenciapoolrevisores) {
        this.conferenciapoolrevisores = conferenciapoolrevisores;
    }
    public Byte getPreferencia() {
        return this.preferencia;
    }
    
    public void setPreferencia(Byte preferencia) {
        this.preferencia = preferencia;
    }
    public Boolean getEstadoRevisor() {
        return this.estadoRevisor;
    }
    
    public void setEstadoRevisor(Boolean estadoRevisor) {
        this.estadoRevisor = estadoRevisor;
    }
    public Boolean getEstadoAuto() {
        return this.estadoAuto;
    }
    
    public void setEstadoAuto(Boolean estadoAuto) {
        this.estadoAuto = estadoAuto;
    }
    public Boolean getEstadoGc() {
        return this.estadoGc;
    }
    
    public void setEstadoGc(Boolean estadoGc) {
        this.estadoGc = estadoGc;
    }
    public Byte getPontuacao() {
        return this.pontuacao;
    }
    
    public void setPontuacao(Byte pontuacao) {
        this.pontuacao = pontuacao;
    }
    public Set<Artigorevisaoitems> getArtigorevisaoitemses() {
        return this.artigorevisaoitemses;
    }
    
    public void setArtigorevisaoitemses(Set<Artigorevisaoitems> artigorevisaoitemses) {
        this.artigorevisaoitemses = artigorevisaoitemses;
    }




}


