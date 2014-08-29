/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Tema;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Valter
 */
@Named(value = "MBPesquisaConferenciaTema")
@SessionScoped
public class MBPesquisaConferenciaTema implements Serializable {
    private String pesquisa;
    private List<MBConferenciaTema> listaTemas;
    private MBConferenciaTema selectedTema;

    /**
     * Creates a new instance of MBPesquisaConferenciaTema
     */
    public MBPesquisaConferenciaTema() {
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public List<MBConferenciaTema> getListaTemas() {
        if (this.pesquisa == null) {
            this.listaTemas = (List<MBConferenciaTema>)AllHellper.getListQualquerCoisa(Tema.class);
        }else {
            String condicao=(" where nomeTema like '%" + this.pesquisa + "%' or descricao like '%" + this.pesquisa + "%'");
            this.listaTemas = (List<MBConferenciaTema>)AllHellper.getListQualquerCoisaCondicao(Tema.class, condicao);
        }
        return listaTemas;
    }

    public void setListaTemas(List<MBConferenciaTema> listaTemas) {
        this.listaTemas = listaTemas;
    }

    public MBConferenciaTema getSelectedTema() {
        return selectedTema;
    }

    public void setSelectedTema(MBConferenciaTema selectedTema) {
        this.selectedTema = selectedTema;
    }
    
    public String pesquisarTemaCondicao() {
        
        return ".";
    }        
}