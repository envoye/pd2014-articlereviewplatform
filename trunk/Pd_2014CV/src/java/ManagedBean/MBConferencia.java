/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Conferencia;
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
 
    public String introduzir() {
        return "index";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Conferencia(this.nome));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }    
}