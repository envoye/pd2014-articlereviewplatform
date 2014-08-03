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
import javax.faces.component.html.HtmlDataTable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaSubtema")
@ViewScoped
public class MBConferenciaSubtema {
    private Tema tema;
    private String nome;
    private String descricao;
    private List<Tema> listTemas;
    private int temaId;
    private List<Subtema> listSubtemas;
    private Subtema subtemaSelecionado;
    private HtmlDataTable dataTableSubtemas;
    
    /**
     * Creates a new instance of MBConferenciaSubtema
     */
    public MBConferenciaSubtema() {
    }

//    public MBConferenciaSubtema(Tema tema, String nome, String descricao) {
//        this.tema = tema;
//        this.nome = nome;
//        this.descricao = descricao;
//    }
    
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
        this.listSubtemas = (List<Subtema>)AllHellper.getListQualquerCoisa(Subtema.class);
        return this.listSubtemas;
    }

    public void setListSubtemas(List<Subtema> listSubtemas) {
        this.listSubtemas = listSubtemas;
    }

    public Subtema getSubtemaSelecionado() {
        return subtemaSelecionado;
    }

    public String setSubtemaSelecionado() {
        this.subtemaSelecionado = (Subtema) this.dataTableSubtemas.getRowData();
        return "subtemaSelecionado";
    }

    public HtmlDataTable getDataTableSubtemas() {
        return dataTableSubtemas;
    }

    public void setDataTableSubtemas(HtmlDataTable dataTableSubtemas) {
        this.dataTableSubtemas = dataTableSubtemas;
    }

    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Subtema(this.tema, this.nome, this.descricao, null, null));
        return "/model/conferencias/ConferenciaSubtema.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "index";
    }
    
    public String pesquisar() {
        return "/model/conferencias/ConferenciaSubtemaList.xhtml?faces-redirect=true";
    }
}