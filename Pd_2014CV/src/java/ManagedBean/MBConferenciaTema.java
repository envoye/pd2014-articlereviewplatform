/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Subtema;
import HibernatePackage.Tema;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaTema")
@SessionScoped
public class MBConferenciaTema implements Serializable {
    private String tema;
    private String descricao;

    private List<Tema> listaTemas;
    private Tema selectedTema = new Tema();
    private int idTema;    
    
    private List<Subtema> listaSubtemas;


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

    public List<Tema> getListaTemas() {
        if (listaTemas == null){
            listaTemas = (List<Tema>)AllHellper.getListQualquerCoisa(Tema.class);
        }        
        return listaTemas;
    }

    public void setListaTemas(List<Tema> listaTemas) {
        this.listaTemas = listaTemas;
    }

    public Tema getSelectedTema() {
        if (this.selectedTema.getId() == null) {
            this.selectedTema = new Tema("");
        }
        return selectedTema;
    }

    public void setSelectedTema(Tema selectedTema) {
        this.selectedTema = selectedTema;
    }    

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
        for (int i=0;i<this.getListaTemas().size();i++){
            if (this.listaTemas.get(i).getId() == idTema){
                this.selectedTema = this.listaTemas.get(i);
            }
        }                
    }
    
    public List<Subtema> getListaSubtemas() {
        if(this.listaSubtemas == null){
            this.listaSubtemas = (List<Subtema>)AllHellper.getListQualquerCoisa(Subtema.class);
        }
        return listaSubtemas;
    }

    public void setListaSubtemas(List<Subtema> listaSubtemas) {
        this.listaSubtemas = listaSubtemas;
    }
   
    public String introduzir() {
        return "/model/conferencias/ConferenciaTema.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Tema(tema, descricao, null, null));
        return "/model/conferencias/ConferenciaTemaEdit.xhtml?faces-redirect=true";
    }
  
    public String atualizar() {
        AllHellper.UpdateTema(this.selectedTema.getId(), this.selectedTema.getNomeTema(), this.selectedTema.getDescricao());
        return "/model/conferencias/ConferenciaTemaEdit.xhtml?faces-redirect=true";
    }        
    
    public String cancelarAct() {
        this.tema = "";
        this.descricao = "";
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }
    
    public String cancelarIntro() {
        this.tema = "";
        this.descricao = "";
        return "/model/conferencias/ConferenciaTemaEdit.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "/model/conferencias/ConferenciaTemaPesquisa.xhtml?faces-redirect=true";
    }

    public String next() {
        if(this.selectedTema.getId() == null) {
            return "";
        }
        return "/model/conferencias/ConferenciaTemaEdit.xhtml?faces-redirect=true";
    }    
    
    public String listarSubtemas() {
        return "/model/conferencias/ConferenciaSubtemaList.xhtml?faces-redirect=true";
    }
    
    public String back() {
        return "/model/conferencias/ConferenciaTemaEdit.xhtml?faces-redirect=true";
    }
 }