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
import HibernatePackage.Conferenciacomiteartigo;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Conferenciapoolrevisores;
import HibernatePackage.Investigador;
import HibernatePackage.Itemrevisao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
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

    private List<Conferenciaedicao> listaEdicoes;
    private Conferenciaedicao selectedEdicao;
    private int edicaoId;
    
    private List<Conferenciacomiteartigo> listaArtigos;
    private Conferenciacomiteartigo selectedArtigo;
    private int artigoId;
    
    private List<Conferenciapoolrevisores> listaRevisores;
    private Conferenciapoolrevisores selectedRevisor;
    private int revisorId;
    
    private List<Artigorevisaoitems> listaItemsRevisao;

    private List<Artigorevisao> listaArtigoRevisao;
    private Artigorevisao selectedArtigoRevisao = new Artigorevisao(new Conferenciacomiteartigo(), new Conferenciapoolrevisores());
    private int artigoRevisaoId;

    @Inject
    private LoginUtilizador loginUtilizador;

    
    
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

    public List<Conferenciaedicao> getListaEdicoes() {
        Investigador i=loginUtilizador.getInvestigador();
        listaEdicoes = TrabalharDados.WorkingData.getTodasEdicaosConferenciasAbertasInvestigador(i);
        return listaEdicoes;
    }

    public void setListaEdicoes(List<Conferenciaedicao> listaEdicoes) {
        this.listaEdicoes = listaEdicoes;
    }
    
    public Conferenciaedicao getSelectedEdicao() {
        if (this.selectedEdicao.getId() == null) {
            this.selectedEdicao = new Conferenciaedicao();
        }                        
        return selectedEdicao;
    }

    public void setSelectedEdicao(Conferenciaedicao selectedEdicao) {
        this.selectedEdicao = selectedEdicao;
    }

    public int getEdicaoId() {
        return edicaoId;
    }

    public void setEdicaoId(int edicaoId) {
        this.edicaoId = edicaoId;
        for (int i=0;i<this.getListaArtigos().size();i++){
            if (this.listaArtigos.get(i).getId() == artigoId){
                this.selectedArtigo = this.listaArtigos.get(i);
            }
        }                                                        
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

    public Conferenciacomiteartigo getSelectedArtigo() {
        if (this.selectedArtigo.getId() == null) {
            this.selectedArtigo = new Conferenciacomiteartigo();
        }                
        return selectedArtigo;
    }

    public void setSelectedArtigo(Conferenciacomiteartigo selectedArtigo) {
        this.selectedArtigo = selectedArtigo;
    }

    public int getArtigoId() {
        return artigoId;
    }

    public void setArtigoId(int artigoId) {
        this.artigoId = artigoId;
        for (int i=0;i<this.getListaArtigos().size();i++){
            if (this.listaArtigos.get(i).getId() == artigoId){
                this.selectedArtigo = this.listaArtigos.get(i);
            }
        }                                                
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

    public Conferenciapoolrevisores getSelectedRevisor() {
        if (this.selectedRevisor.getId() == null) {
            this.selectedRevisor = new Conferenciapoolrevisores();
        }                        
        return selectedRevisor;
    }

    public void setSelectedRevisor(Conferenciapoolrevisores selectedRevisor) {
        this.selectedRevisor = selectedRevisor;
    }

    public int getRevisorId() {
        return revisorId;
    }

    public void setRevisorId(int revisorId) {
        this.revisorId = revisorId;
        for (int i=0;i<this.getListaRevisores().size();i++){
            if (this.listaRevisores.get(i).getId() == revisorId){
                this.selectedRevisor = this.listaRevisores.get(i);
            }
        }                                        
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
        return "/model/artigos/ArtigoRevisaoSelEdicao.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        this.selectedArtigoRevisao = new Artigorevisao(conferenciacomiteartigo, conferenciapoolrevisores, preferencia, estadoRevisor, estadoAuto, estadoGc, pontuacao, null);
        AllHellper.SaveQualquerCoisa(this.selectedArtigoRevisao);
        List<Itemrevisao> listaItemsTipo = TrabalharDados.WorkingData.getListaItemsRevisao(1);
        for (int i = 0; i < listaItemsTipo.size(); i++) {
            AllHellper.SaveQualquerCoisa(new Artigorevisaoitems(new ArtigorevisaoitemsId(this.selectedArtigoRevisao.getId(), listaItemsTipo.get(i).getId()), selectedArtigoRevisao, listaItemsTipo.get(i)));
        }
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

    public String eliminar() {
        AllHellper.DelQualquerCoisa(this.selectedArtigoRevisao);
        this.selectedArtigoRevisao = new Artigorevisao();
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }        
    
    public String next() {
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }        

    public String addItem() {
        return "/model/artigos/ItemRevisaoItem.xhtml?faces-redirect=true";
    }
    
    public String acessoForum() {
        return "/model/chat/Chat.xhtml?faces-redirect=true";
    }
}
