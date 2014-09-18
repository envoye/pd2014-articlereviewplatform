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
import HibernatePackage.Conferenciacomiteartigoforum;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Investigador;
import TrabalharDados.WorkingData;
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
    private List<Conferencia> listConferencias;
    private List<Investigador> listaInvestigadores;
     @Inject
    private LoginUtilizador loginUtilizador;
    private Conferencia conferencia=new Conferencia();   
    private int idconferencia=0;
    private int idinvestigador=0;
    private int idartigo=0;
    private Conferenciaedicao conferenciaedicao;
    private Investigador investigador;
    
    public int getIdconferencia() {
        return idconferencia;
    }

    public void setIdconferencia(int idconferencia) {
        this.idconferencia = idconferencia;
    }

    public int getIdinvestigador() {
        return idinvestigador;
    }

    public void setIdinvestigador(int idinvestigador) {
        this.idinvestigador = idinvestigador;
    }

    public int getIdartigo() {
        return idartigo;
    }

    public void setIdartigo(int idartigo) {
        this.idartigo = idartigo;
    }
   
    /**
     * Creates a new instance of MBConferenciaComiteArtigo
     */
    public MBConferenciaComiteArtigo() {
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

   
   

 

    public List<Artigo> getListaArtigos() {
        
      this.listaArtigos=WorkingData.getListaArtigosConferenciaNaoAtribuidosComite(conferenciaedicao);
             
        return this.listaArtigos;
         
        
       
    }

    public void setListaArtigos(List<Artigo> listaArtigos) {
        this.listaArtigos = listaArtigos;
    }
  
    
    
    public List<Conferencia> getListConferencias() {
      Investigador i= loginUtilizador.getInvestigador();
        listConferencias=WorkingData.getTodasConferenciasAbertasInvestigador(i);    
        return listConferencias;
    }

    public void setListConferencias(List<Conferencia> listConferencias) {
        this.listConferencias = listConferencias;
    }

   public List<Investigador> getListaInvestigadores() {
          Investigador i= loginUtilizador.getInvestigador();
          this.listaInvestigadores=WorkingData.getComiteEdicao(conferenciaedicao);
        
             
        return this.listaInvestigadores;
    }

    public void setListaInvestigadores(List<Investigador> listaInvestigadores) {
        this.listaInvestigadores = listaInvestigadores;
    }

  



    public String introduzir() {
        if(idinvestigador==0)
            return"";
        for (Investigador inv : listaInvestigadores) {
             if(inv.getId()==idinvestigador){
               investigador=inv;
             break;
             }
            }
         if(idartigo==0)
            return"";
        for (Artigo Edicoe : listaArtigos) {
             if(Edicoe.getId()==idartigo){
             artigo=Edicoe;
             break;
             }
            }
            
        conferenciacomite=WorkingData.getComiteDoInvestigadorEdicao(conferenciaedicao, investigador);
        
        Conferenciacomiteartigo conferenciacomiteartigo = new Conferenciacomiteartigo(conferenciacomite, artigo, estado, dataInicioLicitacao, dataFimLicitacao, pontuacao, pontuacaoComite, null, null);
       
            AllHellper.SaveQualquerCoisa(conferenciacomiteartigo);
        Conferenciacomiteartigoforum conferenciacomiteartigoforum = new Conferenciacomiteartigoforum(conferenciacomiteartigo);
          AllHellper.SaveQualquerCoisa(conferenciacomiteartigoforum); 
        loginUtilizador.actualisaInvestigador();
         return "/model/conferencias/ConferenciaComiteArtigoDois.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
       
         if(idinvestigador==0)
            return"";
        for (Investigador inv : listaInvestigadores) {
             if(inv.getId()==idinvestigador){
               investigador=inv;
             break;
             }
            }
         if(idartigo==0)
            return"";
        for (Artigo Edicoe : listaArtigos) {
             if(Edicoe.getId()==idartigo){
             artigo=Edicoe;
             break;
             }
            }
            
        conferenciacomite=WorkingData.getComiteDoInvestigadorEdicao(conferenciaedicao, investigador);
        
        Conferenciacomiteartigo conferenciacomiteartigo = new Conferenciacomiteartigo(conferenciacomite, artigo, estado, dataInicioLicitacao, dataFimLicitacao, pontuacao, pontuacaoComite, null, null);
       
            AllHellper.SaveQualquerCoisa(conferenciacomiteartigo);
        Conferenciacomiteartigoforum conferenciacomiteartigoforum = new Conferenciacomiteartigoforum(conferenciacomiteartigo);
          AllHellper.SaveQualquerCoisa(conferenciacomiteartigoforum); 
        loginUtilizador.actualisaInvestigador();
        
        return "/model/conferencias/ConferenciaComiteArtigo.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }        

    public String next() {
        if(idconferencia==0)
            return"";
        for (Conferencia Edicoe : listConferencias) {
             if(Edicoe.getId()==idconferencia){
             conferencia=Edicoe;
             break;
             }
            }
            this.conferenciaedicao=WorkingData.getUltimaEdição(conferencia);
            return "/model/conferencias/ConferenciaComiteArtigoDois.xhtml?faces-redirect=true";
        
    }    
    
}
