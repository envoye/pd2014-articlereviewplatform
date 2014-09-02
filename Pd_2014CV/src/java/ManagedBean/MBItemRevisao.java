/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Itemrevisao;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Valter
 */
@Named(value = "MBItemRevisao")
@ViewScoped
public class MBItemRevisao {
    private String nomeItem;
    private boolean tipo;
    private boolean privado;
    private String descricao;
    /**
     * Creates a new instance of MBItemRevisao
     */
    public MBItemRevisao() {
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String introduzir() {
        return "/model/artigos/ItemRevisao.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Itemrevisao(this.nomeItem,this.tipo,this.privado,this.descricao,null));
        return "/model/artigos/ItemRevisao.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }        
}
