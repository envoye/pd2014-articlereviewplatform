package HibernatePackage;
// Generated 12/Jun/2014 22:28:48 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Conferenciacomiteartigoforum generated by hbm2java
 */
public class Conferenciacomiteartigoforum  implements java.io.Serializable {


     private Integer id;
     private Conferenciacomiteartigo conferenciacomiteartigo;
     private Date dataLimite;
     private Set<Conferenciacomiteartigoforummensagem> conferenciacomiteartigoforummensagems = new HashSet<Conferenciacomiteartigoforummensagem>(0);

    public Conferenciacomiteartigoforum() {
    }

	
    public Conferenciacomiteartigoforum(Conferenciacomiteartigo conferenciacomiteartigo) {
        this.conferenciacomiteartigo = conferenciacomiteartigo;
    }
    public Conferenciacomiteartigoforum(Conferenciacomiteartigo conferenciacomiteartigo, Date dataLimite, Set<Conferenciacomiteartigoforummensagem> conferenciacomiteartigoforummensagems) {
       this.conferenciacomiteartigo = conferenciacomiteartigo;
       this.dataLimite = dataLimite;
       this.conferenciacomiteartigoforummensagems = conferenciacomiteartigoforummensagems;
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
    public Date getDataLimite() {
        return this.dataLimite;
    }
    
    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }
    public Set<Conferenciacomiteartigoforummensagem> getConferenciacomiteartigoforummensagems() {
        return this.conferenciacomiteartigoforummensagems;
    }
    
    public void setConferenciacomiteartigoforummensagems(Set<Conferenciacomiteartigoforummensagem> conferenciacomiteartigoforummensagems) {
        this.conferenciacomiteartigoforummensagems = conferenciacomiteartigoforummensagems;
    }




}

