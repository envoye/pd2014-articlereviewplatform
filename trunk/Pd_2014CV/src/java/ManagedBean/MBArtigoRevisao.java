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
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBArtigoRevisao")
@ViewScoped
public class MBArtigoRevisao {
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

    public String introduzir() {
        return  "/model/artigos/ArtigoRevisao.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Artigorevisao(conferenciacomiteartigo, conferenciapoolrevisores, preferencia, estadoRevisor, estadoAuto, estadoGc, pontuacao, null));
        return  "/model/artigos/ArtigoRevisao.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return  "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }        
}
