/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigorevisao;
import HibernatePackage.Artigorevisaoitems;
import HibernatePackage.Conferenciacomiteartigo;
import HibernatePackage.Conferenciapoolrevisores;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBArtigoRevisao")
@SessionScoped
public class MBArtigoRevisao implements Serializable {
    
    private Conferenciacomiteartigo conferenciacomiteartigo;
    private Conferenciapoolrevisores conferenciapoolrevisores;
    private Byte preferencia;
    private Boolean estadoRevisor;
    private Boolean estadoAuto;
    private Boolean estadoGc;
    private Byte pontuacao;
    
    private List<Conferenciacomiteartigo> listaArtigos;
    private List<Conferenciapoolrevisores> listaRevisores;
    private List<Artigorevisaoitems> listaItemsRevisao;

    private List<Artigorevisao> listaArtigoRevisao;
    private Artigorevisao selectedArtigoRevisao;
    private int artigoRevisaoId;
    
    /**
     * Creates a new instance of MBArtigoRevisao
     */
    public MBArtigoRevisao() {
    }

    public Conferenciacomiteartigo getConferenciacomiteartigo() {
        return conferenciacomiteartigo;
    }

    public void setConferenciacomiteartigo(Conferenciacomiteartigo conferenciacomiteartigo) {
        this.conferenciacomiteartigo = conferenciacomiteartigo;
    }

    public Conferenciapoolrevisores getConferenciapoolrevisores() {
        return conferenciapoolrevisores;
    }

    public void setConferenciapoolrevisores(Conferenciapoolrevisores conferenciapoolrevisores) {
        this.conferenciapoolrevisores = conferenciapoolrevisores;
    }

    public Byte getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Byte preferencia) {
        this.preferencia = preferencia;
    }

    public Boolean isEstadoRevisor() {
        return estadoRevisor;
    }

    public void setEstadoRevisor(Boolean estadoRevisor) {
        this.estadoRevisor = estadoRevisor;
    }

    public Boolean isEstadoAuto() {
        return estadoAuto;
    }

    public void setEstadoAuto(Boolean estadoAuto) {
        this.estadoAuto = estadoAuto;
    }

    public Boolean isEstadoGc() {
        return estadoGc;
    }

    public void setEstadoGc(Boolean estadoGc) {
        this.estadoGc = estadoGc;
    }

    public Byte getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Byte pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<Conferenciacomiteartigo> getListaArtigos() {
        if(this.listaArtigos == null){
            this.listaArtigos = (List<Conferenciacomiteartigo>)AllHellper.getListQualquerCoisa(Conferenciacomiteartigo.class);
        }        
        return listaArtigos;
    }

    public void setListaArtigos(List<Conferenciacomiteartigo> listaArtigos) {
        this.listaArtigos = listaArtigos;
    }

    public List<Conferenciapoolrevisores> getListaRevisores() {
        if(this.listaRevisores == null){
            this.listaRevisores = (List<Conferenciapoolrevisores>)AllHellper.getListQualquerCoisa(Conferenciapoolrevisores.class);
        }                
        return listaRevisores;
    }

    public void setListaRevisores(List<Conferenciapoolrevisores> listaRevisores) {
        this.listaRevisores = listaRevisores;
    }

    public List<Artigorevisaoitems> getListaItemsRevisao() {
        if(this.listaItemsRevisao == null){
            String condicao=(" where Conferenciacomiteartigo.id='"+ conferenciacomiteartigo.getId()+"' and Conferenciapoolrevisores.id='" +conferenciapoolrevisores.getId()+"'");
            this.listaItemsRevisao = (List<Artigorevisaoitems>)AllHellper.getListQualquerCoisaCondicao(Artigorevisaoitems.class,condicao);
        }                        
        return listaItemsRevisao;
    }

    public void setListaItemsRevisao(List<Artigorevisaoitems> listaItemsRevisao) {
        this.listaItemsRevisao = listaItemsRevisao;
    }    

    public List<Artigorevisao> getListaArtigoRevisao() {
        if (listaArtigoRevisao == null){
            listaArtigoRevisao = (List<Artigorevisao>)AllHellper.getListQualquerCoisa(Artigorevisao.class);
        }                        
        return listaArtigoRevisao;
    }

    public void setListaArtigoRevisao(List<Artigorevisao> listaArtigoRevisao) {
        this.listaArtigoRevisao = listaArtigoRevisao;
    }

    public Artigorevisao getSelectedArtigoRevisao() {
        if (this.selectedArtigoRevisao.getId() == null) {
            this.selectedArtigoRevisao = new Artigorevisao();
        }                
        return selectedArtigoRevisao;
    }

    public void setSelectedArtigoRevisao(Artigorevisao selectedArtigoRevisao) {
        this.selectedArtigoRevisao = selectedArtigoRevisao;
    }

    public int getArtigoRevisaoId() {
        return artigoRevisaoId;
    }

    public void setArtigoRevisaoId(int artigoRevisaoId) {
        this.artigoRevisaoId = artigoRevisaoId;
        for (int i=0;i<this.getListaArtigoRevisao().size();i++){
            if (this.listaArtigoRevisao.get(i).getId() == artigoRevisaoId){
                this.selectedArtigoRevisao = this.listaArtigoRevisao.get(i);
            }
        }                                
    }
    
    public String introduzir() {
        return "/model/artigos/ArtigoRevisao.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Artigorevisao(conferenciacomiteartigo, conferenciapoolrevisores, preferencia, estadoRevisor, estadoAuto, estadoGc, pontuacao, null));
        return "/model/artigos/ArtigoRevisaoEdit.xhtml?faces-redirect=true";
    }

    public String atualizar() {
        AllHellper.UpdateArtigoRevisao(this.selectedArtigoRevisao.getId(), this.selectedArtigoRevisao.getConferenciacomiteartigo(), this.selectedArtigoRevisao.getConferenciapoolrevisores(), this.selectedArtigoRevisao.getPreferencia(), this.selectedArtigoRevisao.getEstadoRevisor(), this.selectedArtigoRevisao.getEstadoAuto(), this.selectedArtigoRevisao.getEstadoGc(), this.selectedArtigoRevisao.getPontuacao());
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }                
    
    public String cancelarAct() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String cancelarIntro() {
        return "/model/artigos/ArtigoRevisaoEdit.xhtml?faces-redirect=true";
    }    
    
    public String pesquisar() {
        return "/model/artigos/ArtigoRevisaoPesquisa.xhtml?faces-redirect=true";
    }        
    
    public String next() {
        if(this.selectedArtigoRevisao.getId() == null) {
            return "";
        }
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }        
}
