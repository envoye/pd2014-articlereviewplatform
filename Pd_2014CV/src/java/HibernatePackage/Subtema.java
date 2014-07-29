package HibernatePackage;
// Generated 27/Jul/2014 19:30:51 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Subtema generated by hbm2java
 */
public class Subtema  implements java.io.Serializable {


     private Integer id;
     private Tema tema;
     private String nome;
     private String descricao;
     private Set<Artigo> artigos = new HashSet<Artigo>(0);
     private Set<Investigadorareaconhecimento> investigadorareaconhecimentos = new HashSet<Investigadorareaconhecimento>(0);

    public Subtema() {
    }
	
    public Subtema(Tema tema, String nome) {
        this.tema = tema;
        this.nome = nome;
    }
    
    public Subtema(Tema tema, String nome, String descricao, Set<Artigo> artigos, Set<Investigadorareaconhecimento> investigadorareaconhecimentos) {
       this.tema = tema;
       this.nome = nome;
       this.descricao = descricao;
       this.artigos = artigos;
       this.investigadorareaconhecimentos = investigadorareaconhecimentos;
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
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Set<Artigo> getArtigos() {
        return this.artigos;
    }
    
    public void setArtigos(Set<Artigo> artigos) {
        this.artigos = artigos;
    }
    
    public Set<Investigadorareaconhecimento> getInvestigadorareaconhecimentos() {
        return this.investigadorareaconhecimentos;
    }
    
    public void setInvestigadorareaconhecimentos(Set<Investigadorareaconhecimento> investigadorareaconhecimentos) {
        this.investigadorareaconhecimentos = investigadorareaconhecimentos;
    }

}


