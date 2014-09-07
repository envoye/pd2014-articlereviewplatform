/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciaartigo;
import HibernatePackage.Conferenciacomite;
import HibernatePackage.Conferenciacomiteartigo;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Investigador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaComiteArtigo")
@SessionScoped
public class MBConferenciaComiteArtigo implements Serializable {
    private Conferenciacomite conferenciacomite= new Conferenciacomite();
    private Artigo artigo= new Artigo();
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
        
       for(int i = 0;i < getListConferencias().size();i++){
           if(listConferencias.get(i).getId().equals(this.conferencia.getId())){
               this.conferencia=listConferencias.get(i);
           }
        }
            Set<Conferenciaedicao> confed=this.conferencia.getConferenciaedicaos();
            Conferenciaedicao aux = null;
            int id=0;
            for (Conferenciaedicao object : confed) {
               if(object.getId()>id){
               id=object.getId();
               aux=object;
               } 
            }
            this.listaArtigos=new ArrayList<Artigo>();
            List<Artigo> listInvestigador= new ArrayList<Artigo>();
            if(aux!=null){
             for(Conferenciaartigo object : aux.getConferenciaartigos()){
             this.listaArtigos.add(object.getArtigo());
             }   
            for(Conferenciacomite object : aux.getConferenciacomites()){
            
            for(Artigo inv : this.listaArtigos){
                for(Conferenciacomiteartigo cca : object.getConferenciacomiteartigos()){
                if(cca.getArtigo().getId()==inv.getId())
                   listInvestigador.add(inv);
                }
            }
            
            }}
           
            this.listaArtigos.remove(listInvestigador);
          
               
        return this.listaArtigos;
         
        
       
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
        if(listConferencias == null || listConferencias.size()==0 ){
     
            this.listConferencias= new ArrayList<Conferencia>();
            List<Conferencia> lConferencia=new ArrayList<Conferencia>();
            lConferencia.addAll(loginUtilizador.getInvestigador().getConferencias());
            for (Conferencia conferencia1 : lConferencia) {
                Conferenciaedicao aux = null;
                int corentId=0;
                for (Conferenciaedicao conferenciaedicao2 : conferencia1.getConferenciaedicaos()) {
                    if(conferenciaedicao2.getId()>corentId){
                    aux=conferenciaedicao2;
                    corentId=conferenciaedicao2.getId();
                    }
                        
                }
                if(aux!=null  && (new Date().before( aux.getDataLimiteSubmissao())))
                this.listConferencias.add(conferencia1);
            }
        }        
        return listConferencias;
    }

    public void setListConferencias(List<Conferencia> listConferencias) {
        this.listConferencias = listConferencias;
    }

   public List<Investigador> getListaInvestigadores() {
        if(this.listaInvestigadores == null){
            Set<Conferenciaedicao> confed=this.conferencia.getConferenciaedicaos();
            Conferenciaedicao aux = null;
            int id=0;
            for (Conferenciaedicao object : confed) {
               if(object.getId()>id){
               id=object.getId();
               aux=object;
               } 
            }
            List<Investigador> listInvestigador= new ArrayList<Investigador>();
            if(aux!=null)
                this.listaInvestigadores = (List<Investigador>)AllHellper.getListQualquerCoisa(Investigador.class);
            for(Conferenciacomite object : aux.getConferenciacomites()){
            
            for(Investigador inv : this.listaInvestigadores){
                if(object.getInvestigador().getId()==inv.getId())
                   listInvestigador.add(inv);
            
            }
            
            }
              for(Investigador inv : this.listaInvestigadores){
                if(loginUtilizador.getInvestigador().getId()==inv.getId())
                   listInvestigador.add(inv);
            
            }
            this.listaInvestigadores.retainAll(listInvestigador);
          
            }     
        return this.listaInvestigadores;
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
       loginUtilizador.setInvestigador(AllHellper.getInvestigador(loginUtilizador.getInvestigador().getId()));
        this.listaArtigos=null;
       this.listConferencias=null;
       this.listaInvestigadores=null;
        
        
        return "/model/conferencias/ConferenciaComiteArtigo.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }        

    public String next() {
        for(int i=0;i<getListConferencias().size();i++){
            if(listConferencias.get(i).getId().equals(conferencia.getId())){
                this.conferencia=listConferencias.get(i);
            }}
        if(conferencia.getId()>=0)
            return "/model/conferencias/ConferenciaComiteArtigoDois.xhtml?faces-redirect=true";
        else
            return "";
    }    
    
}
