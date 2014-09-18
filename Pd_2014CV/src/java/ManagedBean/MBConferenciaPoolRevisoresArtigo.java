/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigorevisao;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciacomiteartigo;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Conferenciapoolrevisores;
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
@Named(value = "MBConferenciaPoolRevisoresArtigo")
@SessionScoped
public class MBConferenciaPoolRevisoresArtigo implements Serializable {
    private Conferenciaedicao conferenciaedicao;
    private Conferenciapoolrevisores investigador=new Conferenciapoolrevisores();
    private Byte classificacao;
    private String estado;
    private Date dataInicioConvite;
    private Date dataFimConvite;
    private Conferencia conferencia;
    private List<Conferenciapoolrevisores> listaInvestigadores;
    private List<Conferencia> listConferencias;
    private List<Conferenciacomiteartigo> Conferenciacomiteartigo;
    private Conferenciacomiteartigo  conferenciacomiteartigo;
    public List<Conferenciacomiteartigo> getConferenciacomiteartigo() {
        Conferenciacomiteartigo.addAll(WorkingData.getComiteDoInvestigadorEdicao(conferenciaedicao,loginUtilizador.getInvestigador()).getConferenciacomiteartigos());
        return Conferenciacomiteartigo;
    }

    public void setConferenciacomiteartigo(List<Conferenciacomiteartigo> Conferenciacomiteartigo) {
        this.Conferenciacomiteartigo = Conferenciacomiteartigo;
    }
    private int idconferencia=0;
    private int idinvestigador=0;
    private int idcomiteartigo=0;
     @Inject
    private LoginUtilizador loginUtilizador;

    public int getIdcomiteartigo() {
        return idcomiteartigo;
    }

    public void setIdcomiteartigo(int idcomiteartigo) {
        this.idcomiteartigo = idcomiteartigo;
    }

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
 
    

    public List<Conferencia> getListConferencias() {
        
       listConferencias=WorkingData.getTodasConferenciasAbertasInvestigadorComite(loginUtilizador.getInvestigador());
        return listConferencias;
    }

    public void setListConferencias(List<Conferencia> listConferencias) {
        this.listConferencias = listConferencias;
    }
    
  

    public Byte getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Byte classificacao) {
        this.classificacao = classificacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getDataInicioConvite() {
        return dataInicioConvite;
    }

    public void setDataInicioConvite(Date dataInicioConvite) {
        this.dataInicioConvite = dataInicioConvite;
    }

    public Date getDataFimConvite() {
        return dataFimConvite;
    }

    public void setDataFimConvite(Date dataFimConvite) {
        this.dataFimConvite = dataFimConvite;
    }

    

    public List<Conferenciapoolrevisores> getListaInvestigadores() {
        
      listaInvestigadores=WorkingData.getListaRevisoresedicao(conferenciaedicao);
   return listaInvestigadores;
    }

    public void setListaInvestigadores(List<Conferenciapoolrevisores> listaInvestigadores) {
        this.listaInvestigadores = listaInvestigadores;
    }

    public String introduzir() {
         
        if(idinvestigador==0)
            return"";
        for (Conferenciapoolrevisores inv : listaInvestigadores) {
             if(inv.getId()==idinvestigador){
               investigador=inv;
             break;
             }
            }
         if(idcomiteartigo==0)
            return"";
        for (Conferenciacomiteartigo inv : Conferenciacomiteartigo) {
             if(inv.getId()==idcomiteartigo){
              conferenciacomiteartigo= inv;
             break;
             }
            }      
        AllHellper.SaveQualquerCoisa(new Artigorevisao(conferenciacomiteartigo, investigador));
       loginUtilizador.actualisaInvestigador();
        return "/model/conferencias/ConferenciaPollArtigos.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        
         if(idinvestigador==0)
            return"";
        for (Conferenciapoolrevisores inv : listaInvestigadores) {
             if(inv.getId()==idinvestigador){
               investigador=inv;
             break;
             }
            }
         if(idcomiteartigo==0)
            return"";
        for (Conferenciacomiteartigo inv : Conferenciacomiteartigo) {
             if(inv.getId()==idcomiteartigo){
              conferenciacomiteartigo= inv;
             break;
             }
            }      
        AllHellper.SaveQualquerCoisa(new Artigorevisao(conferenciacomiteartigo, investigador));
       loginUtilizador.actualisaInvestigador();
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }
    
    public String cancelarAct() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String cancelarIntro() {
        return "/model/conferencias/ConferenciaPoolRevisoresEdit.xhtml?faces-redirect=true";
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
         return "/model/conferencias/ConferenciaPollArtigosDois.xhtml?faces-redirect=true";
            
        
     }
     
}
