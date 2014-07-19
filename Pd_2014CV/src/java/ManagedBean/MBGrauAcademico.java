/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Grauacademico;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBGrauAcademico")
@ViewScoped
public class MBGrauAcademico {
    private String grauAcademico;
    /**
     * Creates a new instance of MBGrauAcademico
     */
    public MBGrauAcademico() {
    }

    public String getGrauAcademico() {
        return grauAcademico;
    }

    public void setGrauAcademico(String grauAcademico) {
        this.grauAcademico = grauAcademico;
    }

    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Grauacademico(grauAcademico, null));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }    
}
