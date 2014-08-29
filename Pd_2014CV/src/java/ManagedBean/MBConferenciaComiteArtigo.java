/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciacomite;
import HibernatePackage.Conferenciacomiteartigo;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Investigador;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaComiteArtigo")
@SessionScoped
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
    private List<Conferenciaedicao> listaEdicoes;
    private List<Conferencia> listConferencias;
    private List<Investigador> listaInvestigadores;
     @Inject
    private LoginUtilizador loginUtilizador;
    private Conferencia conferencia=new Conferencia();   
    
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

    public List<Conferenciaedicao> getListaEdicoes() {
        this.listaEdicoes = new ArrayList<Conferenciaedicao>();
        Set<Conferencia> conf = loginUtilizador.getInvestigador().getConferencias();
        for (Iterator<Conferencia> it = conf.iterator(); it.hasNext();) {
            Conferencia conferencia = it.next();
            Set<Conferenciaedicao> edit = conferencia.getConferenciaedicaos();
            Conferenciaedicao confEd = new Conferenciaedicao();
            confEd.setId(0);
            for (Iterator<Conferenciaedicao> it1 = edit.iterator(); it1.hasNext();) {
                Conferenciaedicao conferenciaedicao1 = it1.next();
                if(conferenciaedicao1.getId() > confEd.getId())
                    confEd=conferenciaedicao1;
            }
            if(confEd!=null){
                this.listaEdicoes.add(confEd);
            }
        }                
        return listaEdicoes;
    }

    public void setListaEdicoes(List<Conferenciaedicao> listaEdicoes) {
        this.listaEdicoes = listaEdicoes;
    }

    public List<Conferencia> getListConferencias() {
        return listConferencias;
    }

    public void setListConferencias(List<Conferencia> listConferencias) {
        this.listConferencias = listConferencias;
    }

    public List<Investigador> getListaInvestigadores() {
        if(this.listaInvestigadores == null){
            this.listaInvestigadores = (List<Investigador>)AllHellper.getListQualquerCoisa(Investigador.class);
        }             
        return listaInvestigadores;
    }

    public void setListaInvestigadores(List<Investigador> listaInvestigadores) {
        this.listaInvestigadores = listaInvestigadores;
    }

    public LoginUtilizador getLoginUtilizador() {
        return loginUtilizador;
    }

    public void setLoginUtilizador(LoginUtilizador loginUtilizador) {
        this.loginUtilizador = loginUtilizador;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

    public String introduzir() {
        return "index";
    }
    
    public String gravar() {
        for(int i = 0;i < getListConferencias().size();i++){
           if(listConferencias.get(i).getId().equals(this.conferencia.getId())){
               this.conferencia=listConferencias.get(i);
           }
        }
        Conferenciaedicao confEd = new Conferenciaedicao();
        confEd.setId(0);
        for (Iterator<Conferenciaedicao> it1 = this.conferencia.getConferenciaedicaos().iterator(); it1.hasNext();) {
            Conferenciaedicao conferenciaedicao1 = it1.next();
            if(conferenciaedicao1.getId() >confEd.getId())
                confEd=conferenciaedicao1;
        }
        if(confEd!=null)
            AllHellper.SaveQualquerCoisa(new Conferenciacomiteartigo(conferenciacomite, artigo, estado, dataInicioLicitacao, dataFimLicitacao, pontuacao, pontuacaoComite, null, null));
        return "/model/conferencias/ConferenciaComiteArtigo.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }        
    
}
