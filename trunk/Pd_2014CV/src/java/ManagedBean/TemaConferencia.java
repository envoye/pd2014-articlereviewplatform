/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Tema;
import HibernatePackage.Subtema;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "temaConferencia")
@Dependent
public class TemaConferencia {
    private String tema;
    private String descricao;
    private List<SubtemaConferencia> listaSubtemas;
    
    /**
     * Creates a new instance of TemaConferencia
     */
    public TemaConferencia(String tema, String descricao) {
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
    
    public List<SubtemaConferencia> getSubtemas() {
        if(this.listaSubtemas == null){
            this.listaSubtemas = (List<SubtemaConferencia>)AllHellper.getListQualquerCoisa(Subtema.class);
        }
        return this.listaSubtemas;
    }
    
    public void addSubtema(String nome, String descricao) {
        this.listaSubtemas.add(new SubtemaConferencia(new Tema(this.tema),nome,descricao));
    }
    
    public void delSubtema(SubtemaConferencia subtema) {
        this.listaSubtemas.remove(subtema);
    }
    
    public String registar() {
        AllHellper.SaveQualquerCoisa(new Tema(this.tema,this.descricao,null,null));
        return "index";
    }
    
    public String cancelar() {
        return "TemaConferencia.xhtml";
    }
}
