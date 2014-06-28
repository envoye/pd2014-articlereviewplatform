/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "conferencia")
@Dependent
public class Conferencia {
    public String nome;
    
    /**
     * Creates a new instance of Conferencia
     */
    public Conferencia() {
    }
    
    public Conferencia(String nome) {
        this.nome = nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String registar() {
        AllHellper.SaveQualquerCoisa(new Conferencia(this.nome));
        return "index";
    }
}

