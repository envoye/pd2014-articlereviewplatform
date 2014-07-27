package HibernatePackage;
// Generated 27/Jul/2014 15:52:48 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Artigo generated by hbm2java
 */
public class Artigo  implements java.io.Serializable {


     private Integer id;
     private Subtema subtema;
     private String titulo;
     private String resumo;
     private Date data;
     private String link;
     private String ficheiroPdf;
     private String palavrasChave;
     private Set<Conferenciaartigo> conferenciaartigos = new HashSet<Conferenciaartigo>(0);
     private Set<Artigopalavrachave> artigopalavrachaves = new HashSet<Artigopalavrachave>(0);
     private Set<Conferenciacomiteartigo> conferenciacomiteartigos = new HashSet<Conferenciacomiteartigo>(0);
     private Set<Artigoinvestigador> artigoinvestigadors = new HashSet<Artigoinvestigador>(0);

    public Artigo() {
    }

	
    public Artigo(Subtema subtema) {
        this.subtema = subtema;
    }
    public Artigo(Subtema subtema, String titulo, String resumo, Date data, String link, String ficheiroPdf, String palavrasChave, Set<Conferenciaartigo> conferenciaartigos, Set<Artigopalavrachave> artigopalavrachaves, Set<Conferenciacomiteartigo> conferenciacomiteartigos, Set<Artigoinvestigador> artigoinvestigadors) {
       this.subtema = subtema;
       this.titulo = titulo;
       this.resumo = resumo;
       this.data = data;
       this.link = link;
       this.ficheiroPdf = ficheiroPdf;
       this.palavrasChave = palavrasChave;
       this.conferenciaartigos = conferenciaartigos;
       this.artigopalavrachaves = artigopalavrachaves;
       this.conferenciacomiteartigos = conferenciacomiteartigos;
       this.artigoinvestigadors = artigoinvestigadors;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Subtema getSubtema() {
        return this.subtema;
    }
    
    public void setSubtema(Subtema subtema) {
        this.subtema = subtema;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getResumo() {
        return this.resumo;
    }
    
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    public String getFicheiroPdf() {
        return this.ficheiroPdf;
    }
    
    public void setFicheiroPdf(String ficheiroPdf) {
        this.ficheiroPdf = ficheiroPdf;
    }
    public String getPalavrasChave() {
        return this.palavrasChave;
    }
    
    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }
    public Set<Conferenciaartigo> getConferenciaartigos() {
        return this.conferenciaartigos;
    }
    
    public void setConferenciaartigos(Set<Conferenciaartigo> conferenciaartigos) {
        this.conferenciaartigos = conferenciaartigos;
    }
    public Set<Artigopalavrachave> getArtigopalavrachaves() {
        return this.artigopalavrachaves;
    }
    
    public void setArtigopalavrachaves(Set<Artigopalavrachave> artigopalavrachaves) {
        this.artigopalavrachaves = artigopalavrachaves;
    }
    public Set<Conferenciacomiteartigo> getConferenciacomiteartigos() {
        return this.conferenciacomiteartigos;
    }
    
    public void setConferenciacomiteartigos(Set<Conferenciacomiteartigo> conferenciacomiteartigos) {
        this.conferenciacomiteartigos = conferenciacomiteartigos;
    }
    public Set<Artigoinvestigador> getArtigoinvestigadors() {
        return this.artigoinvestigadors;
    }
    
    public void setArtigoinvestigadors(Set<Artigoinvestigador> artigoinvestigadors) {
        this.artigoinvestigadors = artigoinvestigadors;
    }




}


