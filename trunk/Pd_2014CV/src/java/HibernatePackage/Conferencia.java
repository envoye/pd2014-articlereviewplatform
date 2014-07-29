package HibernatePackage;
// Generated 29/Jul/2014 18:24:24 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Conferencia generated by hbm2java
 */
public class Conferencia  implements java.io.Serializable {


     private Integer id;
     private Investigador investigador;
     private String nome;
     private Set<Conferenciaedicao> conferenciaedicaos = new HashSet<Conferenciaedicao>(0);

    public Conferencia() {
    }

	
    public Conferencia(Investigador investigador, String nome) {
        this.investigador = investigador;
        this.nome = nome;
    }
    public Conferencia(Investigador investigador, String nome, Set<Conferenciaedicao> conferenciaedicaos) {
       this.investigador = investigador;
       this.nome = nome;
       this.conferenciaedicaos = conferenciaedicaos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Investigador getInvestigador() {
        return this.investigador;
    }
    
    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set<Conferenciaedicao> getConferenciaedicaos() {
        return this.conferenciaedicaos;
    }
    
    public void setConferenciaedicaos(Set<Conferenciaedicao> conferenciaedicaos) {
        this.conferenciaedicaos = conferenciaedicaos;
    }




}


