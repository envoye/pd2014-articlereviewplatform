package HibernatePackage;
// Generated 16/Abr/2014 23:30:37 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Grauacademico generated by hbm2java
 */
public class Grauacademico  implements java.io.Serializable {


     private Integer id;
     private String grauacademico;
     private Set<Investigador> investigadors = new HashSet<Investigador>(0);

    public Grauacademico() {
    }

    public Grauacademico(String grauacademico, Set<Investigador> investigadors) {
       this.grauacademico = grauacademico;
       this.investigadors = investigadors;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getGrauacademico() {
        return this.grauacademico;
    }
    
    public void setGrauacademico(String grauacademico) {
        this.grauacademico = grauacademico;
    }
    public Set<Investigador> getInvestigadors() {
        return this.investigadors;
    }
    
    public void setInvestigadors(Set<Investigador> investigadors) {
        this.investigadors = investigadors;
    }




}

