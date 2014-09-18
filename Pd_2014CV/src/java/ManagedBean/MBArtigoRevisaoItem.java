/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigorevisao;
import HibernatePackage.Artigorevisaoitems;
import HibernatePackage.ArtigorevisaoitemsId;
import HibernatePackage.Itemrevisao;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBArtigoRevisaoItem")
@ViewScoped
public class MBArtigoRevisaoItem {
    private Artigorevisao artigorevisao;
    private Itemrevisao itemrevisao;
    private Byte classificacao;
    private String descricao;    
    private List<Itemrevisao> listaItemsRevisao;

    private List<Artigorevisaoitems> listaRevisaoItems;
    private Artigorevisaoitems selectedRevisaoItem;
    private int revisaoItemId;
     
    /**
     * Creates a new instance of MBArtigoRevisaoItem
     */
    public MBArtigoRevisaoItem() {
    }

    public Artigorevisao getArtigorevisao() {
        return artigorevisao;
    }

    public void setArtigorevisao(Artigorevisao artigorevisao) {
        this.artigorevisao = artigorevisao;
    }

    public Itemrevisao getItemrevisao() {
        return itemrevisao;
    }

    public void setItemrevisao(Itemrevisao itemrevisao) {
        this.itemrevisao = itemrevisao;
    }

    public Byte getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Byte classificacao) {
        this.classificacao = classificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Itemrevisao> getListaItemsRevisao() {
        this.listaItemsRevisao = TrabalharDados.WorkingData.getListaItemsRevisao(0);
        return listaItemsRevisao;
    }

    public void setListaItemsRevisao(List<Itemrevisao> listaItemsRevisao) {
        this.listaItemsRevisao = listaItemsRevisao;
    }

    public List<Artigorevisaoitems> getListaRevisaoItems() {
        if(this.listaRevisaoItems == null){
            this.listaRevisaoItems = (List<Artigorevisaoitems>)AllHellper.getListQualquerCoisa(Artigorevisaoitems.class);
        }                
        return listaRevisaoItems;
    }

    public void setListaRevisaoItems(List<Artigorevisaoitems> listaRevisaoItems) {
        this.listaRevisaoItems = listaRevisaoItems;
    }

    public Artigorevisaoitems getSelectedRevisaoItem() {
        if (this.selectedRevisaoItem.getId() == null) {
            this.selectedRevisaoItem = new Artigorevisaoitems();
        }                        
        return selectedRevisaoItem;
    }

    public void setSelectedRevisaoItem(Artigorevisaoitems selectedRevisaoItem) {
        this.selectedRevisaoItem = selectedRevisaoItem;
    }

    public int getRevisaoItemId() {
        return revisaoItemId;
    }

    public void setRevisaoItemId(int RevisaoItemId) {
        this.revisaoItemId = RevisaoItemId;
        for (int i=0;i<this.getListaRevisaoItems().size();i++){
            if (this.listaRevisaoItems.get(i).getId().getIdItemRevisao() == RevisaoItemId){
                this.selectedRevisaoItem = this.listaRevisaoItems.get(i);
            }
        }                                        
    }
    
    public String introduzir() {
        return "/model/artigos/ArtigoRevisaoItem.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Artigorevisaoitems(new ArtigorevisaoitemsId(artigorevisao.getId(), itemrevisao.getId()), artigorevisao, itemrevisao));
        return "/model/artigos/ArtigoRevisaoItem.xhtml?faces-redirect=true";
    }
  
    public String atualizar() {
        AllHellper.UpdateArtigoRevisaoItems(revisaoItemId, artigorevisao, itemrevisao, classificacao, descricao);
        return "/model/artigos/ArtigoRevisaoItem.xhtml?faces-redirect=true";
    }        
    
    public String cancelarAct() {
        this.artigorevisao = new Artigorevisao();
        this.itemrevisao = new Itemrevisao();
        this.descricao = "";
        this.classificacao = 0;
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }
    
    public String cancelarIntro() {
        this.artigorevisao = new Artigorevisao();
        this.itemrevisao = new Itemrevisao();
        this.descricao = "";
        this.classificacao = 0;
        return "/model/artigos/ArtigoRevisaoItem.xhtml?faces-redirect=true";
    }

    public String eliminar() {
        AllHellper.DelQualquerCoisa(this.selectedRevisaoItem);
        this.selectedRevisaoItem = new Artigorevisaoitems();
        return "/model/artigos/ArtigoRevisaoItem.xhtml?faces-redirect=true";
    }
    
    public String pesquisar() {
        return "/model/artigos/ArtigoRevisaoItemPesquisa.xhtml?faces-redirect=true";
    }

    public String next() {
        return "/model/artigos/ArtigoRevisaoItem.xhtml?faces-redirect=true";
    }        
}
