package HibernatePackage;
// Generated 29/Jul/2014 18:24:24 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Tema generated by hbm2java
 */
public class Tema  implements java.io.Serializable {


     private Integer id;
     private String nomeTema;
     private String descricao;
     private Set<Conferenciaedicao> conferenciaedicaos = new HashSet<Conferenciaedicao>(0);
     private Set<Subtema> subtemas = new HashSet<Subtema>(0);

    public Tema() {
    }
	
    public Tema(String nomeTema) {
        this.nomeTema = nomeTema;
    }

    public Tema(String nomeTema, String descricao, Set<Conferenciaedicao> conferenciaedicaos, Set<Subtema> subtemas) {
       this.nomeTema = nomeTema;
       this.descricao = descricao;
       this.conferenciaedicaos = conferenciaedicaos;
       this.subtemas = subtemas;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomeTema() {
        return this.nomeTema;
    }
    
    public void setNomeTema(String nomeTema) {
        this.nomeTema = nomeTema;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Set<Conferenciaedicao> getConferenciaedicaos() {
        return this.conferenciaedicaos;
    }
    
    public void setConferenciaedicaos(Set<Conferenciaedicao> conferenciaedicaos) {
        this.conferenciaedicaos = conferenciaedicaos;
    }
    public Set<Subtema> getSubtemas() {
        return this.subtemas;
    }
    
    public void setSubtemas(Set<Subtema> subtemas) {
        this.subtemas = subtemas;
    }

}


