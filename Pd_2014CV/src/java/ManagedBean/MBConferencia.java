/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Conferencia;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferencia")
@ViewScoped
public class MBConferencia{
    private String nome;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    /**
     * Creates a new instance of Conferencia
     */
    
    
  
    
    public String registar() {
        AllHellper.SaveQualquerCoisa(new Conferencia(this.nome));
        return "index";
    }
}

