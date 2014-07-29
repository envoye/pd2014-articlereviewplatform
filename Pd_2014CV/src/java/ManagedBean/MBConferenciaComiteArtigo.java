/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Conferenciacomite;
import HibernatePackage.Conferenciacomiteartigo;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaComiteArtigo")
@ViewScoped
public class MBConferenciaComiteArtigo {
    private Conferenciacomite conferenciacomite;
    private Artigo artigo;
    private String estado;
    private Date dataInicioLicitacao;
    private Date dataFimLicitacao;
    private Byte pontuacao;
    private Byte pontuacaoComite;    
    private List<Conferenciacomite> listaConferenciaComite;
    private List<Artigo> listaArtigos;
    
    /**
     * Creates a new instance of MBConferenciaComiteArtigo
     */
    public MBConferenciaComiteArtigo() {
    }

    public Conferenciacomite getConferenciacomite() {
        return conferenciacomite;
    }

    public void setConferenciacomite(Conferenciacomite conferenciacomite) {
        for(int i=0; i<this.getListaConferenciaComite().size(); i++){
            if(this.listaConferenciaComite.get(i).getId().equals(this.conferenciacomite.getId())){
                this.conferenciacomite = this.listaConferenciaComite.get(i);
            }        
        }
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        for(int i=0;i<this.getListaArtigos().size();i++){
            if(this.listaArtigos.get(i).getId().equals(this.artigo.getId())){
                this.artigo = this.listaArtigos.get(i);
            }
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getDataInicioLicitacao() {
        return dataInicioLicitacao;
    }

    public void setDataInicioLicitacao(Date dataInicioLicitacao) {
        this.dataInicioLicitacao = dataInicioLicitacao;
    }

    public Date getDataFimLicitacao() {
        return dataFimLicitacao;
    }

    public void setDataFimLicitacao(Date dataFimLicitacao) {
        this.dataFimLicitacao = dataFimLicitacao;
    }

    public Byte getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Byte pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Byte getPontuacaoComite() {
        return pontuacaoComite;
    }

    public void setPontuacaoComite(Byte pontuacaoComite) {
        this.pontuacaoComite = pontuacaoComite;
    }

    public List<Conferenciacomite> getListaConferenciaComite() {
        if(this.listaConferenciaComite == null){
            this.listaConferenciaComite = (List<Conferenciacomite>)AllHellper.getListQualquerCoisa(Conferenciacomite.class);
        }                        
        return listaConferenciaComite;
    }

    public void setListaConferenciaComite(List<Conferenciacomite> listaConferenciaComite) {
        this.listaConferenciaComite = listaConferenciaComite;
    }

    public List<Artigo> getListaArtigos() {
        if(this.listaArtigos == null){
            this.listaArtigos = (List<Artigo>)AllHellper.getListQualquerCoisa(Artigo.class);
        }                                
        return listaArtigos;
    }

    public void setListaArtigos(List<Artigo> listaArtigos) {
        this.listaArtigos = listaArtigos;
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Conferenciacomiteartigo(conferenciacomite, artigo, estado, dataInicioLicitacao, dataFimLicitacao, pontuacao, pontuacaoComite, null, null));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }        
    
}
