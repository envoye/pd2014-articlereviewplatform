package HibernatePackage;
// Generated 16/Abr/2014 23:30:37 by Hibernate Tools 3.6.0



/**
 * Contacto generated by hbm2java
 */
public class Contacto  implements java.io.Serializable {


     private Integer id;
     private Investigador investigador;
     private String idContacto;

    public Contacto() {
    }

    public Contacto(Investigador investigador, String idContacto) {
       this.investigador = investigador;
       this.idContacto = idContacto;
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
    public String getIdContacto() {
        return this.idContacto;
    }
    
    public void setIdContacto(String idContacto) {
        this.idContacto = idContacto;
    }




}


