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
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaSubtema")
@SessionScoped
public class MBConferenciaSubtema implements Serializable {
    private Tema tema;
    private String nome;
    private String descricao;
    private List<Tema> listTemas;
    private int temaId;
    private List<Subtema> listSubtemas;
    private Subtema selectedSubtema = new Subtema();
    private int subtemaId;
    private HtmlDataTable dataTableSubtemas;
    
    /**
     * Creates a new instance of MBConferenciaSubtema
     */
    public MBConferenciaSubtema() {
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    public Tema getTema() {
        if(this.tema == null)
            if(this.getListTemas().size() > 0)
                this.tema = this.listTemas.get(0);
        return this.tema;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }

    public List<Tema> getListTemas() {
        if(listTemas == null){
            listTemas = (List<Tema>)AllHellper.getListQualquerCoisa(Tema.class);
        }
        return listTemas;
    }

    public void setListTemas(List<Tema> listTemas) {
        this.listTemas = listTemas;
    }

    public int getTemaId() {
        return temaId;
    }

    public void setTemaId(int temaId) {
        this.temaId = temaId;
        for(int i=0;i<this.getListTemas().size();i++){
            if(this.listTemas.get(i).getId() == this.temaId){
                this.tema=this.listTemas.get(i);
            }
        }        
    }

    public List<Subtema> getListSubtemas() {
        if (listSubtemas == null){
            this.listSubtemas = (List<Subtema>)AllHellper.getListQualquerCoisa(Subtema.class);
        }                
        return this.listSubtemas;
    }

    public void setListSubtemas(List<Subtema> listSubtemas) {
        this.listSubtemas = listSubtemas;
    }

    public Subtema getSelectSubtema() {
        if (this.selectedSubtema.getId() == null) {
            this.selectedSubtema = new Subtema(new Tema(), "");
        }        
        return selectedSubtema;
    }

    public void setSelectedSubtema(Subtema selectedSubtema) {
        this.selectedSubtema = selectedSubtema;
    }

    public int getSubtemaId() {
        return subtemaId;
    }

    public void setSubtemaId(int subtemaId) {
        this.subtemaId = subtemaId;
        for (int i=0;i<this.getListSubtemas().size();i++){
            if (this.listSubtemas.get(i).getId() == subtemaId){
                this.selectedSubtema = this.listSubtemas.get(i);
            }
        }                        
    }

    public HtmlDataTable getDataTableSubtemas() {
        return dataTableSubtemas;
    }

    public void setDataTableSubtemas(HtmlDataTable dataTableSubtemas) {
        this.dataTableSubtemas = dataTableSubtemas;
    }

    public String introduzir() {
        return "/model/conferencias/ConferenciaSubtema.xhtml?faces-redirect=true";
    }    
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Subtema(this.tema, this.nome, this.descricao, null, null));
        return "/model/conferencias/ConferenciaSubtema.xhtml?faces-redirect=true";
    }
    
    public String cancelarAct() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String cancelarIntro() {
        return "/model/conferencias/ConferenciaSubtemaEdit.xhtml?faces-redirect=true";
    }    
    
    public String eliminar() {
        AllHellper.DelQualquerCoisa(this.selectedSubtema);
        this.selectedSubtema = new Subtema();
        return "/model/conferencias/ConferenciaTemaEdit.xhtml?faces-redirect=true";        
    }
    
    public String pesquisar() {
        return "/model/conferencias/ConferenciaSubtemaList.xhtml?faces-redirect=true";
    }
    
    public String next() {
        if(this.selectedSubtema.getId() == null) {
            return "";
        }
        return "/model/conferencias/ConferenciaSubtemaEdit.xhtml?faces-redirect=true";
    }        
}