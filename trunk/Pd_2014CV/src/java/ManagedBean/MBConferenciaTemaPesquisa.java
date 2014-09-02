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
@Named(value = "MBConferenciaTemaPesquisa")
@SessionScoped
public class MBConferenciaTemaPesquisa implements Serializable {
    private List<MBConferenciaTema> listaTemas;
    private MBConferenciaTema selectedTema;

    /**
     * Creates a new instance of MBConferenciaTemaPesquisa
     */
    public MBConferenciaTemaPesquisa() {
    }

    public List<MBConferenciaTema> getListaTemas() {
        this.listaTemas = (List<MBConferenciaTema>)AllHellper.getListQualquerCoisa(Tema.class);
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
    
    public String next() {
        if(this.selectedTema.getTema()!=null)
            return "/model/conferencias/ConferenciaTemaEdit.xhtml?faces-redirect=true";
        else
            return "";
    }
}