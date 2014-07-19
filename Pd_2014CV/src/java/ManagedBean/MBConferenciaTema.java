/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Tema;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaTema")
@ViewScoped
public class MBConferenciaTema {
    private String tema;
    private String descricao;
//    private List<ConferenciaSubtema> listaSubtemas;

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
/*
    public List<ConferenciaSubtema> getListaSubtemas() {
        if(this.listaSubtemas == null){
            this.listaSubtemas = (List<ConferenciaSubtema>)AllHellper.getListQualquerCoisa(Subtema.class);
        }
        return listaSubtemas;
    }

    public void setListaSubtemas(List<ConferenciaSubtema> listaSubtemas) {
        this.listaSubtemas = listaSubtemas;
    }
  */      
    public String introduzir() {
        return "index";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Tema(this.tema,this.descricao,null,null));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }
}
