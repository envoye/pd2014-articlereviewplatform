/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Tema;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Valter
 */
@Named(value = "temasConferencias")
@Dependent
public class TemasConferencias {
    private String tema;
    private String descricao;
    
    /**
     * Creates a new instance of TemaConferencia
     */
    public TemasConferencias(String tema, String descricao) {
        this.tema = tema;
        this.descricao = descricao;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public String getTema() {
        return this.tema;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
      public String registar () {
      AllHellper.SaveQualquerCoisa(new Tema(1,this.tema,this.descricao));
        return "index";
  }
}
