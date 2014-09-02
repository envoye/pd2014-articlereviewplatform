/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Subtema;
import HibernatePackage.Tema;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaTema")
@SessionScoped
public class MBConferenciaTema {
    private String tema;
    private String descricao;
    private List<MBConferenciaSubtema> listaSubtemas;

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

    public List<MBConferenciaSubtema> getListaSubtemas() {
        if(this.listaSubtemas == null){
            this.listaSubtemas = (List<MBConferenciaSubtema>)AllHellper.getListQualquerCoisa(Subtema.class);
        }
        return listaSubtemas;
    }

    public void setListaSubtemas(List<MBConferenciaSubtema> listaSubtemas) {
        this.listaSubtemas = listaSubtemas;
    }

    public String introduzir() {
        return "/model/conferencias/ConferenciaTema.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Tema(this.tema,this.descricao,null,null));
        return "/model/conferencias/ConferenciaTema.xhtml?faces-redirect=true";
    }
  
    public String atualizar() {
        AllHellper.SaveQualquerCoisa(new Tema(this.tema,this.descricao,null,null));
        return "/model/conferencias/ConferenciaTema.xhtml?faces-redirect=true";
    }        
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "/model/conferencias/ConferenciaTemaPesquisa.xhtml?faces-redirect=true";
    }
    
    public String listarSubtemas() {
        return "/model/conferencias/ConferenciaSubtemaList.xhtml?faces-redirect=true";
    }
 }