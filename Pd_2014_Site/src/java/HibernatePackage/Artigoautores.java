package HibernatePackage;
// Generated 16/Abr/2014 23:30:37 by Hibernate Tools 3.6.0



/**
 * Artigoautores generated by hbm2java
 */
public class Artigoautores  implements java.io.Serializable {


     private ArtigoautoresId id;
     private Artigo artigo;
     private Investigador investigador;

    public Artigoautores() {
    }

    public Artigoautores(ArtigoautoresId id, Artigo artigo, Investigador investigador) {
       this.id = id;
       this.artigo = artigo;
       this.investigador = investigador;
    }
   
    public ArtigoautoresId getId() {
        return this.id;
    }
    
    public void setId(ArtigoautoresId id) {
        this.id = id;
    }
    public Artigo getArtigo() {
        return this.artigo;
    }
    
    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }
    public Investigador getInvestigador() {
        return this.investigador;
    }
    
    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }




}


