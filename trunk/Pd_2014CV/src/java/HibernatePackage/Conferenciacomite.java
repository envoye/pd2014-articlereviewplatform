package HibernatePackage;
// Generated 28/Jun/2014 14:50:24 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Conferenciacomite generated by hbm2java
 */
public class Conferenciacomite  implements java.io.Serializable {


     private Integer id;
     private Conferenciaedicao conferenciaedicao;
     private Investigador investigador;
     private Boolean aceite;
     private Set<Conferenciacomiteartigo> conferenciacomiteartigos = new HashSet<Conferenciacomiteartigo>(0);

    public Conferenciacomite() {
    }

	
    public Conferenciacomite(Conferenciaedicao conferenciaedicao, Investigador investigador) {
        this.conferenciaedicao = conferenciaedicao;
        this.investigador = investigador;
    }
    public Conferenciacomite(Conferenciaedicao conferenciaedicao, Investigador investigador, Boolean aceite, Set<Conferenciacomiteartigo> conferenciacomiteartigos) {
       this.conferenciaedicao = conferenciaedicao;
       this.investigador = investigador;
       this.aceite = aceite;
       this.conferenciacomiteartigos = conferenciacomiteartigos;
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
    public Boolean getAceite() {
        return this.aceite;
    }
    
    public void setAceite(Boolean aceite) {
        this.aceite = aceite;
    }
    public Set<Conferenciacomiteartigo> getConferenciacomiteartigos() {
        return this.conferenciacomiteartigos;
    }
    
    public void setConferenciacomiteartigos(Set<Conferenciacomiteartigo> conferenciacomiteartigos) {
        this.conferenciacomiteartigos = conferenciacomiteartigos;
    }




}


