/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Itemrevisao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBItemRevisao")
@SessionScoped
public class MBItemRevisao implements Serializable {
    private String nomeItem;
    private boolean tipo;
    private boolean privado;
    private String descricao;
    
    private List<Itemrevisao> listaItemsRevisao;
    private Itemrevisao selectedItemRevisao = new Itemrevisao();
    private int itemRevisaoId;
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

    public List<Itemrevisao> getListaItemsRevisao() {
        if (listaItemsRevisao == null){
            listaItemsRevisao = (List<Itemrevisao>)AllHellper.getListQualquerCoisa(Itemrevisao.class);
        }                
        return listaItemsRevisao;
    }

    public void setListaItemsRevisao(List<Itemrevisao> listaItemsRevisao) {
        this.listaItemsRevisao = listaItemsRevisao;
    }

    public Itemrevisao getSelectedItemRevisao() {
        if (this.selectedItemRevisao.getId() == null) {
            this.selectedItemRevisao = new Itemrevisao("", false, false);
        }        
        return selectedItemRevisao;
    }

    public void setSelectedItemRevisao(Itemrevisao selectedItemRevisao) {
        this.selectedItemRevisao = selectedItemRevisao;
    }

    public int getItemRevisaoId() {
        return itemRevisaoId;
    }

    public void setItemRevisaoId(int itemRevisaoId) {
        this.itemRevisaoId = itemRevisaoId;
        for (int i=0;i<this.getListaItemsRevisao().size();i++){
            if (this.listaItemsRevisao.get(i).getId() == itemRevisaoId){
                this.selectedItemRevisao = this.listaItemsRevisao.get(i);
            }
        }                        
    }
        
    public String introduzir() {
        return "/model/artigos/ItemRevisao.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Itemrevisao(this.nomeItem,this.tipo,this.privado,this.descricao,null));
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }

    public String atualizar() {
        AllHellper.UpdateItemRevisao(this.selectedItemRevisao.getId(), this.selectedItemRevisao.getNomeItem(), this.selectedItemRevisao.isTipo(), this.selectedItemRevisao.isPrivado(), this.selectedItemRevisao.getDescricao());
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }            
    
    public String cancelarAct() {
        this.nomeItem = "";
        this.tipo = false;
        this.privado = false;
        this.descricao = "";
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }
    
    public String cancelarIntro() {
        this.nomeItem = "";
        this.tipo = false;
        this.privado = false;
        this.descricao = "";
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }

    public String eliminar() {
        AllHellper.DelQualquerCoisa(this.selectedItemRevisao);
        this.selectedItemRevisao = new Itemrevisao();
        return "/model/investigadorAP/GrauAcademicoEdit.xhtml?faces-redirect=true";
    }        
    
    public String pesquisar() {
        return "/model/artigos/ItemRevisaoPesquisa.xhtml?faces-redirect=true";
    }        
    
    public String next() {
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }    
}
