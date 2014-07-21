/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Contacto;
import HibernatePackage.Investigador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Valter
 */
@Named(value = "MBInvestigadorContacto")
@ViewScoped
public class MBInvestigadorContacto {
    private Investigador investigador;
    private String idContacto;
    /**
     * Creates a new instance of MBInvestigadorContacto
     */
    public MBInvestigadorContacto() {
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

    public String getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(String idContacto) {
        this.idContacto = idContacto;
    }
    
    public String introduzir() {
        return "index";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Contacto(this.nome));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }        
}
